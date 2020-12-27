package com.contacts.utils;

import java.io.InputStream;

import java.sql.*;
import java.util.Properties;

import javax.sql.RowSet;
import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;



public class DbConnectionUtil {	
	
	public static Connection getMySqlConnection() {
		
		Connection con = null;
		
		String fileName = "DbConnection.properties";
		
		try {
			
			InputStream inStream = DbConnectionUtil.class.getClassLoader().getResourceAsStream(fileName);
			
			Properties props = new Properties();
			
			props.load(inStream);
			
			con = DriverManager.getConnection(props.getProperty("datasource.url"),props.getProperty("datasource.username"), props.getProperty("datasource.password"));
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return con;
		}
	
	public static RowSet getCachedRowSet() {
		
		CachedRowSet rowSet = null;
		RowSetFactory fact = null;
		
		try {
			
			fact = RowSetProvider.newFactory();
			rowSet = fact.createCachedRowSet();
			
			String fileName = "DbConnection.properties";
			InputStream inStream = DbConnectionUtil.class.getClassLoader().getResourceAsStream(fileName);
			
			System.out.println(inStream);
			Properties props = new Properties();
			
			props.load(inStream);
			
			rowSet.setUrl(props.getProperty("datasource.url"));
			rowSet.setUsername(props.getProperty("datasource.username"));
			rowSet.setPassword(props.getProperty("datasource.password"));
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return rowSet;
	}
}
