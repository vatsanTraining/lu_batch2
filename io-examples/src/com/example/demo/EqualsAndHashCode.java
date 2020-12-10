package com.example.demo;

import com.example.model.Professor;

public class EqualsAndHashCode {

	public static void main(String[] args) {

		
		Professor suresh = new Professor(3838, "Suresh", "ECE", "phd");
		
		Professor otherSuresh = suresh;
		
		System.out.println("Is suresh and OtherSuresh Equal :="+ suresh.equals(otherSuresh));
		
		
		
		Professor suresh2 = new Professor(3838, "Suresh", "ECE", "phd");
		
		System.out.println("Is suresh and Suresh2 Equal :="+ suresh.equals(suresh2));
		
		System.out.println( suresh==suresh2);
		
		
	}

}
