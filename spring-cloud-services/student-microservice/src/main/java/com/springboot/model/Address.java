package com.springboot.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_EMPTY)
public class Address implements Serializable {

	private static final long serialVersionUID = 1L;

	private String doorNo;

	private String street;

	private String city;

	private String state;

	private String zipCode;

	public String getCity() {
		return city;
	}

	public String getDoorNo() {
		return doorNo;
	}

	public String getState() {
		return state;
	}

	public String getStreet() {
		return street;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setDoorNo(String doorNo) {
		this.doorNo = doorNo;
	}

	public void setState(String state) {
		this.state = state;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
}
