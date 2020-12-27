package com.contacts.model;

import java.time.LocalDate;

public class ProfessionalFriendContact extends Contact {
	
	private String organization;

	public ProfessionalFriendContact() {
		
	}

	public ProfessionalFriendContact(String contactName, String contactAddr, String mobileNumber, String imgReference,
			LocalDate dateOfBirth, String emailAddr, String contactGroup, String organization) {
		super(contactName, contactAddr, mobileNumber, imgReference, dateOfBirth, emailAddr, contactGroup);
		this.organization = organization;
	}

	/**
	 * @return the organization
	 */
	public String getOrganization() {
		return organization;
	}

	/**
	 * @param organization the organization to set
	 */
	public void setOrganization(String organization) {
		this.organization = organization;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((organization == null) ? 0 : organization.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProfessionalFriendContact other = (ProfessionalFriendContact) obj;
		if (organization == null) {
			if (other.organization != null)
				return false;
		} else if (!organization.equals(other.organization))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Name: " + getContactName()
		+ ", Address: " + getContactAddr() + ", Mobile Number: " + getMobileNumber()
		+ ", Image Source: " + getImgReference() + ", Date of Birth: " + getDateOfBirth()
		+ ", Email: " + getEmailAddr() + ", Group: " + getContactGroup() + ", Organization: " + organization ;
	}

	
	
}
