package com.example.demo;
import com.example.demo.services.CountingService;
public class CountingManager implements Runnable {

	private int countUpTo;
	private String threadName;
	
	private CountingService service;
	
	
	public CountingManager(int countUpTo, String threadName) {
		super();
		this.countUpTo = countUpTo;
		this.threadName = threadName;
		
		this.service = new CountingService();
		
		Thread thread = new Thread(this, this.threadName);  
		thread.start();
		
	}
	@Override
	public void run() {

		 this.service.countNumbers(countUpTo);
	}

}
