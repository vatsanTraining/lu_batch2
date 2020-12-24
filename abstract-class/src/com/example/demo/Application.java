package com.example.demo;

import com.example.demo.model.BankAccount;
import com.example.demo.model.SavingsAccount;
public class Application {

	
	public static void main(String[] args) {

		
		// superType = subtype  => always allowed
		
		BankAccount account = new SavingsAccount(9833, "Ramesh", 1000, "nalini");
		

		
		 account.deposit(5000);
		 account.deposit(15000);
		 
		 account.deposit(150000);

		 System.out.println("Current Balance :="+ account.getCurrentBalance());
		 
		 
	}

}
