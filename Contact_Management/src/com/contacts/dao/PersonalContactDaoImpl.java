package com.contacts.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.contacts.ifaces.ContactsDataAccess;
import com.contacts.model.Contact;
import com.contacts.model.PersonalFriendContact;

public class PersonalContactDaoImpl implements ContactsDataAccess<PersonalFriendContact> {

	private List<PersonalFriendContact> contactList;
	private ContactDaoImplementation contactService;
	private Connection con;
	String contactName;
	String contactAddr;
	String phoneNumber;
	String imgReference;
	LocalDate dateOfBirth;
	String emailAddr;
	String contactGroup;
	String nickname;
	
	private final String ADDSQL = "insert into friends_contacts values(?,?)";
	
	private final String UPDATESQL = "update friends_contacts set mobileNumber=?, nickname=? where mobileNumber=?";
	
	private final String FINDALLSQL = "select a.*,b.nickname from (select c.contactName,c.contactAddr,c.imgReference,c.dateOfBirth,c.emailAddr,c.contactGroup,u.mobileNumber from contacts c INNER JOIN users u on c.mobileNumber = u.mobileNumber) as a RIGHT JOIN (select f.nickname, u.mobileNumber from friends_contacts f INNER JOIN users u ON u.mobileNumber = f.mobileNumber) as b ON a.mobileNumber=b.mobileNumber";
	
	private final String FINDCOMPLETESQL = "select e.* from ("+FINDALLSQL+") as e WHERE e.mobileNumber=?";
	
	private final String DELETESQL = "delete from friends_contacts where mobileNumber=?";
	
	public PersonalContactDaoImpl(Connection con) {
		this.con = con;
		this.contactList = new ArrayList<PersonalFriendContact>();
		this.contactService = new ContactDaoImplementation(con);

		this.contactName = null;
		this.contactAddr = null;
		this.phoneNumber = null;
		this.imgReference = null;
		this.dateOfBirth = null;
		this.emailAddr = null;
		this.contactGroup = null;
		this.nickname = null;
	}
	
	//Get parameters from contact object as per requirement
	private void setFields(PersonalFriendContact contact) {
		contactName=contact.getContactName();
		contactAddr = contact.getContactAddr();
		phoneNumber = contact.getMobileNumber();
		imgReference = contact.getImgReference();
		dateOfBirth = contact.getDateOfBirth();
		emailAddr = contact.getEmailAddr();
		contactGroup = contact.getContactGroup();
		nickname = contact.getNickname();
	}
	
	private PersonalFriendContact getContactDetails(ResultSet rs) {

		try {

			contactName = rs.getString("contactName");
			contactAddr = rs.getString("contactAddr");
			phoneNumber = rs.getString("mobileNumber");
			imgReference = rs.getString("imgReference");
			dateOfBirth = rs.getDate("dateOfBirth").toLocalDate();	
			emailAddr = rs.getString("emailAddr");
			contactGroup = rs.getString("contactGroup");
			nickname = rs.getString("nickname");
			

		} catch (SQLException e) {
			System.err.println("Unable to fetch details!");
			e.printStackTrace();
		}

		PersonalFriendContact contact = new PersonalFriendContact(contactName, contactAddr, phoneNumber, imgReference, dateOfBirth, emailAddr, contactGroup,nickname);
		return contact;
	}


	@Override
	public int addToContacts(PersonalFriendContact contact) {
		
		int rowAdded = 0;
		setFields(contact);
		
		rowAdded=contactService.addToContacts((Contact)contact);
		
		if(rowAdded==0) {
			rowAdded=0;
			
		}else {
			try(PreparedStatement pstmt = con.prepareStatement(ADDSQL) ){
				pstmt.setString(1, contact.getMobileNumber());
				pstmt.setString(2, contact.getNickname());
				rowAdded = pstmt.executeUpdate();

			} catch (SQLException e) {
				System.err.println("Unable to add contact!");
				e.printStackTrace();
			}

		}
		
		return rowAdded;
	}

	@Override
	public int updateContact(String mobileNumber, PersonalFriendContact newContact) {
		
		int rowUpdated = 0;
		setFields(newContact);
		

		rowUpdated = contactService.updateContact(mobileNumber, (Contact)newContact);
		
		if(rowUpdated==0) {
			rowUpdated=0;
		}else {

			try(PreparedStatement pstmt = con.prepareStatement(UPDATESQL)){
				pstmt.setString(1, newContact.getMobileNumber());
				pstmt.setString(2, newContact.getNickname());
				pstmt.setString(3,mobileNumber);
				rowUpdated = pstmt.executeUpdate();			
			} catch (SQLException e) {
				System.err.println("Unable to Update!");
				e.printStackTrace();
			}
		}
		
		
		return rowUpdated;
	}

	@Override
	public List<PersonalFriendContact> findAllContacts() {
		
		contactList.removeAll(contactList);

		try(PreparedStatement pstmt = con.prepareStatement(FINDALLSQL)) {
			
			
			ResultSet rs = pstmt.executeQuery();

			while(rs.next()) {

				PersonalFriendContact contact = getContactDetails(rs);

				contactList.add(contact);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		if(contactList.isEmpty()) {
			return Collections.emptyList();
		}else {
			return contactList;
		}


	}


	@Override
	public List<PersonalFriendContact> findContactByNumber(String number) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PersonalFriendContact> findContactByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PersonalFriendContact findCompleteDetails(String number) {
		
		PersonalFriendContact contact = new PersonalFriendContact();
		try(PreparedStatement pstmt = con.prepareStatement(FINDCOMPLETESQL)) {

			pstmt.setString(1, number);
			ResultSet rs = pstmt.executeQuery();

			while(rs.next()) {

				contact = getContactDetails(rs);
				
			}
		} catch (SQLException e) {
			System.err.println("Unable to find the contact details!");
			e.printStackTrace();
		}
		return contact;
	}

	@Override
	public boolean deleteContact(String number) {
		boolean isDeleted = false;		
		try(PreparedStatement pstmt = con.prepareStatement(DELETESQL)){
			pstmt.setString(1, number);
			pstmt.executeUpdate();
			isDeleted = contactService.deleteContact(number);			
		} catch (SQLException e) {
			System.err.println("Unable to delete contact details with Mobile Number - "+number+" !");
			e.printStackTrace();
		}
		return isDeleted;
	}

}
