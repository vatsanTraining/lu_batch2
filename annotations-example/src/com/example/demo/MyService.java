package com.example.demo;

import com.example.demo.stereotypes.MyBean;

@MyBean(name = "student")
public class MyService {

	
	@MyBean(scope = "request", name = "vidyarthi")
	public String show() {
		
		return "Hello";
	}
}
