package com.training;

import java.util.Arrays;
import java.util.List;

public class Greeting {

	
	public String getMessage() {
		
		return "Hello World";
		
	}
	
	public List<String> getNames(){
		
		
		List<String> nameList = Arrays.asList("Nakul",null,"Nandhini","vicky");
		
		return nameList;
	}
}
