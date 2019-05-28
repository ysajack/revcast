package com.cognizant.revcast.models;

public class LeavePlanView {
	String year;
	Month month;
	String associateId;
	
	public LeavePlanView() {}
	public LeavePlanView(String year, Month month, String associateId) {
		super();
		this.year = year;
		this.month = month;
		this.associateId = associateId;
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
	
}
