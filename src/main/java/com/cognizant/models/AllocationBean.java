package com.cognizant.models;

public class AllocationBean {
	String associateId;
	String projectId;
	String projectStart;
	String projectEnd;
	int allocation;
	int rate;

	public AllocationBean(){}

	public AllocationBean(String associateId, String projectId, String projectStart, String projectEnd, int allocation,
			int rate) {
		super();
		this.associateId = associateId;
		this.projectId = projectId;
		this.projectStart = projectStart;
		this.projectEnd = projectEnd;
		this.allocation = allocation;
		this.rate = rate;
	}
	public String getAssociateId() {
		return associateId;
	}
	public void setAssociateId(String associateId) {
		this.associateId = associateId;
	}
	public String getProjectId() {
		return projectId;
	}
	public void setProjectId(String projectId) {
		this.projectId = projectId;
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
	
}
