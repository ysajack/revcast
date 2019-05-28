package com.cognizant.revcast.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cognizant.revcast.models.Associate;
import com.cognizant.revcast.models.Project;
import com.cognizant.revcast.models.ProjectAssociateView;

public class ProjectDAO {
	public List<Project> getAllProjects() throws ClassNotFoundException, SQLException {
		List<Project> projectList = new ArrayList<Project>();

		Connection cnn = DBConnection.getConnection();
		PreparedStatement psmt = cnn.prepareStatement(
				"select * from project");
		ResultSet rs = psmt.executeQuery();

		while (rs.next()) {
			String bio = rs.getString("bio");
			String projectId = rs.getString("p.project_id");
			String projectName = rs.getString("prj_name");
			String projectType = rs.getString("prj_type");
			String associateId = rs.getString("p.associate_id");

			projectList.add(new Project(bio, projectId, projectName, projectType, associateId));
		}

		cnn.close();
		return projectList;
	}

	public List<Associate> getAllAssociates() throws ClassNotFoundException, SQLException {
		List<Associate> associateList = new ArrayList<Associate>();

		Connection cnn = DBConnection.getConnection();
		PreparedStatement psmt = cnn.prepareStatement(
				"select * from associate");
		ResultSet rs = psmt.executeQuery();

		while (rs.next()) {
			String associateId = rs.getString("associate_id");
			String associateName = rs.getString("associate_name");
			String designation = rs.getString("designation");
			String status = rs.getString("status");
			String revcat = rs.getString("rev_type");
			String practice = rs.getString("practice");
			String onsiteOffshore = rs.getString("onsite_offshore");
			String revType = rs.getString("rev_type");
			String projectStart = rs.getString("prj_start");
			String projectEnd = rs.getString("prj_end");
			int allocation = rs.getInt("allocation");
			int rate = rs.getInt("rate");
			String projectId = rs.getString("project_id");

			associateList.add(new Associate(associateId, associateName, designation, status, revcat, practice,
					onsiteOffshore, revType, projectStart, projectEnd, allocation, rate, projectId));
		}

		cnn.close();
		return associateList;
	}
	
	public List<ProjectAssociateView> getProjectAssociateView() throws ClassNotFoundException, SQLException {
		List<ProjectAssociateView> paList = new ArrayList<ProjectAssociateView>();

		Connection cnn = DBConnection.getConnection();
		PreparedStatement psmt = cnn.prepareStatement(
				"select * from project p, associate a where p.project_id=a.project_id and p.associate_id=a.associate_id");
		ResultSet rs = psmt.executeQuery();

		while (rs.next()) {
			String bio = rs.getString("bio");
			String projectId = rs.getString("p.project_id");
			String projectName = rs.getString("prj_name");
			String projectType = rs.getString("prj_type");
			
			String associateId = rs.getString("p.associate_id");
			
			String associateName = rs.getString("associate_name");
			String designation = rs.getString("designation");
			String status = rs.getString("status");
			String revcat = rs.getString("rev_type");
			String practice = rs.getString("practice");
			String onsiteOffshore = rs.getString("onsite_offshore");
			String revType = rs.getString("rev_type");
			String projectStart = rs.getString("prj_start");
			String projectEnd = rs.getString("prj_end");
			int allocation = rs.getInt("allocation");
			int rate = rs.getInt("rate");
		
			Project prj = new Project(bio, projectId, projectName, projectType, associateId);
			Associate associate = new Associate(associateId, associateName, designation, status, revcat, practice,
					onsiteOffshore, revType, projectStart, projectEnd, allocation, rate, projectId);
			
			paList.add(new ProjectAssociateView(prj,associate));
		}

		cnn.close();
		return paList;
		
	}

}
