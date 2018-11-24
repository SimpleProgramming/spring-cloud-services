package com.springboot;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.autoconfigure.web.ErrorController;

import com.springboot.model.AuditLog;

public class ZuulErrorHandler implements ErrorController {

	@Override
	public String getErrorPath() {
		String s = null;
		List<AuditLog> auditLog = new ArrayList<>();
		
		return null;
	}

}
