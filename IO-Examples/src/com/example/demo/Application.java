package com.example.demo;

import java.io.*;
import com.example.demo.services.ProfessorService;

public class Application {

	public static void main(String[] args) {
		
		int key = 5;
		
		ProfessorService service = new ProfessorService();
		File file = new File("professor.ser");
		
		File textFile = new File("professor.txt");
		
		if(key==1) {
		
		Professor prof = new Professor(3838, "Suresh", "ECE", "PHD");
		
		
		
		boolean result = service.writeObjecttoFile(prof, file);
		
		if(result) {
			System.out.println("One Object Serialized");
		}
		else {
			System.out.println("Check -Exception");
		}

		}
		
		if(key==2) {
			
			Professor prof1 = new Professor(3838, "Suresh", "ECE", "PHD");
			Professor prof2 = new Professor(3839, "Sujesh", "ECE", "PHD");
			Professor prof3 = new Professor(3840, "Puresh", "ECE", "PHD");
			
			Professor prof[]= {prof1,prof2,prof3};
			
			boolean result = service.writeObjecttoFile(prof, file);
			
			if(result) {
				System.out.println("Objects Serialized");
			}
			else {
				System.out.println("Check -Exception");
			}
			
		}
	

	
		if(key==3) {
			
			Professor[] profs = (Professor[])service.readObjectFromFile(file);
			
			for( Professor prof:profs) { 
				System.out.println("De-Serialized Object: "+ prof);
				}
		}
		
		if(key==4) {
			Professor prof1 = new Professor(3838, "Suresh", "ECE", "PHD");
			Professor prof2 = new Professor(3839, "Sujesh", "ECE", "PHD");
			Professor prof3 = new Professor(3840, "Puresh", "ECE", "PHD");	
			
			Professor prof[]= {prof1,prof2,prof3,prof1,prof3,prof2,prof3};
			service.setIndex(prof.length);
			
			for(Professor eachProf: prof) {
				System.out.println("Is Added - "+ service.writeToTextFile(eachProf, textFile));
			}
			
		}
		
		if(key==5) {
			Professor[] list = service.readFromTextFile(textFile);
			
			for(Professor eachProf: list) {
				
				if(eachProf!=null) {
					System.out.println(eachProf);
				}
			}
			
		}
	}
	
	
}
