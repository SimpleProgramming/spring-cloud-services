package com.springboot.entity;

import java.io.Serializable;

import org.springframework.data.cassandra.mapping.Column;
import org.springframework.data.cassandra.mapping.UserDefinedType;

@UserDefinedType("address")
public class AddressEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column("door_no")
	private String doorNo;

	@Column("street")
	private String street;

	@Column("city")
	private String city;

	@Column("state")
	private String state;

	@Column("zip_code")
	private String zipCode;

	public String getCity() {
		return city;
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

	public String getDoorNo() {
		return doorNo;
	}

	public void setDoorNo(String doorNo) {
		this.doorNo = doorNo;
	}

	public void setCity(String city) {
		this.city = city;
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