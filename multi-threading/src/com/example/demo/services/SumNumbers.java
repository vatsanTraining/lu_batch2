package com.example.demo.services;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class SumNumbers implements Callable<Integer>{

	private int countUpTo;
	
	public SumNumbers(int countUpTo) {
		
		this.countUpTo = countUpTo;
	}
		
	@Override
	public Integer call() throws Exception {
	int sum = 0;
		
		for(int i=0;i<=this.countUpTo;i++) {
			sum+=i;
		}
		
		System.out.println("Called By Thread :="+ Thread.currentThread().getName());
		
		TimeUnit.MILLISECONDS.sleep(100);
		
		return sum;
	
	}
}
