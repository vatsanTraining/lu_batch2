package com.example.demo.func.ifaces;

@FunctionalInterface
public interface Compute<T,R> {

	public R compute(T value);
	
	
	default double offer() {
		
		return 4.0;
	}
}
