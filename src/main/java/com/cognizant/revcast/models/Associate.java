package com.cognizant.revcast.models;

public class Associate {
	String associateId;
	String associateName;
	String designation;
	String status;
	String revcat;
	String practice;
	String onsiteOffshore;
	String revType;
	String projectStart;
	String projectEnd;
	int allocation;
	int rate;
	String projectId;
	
	public Associate(String associateId, String associateName, String designation, String status, String revcat,
			String practice, String onsiteOffshore, String revType, String projectStart, String projectEnd,
			int allocation, int rate, String projectId) {
		super();
		this.associateId = associateId;
		this.associateName = associateName;
		this.designation = designation;
		this.status = status;
		this.revcat = revcat;
		this.practice = practice;
		this.onsiteOffshore = onsiteOffshore;
		this.revType = revType;
		this.projectStart = projectStart;
		this.projectEnd = projectEnd;
		this.allocation = allocation;
		this.rate = rate;
		this.projectId = projectId;
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
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getRevcat() {
		return revcat;
	}
	public void setRevcat(String revcat) {
		this.revcat = revcat;
	}
	public String getPractice() {
		return practice;
	}
	public void setPractice(String practice) {
		this.practice = practice;
	}
	public String getOnsiteOffshore() {
		return onsiteOffshore;
	}
	public void setOnsiteOffshore(String onsiteOffshore) {
		this.onsiteOffshore = onsiteOffshore;
	}
	public String getRevType() {
		return revType;
	}
	public void setRevType(String revType) {
		this.revType = revType;
	}
	public String getProjectStart() {
		return projectStart;
	}
	public void setProjectStart(String projectStart) {
		this.projectStart = projectStart;
	}
	public String getProjectEnd() {
		return projectEnd;
	}
	public void setProjectEnd(String projectEnd) {
		this.projectEnd = projectEnd;
	}
	public int getAllocation() {
		return allocation;
	}
	public void setAllocation(int allocation) {
		this.allocation = allocation;
	}
	public int getRate() {
		return rate;
	}
	public void setRate(int rate) {
		this.rate = rate;
	}
	public String getProjectId() {
		return projectId;
	}
	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}
		
}
