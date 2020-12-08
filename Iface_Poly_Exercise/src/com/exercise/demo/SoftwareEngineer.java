package com.exercise.demo;

import com.exercise.iface.Billable;

public class SoftwareEngineer implements Billable {

	@Override
	public double calculate() {
		// TODO Auto-generated method stub
		double salary = 20000.00;
		
		if((this.jobDescription).equals("Designer")) {
			salary = 30000.00;
		}else if ((this.jobDescription).equals("Full-Stack Developer")) {
			salary = 50000.00;
		}
		
		return salary;
	}
	
	@Override
	public void printCalculate() {
		// TODO Auto-generated method stub
		double salary = this.calculate();
		
		System.out.println(this.name + " with the job of "+ this.jobDescription +" earns Rs."+salary);
		
	}
	

	
	private String jobDescription;
	private String name;
	
	public SoftwareEngineer(String jobDescription, String name) {
		super();
		this.jobDescription = jobDescription;
		this.name = name;
	}

	public String getJobDescription() {
		return jobDescription;
	}

	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	

	



}
