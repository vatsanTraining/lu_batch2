package com.training.services;

import java.util.*;
import java.util.stream.*;

import com.training.model.CreditCard;

import static java.util.stream.Collectors.*;

public class StreamingService {

	
	private List<CreditCard> cardList;

	public StreamingService() {
		
		CreditCardService service = new CreditCardService();
		
		cardList = service.findAll();
	}
	
	
	public List<CreditCard> useFilter(){
	
//		ArrayList<CreditCard> subList = new ArrayList<>();
//		for(CreditCard card : cardList) {
//			
//			if(card.getCreditLimit()>50000) {
//				subList.add(card);
//			}
//		}
		
		return  cardList.stream().
		           filter(element -> element.getCreditLimit()>50000).
		           collect(toList());
		
	
	}
	
	
public List<String> useFilterAndMap(){
		
		
		return  cardList.stream().
		           filter(element -> element.getCreditLimit()>50000).
		           map(element -> element.getCardHolderName()).
		           collect(toList());
		
	}


public Map<String,Double> useFilterTransformToMap(){
	
	  
	
	return  cardList.stream().
	           filter(element -> element.getCreditLimit()>50000).
	           collect(toMap(CreditCard::getCardHolderName,CreditCard::getCreditLimit));
	
}

	
}

