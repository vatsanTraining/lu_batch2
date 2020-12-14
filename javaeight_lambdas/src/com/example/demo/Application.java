package com.example.demo;

import com.example.demo.func.ifaces.Calculate;
import com.example.demo.services.UsingLambdas;

public class Application {

	
	public static Runnable getLambda(int start , int end) {
		
		Runnable target = () -> {
			
			for(int j=start;j<end;j++) {
				System.out.println(j);
			}
		};
		
		return target;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		
		UsingLambdas.usingAnnonymousClass();
		
		UsingLambdas.usingLambda();
		
		
		Runnable target = () -> {
			
			for(int j=10;j<15;j++) {
				System.out.println(j);
			}
		};
		
		UsingLambdas.passingLambda(target);

		Runnable target2 = getLambda(20, 25);
				
	      UsingLambdas.passingLambda(target2);			
				
	     Calculate<Double, Double> lambda = (dlrAmt) -> dlrAmt * 100.00;
	     
				System.out.println(lambda.apply(450d));
				System.out.println("Offer: =" +lambda.offer());
				
		Calculate<Long, Long> obj = (faren) ->  faren-32 * 5/19;		
		
		
	}

}
