package com.cognizant.models;

public class ApproveLeaveView {
	Project project;
	Associate associate;
	Leave leave;

	public ApproveLeaveView(){}

	public ApproveLeaveView(Project project, Associate associate, Leave leave) {
		super();
		this.project = project;
		this.associate = associate;
		this.leave = leave;
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
	public Leave getLeave() {
		return leave;
	}
	public void setLeave(Leave leave) {
		this.leave = leave;
	}
	
}
