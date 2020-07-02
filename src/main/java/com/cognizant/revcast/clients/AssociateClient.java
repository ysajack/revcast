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

public class AssociateClient {
	javax.ws.rs.client.Client client = ClientBuilder.newClient();
//	WebTarget wt = client.target("http://localhost:8383/rest/AssociateService/");
	WebTarget wt = client.target("http://revcast-rest.appspot.com/rest/AssociateService/");
	
	public String getAssociateById(String assocId) {
		WebTarget projWebTarget = wt.path("associateById").path(assocId);
		Invocation.Builder invocationBuilder = projWebTarget.request(MediaType.APPLICATION_JSON);
		return invocationBuilder.get(String.class);
	}
	
	public String getAllAssociates() {
		WebTarget projWebTarget = wt.path("allAssociates");
		Invocation.Builder invocationBuilder = projWebTarget.request(MediaType.APPLICATION_JSON);
		return invocationBuilder.get(String.class);
	}
	
	//POST
	public String addAssociate(Associate assoc) {
		WebTarget projWebTarget = wt.path("addAssociate");
        Gson gs = new Gson();
        String assocStr = gs.toJson(assoc);       
        Invocation.Builder invocationBuilder =  projWebTarget.request(MediaType.TEXT_PLAIN);
        Response response = invocationBuilder.post(Entity.entity(assocStr, MediaType.APPLICATION_JSON));
		return response.readEntity(String.class);
	}
	
	
	public boolean isAssociateExistingInProject(String assocId,String projId) {
		WebTarget projWebTarget = wt.path("isAssocExistingInProj").path(assocId).path(projId);
		Invocation.Builder invocationBuilder = projWebTarget.request(MediaType.TEXT_PLAIN);
		return invocationBuilder.get(Boolean.class);
	}

	//PUT
	public String updateAssociateAllocation(AllocationBean allocBean) {
		WebTarget projWebTarget = wt.path("updateAssocAllocation");      
        Invocation.Builder invocationBuilder =  projWebTarget.request(MediaType.TEXT_PLAIN);
        Gson gs = new Gson();
        String allocBeanStr = gs.toJson(allocBean); 
        Response response = invocationBuilder.put(Entity.entity(allocBeanStr, MediaType.APPLICATION_JSON));
		return response.readEntity(String.class);
	}
	
	
}
