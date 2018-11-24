package com.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.sleuth.Span;
import org.springframework.cloud.sleuth.Tracer;
import org.springframework.cloud.sleuth.annotation.ContinueSpan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.model.Student;
import com.springboot.service.StudentService;
import com.springboot.validator.StudentValidator;

@RestController
@RequestMapping("/api/student")
public class StudentController {

	@Autowired
	private StudentValidator studentValidator;

	@Autowired
	private StudentService service;

	@Value("${configuration.property.value}")
	private String from_config_server;

	@Autowired
	private Tracer tracer;

	@InitBinder("student")
	protected void initBinderForStudent(WebDataBinder binder) {
		binder.addValidators(studentValidator);
	}

	@PostMapping
	@ContinueSpan
	public ResponseEntity<Student> insertStudentDetails(@Validated @RequestBody Student student,
			@RequestHeader("request-id") String requestId) {
		Span span = tracer.createSpan("insertStudentDetails");
		span.tag("request-id", requestId);
		Student result = service.insertStudentRecord(student);
		tracer.close(span);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	@GetMapping(path = "/config")
	public String fromConfigServer() {
		return from_config_server;
	}

	@GetMapping(path = "{id}/{lastName}")
	public ResponseEntity<Student> getStudentDetails(@PathVariable(name = "id") String id,
			@PathVariable(name = "lastName") String lastName) {
		return new ResponseEntity<>(service.fetchStudentDetails(id, lastName), HttpStatus.OK);
	}

}