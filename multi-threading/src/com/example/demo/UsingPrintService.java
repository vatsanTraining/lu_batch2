package com.example.demo;

import com.example.demo.services.PrintNames;

public class UsingPrintService implements Runnable {

	private String str1;
	private String str2;
	
	
	public UsingPrintService(String str1, String str2) {
		super();
		this.str1 = str1;
		this.str2 = str2;
		
		Thread thread = new Thread(this);
		thread.start();
	}


	@Override
	public void run() {

		PrintNames.print(str1, str2);
		
	}

}
