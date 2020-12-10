/**
 * 
 */
package com.exercise.demo.services;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author Shreyas
 *
 */
public class FileService {
	
	public static boolean written = false;

	public synchronized void writeToFile(String[] text) {
		
		
		try {
			FileWriter writer = new FileWriter("exercise.txt");
			for(int i = 0; i<text.length ; i++ ) {
				writer.write(text[i]+",");
			}
			
			writer.close();
			written=true;
			//file= new File("exercise.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public synchronized String[] readFromFile() {
		
		String[] textArray = new String[10];
		
		String line = null;
		try (BufferedReader reader = new BufferedReader(new FileReader("exercise.txt"))){
			
			while((line = reader.readLine())!=null) {
				textArray = line.split(",");
			}	
			
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return textArray;
		
		
	}
}
