package com.training;

import java.util.Collection;
import java.util.List;

import com.training.model.CreditCard;
import com.training.services.CreditCardService;
import com.training.utils.SortOrder;

public class Application {

	public static void print(Collection<CreditCard> list) {
		
		for(CreditCard eachCard :list) {
			 System.out.println(eachCard);
		 }
		
	}
	
	private static void printSelected(List<CreditCard> list, int limit ) {
		
		
		for(int i=0;i<limit;i++) {
			
			System.out.println(list.get(i));
		}
		
	}

	public static void main(String[] args) {

		
		
		CreditCard card1 = new CreditCard(49494, "Rakesh", 560000);
		CreditCard card2 = new CreditCard(78841, "Manish", 50000);
		CreditCard card3 = new CreditCard(76434, "Shiv",  260000);
		CreditCard card4 = new CreditCard(25494, "Vaibhav", 860000);
	
		CreditCardService service = new CreditCardService();
		
		 System.out.println(service.add(card1));
		 System.out.println(service.add(card2));
		 System.out.println(service.add(card3));
		 System.out.println(service.add(card4));
		 
		 
		 List<CreditCard> list = service.findAll();
		 
		  print(list);
		  
		  
		  System.out.println("Sorted By Name");
		  
		  List<CreditCard> sortedByName = service.sortedList("cardHolderName");
		  
		  print(sortedByName);
		  
		  
		  System.out.println("Sorted By Card Number");

		  List<CreditCard> sortedByNumber = service.sortedList("cardNumber");
		  
		  print(sortedByNumber);
		  
		  
		  int limit = 2;
		  
		  System.out.println("Top "+limit +" Credit Limit");
		  
		  List<CreditCard> sortedByLimitAsc = service.sortedList("creditLimit", SortOrder.ASCENDING);
		  
		   printSelected(sortedByLimitAsc,limit);
		   
		   
			  System.out.println("Least  "+ limit +"  Credit Limit");

		   List<CreditCard> sortedByLimitDesc = service.sortedList("creditLimit", SortOrder.DESCENDING);
			  
		   printSelected(sortedByLimitDesc,limit);
		   
		 
		
	}

	
}
