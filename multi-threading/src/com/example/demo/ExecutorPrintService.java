package com.example.demo;

import com.example.demo.services.PrintNames;

public class ExecutorPrintService implements Runnable {

	private String str1;
	private String str2;
	
	
	public ExecutorPrintService(String str1, String str2) {
		super();
		this.str1 = str1;
		this.str2 = str2;
		
			}
	@Override
	public void run() {

		PrintNames.print(str1, str2);
		
	}

}
