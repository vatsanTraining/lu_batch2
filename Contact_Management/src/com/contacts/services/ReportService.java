package com.contacts.services;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import java.util.List;
import java.util.Scanner;

import java.util.stream.Collectors;



import com.contacts.dao.ContactDaoImplementation;
import com.contacts.model.Contact;


public class ReportService {

	private Connection con;
	private ContactDaoImplementation contactService;
	private List<Contact> contactList;
	String equalsChar = "=";
	String underscoreChar = "_";

	public ReportService(Connection con) {
		this.con = con;
		contactService = new ContactDaoImplementation(con);
		contactList = contactService.findAllContacts();
	}

	// Method for formatting output strings - Static Method
	public static String fixedLengthString(String string, int length) {
		return String.format("%1$"+length+ "s", string);
	}

	//This method generates a report with Name and Date of Birth by taking the Month as Input
	public boolean listOfBirthdays(String monthName, Scanner myObj){
		boolean isDone = false;
		List<String[]> birthdayList = new ArrayList<String[]>();
		List<Contact> newContactList = null;



		newContactList = contactList.stream()
				.filter(contact -> isRequiredMonth(contact, monthName))
				.collect(Collectors.toList());
		if(newContactList.isEmpty()) {
			System.out.println("No contacts with birthday in the month of "+monthName.toUpperCase());
			isDone = true;
		}else {
			for(Contact eachContact : newContactList) {
				String[] nameAndDateOfBirth = {eachContact.getContactName(), eachContact.getDateOfBirth().toString()};
				birthdayList.add(nameAndDateOfBirth);
			}

			System.out.println("Choose type of report: 1.Text File  2.Console");
//			Scanner myObj = new Scanner(System.in);
			switch (myObj.nextInt()) {
			case 1:
				String fileName = "DoB_Report_"+monthName.toUpperCase()+".txt";
				try(PrintWriter filePrinter = new PrintWriter(fileName)) {
					filePrinter.println(equalsChar.repeat(40));
					filePrinter.println(fixedLengthString("Date Of Birth Table", 40));
					filePrinter.println(equalsChar.repeat(40));
					filePrinter.println(fixedLengthString("Name", 20)+fixedLengthString("Date Of Birth Report - "+monthName.toUpperCase(), 20));
					filePrinter.println(underscoreChar.repeat(40));
					for(String[] eachField : birthdayList) {
						filePrinter.println(fixedLengthString(eachField[0],20)+fixedLengthString(eachField[1], 20));
					}
					System.out.println("Text file created successfully! Check '"+fileName+"' in folder");
					isDone=true;

				} catch (FileNotFoundException e) {
					System.err.println("Unable to generate report!");
					e.printStackTrace();
				}	

				break;

			default:
				System.out.println(equalsChar.repeat(40));
				System.out.println(fixedLengthString("Date Of Birth Report - "+monthName.toUpperCase(), 40));
				System.out.println(equalsChar.repeat(40));				
				System.out.println();
				System.out.println(fixedLengthString("Name", 20)+fixedLengthString("Date Of Birth", 20));
				System.out.println(underscoreChar.repeat(40));
				for(String[] eachField : birthdayList) {
					System.out.println(fixedLengthString(eachField[0],20)+fixedLengthString(eachField[1], 20));
				}
				isDone=true;
				break;	

			}
//			myObj.close();

		}


		return isDone;
	}

	// Method for checking month - required for DoB report
	private boolean isRequiredMonth(Contact contact, String monthName) {
		boolean isMonth = false;
		String contactMonth = (contact.getDateOfBirth().getMonth()).toString();
		if(monthName.equalsIgnoreCase(contactMonth)) {
			isMonth = true;
		}

		return isMonth;

	}

	// Method for Listing contacts of a certain group
	public boolean listOfContactByGroup(String contactGroup, Scanner myObj) {
		boolean isDone = false;
		List<Contact> newContactList = new ArrayList<Contact>();
		
				
		newContactList = contactList.stream()
				.filter(contact -> (contact.getContactGroup()).equalsIgnoreCase(contactGroup))
				.collect(Collectors.toList());

		if(newContactList.isEmpty()) {
			System.out.println("Couldn't find contacts with the Group name "+contactGroup);
			isDone = true;
		} else {
			System.out.println("Choose type of report: 1.Text File  2.Console");
//			Scanner myObj = new Scanner(System.in);
			switch (myObj.nextInt()) {
			case 1:
				String fileName = contactGroup.replaceAll("\\s+","")+"_contacts.txt";
				try(PrintWriter filePrinter = new PrintWriter(fileName)) {
					filePrinter.println(equalsChar.repeat(124));
					filePrinter.println(fixedLengthString(contactGroup.toUpperCase()+" contacts", 124));
					filePrinter.println(equalsChar.repeat(124));
					filePrinter.println(fixedLengthString("Name", 20)+fixedLengthString("Address", 30)+fixedLengthString("Mobile Number", 14)+fixedLengthString("Image", 25)+fixedLengthString("DoB",15)+
							fixedLengthString("Email Address", 20));
					filePrinter.println(underscoreChar.repeat(124));
					for(Contact eachContact : newContactList) {
						filePrinter.println(fixedLengthString(eachContact.getContactName(),20)+fixedLengthString(eachContact.getContactAddr(), 30)+fixedLengthString(eachContact.getMobileNumber(), 14)+fixedLengthString(eachContact.getImgReference(), 25)+fixedLengthString(eachContact.getDateOfBirth().toString(), 15)+fixedLengthString(eachContact.getEmailAddr(), 20));
					}
					System.out.println("Text file created successfully! Check '"+fileName+"' in folder");
					isDone=true;

				} catch (FileNotFoundException e) {
					System.err.println("Unable to generate report!");
					e.printStackTrace();
				}	

				break;

			default:
				System.out.println(equalsChar.repeat(124));
				System.out.println(fixedLengthString(contactGroup.toUpperCase()+" contacts", 44));
				System.out.println(equalsChar.repeat(124));
				System.out.println(fixedLengthString("Name", 20)+fixedLengthString("Address", 30)+fixedLengthString("Mobile Number", 14)+fixedLengthString("Image", 25)+fixedLengthString("DoB",15)+
						fixedLengthString("Email Address", 20));
				System.out.println(underscoreChar.repeat(124));
				for(Contact eachContact : newContactList) {
					System.out.println(fixedLengthString(eachContact.getContactName(),20)+fixedLengthString(eachContact.getContactAddr(), 30)+fixedLengthString(eachContact.getMobileNumber(), 14)+fixedLengthString(eachContact.getImgReference(), 25)+fixedLengthString(eachContact.getDateOfBirth().toString(), 15)+fixedLengthString(eachContact.getEmailAddr(), 20));
				}
				isDone=true;
				break;	

			}
//			myObj.close();


		}
		return isDone;

	}

	// Method for Listing Name and either Mobile Number or Email
	// Choice 1 is Mobile Numbers, Choice 2 is Email Addresses
	public boolean listOfNumberOrEmail(int choice, Scanner myObj) {
		boolean isDone = false;
		DateTimeFormatter now = DateTimeFormatter.ofPattern("yyMMddHHmmss");
		LocalDateTime currentDateAndTime = LocalDateTime.now();

		if(!contactList.isEmpty()) {
			System.out.println("Choose type of report: 1.Text File  2.Console");
//			Scanner myObj = new Scanner(System.in);
			switch ((myObj.nextInt())) {
			case 1:
				String fileName = null;
				if(choice==1) {
					fileName = "mobile_numbers_"+currentDateAndTime.format(now)+".txt";
				} else {
					fileName = "emails_"+currentDateAndTime.format(now)+".txt";
				}
				try(PrintWriter filePrinter = new PrintWriter(fileName)){
					filePrinter.println(equalsChar.repeat(55));
					if(choice==1) {
						filePrinter.println(fixedLengthString("Mobile Numbers List", 44));
					} else {
						filePrinter.println(fixedLengthString("Email Address List", 44));
					}
					filePrinter.println(equalsChar.repeat(55));
					if(choice==1) {
						filePrinter.println(fixedLengthString("Name", 25)+fixedLengthString("Mobile Number", 18));
					} else {
						filePrinter.println(fixedLengthString("Name", 25)+fixedLengthString("Email Address", 30));
					}
					filePrinter.println(underscoreChar.repeat(55));

					for(Contact eachContact : contactList) {
						if (choice==1) {
							filePrinter.println(fixedLengthString(eachContact.getContactName(), 25)+fixedLengthString(eachContact.getMobileNumber(), 18));
						} else {
							filePrinter.println(fixedLengthString(eachContact.getContactName(), 25)+fixedLengthString(eachContact.getEmailAddr(), 30));
						}
					}
				} catch (FileNotFoundException e) {
					System.err.println("Unable to generate report!");
					e.printStackTrace();
				}
				isDone = true;
				System.out.println("Text file created successfully! Check '"+fileName+"' in folder");
				break;

			default:
				System.out.println(equalsChar.repeat(55));
				if(choice==1) {
					System.out.println(fixedLengthString("Mobile Numbers List", 44));
				} else {
					System.out.println(fixedLengthString("Email Address List", 44));
				}
				System.out.println(equalsChar.repeat(55));
				if(choice==1) {
					System.out.println(fixedLengthString("Name", 25)+fixedLengthString("Mobile Number", 18));
				} else {
					System.out.println(fixedLengthString("Name", 25)+fixedLengthString("Email Address", 30));
				}
				System.out.println(underscoreChar.repeat(55));
				for(Contact eachContact : contactList) {
					if (choice==1) {
						System.out.println(fixedLengthString(eachContact.getContactName(), 25)+fixedLengthString(eachContact.getMobileNumber(), 18));
					} else {
						System.out.println(fixedLengthString(eachContact.getContactName(), 25)+fixedLengthString(eachContact.getEmailAddr(), 30));
					}				

				}
				isDone=true;
				break;
			}

//			myObj.close();
		} else {
			System.out.println("No contacts available!");
			isDone=true;
		}
		return isDone;
	}

	// Method to generate report based on ascending order of size of group
	public boolean ascendingGroupCountReport(Scanner myObj) {
		boolean isDone=false; 
		String sql="select contacts.contactName,contacts.mobileNumber,contacts.contactGroup from contacts left join (select contacts.contactGroup, count(contacts.contactGroup) as count from contacts group by contacts.contactGroup) counter ON counter.contactGroup = contacts.contactGroup ORDER BY counter.count";

		List<String[]> newContactList = new ArrayList<String[]>();
		String contactName = null;
		String mobileNumber = null;
		String contactGroup = null;
		DateTimeFormatter now = DateTimeFormatter.ofPattern("yyMMddHHmmss");
		LocalDateTime currentDateAndTime = LocalDateTime.now();

		try(PreparedStatement pstmt = con.prepareStatement(sql)){

			ResultSet rs = pstmt.executeQuery();	
			while(rs.next()) {
				try {
					contactName=rs.getString("contactName");
					mobileNumber=rs.getString("mobileNumber");
					contactGroup=rs.getString("contactGroup");
					
				} catch(SQLException e) {
					System.err.println("Unable to retrieve data!");
					e.printStackTrace();
				}
				
				String[] contactData = {contactName,mobileNumber,contactGroup};
				newContactList.add(contactData);
			}

		} catch (SQLException e1) {
			System.err.println("Unable to retrieve details!");
			e1.printStackTrace();
		}
	

		if(!newContactList.isEmpty()) {

			System.out.println("Choose type of report: 1.Text File  2.Console");
//			Scanner myObj = new Scanner(System.in);
			switch (myObj.nextInt()) {
			case 1:
				String fileName = "ascGroup_report_"+currentDateAndTime.format(now)+".txt";
				try (PrintWriter filePrinter = new PrintWriter(fileName)){
					filePrinter.println(equalsChar.repeat(78));
					filePrinter.println(fixedLengthString("Contacts list in ascending order of total contacts in each group", 78));
					filePrinter.println(equalsChar.repeat(78));
					filePrinter.println(fixedLengthString("Name", 30)+fixedLengthString("Mobile Number", 18)+fixedLengthString("Group", 30));
					filePrinter.println(underscoreChar.repeat(78));
					for(String[] eachContact : newContactList) {
						filePrinter.println(fixedLengthString(eachContact[0], 30)+fixedLengthString(eachContact[1], 18)+fixedLengthString(eachContact[2], 30));
					}
				} catch (FileNotFoundException e) {
					System.err.println("Unable to generate report!");
					e.printStackTrace();
				}
				isDone = true;
				System.out.println("Text file created successfully! Check '"+fileName+"' in folder");
				break;

			default:
				System.out.println(equalsChar.repeat(78));
				System.out.println(fixedLengthString("Contacts list in ascending order of total contacts in each group", 66));
				System.out.println(equalsChar.repeat(78));
				System.out.println(fixedLengthString("Name", 30)+fixedLengthString("Mobile Number", 18)+fixedLengthString("Group", 30));
				System.out.println(underscoreChar.repeat(78));
				for(String[] eachContact : newContactList) {
					System.out.println(fixedLengthString(eachContact[0], 30)+fixedLengthString(eachContact[1], 18)+fixedLengthString(eachContact[2], 30));
				}
				isDone = true;
				break;
			}
//			myObj.close();
		}else {
			System.out.println("No contacts available!");
			isDone=true;
		}
		
		return isDone;
	}
}	

