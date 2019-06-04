package com.cognizant.revcast.models;

public class ProjectBean {
	String bio;
	String projectId;
	String projectName;
	
	public ProjectBean(String bio, String projectId, String projectName) {
		super();
		this.bio = bio;
		this.projectId = projectId;
		this.projectName = projectName;
	}


	public String getBio() {
		return bio;
	}


	public void setBio(String bio) {
		this.bio = bio;
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
}
