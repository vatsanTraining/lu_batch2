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

import com.contacts.model.RelativesContact;

public class RelativesContactDaoImpl implements ContactsDataAccess<RelativesContact> {

	private List<RelativesContact> contactList;
	private ContactDaoImplementation contactService;
	private Connection con;
	String contactName;
	String contactAddr;
	String phoneNumber;
	String imgReference;
	LocalDate dateOfBirth;
	String emailAddr;
	String contactGroup;
	String relation;
	
	private final String ADDSQL = "insert into relatives_contacts values(?,?)";
	
	private final String UPDATESQL = "update relatives_contacts set mobileNumber=?, relation=? where mobileNumber=?";
	
	private final String FINDALLSQL = "select a.*,b.relation from (select c.contactName,c.contactAddr,c.imgReference,c.dateOfBirth,c.emailAddr,c.contactGroup,u.mobileNumber from contacts c INNER JOIN users u on c.mobileNumber = u.mobileNumber) as a RIGHT JOIN (select f.relation, u.mobileNumber from relatives_contacts f INNER JOIN users u ON u.mobileNumber = f.mobileNumber) as b ON a.mobileNumber=b.mobileNumber";
	
	private final String FINDCOMPLETESQL = "select e.* from ("+FINDALLSQL+") as e WHERE e.mobileNumber=?";
	
	private final String DELETESQL = "delete from relatives_contacts where mobileNumber=?";
	
	public RelativesContactDaoImpl(Connection con) {
		this.con = con;
		this.contactList = new ArrayList<RelativesContact>();
		this.contactService = new ContactDaoImplementation(con);

		this.contactName = null;
		this.contactAddr = null;
		this.phoneNumber = null;
		this.imgReference = null;
		this.dateOfBirth = null;
		this.emailAddr = null;
		this.contactGroup = null;
		this.relation = null;
	}
	
	private void setFields(RelativesContact contact) {
		contactName=contact.getContactName();
		contactAddr = contact.getContactAddr();
		phoneNumber = contact.getMobileNumber();
		imgReference = contact.getImgReference();
		dateOfBirth = contact.getDateOfBirth();
		emailAddr = contact.getEmailAddr();
		contactGroup = contact.getContactGroup();
		relation = contact.getRelation();
	}
	
	private RelativesContact getContactDetails(ResultSet rs) {

		try {

			contactName = rs.getString("contactName");
			contactAddr = rs.getString("contactAddr");
			phoneNumber = rs.getString("mobileNumber");
			imgReference = rs.getString("imgReference");
			dateOfBirth = rs.getDate("dateOfBirth").toLocalDate();	
			emailAddr = rs.getString("emailAddr");
			contactGroup = rs.getString("contactGroup");
			relation = rs.getString("relation");
			

		} catch (SQLException e) {
			System.err.println("Unable to fetch details!");
			e.printStackTrace();
		}

		RelativesContact contact = new RelativesContact(contactName, contactAddr, phoneNumber, imgReference, dateOfBirth, emailAddr, contactGroup, relation);
		return contact;
	}
	

	@Override
	public int addToContacts(RelativesContact contact) {

		int rowAdded = 0;
		setFields(contact);
		
		rowAdded=contactService.addToContacts((Contact)contact);
		
		if(rowAdded==0) {
			rowAdded=0;
			
		}else {
			try(PreparedStatement pstmt = con.prepareStatement(ADDSQL) ){
				pstmt.setString(1, contact.getMobileNumber());
				pstmt.setString(2, contact.getRelation());
				rowAdded = pstmt.executeUpdate();

			} catch (SQLException e) {
				System.err.println("Unable to add contact!");
				e.printStackTrace();
			}

		}
		
		return rowAdded;
	}

	@Override
	public int updateContact(String mobileNumber, RelativesContact newContact) {
		int rowUpdated = 0;
		setFields(newContact);
		

		rowUpdated = contactService.updateContact(mobileNumber, (Contact)newContact);
		
		if(rowUpdated==0) {
			rowUpdated=0;
		}else {

			try(PreparedStatement pstmt = con.prepareStatement(UPDATESQL)){
				pstmt.setString(1, newContact.getMobileNumber());
				pstmt.setString(2, newContact.getRelation());
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
	public List<RelativesContact> findAllContacts() {
		contactList.removeAll(contactList);

		try(PreparedStatement pstmt = con.prepareStatement(FINDALLSQL)) {
			
			
			ResultSet rs = pstmt.executeQuery();

			while(rs.next()) {

				RelativesContact contact = getContactDetails(rs);

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
	public List<RelativesContact> findContactByNumber(String number) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RelativesContact> findContactByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RelativesContact findCompleteDetails(String number) {
		RelativesContact contact = new RelativesContact();
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
