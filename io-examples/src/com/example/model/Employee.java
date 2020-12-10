package com.example.model;

//public final class Employee {

public  class Employee{
	
	private int id;
	private String name;
	public Employee() {
		// TODO Auto-generated constructor stub
	}
	public Employee(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + "]";
	}
	
	
	public String show() {
		final int a =5;
		// final variable cannot be reassigned
		//a++;
		return "Hello From Employee";
	}
}
