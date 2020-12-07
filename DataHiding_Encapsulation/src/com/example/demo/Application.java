package com.example.demo;

public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Student ram = new Student();
		
		// 
		System.out.println(ram.getMarkScored());
		System.out.println(ram.getRollNumber());
		System.out.println(ram.getStudentName());
		
		System.out.println(Student.trainerName);
		
		// Its constant because defined as final.
		//Student.trainerName = "srinath";
		
		System.out.println(Student.trainerName);
		
		Student ramesh = new Student(101,"Ramesh",67);
		
		System.out.println(ramesh.getMarkScored());
		System.out.println(ramesh.getRollNumber());
		System.out.println(ramesh.getStudentName());
		
		System.out.println(" Ramesh - Grade:= "+ ramesh.assignGrade());
		
		
        Student rajesh = new Student(102,"Rajesh");
		
		System.out.println(rajesh.getMarkScored());
		System.out.println(rajesh.getRollNumber());
		System.out.println(rajesh.getStudentName());
		
		System.out.println(" Rajesh - Grade:= "+ rajesh.assignGrade());
		
		
		
	}

}
