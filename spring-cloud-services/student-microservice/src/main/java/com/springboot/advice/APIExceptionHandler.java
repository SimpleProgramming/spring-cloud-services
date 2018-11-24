package com.springboot.advice;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonMappingException.Reference;
import com.springboot.exception.DuplicateStudentRecordException;
import com.springboot.exception.StudentNotFoundException;
import com.springboot.model.Error;
import com.springboot.model.ErrorResponse;

@RestControllerAdvice
public class APIExceptionHandler {

	@ExceptionHandler
	public ResponseEntity<ErrorResponse> handleStudentNotFoundException(HttpMessageNotReadableException exception) {
		final ErrorResponse response = new ErrorResponse();
		final JsonMappingException jsonException = (JsonMappingException) exception.getCause();
		response.setCode(Error.UNKNOWN_PROPERTY_ERROR_CODE.value());
		response.setMessage(
				jsonException.getPath().stream().map(Reference::getFieldName).collect(Collectors.joining(".")));
		return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler
	public ResponseEntity<ErrorResponse> handleStudentNotFoundException(StudentNotFoundException exception) {
		final ErrorResponse response = new ErrorResponse();
		response.setCode(Error.NO_DATA_ERROR_CODE.value());
		response.setMessage(Error.NO_DATA_ERROR_MESSAGE.value());
		return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler
	public ResponseEntity<List<ErrorResponse>> handleValidationErrors(MethodArgumentNotValidException exception) {
		List<ErrorResponse> response = exception.getBindingResult().getFieldErrors().stream().map(t -> {
			ErrorResponse e = new ErrorResponse();
			e.setCode(t.getCode());
			e.setMessage(t.getDefaultMessage());
			return e;
		}).collect(Collectors.toList());
		return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler
	public ResponseEntity<ErrorResponse> handleDuplicateStudentRecordException(
			DuplicateStudentRecordException exception) {
		final ErrorResponse response = new ErrorResponse();
		response.setCode("invalid request - data conflict");
		response.setMessage(exception.getMessage());
		return new ResponseEntity<>(response, HttpStatus.CONFLICT);
	}
}