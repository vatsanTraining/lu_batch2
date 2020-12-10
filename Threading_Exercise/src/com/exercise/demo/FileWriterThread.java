package com.exercise.demo;

import com.exercise.demo.services.FileService;

public class FileWriterThread implements Runnable {

	private String[] textArray;
	private FileService service;
	
	
	public FileWriterThread(String[] textArray) {
		super();
		this.textArray = textArray;
		
		this.service = new FileService();
		
		Thread thread = new Thread(this);
		thread.start();
	}


	@Override
	public void run() {
		// TODO Auto-generated method stub
		synchronized (service) {
			while(FileService.written == false) {
				try {
					this.service.writeToFile(textArray);
					service.notifyAll();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			//notify(); Commented as it said IllegalMonitor Error 
		}

	}

}
