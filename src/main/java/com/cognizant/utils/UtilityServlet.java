package com.cognizant.utils;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.util.Calendar;
import java.util.LinkedHashMap;

//import com.google.appengine.repackaged.com.google.gson.Gson;
//import com.google.gson.Gson;


@WebServlet(name = "UtilityServlet", value = "/getUtility")
public class UtilityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public static LinkedHashMap<String,String> getMonth() {
		LinkedHashMap<String,String> hm = new LinkedHashMap<String,String>();
		
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
	
	public static String getCurrentYear() {
		return String.valueOf(Calendar.getInstance().get(Calendar.YEAR));
	}
	
}
