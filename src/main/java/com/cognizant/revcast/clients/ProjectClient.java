package com.cognizant.revcast.clients;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.cognizant.revcast.models.Project;
import com.cognizant.revcast.models.ProjectAssociateView;
import com.google.gson.Gson;

public class ProjectClient {
	javax.ws.rs.client.Client client = ClientBuilder.newClient();
	//WebTarget wt = client.target("http://localhost:8383/rest/ProjectService/");
	WebTarget wt = client.target("http://revcast-rest.appspot.com/rest/ProjectService/");
	
	public String getAllProjects() {
		WebTarget projWebTarget = wt.path("allProjects");
		Invocation.Builder invocationBuilder = projWebTarget.request(MediaType.APPLICATION_JSON);
		return invocationBuilder.get(String.class);
	}
	
	public Project getProjectById(String projId) {
		WebTarget projWebTarget = wt.path("projectById").path(projId);
		Invocation.Builder invocationBuilder = projWebTarget.request(MediaType.APPLICATION_JSON);
		return invocationBuilder.get(Project.class);
	}
	
	public String getAllDistinctBios() {
		WebTarget projWebTarget = wt.path("distinctBios");
		Invocation.Builder invocationBuilder = projWebTarget.request(MediaType.APPLICATION_JSON);
		return invocationBuilder.get(String.class);
	}
	
	public String getAllDistinctProjects() {
		WebTarget projWebTarget = wt.path("distinctProjects");
		Invocation.Builder invocationBuilder = projWebTarget.request(MediaType.APPLICATION_JSON);
		return invocationBuilder.get(String.class);
	}
	
	public String getAllProjectsByBio(String bio) {
		WebTarget projWebTarget = wt.path("projectsByBio").path(bio);
		Invocation.Builder invocationBuilder = projWebTarget.request(MediaType.APPLICATION_JSON);
		return invocationBuilder.get(String.class);
	}
	
	public String getAllAssociates() {
		WebTarget projWebTarget = wt.path("allAssociates");
		Invocation.Builder invocationBuilder = projWebTarget.request(MediaType.APPLICATION_JSON);
		return invocationBuilder.get(String.class);
	}
	
//	public ProjectAssociateView[] getProjectAssociateView() {
//		WebTarget projWebTarget = wt.path("projAssocView");
//		Invocation.Builder invocationBuilder = projWebTarget.request(MediaType.APPLICATION_JSON);
//		return invocationBuilder.get(ProjectAssociateView[].class);
//	}
	
	public String getProjectAssociateView() {
		WebTarget projWebTarget = wt.path("projAssocView");
		Invocation.Builder invocationBuilder = projWebTarget.request(MediaType.APPLICATION_JSON);
		return invocationBuilder.get(String.class);
	}
	
//	public ProjectAssociateView[] getProjAssocViewByProjId(String projId) {
//		WebTarget projWebTarget = wt.path("projAssocViewByProjId").path(projId);
//		Invocation.Builder invocationBuilder = projWebTarget.request(MediaType.APPLICATION_JSON);
//		return invocationBuilder.get(ProjectAssociateView[].class);
//	}
	
	public String getProjAssocViewByProjId(String projId) {
		WebTarget projWebTarget = wt.path("projAssocViewByProjId").path(projId);
		Invocation.Builder invocationBuilder = projWebTarget.request(MediaType.APPLICATION_JSON);
		return invocationBuilder.get(String.class);
	}
	
	public String getProjAssocViewByAssocId(String assocId) {
		WebTarget projWebTarget = wt.path("projAssocViewByAssocId").path(assocId);
		Invocation.Builder invocationBuilder = projWebTarget.request(MediaType.APPLICATION_JSON);
		return invocationBuilder.get(String.class);
	}

//	public ProjectAssociateView[] getProjAssocViewByBio(String bio) {
//		WebTarget projWebTarget = wt.path("projAssocViewByBio").path(bio);
//		Invocation.Builder invocationBuilder = projWebTarget.request(MediaType.APPLICATION_JSON);
//		return invocationBuilder.get(ProjectAssociateView[].class);
//	}
	
	public String getProjAssocViewByBio(String bio) {
		WebTarget projWebTarget = wt.path("projAssocViewByBio").path(bio);
		Invocation.Builder invocationBuilder = projWebTarget.request(MediaType.APPLICATION_JSON);
		return invocationBuilder.get(String.class);
	}
	
	public String getAllProjectBeans() {
		WebTarget projWebTarget = wt.path("allProjectBeans");
		Invocation.Builder invocationBuilder = projWebTarget.request(MediaType.APPLICATION_JSON);
		return invocationBuilder.get(String.class);
	}
	
	public String getProjectBeanById(String projId) {
		WebTarget projWebTarget = wt.path("projBeanById").path(projId);
		Invocation.Builder invocationBuilder = projWebTarget.request(MediaType.APPLICATION_JSON);
		return invocationBuilder.get(String.class);
	}
	
	//POST
	public String addProject(Project prj,String assocId) {
		WebTarget projWebTarget = wt.path("addProject").queryParam("associateId", assocId);
        Gson gs = new Gson();
        String prjStr = gs.toJson(prj);       
        Invocation.Builder invocationBuilder =  projWebTarget.request(MediaType.TEXT_PLAIN);
        Response response = invocationBuilder.post(Entity.entity(prjStr, MediaType.APPLICATION_JSON));
		return response.readEntity(String.class);
	}
	
	public boolean isProjectMappedToAssociate(String assocId,String projId) {
		WebTarget projWebTarget = wt.path("isProjMappedToAssoc").queryParam("associateId", assocId).queryParam("projectId", projId);
		Invocation.Builder invocationBuilder = projWebTarget.request(MediaType.TEXT_PLAIN);
		return invocationBuilder.get(Boolean.class);
	}
	
	public boolean isProjectLeftUnmapped(String projId) {
		WebTarget projWebTarget = wt.path("isProjLeftUnmapped").queryParam("projectId", projId);
		Invocation.Builder invocationBuilder = projWebTarget.request(MediaType.TEXT_PLAIN);
		return invocationBuilder.get(Boolean.class);
	}
	
	//PUT
	public String updateProjAssocAlloc(String projId,String assocId) {
		WebTarget projWebTarget = wt.path("updateProjAssocAlloc").path(projId);      
        Invocation.Builder invocationBuilder =  projWebTarget.request(MediaType.TEXT_PLAIN);
        Response response = invocationBuilder.put(Entity.entity(assocId, MediaType.TEXT_PLAIN));
		return response.readEntity(String.class);
	}

}
