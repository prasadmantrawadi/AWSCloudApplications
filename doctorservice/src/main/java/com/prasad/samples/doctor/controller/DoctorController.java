package com.prasad.samples.doctor.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DoctorController {


	@GetMapping(value = "/get-data")
	public String getData(HttpServletRequest  request, HttpServletResponse response) {
		System.out.println("Inside Doctor Service getData method");
		return "Hello from Doctor Service getData method!!";
	}
}
