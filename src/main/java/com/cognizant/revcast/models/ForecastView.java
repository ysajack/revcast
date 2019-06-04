package com.cognizant.revcast.models;

public class ForecastView {
	String year;
	ForecastMonth month;
	String associateId;
	String associateName;
	String projectId;
	String projectName;
	
	public ForecastView() {}
	
	public ForecastView(String year, ForecastMonth month, String associateId, String associateName, String projectId,
			String projectName) {
		super();
		this.year = year;
		this.month = month;
		this.associateId = associateId;
		this.associateName = associateName;
		this.projectId = projectId;
		this.projectName = projectName;
	}


	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public ForecastMonth getMonth() {
		return month;
	}

	public void setForecastMonth(ForecastMonth month) {
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

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public void setMonth(ForecastMonth month) {
		this.month = month;
	}
	
	
}
