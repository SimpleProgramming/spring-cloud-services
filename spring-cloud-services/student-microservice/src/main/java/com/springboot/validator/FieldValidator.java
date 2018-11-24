package com.springboot.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;

import com.springboot.property.Property;

@Service
public class FieldValidator implements ValidationInterface<String> {

	@Autowired
	private MasterValidator masterValidator;

	@Override
	public void invokeValidationOn(String input, Errors errors, Property property) {
		masterValidator.validate(input, errors, property);
	}
}