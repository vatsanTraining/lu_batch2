package com.exercise.demo;

public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final String[] textArray = {"Shreyas","Nayak","shReYas","nAYak"};
		
		new FileWriterThread(textArray);
		new FileReaderThread();		
		
	}

}
