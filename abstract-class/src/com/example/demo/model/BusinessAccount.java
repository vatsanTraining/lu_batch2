package com.example.demo.model;

public class BusinessAccount extends BankAccount {

	private String businessType;
	
	
	public String getBusinessType() {
		return businessType;
	}

	public void setBusinessType(String businessType) {
		this.businessType = businessType;
	}

	public BusinessAccount(long accountNumber, String accountHolderName, double currentBalance, String businessType) {
		super(accountNumber, accountHolderName, currentBalance);
		this.businessType = businessType;
	}

	@Override
	public double deposit(double amount) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double withdraw(double amount) {
		// TODO Auto-generated method stub
		return 0;
	}

}
