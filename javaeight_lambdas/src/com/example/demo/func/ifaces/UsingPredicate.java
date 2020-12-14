package com.example.demo.func.ifaces;

import java.util.function.BiPredicate;
import java.util.function.DoublePredicate;
import java.util.function.Predicate;

import com.training.model.CreditCard;

public class UsingPredicate {

	
	// Predicate with Objects
	public static void plainPredicate(CreditCard card) {
		
		Predicate<CreditCard> checkLimit = ccard -> ccard.getCreditLimit()>50000;
		
		System.out.println("Is Greater than 50000 :="+ checkLimit.test(card));
	}
	
	// Predicate with Primitives
   public static void primitivePredicate(double amount) {
		
		DoublePredicate checkLimit = cardLimit -> cardLimit>50000;
		
		System.out.println("Is Greater than 50000 :="+ checkLimit.test(amount));
	 
		
		
	}
   
   // Bi Predicate - with two arguments
   
   public static void usingTwoArgsPredicate(CreditCard card, double expected) {
	   
	   // Creating a Lambda for BiPredicates and its method test
	   
	    BiPredicate<Double, Double> obj = new BiPredicate<Double, Double>() {
			
			@Override
			public boolean test(Double t, Double u) {
				return t>u;
			}
		};
		
	   BiPredicate<Double, Double> checkLimit = (limit,expt) -> limit>expt;
	   
	   
	   System.out.println(checkLimit.test(card.getCreditLimit(), expected));
	   
	   
	   
   }
   
   
}
