package com.training.services;

import java.util.*;
import java.util.function.Function;
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
	
	  Function<CreditCard,CreditCard> valuePart = (card) -> 
	           { return new CreditCard(card.getCardNumber(),card.getCardHolderName());};
	
	return  cardList.stream().
	           filter(element -> element.getCreditLimit()>50000).
	           collect(toMap(CreditCard::getCardHolderName,CreditCard::getCreditLimit));
	
	
//	return  cardList.stream().
//	           filter(element -> element.getCreditLimit()>50000).
//	           collect(toMap(CreditCard::getCardHolderName,valuePart));
	
}

  public List<CreditCard> sortedList(){
	  
	  
	  return  cardList.stream()
	     .sorted(Comparator.comparing(CreditCard::getCardHolderName))
	      .collect(toList());
	  
}
  
  public List<Number>  findMaxCreditLimit() {


	  Optional<Double> maxValue=  cardList.stream()
			    .map(element -> element.getCreditLimit())
			     .max(Double::compareTo);

	  Optional<Double> minValue=  cardList.stream()
			    .map(element -> element.getCreditLimit())
			     .min(Double::compareTo);

		 Long count=  cardList.stream()
				    .map(element -> element.getCreditLimit())
				     .count();


	  double max =0.0;
	  double min = 0.0;
	  
      if(maxValue.isPresent()) {
		  max = maxValue.get();
	  } 
      if(minValue.isPresent()) {
		  min = minValue.get();
	  } 
      
      List<Number> result = Arrays.asList(max,min,count);
	
      return result;
  }
  
	
}

