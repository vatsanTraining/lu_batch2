package com.training;

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
		
		
		
		 
	}

}
