package com.myvaccine.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SlotAvailabilityResponse {
	
	@JsonProperty
	List<Center> centers;

	public List<Center> getCenters() {
		return centers;
	}

	public void setCenters(List<Center> centers) {
		this.centers = centers;
	}

	@Override
	public String toString() {
		return "SlotAvailabilityResponse [centers=" + centers + "]";
	}
	
	
	
}
