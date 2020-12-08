package com.example.demo.model;

public class BusinessAccount extends BankAccount {

	private String businesstype;
	
		
	public BusinessAccount(long accountNumber, String accountHolderName, double currentBalance, String businesstype) {
		super(accountNumber, accountHolderName, currentBalance);
		this.setBusinesstype(businesstype);
	}

	public String getBusinesstype() {
		return businesstype;
	}

	public void setBusinesstype(String businesstype) {
		this.businesstype = businesstype;
	}

	@Override
	public double deposit(double amount) {
		// TODO Auto-generated method stub
		double currentBalance = getCurrentBalance();
		double clearBalance = currentBalance;
		
		if((currentBalance+amount)<=1000000) {
			System.out.println("Amount Deposited: "+ amount);
			clearBalance = currentBalance + amount;		
			setCurrentBalance(clearBalance);
		}else {
			System.out.println("Amount Deposited: "+ amount);
			System.out.println("You can deposit maximum Rs. 10 Lakh!");
		}
		
		System.out.println("Current Balance: Rs." + clearBalance);
		return clearBalance;
		
	}

	@Override
	public double withdraw(double amount) {
		// TODO Auto-generated method stub
		double currentBalance = getCurrentBalance();
		double clearBalance = currentBalance;

		if((currentBalance-amount)>=25000) {
			System.out.println("Amount Withdrawn: "+ amount);
			clearBalance = currentBalance - amount;		
			setCurrentBalance(clearBalance);
		}else {
			System.out.println("Amount Withdrawn: "+ amount);
			System.out.println("Minimum Balance has to be Rs. 25000");
		}
		
		System.out.println("Current Balance: Rs." + clearBalance);
		return clearBalance;
	}

}
