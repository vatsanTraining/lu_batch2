package com.training.utils;

import java.util.Comparator;

import com.training.model.CreditCard;

public class CreditLimitComparator implements Comparator<CreditCard> {

	private SortOrder order;
	
	public CreditLimitComparator(SortOrder order) {
		super();
		this.order = order;
	}

	@Override
	public int compare(CreditCard o1, CreditCard o2) {
		
		if(order.equals(SortOrder.ASCENDING)) {

			if(o1.getCreditLimit() < o2.getCreditLimit()) return 1;
			
			if(o1.getCreditLimit() > o2.getCreditLimit()) return -1;
			
			return 0;
		} else {
			
            if(o1.getCreditLimit() < o2.getCreditLimit()) return -1;
			
			if(o1.getCreditLimit() > o2.getCreditLimit()) return 1;
			
			
			return 0;
		}
	}

}
