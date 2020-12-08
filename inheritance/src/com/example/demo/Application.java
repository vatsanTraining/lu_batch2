package com.example.demo;

import com.example.demo.model.Student;
import com.example.demo.services.EnhancedStudentService;
import com.example.demo.services.StudentService;

public class Application {

	public static void main(String[] args) {

		
		Student ramesh = new Student(101,"Ramesh",98);
		
		Student rajesh = new Student(102,"Rajesh",88);
		
		Student rakesh = new Student(103,"Rakesh",98);
		
		// initializing
		Student[] list1 = {ramesh,rajesh,rakesh};
		
		// Declaring an array
		Student[] list2 = new Student[3];
		
		// storing values to the the array
		list2[0]  = ramesh;
		list2[1]  = rajesh;
		list2[2] =rakesh;
	
		
		
		
		StudentService service = new EnhancedStudentService();
		
		service.printStudentList(list1);
		
		System.out.println("================");
		
		service.printStudentList(list2);
		
		System.out.println("================");

		
		service.displayList(ramesh,rajesh);

		System.out.println("================");

		
		service.displayList(ramesh,rajesh,rakesh);
	}

}
