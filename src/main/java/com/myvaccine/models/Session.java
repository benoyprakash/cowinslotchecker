package com.myvaccine.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties(ignoreUnknown = true)
public class Session {

	//private String session_id; // ": "72592317-222d-4340-bef3-2a56789ed5d5",
	private String date; // ": "22-06-2021",
	private int available_capacity; // ": 0,
	private int min_age_limit; // ": 40,
	private String vaccine; // ": "COVAXIN",
	/*
	 * "slots": [ "09:00AM-10:00AM", "10:00AM-11:00AM", "11:00AM-12:00PM", "12:00PM-01:00PM" ],
	 */
	private int available_capacity_dose1; // ": 0,
	private int available_capacity_dose2; // ": 0

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getAvailable_capacity() {
		return available_capacity;
	}

	public void setAvailable_capacity(int available_capacity) {
		this.available_capacity = available_capacity;
	}

	public int getMin_age_limit() {
		return min_age_limit;
	}

	public void setMin_age_limit(int min_age_limit) {
		this.min_age_limit = min_age_limit;
	}

	public String getVaccine() {
		return vaccine;
	}

	public void setVaccine(String vaccine) {
		this.vaccine = vaccine;
	}

	public int getAvailable_capacity_dose1() {
		return available_capacity_dose1;
	}

	public void setAvailable_capacity_dose1(int available_capacity_dose1) {
		this.available_capacity_dose1 = available_capacity_dose1;
	}

	public int getAvailable_capacity_dose2() {
		return available_capacity_dose2;
	}

	public void setAvailable_capacity_dose2(int available_capacity_dose2) {
		this.available_capacity_dose2 = available_capacity_dose2;
	}

	@Override
	public String toString() {
		return "Session [date=" + date + ", available_capacity=" + available_capacity + ", min_age_limit="
				+ min_age_limit + ", vaccine=" + vaccine + ", available_capacity_dose1=" + available_capacity_dose1
				+ ", available_capacity_dose2=" + available_capacity_dose2 + "]";
	}

}
