package com.exercise.loan.apps;

import com.exercise.loan.HousingLoan;
import com.exercise.loan.Loan;

public class Application {

	public static void main(String[] args) {
		
		Loan normalLoan = new Loan(550,50000,2);
		HousingLoan specialLoan = new HousingLoan(250,50000,2);
		
		System.out.println("The Interest Rate on Normal Loan is "+ normalLoan.findRateOfInterest()+ "%");
		System.out.println("The Simple Interest of Special Loan is Rs."+ specialLoan.findRateOfInterest());

	}

}
