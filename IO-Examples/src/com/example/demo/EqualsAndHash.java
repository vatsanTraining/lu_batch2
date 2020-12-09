package com.example.demo;

public class EqualsAndHash {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Professor suresh = new Professor(3838, "Suresh", "ECE", "PHD");
		
		Professor otherSuresh = suresh;
		System.out.println("Is Suresh and otherSuresh equal :- "+ suresh.equals(otherSuresh));

		Professor suresh2 = new Professor(3838, "Suresh", "ECE", "PHD");
		System.out.println("Is Suresh and otherSuresh equal :- "+ suresh.equals(suresh2));
	}

}
