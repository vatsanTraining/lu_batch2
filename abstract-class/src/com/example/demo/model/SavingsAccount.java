package com.example.demo.model;

public class SavingsAccount extends BankAccount {

	
	private String nominee;
	
	
	
	public SavingsAccount(long accountNumber, String accountHolderName, double currentBalance, String nominee) {
		super(accountNumber, accountHolderName, currentBalance);
		this.nominee = nominee;
	}

	
	@Override
	public double withdraw(double amount) {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public double deposit(double amount) {

		double currentBalance = getCurrentBalance();
		
		if(amount<100000) {
		 currentBalance = currentBalance + amount;
		
		setCurrentBalance(currentBalance);
		} else {
			System.out.println("Limit Exceeds - Try Again tomorrow");
		}
		return  currentBalance;
	}


	public String getNominee() {
		return nominee;
	}


	public void setNominee(String nominee) {
		this.nominee = nominee;
	}

	public void showAll() {
		
	}
	
}
