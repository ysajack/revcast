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
import com.cognizant.revcast.models.Project;
import com.cognizant.revcast.models.ProjectAssociateView;

@WebServlet(name = "AdminProjectFilterServlet", value = "admin/projectFilter")
public class AdminProjectFilterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String prjId = request.getParameter("projectId");
		String bio = request.getParameter("bio");
		String associateId = request.getParameter("associateId");
		String associateName = request.getParameter("associateName");
		ProjectDAO prjdao = new ProjectDAO();
		List<ProjectAssociateView> pavList = new ArrayList<ProjectAssociateView>();
		Project prj = null;

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
				prj = prjdao.getProjectById(prjId);
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
		if(pavList.isEmpty()) {
			out.println("<tr>");
			out.println("<td>");
			out.println(prj.getBio());
			out.println("</td>");
			//out.println("<td>");
			out.println("<td><input type=\"text\" name=\"projectId\" value=\""+ prjId +"\" readonly=\"readonly\" /></td>");
			//out.println("</td>");
			out.println("<td>");
			out.println(prj.getProjectName());
			out.println("</td>");
			out.println("<td>");
			out.println(prj.getProjectType());
			out.println("</td>");
			out.println("<td>"+ associateId +"</td>");
			out.println("<td>"+ associateName +"</td>");
			
			out.println("<td><input type=\"text\" name=\"projStart\" required/></td>");
			out.println("<td><input type=\"text\" name=\"projEnd\" required/></td>");
			out.println("<td><input type=\"text\" name=\"allocation\" required/></td>");
			out.println("<td><input type=\"text\" name=\"rateCard\" required/></td>");
			out.println("</tr>");
		}
		else {
			for (ProjectAssociateView pav : pavList) {
				out.println("<tr>");
				out.println("<td>");
				out.println(pav.getProject().getBio());
				out.println("</td>");
				//out.println("<td>");
				out.println("<td><input type=\"text\" name=\"projectId\" value=\""+ pav.getProject().getProjectId() +"\" readonly=\"readonly\" /></td>");
				//out.println(pav.getProject().getProjectId());
				out.println("</td>");
				out.println("<td>");
				out.println(pav.getProject().getProjectName());
				out.println("</td>");
				out.println("<td>");
				out.println(pav.getProject().getProjectType());
				out.println("</td>");
				out.println("<td>"+ associateId +"</td>");
				out.println("<td>"+ associateName +"</td>");
				
				if(pav.getProject().getAssociateId().equals(associateId)) {
					out.println("<td><input type=\"text\" name=\"projStart\" value=\""+ pav.getAssociate().getProjectStart() +"\" required /></td>");
					out.println("<td><input type=\"text\" name=\"projEnd\" value=\""+ pav.getAssociate().getProjectEnd() +"\" required /></td>");
					out.println("<td><input type=\"text\" name=\"allocation\" value=\""+ pav.getAssociate().getAllocation() +"\" required /></td>");
					out.println("<td><input type=\"text\" name=\"rateCard\" value=\""+ pav.getAssociate().getRate() +"\" required /></td>");
				}
				else {
					out.println("<td><input type=\"text\" name=\"projStart\" required/></td>");
					out.println("<td><input type=\"text\" name=\"projEnd\" required/></td>");
					out.println("<td><input type=\"text\" name=\"allocation\" required/></td>");
					out.println("<td><input type=\"text\" name=\"rateCard\" required/></td>");
					out.println("</tr>");
				}
			}
			
		}
		//End else if paList is empty
		
	}

}
