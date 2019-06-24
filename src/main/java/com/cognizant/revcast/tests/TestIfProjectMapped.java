package com.cognizant.revcast.tests;

import java.sql.SQLException;

import com.cognizant.revcast.data.ProjectDAO;

public class TestIfProjectMapped {

	public static void main(String[] args) {
		ProjectDAO pdao = new ProjectDAO();
		
		try {
		//	System.out.println(pdao.isProjectMappedToAssociate("A54321", "P1234570"));
			System.out.println(pdao.isProjectLeftUnmapped("P1234570"));

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
