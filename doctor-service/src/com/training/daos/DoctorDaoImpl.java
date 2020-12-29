package com.training.daos;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import java.time.LocalDate;

import com.training.entity.Doctor;
import com.training.ifaces.DataAccess;
import com.training.utils.DbConnectionUtil;

public class DoctorDaoImpl implements DataAccess<Doctor> {

	private Connection con;
	
	private static final String ADDSQL ="insert into lumen_doctor values(?,?,?,?,?)";
	
	public DoctorDaoImpl(Connection con) {
		super();
		this.con = con;
	}

	public DoctorDaoImpl() {
		super();
		con= DbConnectionUtil.getMySqlConnection();
	}

	@Override
	public int add(Doctor t) {

		
		int rowsAdded = 0;
		
		try(PreparedStatement pstmt = con.prepareStatement(ADDSQL)) {
			
			pstmt.setInt(1, t.getDoctorId());
			pstmt.setString(2, t.getDoctorName());
			pstmt.setLong(3, t.getMobileNumber());
			pstmt.setString(4, t.getSpecialization());
    		 pstmt.setDate(5, Date.valueOf(t.getDateOfBirth()));
			 
     	 rowsAdded = pstmt.executeUpdate();
			 
		} catch (SQLException e) {

              e.printStackTrace();		}
		
		return rowsAdded;
	}

	@Override
	public List<Doctor> findAll() {
	
		
    String sql = "select * from  lumen_doctor";
		
         List<Doctor>	 doctorList = new ArrayList<Doctor>();
         
		try(PreparedStatement pstmt = con.prepareStatement(sql)) {
			
		 
     	ResultSet rs= pstmt.executeQuery();
     	
     	
     	ResultSetMetaData rsmeta = rs.getMetaData();
     	
    	 System.out.println("Number of Coloumns" + rsmeta.getColumnCount());
    	 
    	 System.out.println("Table Name of Coumn 1 "+rsmeta.getTableName(1));

    	 
    	    	 
		
     	   while(rs.next()) {
     		   
     		 int doctorId = rs.getInt("doctorId");
     		String doctorName= rs.getString("doctorName");
     		long mobileNumber = rs.getLong("mobileNumber");
     		String specialization = rs.getString("specialization");
     		LocalDate dateOfBirth = rs.getDate("dateOfBirth").toLocalDate();
     			
     		Doctor doctor = new Doctor(doctorId, doctorName, mobileNumber, specialization, dateOfBirth);
     		
     		doctorList.add(doctor);
     	   }
     	
		} catch (SQLException e) {

              e.printStackTrace();		}
		
		return doctorList;

		
	}

	@Override
	public Doctor update(Doctor existing, Doctor update) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int remove(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Doctor findById(int id) {

		
	    String sql = "select * from  lumen_doctor where doctorId=?";
		
         Doctor 	 doctor =null;

         
		try(PreparedStatement pstmt = con.prepareStatement(sql)) {
			
		 pstmt.setInt(1, id);
    	ResultSet rs= pstmt.executeQuery();
    		
   	 
   	    	 
		
    	if(rs.next()) {
    		   
    		 int doctorId = rs.getInt("doctorId");
    		String doctorName= rs.getString("doctorName");
    		long mobileNumber = rs.getLong("mobileNumber");
    		String specialization = rs.getString("specialization");
    		LocalDate dateOfBirth = rs.getDate("dateOfBirth").toLocalDate();
    			
    		 doctor = new Doctor(doctorId, doctorName, mobileNumber, specialization, dateOfBirth);
    		
    			   }
    	
		} catch (SQLException e) {

             e.printStackTrace();		}
		
		return doctor;

	}

	@Override
	public int[] addInBatch(Doctor... list) {

            int[] rows = null;
			 try(PreparedStatement pstmt = con.prepareStatement(ADDSQL)) {

				  con.setAutoCommit(false);
				 for(Doctor eachDoctor : list) {
				 pstmt.setInt(1, eachDoctor.getDoctorId());
					pstmt.setString(2, eachDoctor.getDoctorName());
					pstmt.setLong(3, eachDoctor.getMobileNumber());
					pstmt.setString(4, eachDoctor.getSpecialization());
		    		 pstmt.setDate(5, Date.valueOf(eachDoctor.getDateOfBirth()));
			
		    	pstmt.addBatch();	 

				 }
				  rows =pstmt.executeBatch();
				  
				   con.commit();
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			 
			 return rows;
	}

	
	 public void usingTransaction() {
		 
		 String sql1 = "insert into lumen_doctor(doctorId,doctorName) values(?,?)";
		 String sql2 = "insert into lumen_doctor(doctorId,doctorName) values(?,?)";
		 Savepoint p1=null;
		 try {
			
			  con.setAutoCommit(false);
			 PreparedStatement pstmt1 = con.prepareStatement(sql1);
			 PreparedStatement pstmt2 = con.prepareStatement(sql2);
			 
			  pstmt1.setInt(1, 201);
			  pstmt1.setString(2, "dummy");
			 
			 pstmt1.executeUpdate();
			 
			  p1 = con.setSavepoint("point1");
			  
			  pstmt2.setInt(1, 202);
			  pstmt2.setString(2, "munna");
			  
			  pstmt2.executeUpdate();
			  
			  con.commit();
			  
			  con.setAutoCommit(true);
			 
		} catch (SQLException e) {
			
			e.printStackTrace();
			
			try {
				con.rollback(p1);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	 }
}
