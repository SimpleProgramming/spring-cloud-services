package com.springboot.validator;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.springboot.model.Address;
import com.springboot.property.Property;

@Service
public class ValidationRouter implements ValidationInterface<Object> {

	private final Map<Class<?>, Validator> validators = new HashMap<>();

	@Autowired
	private AddressValidator addressValidator;

	@PostConstruct
	public void initialize() {
		validators.put(Address.class, addressValidator);
	}

	@Override
	public void invokeValidationOn(Object request, Errors errors, Property property) {
		errors.pushNestedPath(property.getField());
		ValidationUtils.invokeValidator(validators.get(request.getClass()), request, errors);
	}
}