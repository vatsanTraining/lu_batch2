package com.exercise.demo;

import com.exercise.iface.Billable;

public class Application {
	
	public static void print(Billable jobDescription) {
		jobDescription.printCalculate();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SoftwareEngineer ramesh = new SoftwareEngineer("Designer", "Ramesh");
		print(ramesh);
		
		Footballer suresh = new Footballer("Forward", "Suresh");
		print(suresh);
	}

}
