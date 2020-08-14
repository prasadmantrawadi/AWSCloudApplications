package com.prasad.samples.patient.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PatientController {

	
	@GetMapping(value = "/get-data")
	public String getData(HttpServletRequest  request, HttpServletResponse response) {
		System.out.println("Inside Patient Service getData method");
		return "Hello from Patient Service getData method!!";
	}
}
