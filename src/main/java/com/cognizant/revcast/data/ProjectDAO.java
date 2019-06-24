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
import com.cognizant.revcast.models.ProjectBean;

public class ProjectDAO {
	public List<Project> getAllProjects() throws ClassNotFoundException, SQLException {
		List<Project> projectList = new ArrayList<Project>();
		
		Connection cnn = DBConnection.getConnection();
		
		PreparedStatement psmt = cnn.prepareStatement("select * from project");
		ResultSet rs = psmt.executeQuery();

		while (rs.next()) {
			String bio = rs.getString("bio");
			String projectId = rs.getString("project_id");
			String projectName = rs.getString("prj_name");
			String projectType = rs.getString("prj_type");
			String associateId = rs.getString("associate_id");

			projectList.add(new Project(bio, projectId, projectName, projectType, associateId));
		}

		cnn.close();
		return projectList;
	}
	
	public Project getProjectById(String id) throws ClassNotFoundException, SQLException {
		Project proj = null;
		
		Connection cnn = DBConnection.getConnection();
		
		PreparedStatement psmt = cnn.prepareStatement("select * from project where project_id=?");
		psmt.setString(1, id);
		ResultSet rs = psmt.executeQuery();

		while (rs.next()) {
			String bio = rs.getString("bio");
			String projectId = rs.getString("project_id");
			String projectName = rs.getString("prj_name");
			String projectType = rs.getString("prj_type");
			String associateId = rs.getString("associate_id");

			proj = new Project(bio, projectId, projectName, projectType, associateId);
		}

		cnn.close();
		return proj;
	}
	
	public List<String> getAllDistinctBios() throws ClassNotFoundException, SQLException {
		List<String> bioList = new ArrayList<String>();
		
		Connection cnn = DBConnection.getConnection();
		
		PreparedStatement psmt = cnn.prepareStatement("select distinct bio from project");
		ResultSet rs = psmt.executeQuery();

		while (rs.next()) {
			String bio = rs.getString("bio");

			bioList.add(bio);
		}

		cnn.close();
		return bioList;
	}
	
	public List<ProjectBean> getAllDistinctProjects() throws ClassNotFoundException, SQLException {
		List<ProjectBean> prjList = new ArrayList<ProjectBean>();
		
		Connection cnn = DBConnection.getConnection();
		
		PreparedStatement psmt = cnn.prepareStatement("select * from project where project_id in (select distinct project_id from project)");
		ResultSet rs = psmt.executeQuery();

		while (rs.next()) {
			String bio = rs.getString("bio");
			String prj = rs.getString("prj_name");
			String prjId = rs.getString("project_id");
			prjList.add(new ProjectBean(bio,prjId,prj));
		}

		cnn.close();
		return prjList;
	}

	public List<ProjectBean> getAllProjectsByBio(String bio) throws ClassNotFoundException, SQLException {
		List<ProjectBean> prjList = new ArrayList<ProjectBean>();
		
		Connection cnn = DBConnection.getConnection();
		
		PreparedStatement psmt = cnn.prepareStatement("select * from project where project_id in (select distinct project_id from project) and bio=?");
		psmt.setString(1, bio);
		ResultSet rs = psmt.executeQuery();

		while (rs.next()) {
			String prj = rs.getString("prj_name");
			String prjId = rs.getString("project_id");
			prjList.add(new ProjectBean(bio,prjId,prj));
		}

		cnn.close();
		return prjList;
	}

	public List<Associate> getAllAssociates() throws ClassNotFoundException, SQLException {
		List<Associate> associateList = new ArrayList<Associate>();

		Connection cnn = DBConnection.getConnection();
		
		PreparedStatement psmt = cnn.prepareStatement("select * from associate");
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
		
		PreparedStatement psmt = cnn.prepareStatement("select * from project p, associate a where p.project_id=a.project_id and p.associate_id=a.associate_id order by prj_name asc");
		
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
	
	public List<ProjectAssociateView> getProjectAssociateViewByProjectId(String prjId) throws ClassNotFoundException, SQLException {
		List<ProjectAssociateView> paList = new ArrayList<ProjectAssociateView>();

		Connection cnn = DBConnection.getConnection();
		
		PreparedStatement psmt = cnn.prepareStatement("select * from project p, associate a where p.project_id=a.project_id and p.associate_id=a.associate_id and p.project_id=?");
		//PreparedStatement psmt = cnn.prepareStatement("select * from project p, associate where p.project_id=?");
		
		psmt.setString(1, prjId);
		ResultSet rs = psmt.executeQuery();

		while (rs.next()) {
			String bio = rs.getString("bio");
			//String projectId = rs.getString("p.project_id");
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
		
			Project prj = new Project(bio, prjId, projectName, projectType, associateId);
			Associate associate = new Associate(associateId, associateName, designation, status, revcat, practice,
					onsiteOffshore, revType, projectStart, projectEnd, allocation, rate, prjId);
			
			paList.add(new ProjectAssociateView(prj,associate));
		}

		cnn.close();
		return paList;
	}
	
	public List<ProjectAssociateView> getProjectAssociateViewByAssociateId(String assoId) throws ClassNotFoundException, SQLException {
		List<ProjectAssociateView> paList = new ArrayList<ProjectAssociateView>();

		Connection cnn = DBConnection.getConnection();
		
		PreparedStatement psmt = cnn.prepareStatement("select * from project p, associate a where p.project_id=a.project_id and p.associate_id=a.associate_id and p.associate_id=?");
		psmt.setString(1, assoId);
		ResultSet rs = psmt.executeQuery();

		while (rs.next()) {
			String bio = rs.getString("bio");
			String projectId = rs.getString("p.project_id");
			String projectName = rs.getString("prj_name");
			String projectType = rs.getString("prj_type");
			
			//String associateId = rs.getString("p.associate_id");
			
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
		
			Project prj = new Project(bio, projectId, projectName, projectType, assoId);
			Associate associate = new Associate(assoId, associateName, designation, status, revcat, practice,
					onsiteOffshore, revType, projectStart, projectEnd, allocation, rate, projectId);
			
			paList.add(new ProjectAssociateView(prj,associate));
		}

		cnn.close();
		return paList;
	}

	public List<ProjectAssociateView> getProjectAssociateViewByBio(String bio) throws ClassNotFoundException, SQLException {
		List<ProjectAssociateView> paList = new ArrayList<ProjectAssociateView>();

		Connection cnn = DBConnection.getConnection();
		
		PreparedStatement psmt = cnn.prepareStatement("select * from project p, associate a where p.project_id=a.project_id and p.associate_id=a.associate_id and p.bio=?");
		//PreparedStatement psmt = cnn.prepareStatement("select * from project p, associate where p.bio=?");
		
		psmt.setString(1, bio);
		ResultSet rs = psmt.executeQuery();

		while (rs.next()) {
			//String bio = rs.getString("bio");
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
	
	public List<ProjectBean> getAllProjectBeans() throws ClassNotFoundException, SQLException {
		List<ProjectBean> projectList = new ArrayList<ProjectBean>();
		
		Connection cnn = DBConnection.getConnection();
		
		PreparedStatement psmt = cnn.prepareStatement("select * from project");
		ResultSet rs = psmt.executeQuery();

		while (rs.next()) {
			String bio = rs.getString("bio");
			String projectId = rs.getString("project_id");
			String projectName = rs.getString("prj_name");

			projectList.add(new ProjectBean(bio, projectId, projectName));
		}

		cnn.close();
		return projectList;
	}
	
	public ProjectBean getProjectBeanById(String id) throws ClassNotFoundException, SQLException {
		ProjectBean proj = null;
		
		Connection cnn = DBConnection.getConnection();
		
		PreparedStatement psmt = cnn.prepareStatement("select * from project where project_id=?");
		psmt.setString(1, id);
		ResultSet rs = psmt.executeQuery();

		while (rs.next()) {
			String bio = rs.getString("bio");
			String projectId = rs.getString("project_id");
			String projectName = rs.getString("prj_name");

			proj = new ProjectBean(bio, projectId, projectName);
		}

		cnn.close();
		return proj;
	}
	
	//add project and allocation
	public String addProject(Project project,String assoId) {
		Connection cnn = null;
		PreparedStatement psmt = null;
		String response = "";
		
		try {
			cnn = DBConnection.getConnection();
			String sql = "insert into project (bio, project_id, prj_name, prj_type,associate_id) "
					+ "values(?,?,?,?,?)";
			
			psmt = cnn.prepareStatement(sql);
			
			psmt.setString(1, project.getBio());
			psmt.setString(2, project.getProjectId());
			psmt.setString(3, project.getProjectName());
			psmt.setString(4, project.getProjectType());
			psmt.setString(5, assoId);
			
			psmt.executeUpdate();
			response = "Success";
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		finally {

			if (psmt != null) {
				try {
					psmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			if (cnn != null) {
				try {
					cnn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		}
	
		return response;
	}
	
	public boolean isProjectMappedToAssociate(String associateId, String projectId)
			throws ClassNotFoundException, SQLException {
		Connection cnn = DBConnection.getConnection();
		
		boolean isMapped = false;

		PreparedStatement psmt = cnn.prepareStatement("select * from project where associate_id=? and project_id=?");
		psmt.setString(1, associateId);
		psmt.setString(2, projectId);
		ResultSet rs = psmt.executeQuery();

		if (rs.next()) {
			//return true;
			isMapped = true;
		} 
	
		cnn.close();
		return isMapped;
	}
	
	public boolean isProjectLeftUnmapped(String projectId)
			throws ClassNotFoundException, SQLException {
		Connection cnn = DBConnection.getConnection();

		PreparedStatement psmt = cnn.prepareStatement("select * from project where project_id=? and associate_id is NULL");
		psmt.setString(1, projectId);
		ResultSet rs = psmt.executeQuery();

		boolean isLeftUnMapped = false;
		
		if (rs.next()) {
			//return true;
			isLeftUnMapped = true;
		} 
		cnn.close();
		return isLeftUnMapped;
	}
	
	public String updateProjectAssociateAllocation(String assoId, String projId) {
		Connection cnn = null;
		PreparedStatement psmt = null;
		String response = "";

		try {

			cnn = DBConnection.getConnection();

			psmt = cnn.prepareStatement("update project set associate_id=? where project_id=?");
			psmt.setString(1, assoId);
			psmt.setString(2, projId);
			psmt.executeUpdate();
			response = "Success";

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {

			if (psmt != null) {
				try {
					psmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			if (cnn != null) {
				try {
					cnn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		return response;
	}


}
