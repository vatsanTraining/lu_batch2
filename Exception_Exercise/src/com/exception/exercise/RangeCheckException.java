package com.exception.exercise;

public class RangeCheckException extends java.lang.Exception {



	private String message;
	
	public RangeCheckException(String string) {

		this.message = string;
	}
	
	@Override
	public String getMessage() {
		return this.message;
	}
}
