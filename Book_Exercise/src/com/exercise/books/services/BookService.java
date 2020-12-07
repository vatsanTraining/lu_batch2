package com.exercise.books.services;

import com.exercise.books.Book;

public class BookService {
	
	private double discount = 0.0;
	
	public double calculateDiscount(Book currBook) {
		
		
		
		if(currBook.getPrice()>1000.00) {
			discount=(currBook.getPrice())*0.1;
		}
		else if ((currBook.getPrice()<1000.00)&&(currBook.getPrice()>500.00)) {
			discount=(currBook.getPrice())*0.05;
		}
		
		return discount;
	}

	public double calculateDiscount(Book currBook, String customerType) {
		
		if(customerType.equals("Corporate")) {
			discount=(currBook.getPrice())*0.2;
		}
		else if(customerType.equals("Retail")) {
			discount=(currBook.getPrice())*0.15;
		}
		
		return discount;
	}
}
