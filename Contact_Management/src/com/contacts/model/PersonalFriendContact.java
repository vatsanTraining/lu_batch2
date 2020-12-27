package com.contacts.model;

import java.time.LocalDate;

public class PersonalFriendContact extends Contact {

	private String nickname;

	public PersonalFriendContact() {
		
	}

	public PersonalFriendContact(String contactName, String contactAddr, String mobileNumber, String imgReference,
			LocalDate dateOfBirth, String emailAddr, String contactGroup, String nickname) {
		super(contactName, contactAddr, mobileNumber, imgReference, dateOfBirth, emailAddr, contactGroup);
		this.nickname = nickname;
	}

	/**
	 * @return the nickname
	 */
	public String getNickname() {
		return nickname;
	}

	/**
	 * @param nickname the nickname to set
	 */
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((nickname == null) ? 0 : nickname.hashCode());
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
		PersonalFriendContact other = (PersonalFriendContact) obj;
		if (nickname == null) {
			if (other.nickname != null)
				return false;
		} else if (!nickname.equals(other.nickname))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return  "Name: " + getContactName()
				+ ", Address: " + getContactAddr() + ", Mobile Number: " + getMobileNumber()
				+ ", Image Source: " + getImgReference() + ", Date of Birth: " + getDateOfBirth()
				+ ", Email: " + getEmailAddr() + ", Group: " + getContactGroup() + ", Nickname: " + nickname ;
	}
	
	

}
