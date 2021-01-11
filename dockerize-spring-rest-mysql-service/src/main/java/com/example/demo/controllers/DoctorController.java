package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Doctor;
import com.example.demo.services.DoctorService;

@RestController
public class DoctorController {

	
	private DoctorService service;

	@Autowired
	public void setDoctor(DoctorService service) {
		this.service = service;
	}
	
	
	@GetMapping(path = "/api/v1/doctors")
	public List<Doctor> getDoctor() {
		
		return this.service.getAll();
	}
	
	@PostMapping(path = "/api/v1/doctors")
	public Doctor addDoctor(@RequestBody Doctor entity) {
		
		return this.service.addDoctor(entity);
	}
	
	
}
