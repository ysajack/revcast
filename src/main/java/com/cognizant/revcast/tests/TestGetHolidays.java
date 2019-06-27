package com.cognizant.revcast.tests;

import java.util.HashMap;
import java.util.Map;

import com.cognizant.revcast.data.HolidayDAO;
import com.cognizant.revcast.servlets.UtilityServlet;

public class TestGetHolidays {

	public static void main(String[] args) {
		HolidayDAO hdao = new HolidayDAO();
		HashMap<String,Integer> holidays = new HashMap<String,Integer>();
		
	//	System.out.println(hdao.getHolidays("2019", "January", "onsite"));
		
		for(Map.Entry<String, String> month : UtilityServlet.getMonth().entrySet()) {
			int holiday = hdao.getHolidays("2019", month.getValue(), "onsite");
			holidays.put(month.getValue(), holiday);		
		}
		//System.out.println(holidays.get("January"));
		for(Map.Entry<String, Integer> hol : holidays.entrySet()) {
			System.out.println(hol.getKey());	
		}
	}

}
