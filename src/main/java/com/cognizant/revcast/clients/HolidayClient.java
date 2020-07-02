package com.cognizant.revcast.clients;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.cognizant.revcast.models.AllocationBean;
import com.cognizant.revcast.models.Associate;
import com.cognizant.revcast.models.Holiday;
import com.cognizant.revcast.models.Project;
import com.google.gson.Gson;

public class HolidayClient {
	javax.ws.rs.client.Client client = ClientBuilder.newClient();
	//WebTarget wt = client.target("http://localhost:8383/rest/HolidayService/");
	WebTarget wt = client.target("http://revcast-rest.appspot.com/rest/HolidayService/");
	
	//POST
	public String addHoliday(Holiday hol) {
		WebTarget projWebTarget = wt.path("addHoliday");
        Gson gs = new Gson();
        String holStr = gs.toJson(hol);       
        Invocation.Builder invocationBuilder =  projWebTarget.request(MediaType.TEXT_PLAIN);
        Response response = invocationBuilder.post(Entity.entity(holStr, MediaType.APPLICATION_JSON));
		return response.readEntity(String.class);
	}
	
	public int getHolidays(String year,String month,String onOff) {
		WebTarget projWebTarget = wt.path("getHolidays")
				.queryParam("year", year)
				.queryParam("month", month)
				.queryParam("onOff", onOff);
		Invocation.Builder invocationBuilder = projWebTarget.request(MediaType.TEXT_PLAIN);
		return invocationBuilder.get(Integer.class);
	}

}
