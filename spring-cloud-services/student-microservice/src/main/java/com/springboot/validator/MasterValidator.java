package com.springboot.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.apache.commons.lang3.StringUtils;
import com.springboot.model.Error;
import com.springboot.property.Property;

@Component
public class MasterValidator {

	public void checkfieldFormat(String input, Errors errors, Property property) {
		if (!input.matches(property.getFormat()))
			errors.rejectValue(property.getField(), Error.INVALID_ERROR_CODE.value(),
					Error.INVALID_ERROR_MSG.value().concat(property.getField()));
	}

	public void checkMaxlength(String input, Errors errors, Property property) {
		final int inputLength = input.length();
		if (inputLength > Integer.parseInt(property.getMaxlength()))
			errors.rejectValue(property.getField(), Error.ERROR_MAXLENGTH_CODE.value(),
					Error.ERROR_MAXLENGTH_MESSAGE.value().concat(property.getField()));
	}

	public void checkMinlength(String input, Errors errors, Property property) {
		final int inputLength = input.length();
		if (inputLength < Integer.parseInt(property.getMinlength()))
			errors.rejectValue(property.getField(), Error.ERROR_MINLENGTH_CODE.value(),
					Error.ERROR_MINLENGTH_MESSAGE.value().concat(property.getField()));

	}

	public void validate(String input, Errors errors, Property property) {
		if (StringUtils.isNotBlank(property.getMaxlength()))
			checkMinlength(input, errors, property);
		if (StringUtils.isNotBlank(property.getMinlength()))
			checkMaxlength(input, errors, property);
		if (StringUtils.isNotBlank(property.getFormat()))
			checkfieldFormat(input, errors, property);
	}
}
