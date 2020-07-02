package com.cognizant.models;

import javax.ws.rs.FormParam;
import javax.ws.rs.QueryParam;

public class Project {
	@QueryParam("bio")
	String bio;
	@QueryParam("projectId")
	String projectId;
	@QueryParam("projectName")
	String projectName;
	@QueryParam("projectType")
	String projectType;
	@QueryParam("associateId")
	String associateId;

	public Project(){};
	
	public Project(String bio, String projectId, String projectName, String projectType, String associateId) {
		super();
		this.bio = bio;
		this.projectId = projectId;
		this.projectName = projectName;
		this.projectType = projectType;
		this.associateId = associateId;
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


	public String getProjectType() {
		return projectType;
	}


	public void setProjectType(String projectType) {
		this.projectType = projectType;
	}


	public String getAssociateId() {
		return associateId;
	}


	public void setAssociateId(String associateId) {
		this.associateId = associateId;
	}

	@Override
	public String toString() {
		return "Project{" +
				"bio='" + bio + '\'' +
				", projectId='" + projectId + '\'' +
				", projectName='" + projectName + '\'' +
				", projectType='" + projectType + '\'' +
				", associateId='" + associateId + '\'' +
				'}';
	}

	//	@Override
//	public String toString() {
//		return "{" +
//				"bio:'" + bio + '\'' +
//				", projectId:'" + projectId + '\'' +
//				", projectName:'" + projectName + '\'' +
//				", projectType:'" + projectType + '\'' +
//				", associateId:'" + associateId + '\'' +
//				'}';
//	}
}
