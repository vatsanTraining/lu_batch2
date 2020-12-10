package com.example.demo;
import java.io.*;

import com.example.demo.services.ProfessorService;
import com.example.model.*;
public class Application {

	public static void main(String[] args) {

		File file = new File("professor.ser");
		
		File textFile = new File("professor.txt");
		
		ProfessorService service = new ProfessorService();
		
		int key = 4;
		
		if(key ==1) {
			
		Professor prof = new Professor(3838, "Suresh", "ECE", "phd");
		
		
		   boolean result = service.writeObjectToFile(prof, file);
		   
		   if(result) {
			   System.out.println("One Object Serialized");
		   } else {
			   
			   System.out.println("Check -Exception ");
		   }
		}
		
		
		if(key ==2) {
			
			
			Professor prof = (Professor)service.readObjectFromFile(file);
			
			System.out.println("De serialized Professor :="+ prof);
		}
		
		if(key ==3) {
			
			Professor suresh = new Professor(3838, "Suresh", "ECE", "phd");
			
			Professor manish = new Professor(2838, "Manish", "Mech", "pg");
			
			System.out.println("Is added :=" +service.writeToTextFile(manish, textFile));
			
			System.out.println("Is Added :="+service.writeToTextFile(suresh, textFile));
			
		}
		
		if(key ==4 ) {
			
			Professor[] list = service.readFromTextFile(textFile);
			
			for(Professor eachProf : list) {
				
				if(eachProf!=null) {
					System.out.println(eachProf);
				}
			}
		}
	}

}
