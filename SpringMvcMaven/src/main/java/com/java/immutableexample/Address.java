package com.java.immutableexample;

public class Address {

	private String street;
	
	public Address(String street){
		this.street=street;
	}
	
	public Address(){
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}
	
	private Integer streetId;

	public Integer getStreetId() {
		return streetId;
	}

	public void setStreetId(Integer streetId) {
		this.streetId = streetId;
	}
	
	
	
}
