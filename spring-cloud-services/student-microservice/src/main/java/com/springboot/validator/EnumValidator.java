package com.springboot.validator;

import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;

import com.springboot.model.Error;
import com.springboot.model.Major;
import com.springboot.property.Property;

@Service
public class EnumValidator implements ValidationInterface<Major> {

	@Override
	public void invokeValidationOn(Major major, Errors errors, Property property) {
		if (!(major == null) && major == Major.UNKNOWN_ENUM)
			errors.rejectValue(property.getField(), Error.INVALID_ERROR_CODE.value(),
					Error.INVALID_ERROR_MSG.value().concat(property.getField()));
	}

}
