package com.springboot.model;

public enum Error {

	INVALID_ERROR_CODE("invalid"), INVALID_ERROR_MSG("invalid field - "), NO_DATA_ERROR_CODE(
			"noData"), NO_DATA_ERROR_MESSAGE(
					"No Data Available for this Request"), ERROR_MINLENGTH_CODE("minlength"), ERROR_MINLENGTH_MESSAGE(
							"invalid minlength - "), ERROR_MAXLENGTH_CODE("maxlength"), ERROR_MAXLENGTH_MESSAGE(
									"invalid maxlength - "), UNKNOWN_PROPERTY_ERROR_CODE("unknownElement");

	private String value;

	Error(String value) {
		this.value = value;
	}

	public String value() {
		return value;
	}
}