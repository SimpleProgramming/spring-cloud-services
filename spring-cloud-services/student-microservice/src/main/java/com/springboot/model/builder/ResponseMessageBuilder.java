package com.springboot.model.builder;

import com.springboot.model.ResponseMessage;

public class ResponseMessageBuilder {

	private ResponseMessage response = new ResponseMessage();

	public ResponseMessageBuilder withResponseCode(String responseCode) {
		response.setResponseCode(responseCode);
		return this;
	}

	public ResponseMessageBuilder andResponseMsg(String responseMsg) {
		response.setResponseMsg(responseMsg);
		return this;
	}

	public ResponseMessageBuilder onTransactionDate(String date) {
		response.setTransactionDate(date);
		return this;
	}

	public ResponseMessageBuilder withTransactionId(String id) {
		response.setTransactionId(id);
		return this;
	}

	public ResponseMessage build() {
		return response;
	}
}