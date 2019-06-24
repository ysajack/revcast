package com.cognizant.revcast.servlets;

import com.cognizant.revcast.data.AssociateDAO;
import com.cognizant.revcast.data.ProjectDAO;
import com.cognizant.revcast.models.AllocationBean;
import com.cognizant.revcast.models.Associate;
//import com.google.appengine.repackaged.com.google.gson.Gson;
//import com.google.gson.Gson;
import com.cognizant.revcast.models.Project;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "AdminUpdateAllocationServlet", value = "/updateAllocation")
public class AdminUpdateAllocationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		AssociateDAO adao = new AssociateDAO();
		ProjectDAO pdao = new ProjectDAO();
		
	 	String associateId = request.getParameter("associateId");
		String associateName = request.getParameter("associateName");
		String designation = request.getParameter("designation");
		String status = request.getParameter("status");
		String revCat = request.getParameter("revCat");
		String practice = request.getParameter("practice");
		String onsiteOffshore = request.getParameter("onsiteOffshore");
		String revType = request.getParameter("revType");
		String projectStart = request.getParameter("projStart");
		String projectEnd = request.getParameter("projEnd");
		String allocation = request.getParameter("allocation");
		String rate = request.getParameter("rateCard");
		String projectId = request.getParameter("projectId");
		
		String assoProcRes = "";
		String projProcRes = "";
		
		Associate associate = new Associate(associateId,associateName,designation,status,revCat,practice,onsiteOffshore,revType,
				projectStart,projectEnd,Integer.parseInt(allocation),Integer.parseInt(rate),projectId);
		
		try {
			AllocationBean al = new AllocationBean(associateId,projectId,projectStart,
					projectEnd,Integer.parseInt(allocation),Integer.parseInt(rate));
			
			//Processing Associate
			if(adao.isAssociateExistingInProject(associateId, projectId)) {
				assoProcRes = adao.updateAssociateAllocation(al);
			}
			else {
				assoProcRes = adao.addAssociate(associate); //Add a new record
			}
			
			//Processing Project
			if(!pdao.isProjectMappedToAssociate(associateId, projectId)) { //expecting false then negate it
				if(pdao.isProjectLeftUnmapped(projectId)) {
					//If there's a null value (left unmapped), then just use the record and update with the mapping
					projProcRes = pdao.updateProjectAssociateAllocation(associateId,projectId);
				}
				else {
					Project project = pdao.getProjectById(projectId); 
					//If there's a new record needed, then just add it
					projProcRes = pdao.addProject(project,associateId); //add project and allocation, which means adding a new allocation
				}
			}
			else {
				projProcRes = "Success"; //If mapping and allocation exists, do nothing
			}
		} catch (ClassNotFoundException | SQLException e1) {
			e1.printStackTrace();
		}
		
		if(assoProcRes.equals("Success") && projProcRes.equals("Success")) {
			RequestDispatcher req = request.getRequestDispatcher("admin/allocate_success.jsp");
			try {
				req.forward(request, response);
			} catch (ServletException e) {
				e.printStackTrace();
			}
		}
		else {
			RequestDispatcher req = request.getRequestDispatcher("admin/allocate_failure.jsp");
			try {
				req.forward(request, response);
			} catch (ServletException e) {
				e.printStackTrace();
			}
		}
	}
	
}
