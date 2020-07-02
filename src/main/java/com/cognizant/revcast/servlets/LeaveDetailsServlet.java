package com.cognizant.revcast.servlets;

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

import com.cognizant.revcast.clients.LeaveClient;
import com.cognizant.revcast.data.LeaveDAO;
import com.cognizant.revcast.models.Leave;
import com.google.gson.Gson;
//import com.google.appengine.repackaged.com.google.gson.Gson;

@WebServlet(name = "LeaveDetailsServlet", value = "/updateLeave")
public class LeaveDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//LeaveDAO ldao = new LeaveDAO();
		LeaveClient ldao = new LeaveClient();
		
		String lid = request.getParameter("leaveId");
		int id = Integer.valueOf(lid);
		String mo = request.getParameter("month_taken");
		String yr = request.getParameter("year_taken");
		String nod = request.getParameter("num_of_days");
		int numOfDays = Integer.valueOf(nod);
		String dates = request.getParameter("date_taken");
		String leaveStatus = request.getParameter("leave_status");
		String comments = request.getParameter("comments");
		String assoId = request.getParameter("associate_id");
		
		Leave leave = new Leave(id,yr,mo,numOfDays,dates,leaveStatus,comments,assoId);


		if (ldao.updateLeave(leave).equals("Success")) {
			RequestDispatcher req = request.getRequestDispatcher("associates/success.jsp");
			try {
				req.forward(request, response);
			} catch (ServletException e) {
				e.printStackTrace();
			}

		} else {
			RequestDispatcher req = request.getRequestDispatcher("associates/failure.jsp");
			try {
				req.forward(request, response);
			} catch (ServletException e) {
				e.printStackTrace();
			}
		}

	}

	public static String getAllLeaveDetails(String yr,String mo,String assoId){
		return new LeaveClient().getAllLeaveDetails(yr, mo, assoId);
	}
	 
	public static String getLeaveById(String id) {
		return new LeaveClient().getLeaveById(id);
	}

}
