package com.contacts.model;

import java.time.LocalDate;

public class RelativesContact extends Contact {

	private String relation;
	
	//Zero-Argument Constructor
	public RelativesContact() {
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
	 * @param relation
	 */
	public RelativesContact(String contactName, String contactAddr, String mobileNumber, String imgReference,
			LocalDate dateOfBirth, String emailAddr, String contactGroup, String relation) {
		super(contactName, contactAddr, mobileNumber, imgReference, dateOfBirth, emailAddr, contactGroup);
		this.relation = relation;
	}

	/**
	 * @return the relation
	 */
	public String getRelation() {
		return relation;
	}

	/**
	 * @param relation the relation to set
	 */
	public void setRelation(String relation) {
		this.relation = relation;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((relation == null) ? 0 : relation.hashCode());
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
		RelativesContact other = (RelativesContact) obj;
		if (relation == null) {
			if (other.relation != null)
				return false;
		} else if (!relation.equals(other.relation))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Name: " + getContactName()
		+ ", Address: " + getContactAddr() + ", Mobile Number: " + getMobileNumber()
		+ ", Image Source: " + getImgReference() + ", Date of Birth: " + getDateOfBirth()
		+ ", Email: " + getEmailAddr() + ", Group: " + getContactGroup() + ", Relation: " + relation ;
	}
	
	
	
	
	
	


}
