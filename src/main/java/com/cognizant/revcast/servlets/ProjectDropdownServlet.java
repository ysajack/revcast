package com.cognizant.revcast.servlets;

import com.cognizant.revcast.data.ProjectDAO;
import com.cognizant.revcast.models.ProjectBean;
import com.google.gson.Gson;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ProjectDropdownServlet", value = "/projectDropdown")
public class ProjectDropdownServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {	
		ProjectDAO prjdao = new ProjectDAO();
		Gson gs = new Gson();
		List<ProjectBean> prjList = new ArrayList<ProjectBean>();

		String bio = request.getParameter("bio");
	
		try {
			if(bio.equals("All BIOs")) {
				prjList = prjdao.getAllDistinctProjects();
			}
			else {
				prjList = prjdao.getAllProjectsByBio(bio);
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		String str = gs.toJson(prjList);
		
		response.setContentType("text/plain");	
		response.getWriter().println(str);
				
	}

}
