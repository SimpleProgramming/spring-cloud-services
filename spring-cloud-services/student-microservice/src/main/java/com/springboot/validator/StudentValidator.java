package com.springboot.validator;

import java.util.List;

import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.sleuth.Span;
import org.springframework.cloud.sleuth.Tracer;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.springboot.model.Student;
import com.springboot.property.Property;
import com.springboot.property.StudentProperty;

@Component
public class StudentValidator implements Validator {

	@Autowired
	private ValidationRegistry registry;

	@Autowired
	private StudentProperty studentProperty;
	
	@Autowired
	private Tracer tracer;

	@Override
	public boolean supports(Class<?> clazz) {
		return Student.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Span span = tracer.createSpan("validate-student");
		Student student = (Student) target;
		List<Property> properties = studentProperty.getProperty();
		properties.forEach(t -> registry.getValidationService(t.getValidator())
				.invokeValidationOn(new BeanWrapperImpl(student).getPropertyValue(t.getField()), errors, t));
		tracer.close(span);
	}
}