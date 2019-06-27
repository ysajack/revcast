package com.cognizant.revcast.servlets;

import com.cognizant.revcast.data.LeaveDAO;
//import com.google.appengine.repackaged.com.google.gson.Gson;
//import com.google.gson.Gson;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "AdminApproveLeaveServlet", value = "/approveLeave")
public class AdminApproveLeaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		LeaveDAO ldao = new LeaveDAO();
		
		String leaveId = request.getParameter("leaveId");
	
		if(ldao.approveLeave(leaveId) == "Success") {
			RequestDispatcher req = request.getRequestDispatcher("admin/approve_success.jsp");
			try {
				req.forward(request, response);
			} catch (ServletException e) {
				e.printStackTrace();
			}
		}
		else {
			RequestDispatcher req = request.getRequestDispatcher("admin/approve_failure.jsp");
			try {
				req.forward(request, response);
			} catch (ServletException e) {
				e.printStackTrace();
			}
		}
	}
	
}
