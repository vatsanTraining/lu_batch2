package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Doctor;

@RestController
public class DoctorController {

	
	
	private Doctor doctor;

	@Autowired
	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
	
	
	@GetMapping(path = "/api/v1/doctors")
	public Doctor getDoctor() {
		
		return this.doctor;
	}
	
}
