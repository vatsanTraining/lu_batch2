package com.training;
import java.util.*;

import com.training.model.CreditCard;
import com.training.services.Transaction;
public class UsingSet {

	public static void main(String[] args) {

		
		
		HashSet<Transaction> txn = new HashSet<>();
		
		
		  txn.add(new Transaction(101, "jio payment", 450));
		  txn.add(new Transaction(102, "tata sky", 650));
		  
		  
 
		  System.out.println(txn);
		  
		  
		  HashMap<String,CreditCard> cardList = new HashMap<>();
		  
			CreditCard card1 = new CreditCard(49494, "Rakesh", 560000);
			CreditCard card2 = new CreditCard(78841, "Manish", 50000);
			CreditCard card3 = new CreditCard(78841, "Manish", 700000);

			
			System.out.println(cardList.put(card1.getCardHolderName(), card1));
			System.out.println(cardList.put(card2.getCardHolderName(), card2));
			
			System.out.println(cardList.put(card3.getCardHolderName(), card3));
			
			
			System.out.println(cardList.get("Manish"));
			
			
			Set<Map.Entry<String, CreditCard>> setView = cardList.entrySet();
			
			
			for(Map.Entry<String, CreditCard> eachEntry : setView) {
				
				System.out.println(eachEntry.getKey());
				System.out.println(eachEntry.getValue());
				
			}
		  
			List<String> names2 = new ArrayList<>();
			 names2.add("Manish");
			 
			 
			List<String> names = Arrays.asList("Ramesh","Suresh","Manish");
			
			System.out.println(names);
	}

}
