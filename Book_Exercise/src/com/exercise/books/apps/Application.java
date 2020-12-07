package com.exercise.books.apps;

import com.exercise.books.Book;
import com.exercise.books.BookService.BookService;
import java.util.*;

public class Application {

	public static void main(String[] args) {
		Book newBook = new Book(1, "My Journey", "A.P.J. Abdul Kalam", 700.00);
		BookService service = new BookService();
		
		System.out.println("Enter The Customer Type : ");
		Scanner sc = new Scanner(System.in);
		String custType = sc.next();
		
		double discount = service.calculateDiscount(newBook);
		double specialDiscount = service.calculateDiscount(newBook, custType);
		
		System.out.println("Discount for "+ newBook.getBookName() +" is :" + discount);
		System.out.println("Discount for "+ custType +" for "+ newBook.getBookName() +" is : " + specialDiscount);
		
		sc.close();

	}

}
