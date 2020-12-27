package com.contacts.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;

import java.time.LocalDate;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.contacts.dao.ContactDaoImplementation;
import com.contacts.model.Contact;
import com.contacts.utils.DbConnectionUtil;

@DisplayName("Testing contact addition")
class TestAddToContacts {
	
	private Contact testContact = new Contact("testContact", "testAddr", "0000000000", "test.jpg" , LocalDate.now(), "test@test.com", "Test");
	private Connection con = DbConnectionUtil.getMySqlConnection();
	private ContactDaoImplementation contactService = new ContactDaoImplementation(con);
	
	@Test
	void testAddToContacts() {
		
		int rowAdded = contactService.addToContacts(testContact);
		
		assertEquals(1,rowAdded);
	}

}
