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
import com.cognizant.revcast.models.Leave;
import com.cognizant.revcast.models.Project;
import com.google.gson.Gson;

public class LeaveClient {
	javax.ws.rs.client.Client client = ClientBuilder.newClient();
	//WebTarget wt = client.target("http://localhost:8383/rest/LeaveService/");
	WebTarget wt = client.target("http://revcast-rest.appspot.com/rest/LeaveService/");
	
	public String getAllLeavesByAssociate(String assocId) {
		WebTarget projWebTarget = wt.path("allLeavesByAssoc").path(assocId);
		Invocation.Builder invocationBuilder = projWebTarget.request(MediaType.APPLICATION_JSON);
		return invocationBuilder.get(String.class);
	}
	
	public String getAllLeavesOfAllAssociates() {
		WebTarget projWebTarget = wt.path("allLeavesOfAllAssocs");
		Invocation.Builder invocationBuilder = projWebTarget.request(MediaType.APPLICATION_JSON);
		return invocationBuilder.get(String.class);
	}
	
	public String getApproveLeaveViewForAllAssociates() {
		WebTarget projWebTarget = wt.path("getApproveLeaveViewForAllAssocs");
		Invocation.Builder invocationBuilder = projWebTarget.request(MediaType.APPLICATION_JSON);
		return invocationBuilder.get(String.class);
	}
	
	public String getLeavePlanViewOfAllAssociates() {
		WebTarget projWebTarget = wt.path("leavePlanViewOffAllAssocs");
		Invocation.Builder invocationBuilder = projWebTarget.request(MediaType.APPLICATION_JSON);
		return invocationBuilder.get(String.class);
	}
	
	public String getLeavePlanViewByAssociate(String assocId) {
		WebTarget projWebTarget = wt.path("leavePlanViewByAssoc").path(assocId);
		Invocation.Builder invocationBuilder = projWebTarget.request(MediaType.APPLICATION_JSON);
		return invocationBuilder.get(String.class);
	}
	
	public String getCurrentYear() {
		WebTarget projWebTarget = wt.path("currentYear");
		Invocation.Builder invocationBuilder = projWebTarget.request(MediaType.TEXT_PLAIN);
		return invocationBuilder.get(String.class);
	}
	
	//POST
	public String insertLeaveRequest(Leave leave) {
		WebTarget projWebTarget = wt.path("insertLeaveRequest");
        Gson gs = new Gson();
        String leaveStr = gs.toJson(leave);       
        Invocation.Builder invocationBuilder =  projWebTarget.request(MediaType.TEXT_PLAIN);
        Response response = invocationBuilder.post(Entity.entity(leaveStr, MediaType.APPLICATION_JSON));
		return response.readEntity(String.class);
	}
	
	public String getAllLeaveDetails(String yr,String mo,String assocId) {
		WebTarget projWebTarget = wt.path("allLeaveDetails").queryParam("yr", yr).queryParam("mo", mo).queryParam("assocId", assocId);
		Invocation.Builder invocationBuilder = projWebTarget.request(MediaType.APPLICATION_JSON);
		return invocationBuilder.get(String.class);
	}
	
	public String getLeaveById(String leaveId) {
		WebTarget projWebTarget = wt.path("leaveById").queryParam("leaveId", leaveId);
		Invocation.Builder invocationBuilder = projWebTarget.request(MediaType.APPLICATION_JSON);
		return invocationBuilder.get(String.class);
	}
	
	//PUT
	public String updateLeave(Leave leave) {
		WebTarget projWebTarget = wt.path("updateLeave");      
        Invocation.Builder invocationBuilder =  projWebTarget.request(MediaType.TEXT_PLAIN);
        Gson gs = new Gson();
        String leaveStr = gs.toJson(leave); 
        Response response = invocationBuilder.put(Entity.entity(leaveStr, MediaType.APPLICATION_JSON));
		return response.readEntity(String.class);
	}
	
	//PUT
	public String approveLeave(String leaveId) {
		WebTarget projWebTarget = wt.path("approveLeave").path(leaveId);      
        Invocation.Builder invocationBuilder =  projWebTarget.request(MediaType.TEXT_PLAIN);
        Response response = invocationBuilder.put(Entity.entity(leaveId, MediaType.APPLICATION_JSON));
		return response.readEntity(String.class);
	}
	
}
