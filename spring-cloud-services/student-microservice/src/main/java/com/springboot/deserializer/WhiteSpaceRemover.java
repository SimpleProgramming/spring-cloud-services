package com.springboot.deserializer;

import java.io.IOException;

import org.springframework.boot.jackson.JsonComponent;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

@JsonComponent
public class WhiteSpaceRemover extends JsonDeserializer<String> {

	@Override
	public String deserialize(JsonParser arg0, DeserializationContext arg1)
			throws IOException, JsonProcessingException {
		return arg0.getValueAsString().trim();
	}
}