package com.springboot.validator;

import org.springframework.validation.Errors;

import com.springboot.property.Property;

public interface ValidationInterface<T> {
	public void invokeValidationOn(T request, Errors errors, Property property);
}