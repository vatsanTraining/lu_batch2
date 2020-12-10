package com.training.utils;

import java.io.IOException;


public class ExceptionHandling {

	// using try catch 
	
	public static void  usingTryCatch(String mark) {
		
		
		try {
			
            int markScored = Integer.parseInt(mark);
		    
		    System.out.println(markScored);
		    
		} catch (NumberFormatException e) {
			
			System.err.println("Mark should be a Positive Integer - and not String ");
			
			e.printStackTrace();
		}
		    
		System.out.println("Completed");
	}
	
	// using try-catch-finally
	
	public static void  usingTryCatchFinally(String name) {
		
		try {
			
			int length = name.length();
		    
		     System.out.println("Length of the given String :"+length);
		    
		} catch (NullPointerException e) {
			
			System.err.println("Argument Name is Null - check again");
			
			  e.printStackTrace();
		
		}finally {
			System.out.println("Inside Finally Block");
		}
		
		System.out.println("Completed");
		     	     
		
	}

	// understanding the working of the finally

	
      public static int  usingTryCatchReturnFinally(String name) {
		
    	  int length=0;
		try {
			
			length = name.length();
		    
		     System.out.println("Length of the given String :"+length);
		    
		} catch (NullPointerException e) {
			
			System.err.println("Argument Name is Null - check again");
			
			  e.printStackTrace();
			  
			  return 420;
		
		}finally {
			System.out.println("Inside Finally Block");
		}
		
		System.out.println("Completed ***");
		     	     
		return length;
		
	}

      // using throws clause
      
      public static void usingThrowAndThrowsClause() throws IOException {
    	  
    	  
    	 int intChar =   System.in.read();
    	  
    	 System.out.println(intChar);
    	  
      }
      
      // using throw 
      public static void usingThrow() {
    	  
    	  
    	   throw new RuntimeException("Hee Hee");
      }
}
