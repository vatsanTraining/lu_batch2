package com.mobile.exercise;

public class Application {

	public static void main(String[] args) {
		
		MobileBill shreyas = new MobileBill();
		shreyas.setUserName("Shreyas");
		shreyas.setMobileNumber("9448121234");
		shreyas.setPlanName("Bonus Pack");
	
		
		System.out.println(shreyas.getUserName());
		System.out.println(shreyas.getMobileNumber());
		System.out.println(shreyas.getPlanName());
		System.out.println(MobileBill.providerName);
		System.out.println(shreyas.getPlanAmount(shreyas.getPlanName()));
		
		MobileBill ramesh = new MobileBill("Ramesh", "Default", "9232345432");
		
		System.out.println(ramesh.getUserName());
		System.out.println(ramesh.getMobileNumber());
		System.out.println(ramesh.getPlanName());
		System.out.println(MobileBill.providerName);
		System.out.println(ramesh.getPlanAmount(ramesh.getPlanName()));
		
		MobileBill suresh = new MobileBill("Suresh","9432452341");
		

	}

}
