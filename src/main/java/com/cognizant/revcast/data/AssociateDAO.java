package com.cognizant.revcast.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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

			associate = new Associate(associateId, associateName, designation, status, revcat, practice,
					onsiteOffshore, revType, projectStart, projectEnd, allocation, rate, projectId);
		}

		cnn.close();
		return associate;
	}
	
}
