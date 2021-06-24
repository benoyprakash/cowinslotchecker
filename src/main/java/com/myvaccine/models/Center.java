package com.myvaccine.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Center {
	private String center_id;
	private String name;		//"North Paravur THQH",
	private String address;		//"Paravur Main Road Near Private Bus Stand North Paravur Kerala",
	private String state_name;	//": "Kerala",
	private String district_name;	//": "Ernakulam",
	private String block_name;	//"Ezhikara CHC",
	private int pincode;		//683513,
	private int lat;			//10,
	@JsonProperty("long")
	private int lon;			//76,
	private String from;		//09:00:00",
	private String to;			//"13:00:00",
	private String fee_type;	//"Free",
	private List<Session> sessions;		//sessions
	private List<VaccineFee> vaccine_fees;
	
	
	public String getCenter_id() {
		return center_id;
	}
	public void setCenter_id(String center_id) {
		this.center_id = center_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getState_name() {
		return state_name;
	}
	public void setState_name(String state_name) {
		this.state_name = state_name;
	}
	public String getDistrict_name() {
		return district_name;
	}
	public void setDistrict_name(String district_name) {
		this.district_name = district_name;
	}
	public String getBlock_name() {
		return block_name;
	}
	public void setBlock_name(String block_name) {
		this.block_name = block_name;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	public int getLat() {
		return lat;
	}
	public void setLat(int lat) {
		this.lat = lat;
	}
	public int getLon() {
		return lon;
	}
	public void setLon(int lon) {
		this.lon = lon;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getFee_type() {
		return fee_type;
	}
	public void setFee_type(String fee_type) {
		this.fee_type = fee_type;
	}
	public List<Session> getSessions() {
		return sessions;
	}
	public void setSessions(List<Session> sessions) {
		this.sessions = sessions;
	}
	public List<VaccineFee> getVaccine_fees() {
		return vaccine_fees;
	}
	public void setVaccine_fees(List<VaccineFee> vaccine_fees) {
		this.vaccine_fees = vaccine_fees;
	}
	@Override
	public String toString() {
		return "Center [name=" + name + ", sessions=" + sessions + "]";
	}
	
	
}
