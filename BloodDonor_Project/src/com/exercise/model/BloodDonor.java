package com.exercise.model;

public class BloodDonor {

	private int donorId;
	private String donorName;
	private int donorAge;
	private String bloodGroup;
	
	public BloodDonor(int donorId, String donorName, int donorAge, String bloodGroup) {
		super();
		this.donorId = donorId;
		this.donorName = donorName;
		this.donorAge = donorAge;
		this.bloodGroup = bloodGroup;
	}

	public int getDonorId() {
		return donorId;
	}

	public void setDonorId(int donorId) {
		this.donorId = donorId;
	}

	public String getDonorName() {
		return donorName;
	}

	public void setDonorName(String donorName) {
		this.donorName = donorName;
	}

	public int getDonorAge() {
		return donorAge;
	}

	public void setDonorAge(int donorAge) {
		this.donorAge = donorAge;
	}

	public String getBloodGroup() {
		return bloodGroup;
	}

	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	@Override
	public String toString() {
		return "BloodDonor [donorId=" + donorId + ", donorName=" + donorName + ", donorAge=" + donorAge
				+ ", bloodGroup=" + bloodGroup + "]";
	}
	
	
	
	
}
