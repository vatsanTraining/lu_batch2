package com.example.demo;

import com.training.ifaces.Conditional;

public class FindEven implements Conditional {

	@Override
	public boolean test(int value) {
		return value%2 ==0;
	}

	@Override
	public boolean check() {
		// TODO Auto-generated method stub
		return 67%2 ==0;
	}

}
