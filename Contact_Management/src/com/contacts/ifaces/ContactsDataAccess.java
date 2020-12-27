/**
 * 
 */
package com.contacts.ifaces;

import java.util.List;

/**
 * @author Shreyas
 *
 */
public interface ContactsDataAccess<T> {

	public int addToContacts(T contact);
	public int updateContact(String mobileNumber, T newContact);
	public List<T> findAllContacts();
	public List<T> findContactByNumber(String number);
	public List<T> findContactByName(String name);
	public T findCompleteDetails(String number);
	public boolean deleteContact(String number);
	
}
