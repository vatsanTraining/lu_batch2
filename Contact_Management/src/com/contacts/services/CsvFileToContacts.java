package com.contacts.services;

import java.io.BufferedReader;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;


import com.contacts.dao.ContactDaoImplementation;
import com.contacts.dao.PersonalContactDaoImpl;
import com.contacts.dao.ProfessionalContactDaoImpl;
import com.contacts.dao.RelativesContactDaoImpl;
import com.contacts.model.Contact;
import com.contacts.model.PersonalFriendContact;
import com.contacts.model.ProfessionalFriendContact;
import com.contacts.model.RelativesContact;

public class CsvFileToContacts {


	private ProfessionalContactDaoImpl professionalContactService;
	private PersonalContactDaoImpl personalContactService;
	private RelativesContactDaoImpl relativesContactService;
	private ContactDaoImplementation contactService;
	final String DELIMITER = ",";

	public CsvFileToContacts(Connection con) {

		professionalContactService = new ProfessionalContactDaoImpl(con);
		personalContactService = new PersonalContactDaoImpl(con);
		relativesContactService = new RelativesContactDaoImpl(con);
		contactService = new ContactDaoImplementation(con);		
	}

	public boolean addContactsFromFile(String csvFileName) {
		BufferedReader fileReader = null;
		String contactName;
		String contactAddr;
		String phoneNumber;
		String imgReference;
		String dateOfBirthString;
		LocalDate dateOfBirth = null;		
		String emailAddr;
		String contactGroup;
		String[] otherField = new String[4];
		int totalCounter = 0;
		int successCounter = 0;
		boolean isDone = false;


		try
		{			
			String line = "";
			String[] fields = new String[10];
			fileReader = new BufferedReader(new FileReader(csvFileName));
			boolean isAdded = false;
			while ((line = fileReader.readLine()) != null) 
			{
				totalCounter = totalCounter+1;
				fields = line.split(DELIMITER);
				contactName = fields[0];
				contactAddr = fields[1];
				phoneNumber = fields[2];
				imgReference = fields[3];		
				dateOfBirthString = fields[4];
				if(dateOfBirthString.equals("")) {
					dateOfBirthString = "1970-01-01";
				}
				DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
				try {

					Date DateOfBirth = formatter.parse(dateOfBirthString);
					dateOfBirth = DateOfBirth.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();					
				} catch (ParseException e) {

					e.printStackTrace();
					isDone = true;
					return isDone;
				}
				emailAddr = fields[5];

				contactGroup = fields[6];

				switch (contactGroup.toLowerCase()) {
				case "personal friends":
					otherField[0]=fields[7];
					PersonalFriendContact newPersonalContact = new PersonalFriendContact(contactName, contactAddr, phoneNumber, imgReference, dateOfBirth, emailAddr, contactGroup, otherField[0]);
					personalContactService.addToContacts(newPersonalContact);
					isAdded = true;
					break;

				case "professional friends":
					otherField[0]=fields[7];
					ProfessionalFriendContact newProfessionalContact = new ProfessionalFriendContact(contactName, contactAddr, phoneNumber, imgReference, dateOfBirth, emailAddr, contactGroup, otherField[0]);
					professionalContactService.addToContacts(newProfessionalContact);
					isAdded = true;
					break;

				case "relatives":
					otherField[0]=fields[7];
					RelativesContact newRelativeContact = new RelativesContact(contactName, contactAddr, phoneNumber, imgReference, dateOfBirth, emailAddr, contactGroup, otherField[0]);
					relativesContactService.addToContacts(newRelativeContact);
					isAdded = true;
					break;

				default:
					Contact newContact = new Contact(contactName, contactAddr, phoneNumber, imgReference, dateOfBirth, emailAddr, contactGroup);
					contactService.addToContacts(newContact);
					isAdded = true;
					break;
				}

				if(isAdded) {
					successCounter = successCounter+1;
				}
			}

		} 
		catch (Exception e) {
			isDone=true;
			e.printStackTrace();
			return isDone;
			
		} 
		finally
		{
			try {
				fileReader.close();
			} catch (IOException e) {
				e.printStackTrace();
				isDone = true;
				return isDone;
				
			}

			System.out.println("Total Contacts Read : "+totalCounter);
			System.out.println("Total Contacts Successfully Added: "+successCounter);
			
			isDone = true;
		}
		return isDone;
		
		
	} 
}
