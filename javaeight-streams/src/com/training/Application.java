package com.training;

import java.util.List;
import java.util.Map;

import com.training.services.StreamingService;

public class Application {

	public static void main(String[] args) {

		
		StreamingService service = new StreamingService();
		
		
		System.out.println("List of CardHolder 500000");
		service.useFilter().stream().forEach(System.out::println);
		
		
		System.out.println("List of cardHolder Names");
		service.useFilterAndMap().stream().forEach(System.out::println);
		
		
		Map<String,Double> list = service.useFilterTransformToMap();
		
		
		System.out.println("CardHolder Name and Limit");
		for(Map.Entry<String, Double> element:list.entrySet()) {
			
			System.out.println(element.getKey()  + element.getValue());
		}
		
		
		System.out.println("Sorted List");
		
		  service.sortedList().forEach(System.out::println);
		
		 	  
		  List<Number> result = service.findMaxCreditLimit();
		  
		  System.out.println("Maximum : = "+ result.get(0));
		  
		  System.out.println("Minimum : = "+ result.get(1));
		  
		  System.out.println("Count of Elements : = "+ result.get(2));
		  
		  
		  

	}

}
