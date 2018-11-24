package com.springboot.model.builder;

public class Builders {

	public static AddressBuilder address() {
		return new AddressBuilder();
	}

	public static StudentBuilder student() {
		return new StudentBuilder();
	}

	public static ResponseMessageBuilder responseMessage() {
		return new ResponseMessageBuilder();
	}
}
