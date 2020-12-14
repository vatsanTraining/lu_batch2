package com.example.demo;

import com.example.demo.func.ifaces.UsingPredicate;
import com.training.model.CreditCard;

public class ApplicationForPredicate {

	public static void main(String[] args) {

		
		CreditCard card1 = new CreditCard(1010, "Ramesh", 47000);
		
		CreditCard card2 = new CreditCard(2020, "Rajesh", 77000);
		
		UsingPredicate.plainPredicate(card1);
		
		UsingPredicate.plainPredicate(card2);
		
		
		
	}

}
