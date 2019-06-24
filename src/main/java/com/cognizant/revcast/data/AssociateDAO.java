package com.cognizant.revcast.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cognizant.revcast.models.AllocationBean;
import com.cognizant.revcast.models.Associate;

public class AssociateDAO {
	public Associate getAssociateById(String assoId) throws ClassNotFoundException, SQLException {
		Associate associate = null;

		Connection cnn = DBConnection.getConnection();

		PreparedStatement psmt = cnn.prepareStatement("select * from associate where associate_id=?");
		psmt.setString(1, assoId);
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

			associate = new Associate(associateId, associateName, designation, status, revcat, practice, onsiteOffshore,
					revType, projectStart, projectEnd, allocation, rate, projectId);
		}

		cnn.close();
		return associate;
	}

	public List<Associate> getAllAssociates() throws ClassNotFoundException, SQLException {
		List<Associate> assoList = new ArrayList<Associate>();

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

			Associate associate = new Associate(associateId, associateName, designation, status, revcat, practice,
					onsiteOffshore, revType, projectStart, projectEnd, allocation, rate, projectId);
			assoList.add(associate);
		}

		cnn.close();
		return assoList;
	}

	public String addAssociate(Associate associate) {
		Connection cnn = null;
		PreparedStatement psmt = null;
		String response = "";

		try {
			cnn = DBConnection.getConnection();
			String sql = "insert into associate (associate_id,associate_name,designation,status,rev_cat,practice,onsite_offshore,"
					+ "rev_type,prj_start,prj_end,allocation,rate,project_id) " + "values(?,?,?,?,?,?,?,?,?,?,?,?,?)";

			psmt = cnn.prepareStatement(sql);

			psmt.setString(1, associate.getAssociateId());
			psmt.setString(2, associate.getAssociateName());
			psmt.setString(3, associate.getDesignation());
			psmt.setString(4, associate.getStatus());
			psmt.setString(5, associate.getRevcat());
			psmt.setString(6, associate.getPractice());
			psmt.setString(7, associate.getOnsiteOffshore());
			psmt.setString(8, associate.getRevType());
			psmt.setString(9, associate.getProjectStart());
			psmt.setString(10, associate.getProjectEnd());
			psmt.setInt(11, associate.getAllocation());
			psmt.setInt(12, associate.getRate());
			psmt.setString(13, associate.getProjectId());

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

	public boolean isAssociateExistingInProject(String associateId, String projectId) throws ClassNotFoundException, SQLException {
		Connection cnn = DBConnection.getConnection();

		PreparedStatement psmt = cnn.prepareStatement("select * from associate where associate_id=? and project_id=?");
		psmt.setString(1, associateId);
		psmt.setString(2, projectId);
		ResultSet rs = psmt.executeQuery();
		
		boolean isExisting = false;

		if (rs.next()) {
			isExisting = true;
		} 

		cnn.close();
		return isExisting;
	}

	public String updateAssociateAllocation(AllocationBean allocation) {
		Connection cnn = null;
		PreparedStatement psmt = null;
		String response = "";

		try {

			cnn = DBConnection.getConnection();

			psmt = cnn.prepareStatement("update associate set prj_start=?, prj_end=?, allocation=?,rate=? "
					+ "where associate_id=? and project_id=?");
			psmt.setString(1, allocation.getProjectStart());
			psmt.setString(2, allocation.getProjectEnd());
			psmt.setInt(3, allocation.getAllocation());
			psmt.setInt(4, allocation.getRate());
			psmt.setString(5, allocation.getAssociateId());
			psmt.setString(6, allocation.getProjectId());
			psmt.executeUpdate();
			response= "Success";

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
