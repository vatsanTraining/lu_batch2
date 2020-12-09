package com.exception.exercise;

public class Student {
	
	
	// Instance Variables - they have a default value, can be used without assigning 
	private int rollNumber;
	private String studentName;
	private double markScored;
	
	// Class Variable - with Static keyword, has default value
	public static final String trainerName = "JavaWorld";
	
	// Zero Argument Constructor
	public Student() {
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
	try {
			
			if(markScored >= 0 && markScored <=100) {
				this.markScored = markScored;
			} else {
				throw new RangeCheckException("marks should be between 0 and 100");
			}
			
		} catch (RangeCheckException e) {
			System.err.println(e.getMessage());
			// e.printStackTrace();
		}
		}
	
	

	// Constructors can be Overloaded
	
	
	public Student(int rollNumber, String studentName, double markScored) throws RangeCheckException {
		
		this.rollNumber = rollNumber;
		this.studentName = studentName;
		this.markScored = markScored;
		
		if(markScored >=0 && markScored <=100) {
			this.markScored = markScored;
		} else {
			throw new RangeCheckException("Marks should be between 0 and 100");
		}
		
	}

	
}
