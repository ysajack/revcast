package com.cognizant.models;

public class Leave {
	int id;
	String year;
	String month;
	int numOfdays;
	String dateTaken;
	String status;
	String comments;
	String associateId;

	public Leave(){}

	public Leave(int id,String year, String month, int numOfdays, String dateTaken, String status,String comments, String associateId) {
		super();
		this.id=id;
		this.year = year;
		this.month = month;
		this.numOfdays = numOfdays;
		this.dateTaken = dateTaken;
		this.status=status;
		this.comments = comments;
		this.associateId = associateId;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public int getNumOfdays() {
		return numOfdays;
	}

	public void setNumOfdays(int numOfdays) {
		this.numOfdays = numOfdays;
	}

	public String getDateTaken() {
		return dateTaken;
	}

	public void setDateTaken(String dateTaken) {
		this.dateTaken = dateTaken;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getAssociateId() {
		return associateId;
	}

	public void setAssociateId(String associateId) {
		this.associateId = associateId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
}
