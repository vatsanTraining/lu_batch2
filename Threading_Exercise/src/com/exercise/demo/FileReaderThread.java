package com.exercise.demo;


import com.exercise.demo.services.FileService;

public class FileReaderThread implements Runnable {

		
	private FileService service;
	
	
	public FileReaderThread() {
		super();
		
		this.service = new FileService();
		
		Thread thread = new Thread(this);
		thread.start();
	}


	@Override
	public void run() {
		// TODO Auto-generated method stub
		synchronized (service) {
			
		
		while(FileService.written == true){
			try {
				service.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		String[] textArray = this.service.readFromFile();
			
		for(int i=0;i<textArray.length;i++) {
			System.out.println(textArray[i]);
		}
		}
	}



}
