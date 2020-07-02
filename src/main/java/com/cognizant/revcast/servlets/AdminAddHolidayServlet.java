package com.cognizant.revcast.servlets;

import com.cognizant.revcast.clients.HolidayClient;
import com.cognizant.revcast.data.HolidayDAO;
import com.cognizant.revcast.models.Holiday;
//import com.google.appengine.repackaged.com.google.gson.Gson;
//import com.google.gson.Gson;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "AdminAddHolidayServlet", value = "/addHoliday")
public class AdminAddHolidayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//HolidayDAO hdao = new HolidayDAO();
		HolidayClient hdao = new HolidayClient();

		String holYear = request.getParameter("year");
		String holMonth = request.getParameter("month");
		String numOfHol = request.getParameter("num_of_days");
		
		String holDate = request.getParameter("date_taken_1");
		String date2="";
		String date3="";
		try {
			date2= request.getParameter("date_taken_2");
			date3=request.getParameter("date_taken_3");
		}
		catch(Exception e) {
		}
		if(!date2.equals("")) {
			holDate += ", " + date2;
		}
		if(!date3.equals("")) {
			holDate += "," + date3;
		}
		String onsiteOffshore = request.getParameter("onsite_offshore");
		String comments = request.getParameter("comments");

		Holiday holiday = new Holiday(holYear,holMonth,Integer.parseInt(numOfHol),holDate,onsiteOffshore,comments);
		
		if(hdao.addHoliday(holiday).equals("Success")) {
			RequestDispatcher req = request.getRequestDispatcher("admin/holiday_success.jsp");
			try {
				req.forward(request, response);
			} catch (ServletException e) {
				e.printStackTrace();
			}
		}
		else {
			RequestDispatcher req = request.getRequestDispatcher("admin/holiday_failure.jsp");
			try {
				req.forward(request, response);
			} catch (ServletException e) {
				e.printStackTrace();
			}
		}
	}
	
}
