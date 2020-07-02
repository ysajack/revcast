package com.cognizant.revcast.servlets;

import com.cognizant.revcast.clients.AssociateClient;
import com.cognizant.revcast.data.AssociateDAO;
import com.cognizant.revcast.models.Associate;
import com.google.gson.Gson;

//import com.google.appengine.repackaged.com.google.gson.Gson;
//import com.google.gson.Gson;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "AssociateServlet", value = "selectAssociate")
public class AssociateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {	
		RequestDispatcher req = request.getRequestDispatcher("associates/request_leave.jsp");
		try {
			req.forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {	
		RequestDispatcher req = request.getRequestDispatcher("associates/request_leave.jsp");
		try {
			req.forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		}
	}
	
	public static List<Associate> getAllAssociates(){
		Associate[] a = new Gson().fromJson(new AssociateClient().getAllAssociates(), Associate[].class);
		return Arrays.asList(a);
	}
	
	
}
