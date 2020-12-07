package com.mobile.exercise;

public class MobileBill {
	
	private String userName;
	private String planName;
	private String mobileNumber;
	private double planAmount;
	public static final String providerName = "Airtel";
	
	// Setters and Getters 
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPlanName() {
		return planName;
	}
	public void setPlanName(String planName) {
		this.planName = planName;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	

	
	// Default Constructor 
	public MobileBill() {
		
		
	}
	
	// Overloaded Constructors
	public MobileBill(String userName, String planName, String mobileNumber) {
		
		this.userName = userName;
		this.planName = planName;
		this.mobileNumber = mobileNumber;
		this.planAmount = getPlanAmount(this.planName);
	}
	
	public MobileBill(String userName, String mobileNumber) {
		this(userName, "Default", mobileNumber);
		this.userName = userName;
		this.mobileNumber = mobileNumber;
		this.planAmount = getPlanAmount(this.planName);
	}
	
	public double getPlanAmount(String planName) {
		double amount = 100.00;
		if(!(planName.equals("Default"))) {
			amount = 300.00;
		}
		return amount;
	}

	
	
	
	
	
	
	
	
	
	
}
