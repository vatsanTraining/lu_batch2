package com.example.demo;

import com.training.ifaces.Conditional;

public class Application {

	// Argument is Interface type , so any Object whose class is implementing conditional can be 
	// passed as argument
	public static void print(Conditional poly) {
		
		// poly will refer to some object which implements conditional 
		// and that objects check method will be called
		// Runtime polymorphism
		System.out.println(poly.check());
	}
	
	public static void main(String[] args) {
	
		
		Student ramesh = new Student(101,"Ramesh",67);
		
		boolean condition1 = ramesh.test(ramesh.getRollNumber());
		
		System.out.println("Student Test :="+ condition1);
		
		 Professor prof = new Professor(201, "manish", "ece", "phd");
		 
		  boolean condition2 = prof.test(prof.getId());
		  
		  System.out.println("Professor Test :="+ condition2);
		  
		  FindEven obj =new FindEven();
		  
		    boolean condition3 = obj.test(21);
		    
		    System.out.println("Is Even :="+ condition3);
		    
		    print(ramesh);
		    print(prof);
		    print(obj);
		}

}
