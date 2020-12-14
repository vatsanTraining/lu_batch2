package com.example.demo;

import java.util.*;
import java.util.function.Predicate;

import com.training.model.CreditCard;

public class ApplicationMethodReference {

	public static boolean check(CreditCard card) {
		
		return card.getCardHolderName().length()>6;
			
	}
	
	public static void main(String[] args) {

		CreditCard card1 = new CreditCard(123, "Rajesh", 48482);
		CreditCard card2 = new CreditCard(223, "SunilKumar", 87482);
		CreditCard card3 = new CreditCard(163, "Sushil", 568482);
		
		List<CreditCard> cardList = new ArrayList<CreditCard>();
		
		cardList.add(card1);
		cardList.add(card2);
		cardList.add(card3);
		
		
		cardList.forEach(element -> System.out.println(element));
		
		cardList.forEach(System.out::println);
		
		
		Predicate<CreditCard> nameLength = ApplicationMethodReference::check;
		
		
		System.out.println("is Name Length More than 6 :=" +nameLength.test(card2));
		
		
		System.out.println("is Name Length More than 6 :=" +nameLength.test(card1));
		
		
		
		
	}
}
