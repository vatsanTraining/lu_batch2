package com.example.demo.services;

public class UsingLambdas {

	
	
	public static void  usingAnnonymousClass() {
		
		
		Thread thread = new Thread(new Runnable() {
			
			@Override
			public void run() {
				
				for(int i=0;i<5;i++) {
					 System.out.println(Thread.currentThread().getName() +i);
				}
				
			}
		});
		
		thread.start();
	}
	
	public static void usingLambda() {
		
		Thread thread = new Thread( ()-> {
			
			for(int i=0;i<5;i++) {
				 System.out.println(Thread.currentThread().getName() +i);
			}
		});
		
		thread.start();
	}
	
	public static void passingLambda(Runnable target) {
		
		
		Thread thread = new Thread(target);
		
		 thread.start();
	}
}
