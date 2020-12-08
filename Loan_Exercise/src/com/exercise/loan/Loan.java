package com.exercise.loan;

public class Loan {
	
	private int cibilScore;
	private double loanAmount;
	private double termOfLoan;

	// Constructors 
	public Loan() {

	}



	public Loan(int cibilScore, double loanAmount, double termOfLoan) {
		super();
		this.cibilScore = cibilScore;
		this.loanAmount = loanAmount;
		this.termOfLoan = termOfLoan;
	}


// Setter and Getter Methods
	public int getCibilScore() {
		return cibilScore;
	}

	public void setCibilScore(int cibilScore) {
		this.cibilScore = cibilScore;
	}
	
	public double getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(double loanAmount) {
		this.loanAmount = loanAmount;
	}

	public double getTermOfLoan() {
		return termOfLoan;
	}

	public void setTermOfLoan(double termOfLoan) {
		this.termOfLoan = termOfLoan;
	}
	
	// User Methods


	public double findRateOfInterest() {
		double rateOfInterest = 8.2;
		if(this.cibilScore>500) {
			rateOfInterest = 7.5;
		}
		return rateOfInterest;
	}
	
	
}
