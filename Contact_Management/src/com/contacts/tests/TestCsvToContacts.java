package com.contacts.tests;

import static org.junit.jupiter.api.Assertions.*;

//import java.io.FileNotFoundException;
import java.sql.Connection;

import org.junit.jupiter.api.Test;

import com.contacts.services.CsvFileToContacts;
import com.contacts.utils.DbConnectionUtil;

class TestCsvToContacts {

	
	@Test
	void testAddContactsFromFile() {
		
		final Connection con = DbConnectionUtil.getMySqlConnection();
		final CsvFileToContacts fileService = new CsvFileToContacts(con);
		
		assertAll("Test Adding Contacts from CSV File",
				()->{
					String fileName = "test_contact.csv";
					boolean isAdded = fileService.addContactsFromFile(fileName);
					assertEquals(true,isAdded);}
//				},
//				()->{
//					String fileName = "test.csv";
//					assertThrows(FileNotFoundException.class, ()->fileService.addContactsFromFile(fileName) );
//				}
//				
//				
				
				);
	}

}
