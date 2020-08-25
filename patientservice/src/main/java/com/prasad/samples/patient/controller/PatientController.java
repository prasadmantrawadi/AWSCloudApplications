package com.prasad.samples.patient.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PatientController {

	private final static Logger logger = LoggerFactory.getLogger(PatientController.class);
	
	@GetMapping(value = "/patients")
	public String getAllPatients(@AuthenticationPrincipal Jwt jwt) {
		logger.info("Inside Patient Service getAllPatients method");
		logger.info("Inside Doctor Service getData method");
		logger.info("***** JWT Headers: {}", jwt.getHeaders());
		logger.info("***** JWT Claims: {}", jwt.getClaims().toString());
		logger.info("***** JWT Token: {}", jwt.getTokenValue());
		logger.info(String.format("Patient Resource accessed by: %s (with subjectId: %s)" ,
	            jwt.getClaims().get("username"),
	            jwt.getSubject()));
		return "All Patients details from Patients Service";
	}
}
