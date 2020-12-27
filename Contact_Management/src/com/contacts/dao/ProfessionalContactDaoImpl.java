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
import com.contacts.model.ProfessionalFriendContact;

public class ProfessionalContactDaoImpl implements ContactsDataAccess<ProfessionalFriendContact> {

	private List<ProfessionalFriendContact> contactList;
	private ContactDaoImplementation contactService;
	private Connection con;
	String contactName;
	String contactAddr;
	String phoneNumber;
	String imgReference;
	LocalDate dateOfBirth;
	String emailAddr;
	String contactGroup;
	String organization;
	
	private final String ADDSQL = "insert into professional_contacts values(?,?)";
	
	private final String UPDATESQL = "update professional_contacts set mobileNumber=?, organization=? where mobileNumber=?";
	
	private final String FINDALLSQL = "select a.*,b.organization from (select c.contactName,c.contactAddr,c.imgReference,c.dateOfBirth,c.emailAddr,c.contactGroup,u.mobileNumber from contacts c INNER JOIN users u on c.mobileNumber = u.mobileNumber) as a RIGHT JOIN (select f.organization, u.mobileNumber from professional_contacts f INNER JOIN users u ON u.mobileNumber = f.mobileNumber) as b ON a.mobileNumber=b.mobileNumber";
	
	private final String FINDCOMPLETESQL = "select e.* from ("+FINDALLSQL+") as e WHERE e.mobileNumber=?";
	
	private final String DELETESQL = "delete from professional_contacts where mobileNumber=?";
	
	public ProfessionalContactDaoImpl(Connection con) {
		this.con = con;
		this.contactList = new ArrayList<ProfessionalFriendContact>();
		this.contactService = new ContactDaoImplementation(con);

		this.contactName = null;
		this.contactAddr = null;
		this.phoneNumber = null;
		this.imgReference = null;
		this.dateOfBirth = null;
		this.emailAddr = null;
		this.contactGroup = null;
		this.organization = null;
	}
	
	private void setFields(ProfessionalFriendContact contact) {
		contactName=contact.getContactName();
		contactAddr = contact.getContactAddr();
		phoneNumber = contact.getMobileNumber();
		imgReference = contact.getImgReference();
		dateOfBirth = contact.getDateOfBirth();
		emailAddr = contact.getEmailAddr();
		contactGroup = contact.getContactGroup();
		organization = contact.getOrganization();
	}
	
	private ProfessionalFriendContact getContactDetails(ResultSet rs) {


		try {

			contactName = rs.getString("contactName");
			contactAddr = rs.getString("contactAddr");
			phoneNumber = rs.getString("mobileNumber");
			imgReference = rs.getString("imgReference");
			dateOfBirth = rs.getDate("dateOfBirth").toLocalDate();	
			emailAddr = rs.getString("emailAddr");
			contactGroup = rs.getString("contactGroup");
			organization = rs.getString("organization");
			

		} catch (SQLException e) {
			System.err.println("Unable to fetch details!");
			e.printStackTrace();
		}

		ProfessionalFriendContact contact = new ProfessionalFriendContact(contactName, contactAddr, phoneNumber, imgReference, dateOfBirth, emailAddr, contactGroup,organization);
		return contact;
	}

	@Override
	public int addToContacts(ProfessionalFriendContact contact) {
		int rowAdded = 0;
		setFields(contact);
		
		rowAdded=contactService.addToContacts((Contact)contact);
		
		if(rowAdded==0) {
			rowAdded=0;
			
		}else {
			try(PreparedStatement pstmt = con.prepareStatement(ADDSQL) ){
				pstmt.setString(1, contact.getMobileNumber());
				pstmt.setString(2, contact.getOrganization());
				rowAdded = pstmt.executeUpdate();

			} catch (SQLException e) {
				System.err.println("Unable to add contact!");
				e.printStackTrace();
			}

		}
		
		return rowAdded;
	}

	@Override
	public int updateContact(String mobileNumber, ProfessionalFriendContact newContact) {
		int rowUpdated = 0;
		setFields(newContact);
		

		rowUpdated = contactService.updateContact(mobileNumber, (Contact)newContact);
		
		if(rowUpdated==0) {
			rowUpdated=0;
		}else {

			try(PreparedStatement pstmt = con.prepareStatement(UPDATESQL)){
				pstmt.setString(1, newContact.getMobileNumber());
				pstmt.setString(2, newContact.getOrganization());
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
	public List<ProfessionalFriendContact> findAllContacts() {
		contactList.removeAll(contactList);

		try(PreparedStatement pstmt = con.prepareStatement(FINDALLSQL)) {
			
			
			ResultSet rs = pstmt.executeQuery();

			while(rs.next()) {

				ProfessionalFriendContact contact = getContactDetails(rs);

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
	public List<ProfessionalFriendContact> findContactByNumber(String number) {
		return null;

	}

	@Override
	public List<ProfessionalFriendContact> findContactByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProfessionalFriendContact findCompleteDetails(String number) {
		ProfessionalFriendContact contact = new ProfessionalFriendContact();
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
