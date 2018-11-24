package com.springboot.property;

import java.io.Serializable;

public class Property implements Serializable {

	private static final long serialVersionUID = 1L;

	private String field;
	private String validator;
	private String maxlength;
	private String minlength;
	private String format;

	public String getField() {
		return field;
	}

	public String getFormat() {
		return format;
	}

	public String getMaxlength() {
		return maxlength;
	}

	public String getMinlength() {
		return minlength;
	}

	public String getValidator() {
		return validator;
	}

	public void setField(String field) {
		this.field = field;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	public void setMaxlength(String maxlength) {
		this.maxlength = maxlength;
	}

	public void setMinlength(String minlength) {
		this.minlength = minlength;
	}

	public void setValidator(String validator) {
		this.validator = validator;
	}
}
