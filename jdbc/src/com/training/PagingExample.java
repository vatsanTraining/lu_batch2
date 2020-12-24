package com.training;
import java.util.*;
import java.sql.*;
import java.time.LocalDate;

import javax.sql.*;
import javax.sql.rowset.*;

import com.training.entity.Doctor;
import com.training.utils.DbConnectionUtil;
public class PagingExample {

	public static void main(String[] args) {

		try {
		

			CachedRowSet rowSet = (CachedRowSet) DbConnectionUtil.getCachedRowSet();
			
			
			String sql = "select * from lumen_doctor";
			
			rowSet.setCommand(sql);
			
			  rowSet.setPageSize(2);
			  
			  rowSet.execute();
			  
			  int page =1; 
					  
					  do {
						  System.out.println("Page ========="+page);
						  while(rowSet.next()) {
								 int doctorId = rowSet.getInt("doctorId");
		     		String doctorName= rowSet.getString("doctorName");
		     		long mobileNumber = rowSet.getLong("mobileNumber");
		    		String specialization = rowSet.getString("specialization");
		     		LocalDate dateOfBirth = rowSet.getDate("dateOfBirth").toLocalDate();
						     			
		    		Doctor doctor = new Doctor(doctorId, doctorName, mobileNumber, specialization, dateOfBirth);
						     	
						     		System.out.println(doctor);
						  }
						    page++;
						  }while(rowSet.nextPage());
			
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
		
	}

}
