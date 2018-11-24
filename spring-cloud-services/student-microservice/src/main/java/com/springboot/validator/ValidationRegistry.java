package com.springboot.validator;

public interface ValidationRegistry {
	public <T> ValidationInterface<T> getValidationService(String serviceName);
}