package com.example.demo.services;

import com.example.demo.model.Student;

public class EnhancedStudentService extends StudentService {

	@Override
	public void printStudentList(Student[] students) {
	
		for(Student eachStudent: students) {
			print(eachStudent);
		}
	}
	@Override
	public void displayList(Student... students) {

		printStudentList(students);
	}
	private void print(Student student) {
		System.out.println("Roll Number :=" +student.getRollNumber());
		System.out.println("Name :="+student.getStudentName());
	    System.out.println("Mark Scored:="+student.getMarkScored());		
	
	}
}
