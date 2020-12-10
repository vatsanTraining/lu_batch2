package com.example.model;

// A final class cannot be subclassed
//public class Manager extends Employee{
//
//}

public class Manager extends Employee{
	
	// A Final method cannot be overridden
@Override  	
public  String show() {
		
		return "Hello From Employee";
	}
}