package com.example.demo;

import com.training.ifaces.Conditional;

public class Student implements Conditional {

	@Override
	public boolean test(int value) {

		
		return value>90;
	}


	/*
	 *  The lines below define instance variables -rollnumber,studentname,markscored
	 *  Instance variables have a default value - 0,0.0,null,false
	 *  They can be used without assigning
	 */
	private int rollNumber;
	private String studentName;
	private double markScored;
	
	// Class Variable - with static key word - they have a default value
	public static final String trainerName  = "Javgal";
	
	// Zero Argument Constructor - Constructor can be overloaded
	public Student() {
		}
	
	
	// Constructors can be overloaded / 2 parameter constructor


	public Student(int rollNumber, String studentName) {
		
		// Calling the overloaded 3 argument constructor by passing the values
		this(rollNumber,studentName,99);
		
		this.rollNumber = rollNumber;
		this.studentName = studentName;
	}



	// Constructors can be overloaded / 3 parameter constructor

	public Student(int rollNumber, String studentName, double markScored) {
		super();
		// this()  => Cant have both this() and super() 
		// instance variable = parameter variable
		this.rollNumber = rollNumber;
		this.studentName = studentName;
		this.markScored = markScored;
	}

	public int getRollNumber() {
		return rollNumber;
	}


	public void setRollNumber(int rollNumber) {
		this.rollNumber = rollNumber;
	}


	public String getStudentName() {
		return studentName;
	}


	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}


	public double getMarkScored() {
		return markScored;
	}


	public void setMarkScored(double markScored) {
		this.markScored = markScored;
	}


	public String assignGrade() {
		
		// local Variable
		String grade = "O";
		
		/*
		 * Local Variable has to be initlized before use
		 * They cannot have any modifier like private,protected
		 */
		
		//String grade ;
		
		//System.out.println(grade);
		
		if(this.markScored <80) {
			grade ="A";
		}
		
		return grade;
	}


	@Override
	public boolean check() {
		// TODO Auto-generated method stub
		return this.markScored>60;
	}
	
	
	
}
