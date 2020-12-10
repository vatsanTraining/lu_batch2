package com.example.demo.services;

import java.io.*;
/**
 * 
 */

import com.example.demo.*;

public class ProfessorService {
	
	private int index;
	
	public boolean writeObjecttoFile(Professor prof, File file) {
		
		boolean result = false;
		
		try(ObjectOutputStream outStream = new ObjectOutputStream(new FileOutputStream(file))){
				
			//try with resource
				outStream.writeObject(prof);
				result=true;
				
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		return result;
		
	}
	
	public Object readObjectFromFile(File file) {
		
		Object obj=null;
		
		try(ObjectInputStream inStream = new ObjectInputStream(new FileInputStream(file))){
			
			obj = inStream.readObject();
		}catch(ClassNotFoundException | IOException e) {
			e.printStackTrace();
			//catch multiple exception
		}
		
		return obj;
	}
	
	public boolean writeObjecttoFile(Professor[] prof, File file) {
		
		boolean result = false;
		
		try(ObjectOutputStream outStream = new ObjectOutputStream(new FileOutputStream(file))){
				
			//try with resource
			
				outStream.writeObject(prof);
			
				result=true;
				
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		return result;
		
	}
	
	public boolean writeToTextFile(Professor prof, File file) {
		
		boolean result = false;
		
		try( PrintWriter writer = new PrintWriter(new FileWriter(file,true))) {
			
			writer.println(prof);
			result=true;
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		return result;
		
	}
	
	public Professor[] readFromTextFile(File file) {
		
		Professor[] list = new Professor[4];
		
		
		String line=null;
		
		try(BufferedReader reader = new BufferedReader(new FileReader(file))) {
			int i = 0;
			while((line = reader.readLine())!=null) {
				String[] values = line.split(",");
				Professor prof = new Professor(Integer.parseInt(values[0]),values[1],values[2],values[3]);
				
				if(i<4) {
				list[i]=prof;
				} else{
			    Professor[] list2 = new Professor[(list.length + 5)];
			    int a;
			    for( a = 0; a < list.length; a++) {
			        list2[a] = list[a];			        
			    }
			    
			    list2[i]=prof;			    
			    list=list2;
			    
				}				
				
				i++;
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return list;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}
}
