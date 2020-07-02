package com.cognizant.revcast.servlets;

import com.cognizant.revcast.clients.ProjectClient;
import com.cognizant.revcast.data.ProjectDAO;
import com.cognizant.revcast.models.Project;
import com.cognizant.revcast.models.ProjectAssociateView;
import com.cognizant.revcast.models.ProjectBean;
//import com.google.appengine.repackaged.com.google.gson.Gson;
import com.google.gson.Gson;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "AdminAddProjectServlet", value = "/addProject")
public class AdminAddProjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
	//	ProjectDAO pdao = new ProjectDAO();

		String bio = request.getParameter("bio");
		String projectId = request.getParameter("projectId");
		String projectName = request.getParameter("projectName");
		String type = request.getParameter("type");
		//String associateId = request.getParameter("associateId");

		Project project = new Project(bio,projectId,projectName,type,null);
		
		if(new ProjectClient().addProject(project,null).equals("Success")) {
			RequestDispatcher req = request.getRequestDispatcher("admin/success.jsp");
			try {
				req.forward(request, response);
			} catch (ServletException e) {
				e.printStackTrace();
			}
		}
		else {
			RequestDispatcher req = request.getRequestDispatcher("admin/failure.jsp");
			try {
				req.forward(request, response);
			} catch (ServletException e) {
				e.printStackTrace();
			}
		}
	}

	public static String getProjectAssociateView() {
		return new ProjectClient().getProjectAssociateView();
	}
	
	public static String getProjectAssociateViewByProjectId(String prjId) {
		return new ProjectClient().getProjectAssociateView();
	}
	
	public static String getAllDistinctProjects() {
		return new ProjectClient().getAllDistinctProjects();
	}
	
	public static String getAllProjectsByBio(String bio) {
		return new ProjectClient().getAllProjectsByBio(bio);
	}
	
	public static String getAllDistinctBios() {
		return new ProjectClient().getAllDistinctBios();
	}
	
}
