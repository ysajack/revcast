package com.cognizant.revcast.models;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "projectBean")
public class ProjectBean implements Serializable{

	private static final long serialVersionUID = 1L;
	private String bio;
	private String projectId;
	private String projectName;
	
	public ProjectBean(){};

	public ProjectBean(String bio, String projectId, String projectName) {
		super();
		this.bio = bio;
		this.projectId = projectId;
		this.projectName = projectName;
	}


	public String getBio() {
		return bio;
	}

	@XmlElement
	public void setBio(String bio) {
		this.bio = bio;
	}


	public String getProjectId() {
		return projectId;
	}

	@XmlElement
	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}


	public String getProjectName() {
		return projectName;
	}

	@XmlElement
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
}
