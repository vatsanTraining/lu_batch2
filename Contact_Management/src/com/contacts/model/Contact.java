package com.contacts.model;

import java.time.LocalDate;

public class Contact {

	private String contactName;
	private String contactAddr;
	private String mobileNumber;
	private String imgReference;
	private LocalDate dateOfBirth;
	private String emailAddr;
	private String contactGroup;
	
	//Zero-Argument Constructor
	public Contact() {
		super();
		
	}

	/**
	 * @param contactName
	 * @param contactAddr
	 * @param mobileNumber
	 * @param imgReference
	 * @param dateOfBirth
	 * @param emailAddr
	 * @param contactGroup
	 */
	public Contact(String contactName, String contactAddr, String mobileNumber, String imgReference,
			LocalDate dateOfBirth, String emailAddr, String contactGroup) {
		super();
		this.contactName = contactName;
		this.contactAddr = contactAddr;
		this.mobileNumber = mobileNumber;
		this.imgReference = imgReference;
		this.dateOfBirth = dateOfBirth;
		this.emailAddr = emailAddr;
		this.contactGroup = contactGroup;
	}

	/**
	 * @return the contactName
	 */
	public String getContactName() {
		return contactName;
	}

	/**
	 * @param contactName the contactName to set
	 */
	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	/**
	 * @return the contactAddr
	 */
	public String getContactAddr() {
		return contactAddr;
	}

	/**
	 * @param contactAddr the contactAddr to set
	 */
	public void setContactAddr(String contactAddr) {
		this.contactAddr = contactAddr;
	}

	/**
	 * @return the mobileNumber
	 */
	public String getMobileNumber() {
		return mobileNumber;
	}

	/**
	 * @param mobileNumber the mobileNumber to set
	 */
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	/**
	 * @return the imgReference
	 */
	public String getImgReference() {
		return imgReference;
	}

	/**
	 * @param imgReference the imgReference to set
	 */
	public void setImgReference(String imgReference) {
		this.imgReference = imgReference;
	}

	/**
	 * @return the dateOfBirth
	 */
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	/**
	 * @param dateOfBirth the dateOfBirth to set
	 */
	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	/**
	 * @return the emailAddr
	 */
	public String getEmailAddr() {
		return emailAddr;
	}

	/**
	 * @param emailAddr the emailAddr to set
	 */
	public void setEmailAddr(String emailAddr) {
		this.emailAddr = emailAddr;
	}

	/**
	 * @return the contactGroup
	 */
	public String getContactGroup() {
		return contactGroup;
	}

	/**
	 * @param contactGroup the contactGroup to set
	 */
	public void setContactGroup(String contactGroup) {
		this.contactGroup = contactGroup;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((contactAddr == null) ? 0 : contactAddr.hashCode());
		result = prime * result + ((contactGroup == null) ? 0 : contactGroup.hashCode());
		result = prime * result + ((contactName == null) ? 0 : contactName.hashCode());
		result = prime * result + ((dateOfBirth == null) ? 0 : dateOfBirth.hashCode());
		result = prime * result + ((emailAddr == null) ? 0 : emailAddr.hashCode());
		result = prime * result + ((imgReference == null) ? 0 : imgReference.hashCode());
		result = prime * result + ((mobileNumber == null) ? 0 : mobileNumber.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contact other = (Contact) obj;
		if (contactAddr == null) {
			if (other.contactAddr != null)
				return false;
		} else if (!contactAddr.equals(other.contactAddr))
			return false;
		if (contactGroup == null) {
			if (other.contactGroup != null)
				return false;
		} else if (!contactGroup.equals(other.contactGroup))
			return false;
		if (contactName == null) {
			if (other.contactName != null)
				return false;
		} else if (!contactName.equals(other.contactName))
			return false;
		if (dateOfBirth == null) {
			if (other.dateOfBirth != null)
				return false;
		} else if (!dateOfBirth.equals(other.dateOfBirth))
			return false;
		if (emailAddr == null) {
			if (other.emailAddr != null)
				return false;
		} else if (!emailAddr.equals(other.emailAddr))
			return false;
		if (imgReference == null) {
			if (other.imgReference != null)
				return false;
		} else if (!imgReference.equals(other.imgReference))
			return false;
		if (mobileNumber == null) {
			if (other.mobileNumber != null)
				return false;
		} else if (!mobileNumber.equals(other.mobileNumber))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Name: " + contactName + ", Address: " + contactAddr + ", Mobile Number: " + mobileNumber
				+ ", Image Source: " + imgReference + ", Date of Birth: " + dateOfBirth + ", Email: " + emailAddr
				+ ", Group: " + contactGroup;
	}

	
	
	
	
	
}
