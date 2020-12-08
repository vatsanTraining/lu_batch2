package com.example.demo;

import com.example.demo.model.BankAccount;
import com.example.demo.model.BusinessAccount;
import com.example.demo.model.SavingsAccount;

public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BankAccount SavAccount = new SavingsAccount(9833, "Ramesh", 6000, "Nalini");
		BankAccount BusAccount = new BusinessAccount(9833, "Ramesh", 28000, "Nalini");
		
		
		SavAccount.deposit(50000);
		SavAccount.deposit(45000);
		SavAccount.withdraw(1000);
		SavAccount.deposit(45000);
		SavAccount.deposit(2000);
		SavAccount.withdraw(96000);
		
		System.out.println("================================");
		
		BusAccount.deposit(500000);
		BusAccount.deposit(450000);
		BusAccount.withdraw(30000);
		BusAccount.deposit(450000);
		BusAccount.deposit(40000);
		BusAccount.withdraw(960000);
		
		
		
	}

}
