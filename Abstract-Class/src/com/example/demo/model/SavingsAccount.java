package com.example.demo.model;

public class SavingsAccount extends BankAccount {

	private String nominee;
	
	
	
	public SavingsAccount(long accountNumber, String accountHolderName, double currentBalance, String nominee) {
		super(accountNumber, accountHolderName, currentBalance);
		this.setNominee(nominee);
	}

	public String getNominee() {
		return nominee;
	}

	public void setNominee(String nominee) {
		this.nominee = nominee;
	}

	@Override
	public double deposit(double amount) {
		// TODO Auto-generated method stub
		
		double currentBalance = getCurrentBalance();
		double clearBalance = currentBalance;
		
		if((currentBalance+amount)<=100000) {
			System.out.println("Amount Deposited: "+ amount);
			clearBalance = currentBalance + amount;		
			setCurrentBalance(clearBalance);
		}else {
			System.out.println("Amount Deposited: "+ amount);
			System.out.println("You can deposit maximum Rs. 1 Lakh!");
		}
		
		System.out.println("Current Balance: Rs." + clearBalance);
		return clearBalance;
		
	}

	@Override
	public double withdraw(double amount) {
		// TODO Auto-generated method stub
		
		double currentBalance = getCurrentBalance();
		double clearBalance = currentBalance;

		if((currentBalance-amount)>=5000) {
			System.out.println("Amount Withdrawn: "+ amount);
			clearBalance = currentBalance - amount;		
			setCurrentBalance(clearBalance);
		}else {
			System.out.println("Amount Withdrawn: "+ amount);
			System.out.println("Minimum Balance has to be Rs. 5000");
		}
		
		System.out.println("Current Balance: Rs." + clearBalance);
		return clearBalance;
		
			}

}
