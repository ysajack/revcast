package com.cognizant.revcast.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cognizant.revcast.clients.ProjectClient;
import com.cognizant.revcast.data.ProjectDAO;
import com.cognizant.revcast.models.Project;
import com.cognizant.revcast.models.ProjectAssociateView;
import com.google.gson.Gson;

@WebServlet(name = "ResourceFilterServlet", value = "/resourceFilter")
public class ResourceFilterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String prjId = request.getParameter("projectId");
		String bio = request.getParameter("bio");
		//ProjectDAO prjdao = new ProjectDAO();
		ProjectClient prjdao = new ProjectClient();
		
		//List<ProjectAssociateView> pavList = new ArrayList<ProjectAssociateView>();
		String pavList = null;
		
		Project prj = null;

		if(prjId == null || prjId.equals("") || prjId.equals("All Projects")) {
			if(!(bio == null || bio.equals("") || bio.equals("All BIOs"))){
				pavList = prjdao.getProjAssocViewByBio(bio);
			}
			else {
				pavList = prjdao.getProjectAssociateView();
			}
		}
		else {
			pavList = prjdao.getProjAssocViewByProjId(prjId);
			prj = prjdao.getProjectById(prjId);
		}
		
		ProjectAssociateView[] pavArr = new Gson().fromJson(pavList, ProjectAssociateView[].class);

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.println("<table id=\"fill-table\">\n" + 
				"		<tr>\n" + 
				"			<th>\n" + 
				"			Associate ID\n" + 
				"			</th>\n" + 
				"			<th>\n" + 
				"			Associate Name\n" + 
				"			</th>\n" + 
				"			<th>\n" + 
				"			Designation\n" + 
				"			</th>\n" + 
				"			<th>\n" + 
				"			Status\n" + 
				"			</th>\n" + 
				"			<th>\n" + 
				"			Rev Cat\n" + 
				"			</th>\n" + 
				"			<th>\n" + 
				"			Practice\n" + 
				"			</th>\n" + 
				"			<th>\n" + 
				"			Onsite/Offshore\n" + 
				"			</th>\n" + 
				"			<th>\n" + 
				"			Rev Type\n" + 
				"			</th>\n" + 
				"			<th>\n" + 
				"			BIO\n" + 
				"			</th>\n" +
				"			<th>\n" + 
				"			Project\n" + 
				"			</th>\n" +
				"			<th>\n" + 
				"			Project Name\n" + 
				"			</th>\n" +
				"	</tr>");
		if(pavArr.length==0) {
			out.println("<tr>");
			out.println("<td>");
			out.println("</td>");
			out.println("<td>");
			out.println("</td>");
			out.println("<td>");
			out.println("</td>");
			out.println("<td>");
			out.println("</td>");
			out.println("<td>");
			out.println("</td>");
			out.println("<td>");
			out.println("</td>");
			out.println("<td>");
			out.println("</td>");
			out.println("<td>");
			out.println("</td>");
			out.println("<td>");
			out.println(prj.getBio());
			out.println("</td>");
			out.println("<td>");
			out.println(prj.getProjectId());
			out.println("</td>");
			out.println("<td>");
			out.println(prj.getProjectName());
			out.println("</td>");
			out.println("</tr>");
		}
		else {
			for (ProjectAssociateView pav : pavArr) {
				out.println("<tr>");
				out.println("<td>");
				out.println(pav.getAssociate().getAssociateId());
				out.println("</td>");
				out.println("<td>");
				out.println(pav.getAssociate().getAssociateName());
				out.println("</td>");
				out.println("<td>");
				out.println(pav.getAssociate().getDesignation());
				out.println("</td>");
				out.println("<td>");
				out.println(pav.getAssociate().getStatus());
				out.println("</td>");
				out.println("<td>");
				out.println(pav.getAssociate().getRevcat());
				out.println("</td>");
				out.println("<td>");
				out.println(pav.getAssociate().getPractice());
				out.println("</td>");
				out.println("<td>");
				out.println(pav.getAssociate().getOnsiteOffshore());
				out.println("</td>");
				out.println("<td>");
				out.println(pav.getAssociate().getRevType());
				out.println("</td>");
				out.println("<td>");
				out.println(pav.getProject().getBio());
				out.println("</td>");
				out.println("<td>");
				out.println(pav.getProject().getProjectId());
				out.println("</td>");
				out.println("<td>");
				out.println(pav.getProject().getProjectName());
				out.println("</td>");
				out.println("</tr>");
			}
		}
		//end of if paList is empty
		
	}

}
