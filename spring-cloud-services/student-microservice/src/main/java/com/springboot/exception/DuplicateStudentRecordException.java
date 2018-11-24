package com.springboot.exception;

public class DuplicateStudentRecordException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private String message;

	public DuplicateStudentRecordException(String message) {
		this.setMessage(message);
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}