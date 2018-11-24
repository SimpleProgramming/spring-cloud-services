package com.springboot.validator;

import java.util.List;

import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.sleuth.Span;
import org.springframework.cloud.sleuth.Tracer;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.springboot.model.Address;
import com.springboot.property.AddressProperty;
import com.springboot.property.Property;

@Component
public class AddressValidator implements Validator {

	@Autowired
	private ValidationRegistry registry;

	@Autowired
	private AddressProperty aaddressProperty;
	
	@Autowired
	private Tracer tracer;

	@Override
	public boolean supports(Class<?> arg0) {
		return Address.class.equals(arg0);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Span span = tracer.createSpan("validate-address");
		final Address address = (Address) target;
		final List<Property> properties = aaddressProperty.getProperty();
		properties.forEach(t -> registry.getValidationService(t.getValidator())
				.invokeValidationOn(new BeanWrapperImpl(address).getPropertyValue(t.getField()), errors, t));
		errors.popNestedPath();
		tracer.close(span);
	}
}