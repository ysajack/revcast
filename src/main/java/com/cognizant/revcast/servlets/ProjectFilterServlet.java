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

import com.cognizant.revcast.data.ProjectDAO;
import com.cognizant.revcast.models.ProjectAssociateView;

@WebServlet(name = "ProjectFilterServlet", value = "/projectFilter")
public class ProjectFilterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String prjId = request.getParameter("projectId");
		String bio = request.getParameter("bio");
		ProjectDAO prjdao = new ProjectDAO();
		List<ProjectAssociateView> pavList = new ArrayList<ProjectAssociateView>();

		try {
			if(prjId == null || prjId.equals("") || prjId.equals("All Projects")) {
				if(!(bio == null || bio.equals("") || bio.equals("All BIOs"))){
					pavList = prjdao.getProjectAssociateViewByBio(bio);
				}
				else {
					pavList = prjdao.getProjectAssociateView();
				}
			}
			else {
				pavList = prjdao.getProjectAssociateViewByProjectId(prjId);
			}
		
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.println("<table id=\"fill-table\">\n" + 
				"		<tr>\n" + 
				"			<th>\n" + 
				"			BIO\n" + 
				"			</th>\n" + 
				"			<th>\n" + 
				"			Project\n" + 
				"			</th>\n" + 
				"			<th>\n" + 
				"			Project Name\n" + 
				"			</th>\n" + 
				"			<th>\n" + 
				"			Type\n" + 
				"			</th>\n" + 
				"			<th>\n" + 
				"			Associate ID\n" + 
				"			</th>\n" + 
				"			<th>\n" + 
				"			Associate Name\n" + 
				"			</th>\n" + 
				"			<th>\n" + 
				"			Start\n" + 
				"			</th>\n" + 
				"			<th>\n" + 
				"			Project End Date\n" + 
				"			</th>\n" + 
				"			<th>\n" + 
				"			Allocation\n" + 
				"			</th>\n" + 
				"			<th>\n" + 
				"			Rate Card\n" + 
				"			</th>\n" + 
				"	</tr>");
		
		for (ProjectAssociateView pav : pavList) {
			out.println("<tr>");
			out.println("<td>");
			out.println(pav.getProject().getBio());
			out.println("</td>");
			out.println("<td>");
			out.println(pav.getProject().getProjectId());
			out.println("</td>");
			out.println("<td>");
			out.println(pav.getProject().getProjectName());
			out.println("</td>");
			out.println("<td>");
			out.println(pav.getProject().getProjectType());
			out.println("</td>");
			out.println("<td>");
			out.println(pav.getProject().getProjectId());
			out.println("</td>");
			out.println("<td>");
			out.println(pav.getAssociate().getAssociateName());
			out.println("</td>");
			out.println("<td>");
			out.println(pav.getAssociate().getProjectStart());
			out.println("</td>");
			out.println("<td>");
			out.println(pav.getAssociate().getProjectEnd());
			out.println("</td>");
			out.println("<td>");
			out.println(pav.getAssociate().getAllocation());
			out.println("</td>");
			out.println("<td>");
			out.println(pav.getAssociate().getRate());
			out.println("</td>");
			out.println("</tr>");
		}

	}

}
