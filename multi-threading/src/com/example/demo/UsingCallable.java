package com.example.demo;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import com.example.demo.services.SumNumbers;

public class UsingCallable {

	
	public static void getFromFuture(Future<Integer> task) {
		
      while(!task.isDone()) {
    	  System.out.println("Waiting");
      }
			 
			 try {
				System.out.println(task.get() +":" +task.isDone());
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}
	
		
	}
	public static void main(String[] args) {

		
		ExecutorService executor = Executors.newFixedThreadPool(3);
		
		
	    Callable<Integer> upToTen = new SumNumbers(10);
		
		Callable<Integer> upToHundred = new SumNumbers(100);
		
		Callable<Integer> upToThousand = new SumNumbers(1000);
		

		Future<Integer> task1 = executor.submit(upToTen);
		
		Future<Integer> task2 = executor.submit(upToHundred);
		
		Future<Integer> task3 = executor.submit(upToThousand);
		
		
		getFromFuture(task1);
		getFromFuture(task2);
		getFromFuture(task3);
		
		
	}

}
