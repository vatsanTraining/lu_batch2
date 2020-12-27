package com.contacts.services;

import java.sql.Connection;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;



import com.contacts.dao.ContactDaoImplementation;
import com.contacts.dao.PersonalContactDaoImpl;
import com.contacts.dao.ProfessionalContactDaoImpl;
import com.contacts.dao.RelativesContactDaoImpl;
import com.contacts.model.Contact;
import com.contacts.model.PersonalFriendContact;
import com.contacts.model.ProfessionalFriendContact;
import com.contacts.model.RelativesContact;
import com.contacts.utils.DbConnectionUtil;

public class MenuService {

	private Connection con;
	private ContactDaoImplementation contactService;
	private PersonalContactDaoImpl personalContactService;
	private ProfessionalContactDaoImpl professionalContactService; 
	private RelativesContactDaoImpl relativesContactService;
	private CsvFileToContacts fileToContactService;
	private ReportService reportService;	
	private List<Contact> contactList;
	private final String underscoreChar = "_";
	private boolean isDone = false;
	private String repeatChoice = null;
	
	public MenuService() {
		this.con = DbConnectionUtil.getMySqlConnection();

		this.fileToContactService = new CsvFileToContacts(con);
		this.contactService = new ContactDaoImplementation(con);
		this.personalContactService = new PersonalContactDaoImpl(con);
		this.professionalContactService = new ProfessionalContactDaoImpl(con);
		this.relativesContactService = new RelativesContactDaoImpl(con);		
		this.reportService = new ReportService(con);
		this.contactList = new ArrayList<Contact>();
	}

	// Menu method for adding contacts to the database
	public boolean addContactMenu(Scanner myObj) {
		isDone=false;
		

		
		myObj.nextLine();
//		Scanner myObj = new Scanner(System.in);
		do {

			System.out.println("Name:");
			String contactName = myObj.nextLine();
			System.out.println("Address:");
			String contactAddr = myObj.nextLine();
			System.out.println("Mobile Number:");
			String mobileNumber = myObj.next();
			System.out.println("Image Reference:");
			String imgReference = myObj.next();
			System.out.println("Date of Birth (YYYY-MM-DD):");
			String dateOfBirthString = myObj.next();
			LocalDate dateOfBirth = null;
			DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			try {
				Date DateOfBirth = formatter.parse(dateOfBirthString);
				dateOfBirth = DateOfBirth.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();					
			} catch (ParseException e) {
				System.err.println("Please enter Date of Birth in mentioned order!");
				e.printStackTrace();
			}
			System.out.println("Email Address:");
			String emailAddr = myObj.next();

			System.out.println("Group: Enter your choice");
			System.out.println("[ 1.Personal Friends 2.Professional Friends 3.Relatives 4.Other ]");

			int contactAdded = 0;
			String contactGroup = null;

			switch(myObj.nextInt()) {

			case 1:
				contactGroup = "Personal Friends";
				System.out.println("Nickname:");
				myObj.nextLine();
				String nickname = myObj.nextLine();
				PersonalFriendContact personalContact = new PersonalFriendContact(contactName, contactAddr, mobileNumber, imgReference, dateOfBirth, emailAddr, contactGroup, nickname);
				contactAdded = personalContactService.addToContacts(personalContact);
				break;

			case 2:
				contactGroup = "Professional Friends";
				System.out.println("Organization:");
				myObj.nextLine();
				String organization = myObj.nextLine();
				ProfessionalFriendContact professionalContact = new ProfessionalFriendContact(contactName, contactAddr, mobileNumber, imgReference, dateOfBirth, emailAddr, contactGroup, organization);
				contactAdded = professionalContactService.addToContacts(professionalContact);
				break;	

			case 3:
				contactGroup = "Relatives";
				System.out.println("Relation:");
				myObj.nextLine();
				String relation = myObj.nextLine();
				RelativesContact relativeContact = new RelativesContact(contactName, contactAddr, mobileNumber, imgReference, dateOfBirth, emailAddr, contactGroup, relation);
				contactAdded = relativesContactService.addToContacts(relativeContact);
				break;		

			default:
				contactGroup = "Other";
				myObj.nextLine();
				Contact contact = new Contact(contactName, contactAddr, mobileNumber, imgReference, dateOfBirth, emailAddr, contactGroup);
				contactAdded = contactService.addToContacts(contact);
				break;
			}
			
			System.out.println(underscoreChar.repeat(250));
			System.out.println(contactAdded +" contact added!");
			System.out.println("Do you want to add another contact? (Y/N)");
			repeatChoice = myObj.next();
			
			if(repeatChoice.equalsIgnoreCase("N")) {
				isDone=true;
			}
			
		}while(repeatChoice.equalsIgnoreCase("Y"));
		
//		myObj.close();
		return isDone;
	}

	// Menu method for add contacts from CSV file
	public boolean addContactsFromCSV(Scanner myObj) {
		isDone = false;
		boolean isAddedFromFile = false;
//		Scanner myObj = new Scanner(System.in);
		myObj.nextLine();
		
		System.out.println("Enter the name of the csv file with extension(.csv)");
		String csvFileName = myObj.next();
		isAddedFromFile = fileToContactService.addContactsFromFile(csvFileName);
		
		if(isAddedFromFile) {
			System.out.println("Adding from file has been completed!");
			isDone = true;
		}
		
//		myObj.close();
		return isDone;
	}

	// Menu method for searching contacts in the database
	public boolean searchContactMenu(Scanner myObj) {
		isDone = false;
		
		contactList.clear();
		myObj.nextLine();
		
//		Scanner myObj = new Scanner(System.in);
		
		do {

			contactList = searchContacts("for Search", myObj);

			if(contactList.isEmpty()) {
				System.out.println("Couldn't find contact(s)!");
			}
			else {
				displayContacts(contactList);
			}
			
			System.out.println(underscoreChar.repeat(250));
			System.out.println("Do you want to search again? (Y/N)");
			repeatChoice = myObj.next();
			
			if(repeatChoice.equalsIgnoreCase("N")) {
				isDone = true;
				
			}
			
			
		} while (repeatChoice.equalsIgnoreCase("Y"));
		
//		myObj.close();
		return isDone;
		
	}
	
	
	// Method to search contacts by either name or mobile number and then return contact list
	private List<Contact> searchContacts(String searchReason, Scanner myObj) {
		
		List<Contact> contactList = new ArrayList<Contact>();

		
		System.out.println("Enter option to find contact(s) by Name or Mobile Number "+searchReason+" :");
		System.out.println("[ 1. Search by Name  2. Search by Mobile Number ]");
		
		String searchString = null;
		switch (myObj.nextInt()) {
		case 1:
			System.out.println("Search Name - ");
			myObj.nextLine();
			searchString = myObj.nextLine();
			contactList = contactService.findContactByName(searchString);
			break;

		default:
			System.out.println("Search Mobile Number - ");
			myObj.nextLine();
			searchString = myObj.next();
			contactList = contactService.findContactByNumber(searchString);
			break;
		}
		
		System.out.println(underscoreChar.repeat(250));
		System.out.println("Search Results:");
		

		return contactList;
		
	}
	
	// Method to display contacts in a contact list
	private void displayContacts(List<Contact> contactList) {
		
		int contactCount = 0;

		for(Contact eachContact : contactList) {
			contactCount = contactCount+1;
			System.out.println("__ID:"+contactCount+ReportService.fixedLengthString(underscoreChar.repeat(247), 247));

			displaySingleContact(eachContact);
		}
	}
	
	// Method to display single contact
	private void displaySingleContact(Contact contact) {
		
		String contactGroup = contact.getContactGroup();
		String mobileNumber = contact.getMobileNumber();
		
		switch (contactGroup.toLowerCase()) {
		case "personal friends":
			PersonalFriendContact personalContact = personalContactService.findCompleteDetails(mobileNumber);
			System.out.println(personalContact);
			break;

		case "professional friends":
			ProfessionalFriendContact professionalContact = professionalContactService.findCompleteDetails(mobileNumber);
			System.out.println(professionalContact);
			break;	

		case "relatives":
			RelativesContact relativeContact = relativesContactService.findCompleteDetails(mobileNumber);
			System.out.println(relativeContact);
			break;		

		default:
			System.out.println(contact);
			break;
		}
	}

	
	// Menu method to search specific contact and update fields to the database
	public boolean updateContactMenu(Scanner myObj) {
		isDone = false;
		
		contactList.clear();
		myObj.nextLine();
		
//		Scanner myObj = new Scanner(System.in);
		
		do {
			
			contactList = searchContacts("for Update", myObj);
			
			if(contactList.isEmpty()) {
				System.out.println("Couldn't find contact(s)!");
			}
			else {
				displayContacts(contactList);
			}
			
			System.out.println(underscoreChar.repeat(250));
			System.out.println("Select Contact ID that you want to update - ");
			int chosenId = myObj.nextInt();
			int contactUpdated = 0;
			
			if(chosenId<=contactList.size()) {
				Contact chosenContact = contactList.get(chosenId-1);
				String contactGroup = chosenContact.getContactGroup();
				String existingMobileNumber = chosenContact.getMobileNumber();
				String[] updatedFields = updatedFields(chosenContact, myObj);

				String dateOfBirthString = updatedFields[4];
				LocalDate dateOfBirth = null;
				DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
				try {
					Date DateOfBirth = formatter.parse(dateOfBirthString);
					dateOfBirth = DateOfBirth.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();					
				} catch (ParseException e) {
					System.err.println("Unable to convert Date of Birth to required format!");
					e.printStackTrace();
				}

				System.out.println(underscoreChar.repeat(250));


				switch (contactGroup.toLowerCase()) {
				case "personal friends":
					PersonalFriendContact updatedPersonalContact = new PersonalFriendContact(updatedFields[0], updatedFields[1], updatedFields[2], updatedFields[3], dateOfBirth, updatedFields[5], contactGroup, updatedFields[7]);
					contactUpdated = personalContactService.updateContact(existingMobileNumber, updatedPersonalContact);
					displaySingleContact(updatedPersonalContact);
					break;

				case "professional friends":
					ProfessionalFriendContact updatedProfessionalContact = new ProfessionalFriendContact(updatedFields[0], updatedFields[1], updatedFields[2], updatedFields[3], dateOfBirth, updatedFields[5], contactGroup, updatedFields[7]);
					contactUpdated = professionalContactService.updateContact(existingMobileNumber, updatedProfessionalContact);
					displaySingleContact(updatedProfessionalContact);
					break;

				case "relatives":
					RelativesContact updatedRelativeContact = new RelativesContact(updatedFields[0], updatedFields[1], updatedFields[2], updatedFields[3], dateOfBirth, updatedFields[5], contactGroup, updatedFields[7]);
					contactUpdated = relativesContactService.updateContact(existingMobileNumber, updatedRelativeContact);
					displaySingleContact(updatedRelativeContact);
					break;	

				default:
					Contact updatedContact = new Contact(updatedFields[0], updatedFields[1], updatedFields[2], updatedFields[3], dateOfBirth, updatedFields[5], contactGroup);
					contactUpdated = contactService.updateContact(dateOfBirthString, updatedContact);
					displaySingleContact(updatedContact);
					break;
				}
			}
			
			if(contactUpdated == 0) {
				System.out.println("Unable to update contact!");
			}else {
				System.out.println(contactUpdated+" contact updated as shown above");
			}
			
			System.out.println(underscoreChar.repeat(250));
			
			System.out.println("Do you want to update another contact? (Y/N)");
			repeatChoice = myObj.next();
			
			if(repeatChoice.equalsIgnoreCase("N")) {
				isDone = true;
			}
			
		} while (repeatChoice.equalsIgnoreCase("Y"));
		
//		myObj.close();
		return isDone;
	}
	
	// Method to get the values for updating the fields of a contact
	private String[] updatedFields (Contact contact, Scanner myObj) {
		String[] fields = new String[10];
		isDone = false; 
		
		fields[0] = contact.getContactName();
		fields[1] = contact.getContactAddr();
		fields[2] = contact.getMobileNumber();
		fields[3] = contact.getImgReference();
		fields[4] = contact.getDateOfBirth().toString();
		fields[5] = contact.getEmailAddr();
		fields[6] = contact.getContactGroup();
		
		do {
			System.out.println("Choose field option to update - ");
			System.out.println("1. Name");
			System.out.println("2. Address");
			System.out.println("3. Mobile Number");
			System.out.println("4. Image Source");
			System.out.println("5. Date of Birth");
			System.out.println("6. Email Address");
			
			
			switch (fields[6].toLowerCase()) {
			case "personal friends":
				System.out.println("7. Nickname");
				break;
			
			case "professional friends":
				System.out.println("7. Organization");
				break;
				
			case "relatives":
				System.out.println("7. Relation");
				break;	

			default:
				break;
			}
			
			switch (myObj.nextInt()) {
			case 1:
				System.out.println("Enter new Name -");
				myObj.nextLine();
				fields[0] = myObj.nextLine();
				break;

			case 2:
				System.out.println("Enter new Address -");
				myObj.nextLine();
				fields[1] = myObj.nextLine();
				break;
			
			case 3:
				System.out.println("Enter new Mobile Number -");
				fields[2] = myObj.next();
				break;	
			
			case 4:
				System.out.println("Enter new Image Source -");
				fields[3] = myObj.next();
				break;	
				
			case 5:
				System.out.println("Enter new Date of Birth (YYYY-MM-DD) -");
				fields[4] = myObj.next();
				break;
				
			case 6:
				System.out.println("Enter new Email Address -");
				fields[5] = myObj.next();
				break;	
			
			case 7:
				fields[7] = updateExtraField(myObj, fields[6]);
				break;	
				
			default:
				break;
			}
			
			System.out.println("Do you want to update another field? (Y/N)");
			
			String option = myObj.next();
			
			if(option.equalsIgnoreCase("N")) {
				isDone = true;
			}
		} while (!isDone);
		
		return fields;
		
	}
	
	// Method to udpate group-specific fields
	private String updateExtraField(Scanner myObj, String contactGroup) {
		String specificField = null;
		
		switch (contactGroup.toLowerCase()) {
		case "personal friends":
			System.out.println("Enter new Nickname -");
			myObj.nextLine();
			specificField = myObj.nextLine();
			break;
			
		case "professional friends":
			System.out.println("Enter new Organization -");
			myObj.nextLine();
			specificField = myObj.nextLine();
			break;	

		case "relatives":
			System.out.println("Enter new Relation -");
			myObj.nextLine();
			specificField = myObj.nextLine();
			break;
			
		default:
			break;
		}
		
		return specificField;
	}

	// Menu Method to delete contact from database
	public boolean deleteContactMenu(Scanner myObj) {
		isDone = false;
		
		contactList.clear();
		myObj.nextLine();
		
//		Scanner myObj = new Scanner(System.in);
		
		do {
			contactList = searchContacts("to Delete", myObj);
			

			if(contactList.isEmpty()) {
				System.out.println("Couldn't find contact(s)!");
			}
			else {
				displayContacts(contactList);
			}
			
			System.out.println(underscoreChar.repeat(250));
			
			System.out.println("Select Contact ID that you want to delete - ");
			int chosenId = myObj.nextInt();
			
			boolean isDeleted = false;
			if(chosenId<=contactList.size())
			{		
				Contact chosenContact = contactList.get(chosenId-1);
				String contactGroup = chosenContact.getContactGroup();
				String mobileNumber = chosenContact.getMobileNumber();



				switch (contactGroup.toLowerCase()) {
				case "personal friends":
					isDeleted = personalContactService.deleteContact(mobileNumber);
					break;

				case "professional friends":
					isDeleted = professionalContactService.deleteContact(mobileNumber);
					break;	

				case "relatives":
					isDeleted = relativesContactService.deleteContact(mobileNumber);
					break;	

				default:
					isDeleted = contactService.deleteContact(mobileNumber);
					break;
				}
			}
			
			if(isDeleted) {
				System.out.println("1 Contact Deleted!");
			} else {
				System.out.println("Unable to delete contact!");
			}
			
			System.out.println(underscoreChar.repeat(250));
			System.out.println("Do you want to delete another contact? (Y/N)");
			repeatChoice = myObj.next();
			
			if(repeatChoice.equalsIgnoreCase("N")) {
				isDone = true;
			}
			
		} while (repeatChoice.equalsIgnoreCase("Y"));
		
//		myObj.close();
		return isDone;
				
	}

	// Menu Method for Report Generation
	public boolean reportGenerateMenu(Scanner myObj) {
		isDone = false;
		
		myObj.nextLine();
		
//		Scanner myObj = new Scanner(System.in);
		
		do {
			System.out.println("Choose the Report required from the options - ");
			System.out.println("1. List of the Birthdays for the required Month");
			System.out.println("2. List of Contacts for the required Group");
			System.out.println("3. List of Name and Mobile Numbers");
			System.out.println("4. List of Name and Email Addresses");
			System.out.println("5. List of Name and Mobile Numbers in ascending order of group size");

			
			switch (myObj.nextInt()) {
			case 1:
				System.out.println(underscoreChar.repeat(250));
				System.out.println("1. List of the Birthdays for the required Month");			
				System.out.println("Enter the Month - ");
				String monthName = myObj.next();
				reportService.listOfBirthdays(monthName, myObj);
				break;

			case 2:
				System.out.println(underscoreChar.repeat(250));
				System.out.println("2. List of Contacts for the required Group");			
				System.out.println("Enter the Group Name [ Personal Friends, Professional Friends, Relatives, Other ] - ");
				myObj.nextLine();
				String contactGroup = myObj.nextLine();
				reportService.listOfContactByGroup(contactGroup, myObj);
				break;

			case 3:
				System.out.println(underscoreChar.repeat(250));
				System.out.println("3. List of Name and Mobile Numbers");				
				reportService.listOfNumberOrEmail(1, myObj);
				break;	

			case 4:
				System.out.println(underscoreChar.repeat(250));
				System.out.println("4. List of Name and Email Addresses");				
				reportService.listOfNumberOrEmail(2, myObj);
				break;	

			case 5:
				System.out.println(underscoreChar.repeat(250));
				System.out.println("5. List of Name and Mobile Numbers in ascending order of group size");				
				reportService.ascendingGroupCountReport(myObj);
				break;		

			default:
				break;
			}

			System.out.println(underscoreChar.repeat(250));
			System.out.println("Do you want to generate another report? (Y/N)");

			repeatChoice = myObj.next();
			
			if(repeatChoice.equalsIgnoreCase("N")) {
				isDone = true;
			}
			System.out.println(underscoreChar.repeat(250));
		
		} while (repeatChoice.equalsIgnoreCase("Y"));
		
//		myObj.close();
		return isDone;
		
	}


}	
	

	

