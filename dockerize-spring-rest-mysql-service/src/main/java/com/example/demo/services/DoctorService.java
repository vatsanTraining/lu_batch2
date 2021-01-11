package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Doctor;
import com.example.demo.repos.DoctorRepository;

@Service
public class DoctorService {

	
	@Autowired
	private DoctorRepository repo;


	public List<Doctor> getAll(){
		
		return this.repo.findAll();
	}

	public Doctor addDoctor(Doctor entity) {
		
		return this.repo.save(entity);
	}
}
