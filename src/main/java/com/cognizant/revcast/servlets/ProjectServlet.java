package com.cognizant.revcast.servlets;

import com.cognizant.revcast.data.ProjectDAO;
import com.cognizant.revcast.models.ProjectAssociateView;
import com.google.appengine.api.utils.SystemProperty;
import com.google.appengine.repackaged.com.google.gson.Gson;

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
		Properties properties = System.getProperties();
		response.setContentType("text/plain");
		response.getWriter().println("Hello App Engine - Standard using " + SystemProperty.version.get() + " Java "
				+ properties.get("java.specification.version"));
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
	
}
