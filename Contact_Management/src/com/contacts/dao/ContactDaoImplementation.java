package com.contacts.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.contacts.ifaces.ContactsDataAccess;
import com.contacts.model.Contact;




public class ContactDaoImplementation implements ContactsDataAccess<Contact> {

	private final String ADDSQL = "insert into contacts values (?,?,?,?,?,?,?)" ;
	private final String FINDALLSQL = "select * from contacts";
	private final String FINDNUMBERSQL = "select * from contacts where mobileNumber LIKE ? ORDER BY LOCATE(?,mobileNumber) DESC";
	private final String FINDNAMESQL = "select * from contacts where LOWER(contactName) LIKE ? ORDER BY LOCATE(?,LOWER(contactName))";
	private final String UPDATESQL = "update contacts set contactName=? , contactAddr=?, mobileNumber=?, imgReference=?, dateOfBirth=?, emailAddr=?, contactGroup=? where mobileNumber=?";
	private final String DELETESQL = "delete from contacts where mobileNumber=?";

	private List<Contact> contactList;

	private Connection con;

	//Parameterized Constructor with connection as parameter
	public ContactDaoImplementation(Connection con) {
		this.con = con;
		this.contactList = new ArrayList<Contact>();

	}

	// Private Method to get field elements
	private Contact getContactDetails(ResultSet rs) {


		String contactName = null;
		String contactAddr = null;
		String mobileNumber = null;
		String imgReference = null;
		LocalDate dateOfBirth = null;
		String emailAddr = null;
		String contactGroup = null;


		try {

			contactName = rs.getString("contactName");
			contactAddr = rs.getString("contactAddr");
			mobileNumber = rs.getString("mobileNumber");
			imgReference = rs.getString("imgReference");
			dateOfBirth = rs.getDate("dateOfBirth").toLocalDate();	
			emailAddr = rs.getString("emailAddr");
			contactGroup = rs.getString("contactGroup");


		} catch (SQLException e) {

			e.printStackTrace();
		}

		Contact contact = new Contact(contactName, contactAddr, mobileNumber, imgReference, dateOfBirth, emailAddr, contactGroup);
		return contact;
	}

	@Override
	public int addToContacts(Contact contact) {
		int rowAdded = 0;

		// Users table has mobileNumber as Primary Key and other tables reference this as foreign key. Requirement for Joins 
		String sql = "insert into users values (?)";

		try(PreparedStatement pstmt = con.prepareStatement(sql)){
			pstmt.setString(1, contact.getMobileNumber());
			pstmt.executeUpdate();			
		} catch (SQLException e1) {

			e1.printStackTrace();
		}

		// Adding contact to contacts table...

		try(PreparedStatement pstmt = con.prepareStatement(ADDSQL) ){
			pstmt.setString(1, contact.getContactName());
			pstmt.setString(2, contact.getContactAddr());
			pstmt.setString(3, contact.getMobileNumber());
			pstmt.setString(4, contact.getImgReference());		
			pstmt.setDate(5, Date.valueOf(contact.getDateOfBirth()));
			pstmt.setString(6, contact.getEmailAddr());
			pstmt.setString(7, contact.getContactGroup());

			rowAdded = pstmt.executeUpdate();

		} catch (SQLException e) {
			System.err.println("Unable to add contact!");
			e.printStackTrace();
		}

		return rowAdded;
	}


	@Override
	public int updateContact(String mobileNumber, Contact newContact) {

		int rowUpdated=0;

		//Update 'users' table before any other table(only if change), All tables reference Mobile number of 'users' table as foreign key
		if(!(mobileNumber.equalsIgnoreCase(newContact.getMobileNumber()))) {
			String sql = "update users set mobileNumber=? where mobileNumber=?";


			try(PreparedStatement pstmt = con.prepareStatement(sql)){
				pstmt.setString(1, newContact.getMobileNumber());
				pstmt.setString(2, mobileNumber);
				pstmt.executeUpdate();			
			} catch (SQLException e1) {
				System.err.println("Unable to Update!");
				e1.printStackTrace();
			}
		}

		// Update 'contacts' table 
		try(PreparedStatement pstmt = con.prepareStatement(UPDATESQL)){
			pstmt.setString(1, newContact.getContactName());
			pstmt.setString(2, newContact.getContactAddr());
			pstmt.setString(3, newContact.getMobileNumber());
			pstmt.setString(4, newContact.getImgReference());
			pstmt.setDate(5, Date.valueOf(newContact.getDateOfBirth()));
			pstmt.setString(6, newContact.getEmailAddr());
			pstmt.setString(7, newContact.getContactGroup());
			pstmt.setString(8, mobileNumber);

			rowUpdated = pstmt.executeUpdate();			
		} catch (SQLException e1) {
			System.err.println("Unable to update contact with Mobile Number - "+ mobileNumber);
			e1.printStackTrace();
		}

		return rowUpdated;
	}


	@Override
	public List<Contact> findAllContacts() {

		contactList.removeAll(contactList);

		try(PreparedStatement pstmt = con.prepareStatement(FINDALLSQL)) {

			ResultSet rs = pstmt.executeQuery();

			while(rs.next()) {

				Contact contact = getContactDetails(rs);

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
	public List<Contact> findContactByNumber(String number) {

		contactList.removeAll(contactList);		

		try(PreparedStatement pstmt = con.prepareStatement(FINDNUMBERSQL)) {

			pstmt.setString(1, "%"+number+"%");
			pstmt.setString(2, number);
			ResultSet rs = pstmt.executeQuery();			

			while(rs.next()) {

				Contact foundContact =  getContactDetails(rs);			
				contactList.add(foundContact);

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
	public List<Contact> findContactByName(String name) {
		contactList.removeAll(contactList);		

		try(PreparedStatement pstmt = con.prepareStatement(FINDNAMESQL)) {

			pstmt.setString(1, "%"+name.toLowerCase()+"%");
			pstmt.setString(2, name);
			ResultSet rs = pstmt.executeQuery();			

			while(rs.next()) {

				Contact foundContact =  getContactDetails(rs);			
				contactList.add(foundContact);

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
	public Contact findCompleteDetails(String number) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteContact(String number) {
		boolean isDeleted = false;
		String sql = "delete from users where mobileNumber=?";

		try(PreparedStatement pstmt = con.prepareStatement(DELETESQL)){


			pstmt.setString(1, number);
			pstmt.executeUpdate();
			
				try(PreparedStatement pstmt1 = con.prepareStatement(sql)) {
					pstmt1.setString(1, number);
					pstmt1.executeUpdate();	
					isDeleted=true;
				} catch (SQLException e) {
					System.err.println("Unable to delete from Users Table!");
					e.printStackTrace();
				}
			

		} catch (SQLException e) {
			System.err.println("Unable to delete Contact!");
			e.printStackTrace();
		}
		return isDeleted;
	}






}
