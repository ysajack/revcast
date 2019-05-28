package com.cognizant.revcast.models;

public class ProjectAssociateView {
	Project project;
	Associate associate;
	
	public ProjectAssociateView(Project project, Associate associate) {
		super();
		this.project = project;
		this.associate = associate;
	}
	public Project getProject() {
		return project;
	}
	public void setProject(Project project) {
		this.project = project;
	}
	public Associate getAssociate() {
		return associate;
	}
	public void setAssociate(Associate associate) {
		this.associate = associate;
	}
	
}
