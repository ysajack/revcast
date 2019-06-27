package com.cognizant.revcast.tests;

import java.util.Calendar;
import java.util.Map;

import com.cognizant.revcast.servlets.UtilityServlet;

public class Test3 {

	public static void main(String[] args) {
		//String thisYear = new SimpleDateFormat("yyyy").format(new Date());
		String year = String.valueOf(Calendar.getInstance().get(Calendar.YEAR));
		
		System.out.println(year);

		//UtilityServlet u = new UtilityServlet();
		for(Map.Entry<String, String> e : UtilityServlet.getMonth().entrySet()) {
			
		}
	}

}
