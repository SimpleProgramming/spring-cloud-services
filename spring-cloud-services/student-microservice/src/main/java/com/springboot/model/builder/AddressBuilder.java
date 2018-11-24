package com.springboot.model.builder;

import com.springboot.model.Address;

public class AddressBuilder {

	private Address address = new Address();

	public AddressBuilder withDoorNo(String doorNo) {
		address.setDoorNo(doorNo);
		return this;
	}

	public AddressBuilder fromStreet(String street) {
		address.setStreet(street);
		return this;
	}

	public AddressBuilder fromCity(String city) {
		address.setCity(city);
		return this;
	}

	public AddressBuilder fromState(String state) {
		address.setState(state);
		return this;
	}

	public AddressBuilder withZipCode(String zipCode) {
		address.setZipCode(zipCode);
		return this;
	}

	public Address build() {
		return address;
	}
}