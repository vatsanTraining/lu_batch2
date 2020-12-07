package com.example.demo.services;

import com.example.demo.Professor;

public class PaymentService {

	
	// The modifer is protected --->
	
	protected double calculateSalary(Professor prof) {
		
		 double salary = 50000.00;
		 
		 // Objects like String should be compared with .equals and not  ==
		 if(prof.getQualification().equals("PG")) {
			 salary = 60000.00;
			 
			 // can also case insenstive comparison with ignorecase
		  } else if (prof.getQualification().equalsIgnoreCase("phd")) {
			
			 salary = 75000.00;
		  } 
			 
		 	 	 return salary;
		
	}
		// Switch case with String - New from Java 7 - earlier it was just int and char
	public double calculateSalary(String qualification) {
		
		 String key = qualification.toUpperCase();
		switch (key) {
		case "PG":
			return 60000.00;
		case "PHD":
			return 75000.00;
		default:
			return 50000.00;
		}
		
	}
}
