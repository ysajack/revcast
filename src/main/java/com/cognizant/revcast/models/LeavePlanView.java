package com.cognizant.revcast.models;

public class LeavePlanView {
	String year;
	Month month;
	String associateId;
	String associateName;
	
	public LeavePlanView() {}
	public LeavePlanView(String year, Month month, String associateId, String associateName) {
		super();
		this.year = year;
		this.month = month;
		this.associateId = associateId;
		this.associateName=associateName;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public Month getMonth() {
		return month;
	}

	public void setMonth(Month month) {
		this.month = month;
	}

	public String getAssociateId() {
		return associateId;
	}

	public void setAssociateId(String associateId) {
		this.associateId = associateId;
	}
	public String getAssociateName() {
		return associateName;
	}
	public void setAssociateName(String associateName) {
		this.associateName = associateName;
	}
	
}
