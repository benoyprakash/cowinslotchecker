package com.myvaccine.cowinbooking;

import java.awt.Toolkit;
import java.time.LocalDate;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.myvaccine.models.Center;
import com.myvaccine.models.Session;
import com.myvaccine.models.SlotAvailabilityResponse;

public class SlotChecker implements Runnable {

	public static void main(String[] args) throws JsonMappingException, JsonProcessingException {
		new Thread(new SlotChecker()).start();
	}

	@Override
	public void run() {
		while (true) {
			try {
				SlotChecker.checkSlotsAvailable();
				Thread.sleep(120000); // 1000 * 120s = every 2 mins
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static void checkSlotsAvailable()
			throws JsonMappingException, JsonProcessingException, InterruptedException {
		
		String districtId = "307"; // 307 = Ernakulam (https://cdn-api.co-vin.in/api/v2/admin/location/districts/17)
		String vaccineName = "COVISHIELD"; // COVAXIN or COVISHIELD
		String dose = "d1"; // d1 or d2
		int minAge = 18; // 18 or 45
		
		String slotAvailibilityData = SlotChecker.getSlotAvailabilityData(districtId);
		SlotAvailabilityResponse slotResponse = SlotChecker.parseCowinResponse(slotAvailibilityData);
		boolean isSlotAvailable = SlotChecker.isSlotAvailable(slotResponse, vaccineName, dose, minAge);
		if (isSlotAvailable) {
			for (int i = 0; i < 5; i++) {
				Toolkit.getDefaultToolkit().beep();
				Thread.sleep(3000);
			}
		}
	}

	// Get the Slot availability data API response
	public static String getSlotAvailabilityData(String districtId)
			throws JsonMappingException, JsonProcessingException {

		LocalDate today = LocalDate.now();
		String dateString = today.getDayOfMonth() + "-" + today.getMonthValue() + "-" + today.getYear();

		RestTemplate restTemplate = new RestTemplate();
		String cowinCalendarByDistrictURL = "https://cdn-api.co-vin.in/api/v2/appointment/sessions/public/calendarByDistrict?district_id="
				+ districtId + "&date=" + dateString;
		ResponseEntity<String> response = restTemplate.getForEntity(cowinCalendarByDistrictURL, String.class);
		System.out.println("HTTP Status code : " + response.getStatusCodeValue());

		if (response.getStatusCodeValue() == 200) {
			return response.getBody();
		}
		return null;
	}

	private static boolean isSlotAvailable(SlotAvailabilityResponse slotResponse, String vaccineName, String dose,
			int minAge) {
		
		boolean isAvailable = false;
		for (Center center : slotResponse.getCenters()) {

			for (Session session : center.getSessions()) {
				if (session.getVaccine().equalsIgnoreCase(vaccineName) && session.getMin_age_limit() == minAge) {

					if (dose.equals("d1") && session.getAvailable_capacity_dose1() > 0) {
						System.out.println("\n- - - - - - - - - - - - - - - - - - - - - - - - - - - - - ");
						System.out.println(
								session.getVaccine() + "(D1): " + session.getAvailable_capacity_dose1() + " nos. @ "
										+ center.getName() + ", " + center.getAddress() + ", " + center.getPincode()
										+ " - " + session.getDate() + " and min-age " + session.getMin_age_limit());
						isAvailable = true;
					} else if (dose.equals("d2") && session.getAvailable_capacity_dose2() > 0) {
						System.out.println("\n- - - - - - - - - - - - - - - - - - - - - - - - - - - - - ");
						System.out.println(
								session.getVaccine() + "(D2): " + session.getAvailable_capacity_dose2() + " nos. @ "
										+ center.getName() + ", " + center.getAddress() + ", " + center.getPincode()
										+ " - " + session.getDate() + " and min-age " + session.getMin_age_limit());
						isAvailable = true;
					}
				}
			}
		}
		return isAvailable;
	}

	// parse Json slotAvailabilityResponse
	public static SlotAvailabilityResponse parseCowinResponse(String slotAvailabilityResponse)
			throws JsonMappingException, JsonProcessingException {

		ObjectMapper mapper = new ObjectMapper();
		SlotAvailabilityResponse response = mapper.readValue(slotAvailabilityResponse, SlotAvailabilityResponse.class);
		return response;
	}

}
