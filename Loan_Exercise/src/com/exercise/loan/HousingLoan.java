package com.exercise.loan;

public class HousingLoan extends Loan {
	
		

	public HousingLoan() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	public HousingLoan(int cibilScore, double loanAmount, double termOfLoan) {
		super(cibilScore, loanAmount, termOfLoan);
		// TODO Auto-generated constructor stub
	}



	// User Methods
	
	@Override
	public double findRateOfInterest() {
		double interestAmount;
		double rateOfInterest;
		
		rateOfInterest = super.findRateOfInterest();
		
		interestAmount = ((super.getLoanAmount())*(super.getTermOfLoan())*(rateOfInterest))/100;
		
		return interestAmount;
	}
	
	

	
	
	
	
	
	
}
