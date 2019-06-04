package com.cognizant.revcast.servlets;

import com.cognizant.revcast.data.ProjectDAO;
import com.cognizant.revcast.models.ProjectAssociateView;
import com.cognizant.revcast.models.ProjectBean;
import com.google.appengine.api.utils.SystemProperty;
//import com.google.appengine.repackaged.com.google.gson.Gson;
import com.google.gson.Gson;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ProjectServlet", value = "/project")
public class ProjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//For smoke
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {	
		Gson gs = new Gson();
		ProjectDAO prjdao = new ProjectDAO();
	
		List<ProjectAssociateView> paList = new ArrayList<ProjectAssociateView>();
		String msg = "";
		try {
			paList = prjdao.getProjectAssociateView();
			

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			msg=e.toString();
		}
		
		//Converting to json
		String str = gs.toJson(paList);
		
		
		Properties properties = System.getProperties();
		response.setContentType("text/plain");
		
		response.getWriter().println("Hello App Engine - Standard using " + SystemProperty.version.get() + " Java "
				+ properties.get("java.specification.version"));
		
		response.getWriter().println("PRJ STR: " + str);
		response.getWriter().println("PRJ MSG: " + msg);
		
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
