package com.cognizant.revcast.servlets;

import com.cognizant.revcast.clients.AssociateClient;
import com.cognizant.revcast.clients.ProjectClient;
import com.cognizant.revcast.data.AssociateDAO;
import com.cognizant.revcast.data.ForecastDAO;
import com.cognizant.revcast.data.ProjectDAO;
import com.cognizant.revcast.models.Associate;
import com.cognizant.revcast.models.ForecastView;
import com.cognizant.revcast.models.ProjectAssociateView;
import com.google.gson.Gson;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "ForecastServlet", value = "/forecast")
public class ForecastServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {		
		response.setContentType("text/plain");	
		
		if(getForecastOfAllAssociates() != null) {
			response.getWriter().println("Success");
		}	
	}

	public static String getProjectAssociateView() {
		return new ProjectClient().getProjectAssociateView();
	}

	public static String getForecastOfAllAssociates() {
		//AssociateDAO adao = new AssociateDAO();
		ForecastDAO fdao = new ForecastDAO();
		AssociateClient adao = new AssociateClient();
		
		
		Gson gs = new Gson();
		List<ForecastView> fcvList = new ArrayList<ForecastView>();
		
		Associate[] assoList = new Gson().fromJson(adao.getAllAssociates(),Associate[].class);
		
		for(Associate asso : assoList) {
			ForecastView lpv = fdao.getForecastByAssociate(asso.getAssociateId());
			fcvList.add(lpv);
		}
		
		String str = gs.toJson(fcvList);
		return str;
	}
	
	public static String getForecastByAssociate(String assoId) {
		Gson gs = new Gson();
		ForecastDAO fdao = new ForecastDAO();
		
		ForecastView fc = fdao.getForecastByAssociate(assoId);
		String str = gs.toJson(fc);
		return str;
	}

}
