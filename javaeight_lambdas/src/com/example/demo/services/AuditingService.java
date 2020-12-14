package com.example.demo.services;

import com.example.demo.func.ifaces.Calculate;
import com.example.demo.func.ifaces.Compute;

public class AuditingService implements Calculate<Double, Double>, Compute<Long, Long> {

	@Override
	public Long compute(Long value) {
		return value * 10;
	}

	
	@Override
	public double offer() {
		//return Calculate.super.offer();
		
		//return Compute.super.offer();
		
		return Compute.super.offer() + Calculate.super.offer();
		
		// return 200.00;
	}


	

	@Override
	public Double apply(Double t) {
		// TODO Auto-generated method stub
		return null;
	}

}
