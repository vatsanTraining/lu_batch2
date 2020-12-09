package com.exception.exercise;

public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			Student ram = new Student(101,"Ram",-1);
		} catch(RangeCheckException e) {
			System.err.println(e.getMessage());
			//e.printStackTrace();
		}
		
		Student ramesh = new Student();
		ramesh.setMarkScored(110);

	}

}
