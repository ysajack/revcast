package com.cognizant.revcast.tests;

import com.cognizant.revcast.data.ProjectDAO;
import com.cognizant.revcast.models.Project;

public class TestAddProject {

	public static void main(String[] args) {
		ProjectDAO pdao = new ProjectDAO();
		
		Project prj = new Project("Digital","P1234570","Global Share","BTM","A12347");
		System.out.println("Add Project: " + pdao.addProject(prj,"A12347"));

	}

}
