package com.example.demo.services;
import static java.lang.Math.*;
import com.example.demo.Professor;

public class PaymentService {

	private double housingLoan;
	
	private static double houseLoan;
	
	
	// The modifer is protected --->
	// If its protected it can only accessed in samepackage or subclasses 
	// protected double calculateSalary(Professor prof) {
		
		public double calculateSalary(Professor prof) {
		 double salary = 50000.00;
		 
		 // Objects like String should be compared with .equals and not  ==
		 if(prof.getQualification().equals("PG")) {
			 salary = 60000.00;
			 
			 // can also case in-sensitive comparison with ignore case
		  } else if (prof.getQualification().equalsIgnoreCase("phd")) {
			
			 salary = 75000.00;
		  } 
			 
		 	 	 return salary;
		
		 	 	 
	}
	// The following method is a overloaded Method argument is String than Professor
		// Switch case with String - New from Java 7 - earlier it was just int and char
	public double calculateSalary(String qualification) {
		
		System.out.println(housingLoan);
		
				System.out.println(houseLoan);
		
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
	
	
	public static void printHousingLoand() {
		
		//System.out.println(housingLoan);
		
		System.out.println(houseLoan);
		
		// static method accessed without Class name because static import is used
				System.out.println(sqrt(4));
				
				System.out.println(Math.sin(30));
				
	}
	
	
}
