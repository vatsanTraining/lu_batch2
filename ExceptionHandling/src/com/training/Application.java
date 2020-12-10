package com.training;


import java.io.IOException;

import com.training.utils.ExceptionHandling;

public class Application {

	// declaring a name but initializing  name = "Ramesh";
	
	 static String name;

	public static void main(String[] args)  {
		
		
		// ExceptionHandling.usingTryCatch("66");
		 
		 
		 //ExceptionHandling.usingTryCatchFinally(name);
		 
		 
		 
		// int value = ExceptionHandling.usingTryCatchReturnFinally(name);
		
		// System.out.println("Length :===="+value);
		
		
//		 try {
//			ExceptionHandling.usingThrowAndThrowsClause();
//		} catch (IOException e) {
//			
//			System.err.println("Using Declare Rule of exception handling");
//			e.printStackTrace();
//		}

		
		try {
			ExceptionHandling.usingThrow();
		} catch (RuntimeException e) {

			System.out.println("Using Throw clause to throw exceptions");
			e.printStackTrace();
		}
	}
}
