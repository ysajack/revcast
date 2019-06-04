package com.cognizant.revcast.servlets;

import com.cognizant.revcast.data.LeaveDAO;
import com.cognizant.revcast.models.Leave;
import com.cognizant.revcast.models.LeavePlanView;
//import com.google.appengine.repackaged.com.google.gson.Gson;
import com.google.gson.Gson;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "LeavePlanServlet", value = "/leaveRequest")
public class LeavePlanServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		LeaveDAO ldao = new LeaveDAO();
		
	//	String year = request.getParameter("year_taken");
	//	String month = request.getParameter("month_taken");
		int numOfdays = Integer.parseInt(request.getParameter("num_of_days"));
		String comments = request.getParameter("comments");
		//String associate_id = request.getParameter("associate_id");
		String associate_id = "A12345";
		String date_taken=request.getParameter("date_taken_1");
		String[] arr = date_taken.split("-");
		String year = arr[0];
		String month = getMonth().get(arr[1]);
		String date2="";
		String date3="";
		try {
			date2= request.getParameter("date_taken_2");
			date3=request.getParameter("date_taken_3");
		}
		catch(Exception e) {
		}
		
		if(!date2.equals("")) {
			date_taken += ", " + date2;
		}
		if(!date3.equals("")) {
			date_taken += "," + date3;
		}
		
		Leave leave = new Leave(0,year,month,numOfdays,date_taken,null,comments,associate_id);
		
		if(ldao.insertLeaveRequest(leave) == "Success") {
			RequestDispatcher req = request.getRequestDispatcher("associates/success.jsp");
			try {
				req.forward(request, response);
			} catch (ServletException e) {
				e.printStackTrace();
			}
		}
		else {
			RequestDispatcher req = request.getRequestDispatcher("associates/failure.jsp");
			try {
				req.forward(request, response);
			} catch (ServletException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static String getLeavePlanView() {
		Gson gs = new Gson();
		LeaveDAO ldao = new LeaveDAO();
		LeavePlanView lpv = new LeavePlanView();
		
		try {
			lpv = (LeavePlanView) ldao.getLeavePlanViewByAssociate("A12345");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		String str = gs.toJson(lpv);
		return str;
	}
	
	public static String getLeavePlanViewOfAllAssociates() {
		Gson gs = new Gson();
		LeaveDAO ldao = new LeaveDAO();
		List<LeavePlanView> lpvList = new ArrayList<LeavePlanView>();
		
		lpvList = ldao.getLeavePlanViewOfAllAssociates();
		
		String str = gs.toJson(lpvList);
		return str;
	}
	
	public static String getCurrentYear() {
		LeaveDAO ldao = new LeaveDAO();
		String year = null;
		try {
			year = ldao.getCurrentYear();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return year;
	}
	
	public HashMap<String,String> getMonth() {
		HashMap<String,String> hm = new HashMap<String,String>();
		
		hm.put("01", "January");
		hm.put("02", "February");
		hm.put("03", "March");
		hm.put("04", "April");
		hm.put("05", "May");
		hm.put("06", "June");
		hm.put("07", "July");
		hm.put("08", "August");
		hm.put("09", "September");
		hm.put("10", "October");
		hm.put("11", "November");
		hm.put("12", "December");
		
		return hm;
	}
	
}
