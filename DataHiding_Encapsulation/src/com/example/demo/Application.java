package com.example.demo;

public class Application {

	public static Double checkScholorship(Double markScored) {
		
		Double amount = 50000.00D;
		if(markScored <70) {
			amount = 35000.00D;
		} 
		return amount;
	}
	
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
		
		// Upcasting - cast not required
		
		byte rno = 103;
		
		Student manish = new Student();
		
		  manish.setRollNumber(rno);  // able to byte to int
		  manish.setStudentName("Manish Kumar");
		  manish.setMarkScored(67);
		  
		  
		  System.out.println(manish.getMarkScored());
			System.out.println(manish.getRollNumber());
			System.out.println(manish.getStudentName());

		  
		  System.out.println("Manish - Grade:="+ manish.assignGrade());
		  
		  // Variable Casting - down casting
		  
		  int roll= 56;
		  
		  byte broll =(byte)roll;
		  
		  String mark ="66"; //correct -can parse
		  String age ="SixtySix";// wrong - cannot parse Number Format Exception will be thrown
		  
		  int rollNumber = Integer.parseInt(args[0]);   // parsing String representation of number into integer
		  
		  double markScored = Double.parseDouble(args[2]);// parsing string to double
		  
		  
		  Student rishi = new Student(rollNumber,args[1],markScored);
		  
		  
		  System.out.println(rishi.getMarkScored());
			System.out.println(rishi.getRollNumber());
			System.out.println(rishi.getStudentName());
		  
		  System.out.println("Rishi - Grade:="+ rishi.assignGrade());

		  checkScholorship(rishi.getMarkScored());
		
	}

}
