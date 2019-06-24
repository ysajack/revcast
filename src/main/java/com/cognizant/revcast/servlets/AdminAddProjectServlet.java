package com.cognizant.revcast.servlets;

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
		ProjectDAO pdao = new ProjectDAO();

		String bio = request.getParameter("bio");
		String projectId = request.getParameter("projectId");
		String projectName = request.getParameter("projectName");
		String type = request.getParameter("type");
		//String associateId = request.getParameter("associateId");

		Project project = new Project(bio,projectId,projectName,type,null);
		
		if(pdao.addProject(project,null) == "Success") {
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
		Gson gs = new Gson();
		ProjectDAO prjdao = new ProjectDAO();
		List<ProjectAssociateView> paList = new ArrayList<ProjectAssociateView>();

		try {
			paList = prjdao.getProjectAssociateView();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		//Converting to json
		String str = gs.toJson(paList);
		return str;
		//To convert from json to Project object
				// Project pr = new Gson().fromJson(str, Project.class);
				// System.out.println(pr);
	}
	
	public static String getProjectAssociateViewByProjectId(String prjId) {
		Gson gs = new Gson();
		ProjectDAO prjdao = new ProjectDAO();
		List<ProjectAssociateView> paList = new ArrayList<ProjectAssociateView>();

		try {
			if(prjId == null || prjId.equals("")) {
				paList = prjdao.getProjectAssociateView();
			}
			else {
				paList = prjdao.getProjectAssociateViewByProjectId(prjId);
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		//Converting to json
		String str = gs.toJson(paList);
		return str;
	}
	
	public static String getAllDistinctProjects() {
		Gson gs = new Gson();
		ProjectDAO prjdao = new ProjectDAO();
		List<ProjectBean> pjList = new ArrayList<ProjectBean>();

		try {
			pjList = prjdao.getAllDistinctProjects();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		//Converting to json
		String str = gs.toJson(pjList);
		return str;
	}
	
	public static String getAllProjectsByBio(String bio) {
		Gson gs = new Gson();
		ProjectDAO prjdao = new ProjectDAO();
		List<ProjectBean> pjList = new ArrayList<ProjectBean>();

		try {
			pjList = prjdao.getAllProjectsByBio(bio);

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		//Converting to json
		String str = gs.toJson(pjList);
		return str;
	}
	
	public static String getAllDistinctBios() {
		Gson gs = new Gson();
		ProjectDAO prjdao = new ProjectDAO();
		List<String> bioList = new ArrayList<String>();

		try {
			bioList = prjdao.getAllDistinctBios();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		//Converting to json
		String str = gs.toJson(bioList);
		return str;
	}
	
}
