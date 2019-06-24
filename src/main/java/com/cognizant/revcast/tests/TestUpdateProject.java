package com.cognizant.revcast.tests;

import com.cognizant.revcast.data.ProjectDAO;

public class TestUpdateProject {

	public static void main(String[] args) {
		ProjectDAO pdao = new ProjectDAO();
		
		System.out.println(pdao.updateProjectAssociateAllocation("A54321", "P1234570"));

	}

}
