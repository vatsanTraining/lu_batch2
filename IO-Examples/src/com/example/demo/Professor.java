package com.example.demo;

import java.io.Serializable;

public class Professor implements Serializable{
	
	private int id;
	private String firstName;
	private String department;
	private transient String qualification;
	
	public Professor() {
		
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	

	public Professor(int id, String firstName, String department, String qualification) {
		
		this.id = id;
		this.firstName = firstName;
		this.department = department;
		this.qualification = qualification;
	}
	
	@Override
	public String toString() {
		return  id + "," + firstName + "," + department + "," + qualification ;
	}

	

	
	
	
	
}
