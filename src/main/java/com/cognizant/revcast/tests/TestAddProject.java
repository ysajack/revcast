package com.cognizant.revcast.tests;

import java.util.Arrays;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.cognizant.revcast.clients.AssociateClient;
import com.cognizant.revcast.clients.LeaveClient;
import com.cognizant.revcast.clients.ProjectClient;

//import javax.ws.rs.client.Client;
//import javax.ws.rs.client.ClientBuilder;
//import javax.ws.rs.client.Entity;
//import javax.ws.rs.client.Invocation;
//import javax.ws.rs.client.WebTarget;
//import javax.ws.rs.core.MediaType;
//import javax.ws.rs.core.Response;

import com.cognizant.revcast.data.ProjectDAO;
import com.cognizant.revcast.models.Leave;
import com.cognizant.revcast.models.LeavePlanView;
import com.cognizant.revcast.models.Project;
import com.cognizant.revcast.servlets.AssociateServlet;
import com.cognizant.revcast.servlets.LeavePlanServlet;
import com.google.gson.Gson;

public class TestAddProject {

	public static void main(String[] args) {
//		ProjectDAO pdao = new ProjectDAO();
		
//		Project prj = new Project("Digital","P1234570","Global Share","BTM","A12347");
//		System.out.println("Add Project: " + pdao.addProject(prj,"A12347"));

//        Client client = ClientBuilder.newClient();
//        WebTarget webTarget = client.target("http://localhost:8383/rest/ProjectService").path("addProject");
//
//        Project prj = new Project();
//        prj.setBio("DG");
//        prj.setProjectId("PID333");
//        prj.setProjectName("Prjname");
//        prj.setProjectType("Type");
//       
//      
//        String str = "Sending Post";
//        Gson gs = new Gson();
//        String prjStr = gs.toJson(prj);       
//        Invocation.Builder invocationBuilder =  webTarget.request(MediaType.TEXT_PLAIN);
//        Response response = invocationBuilder.post(Entity.entity(prjStr, MediaType.APPLICATION_JSON));
//         
//        System.out.println(response.getStatus());
//        System.out.println(response.readEntity(String.class));
		
//		LeaveClient c = new LeaveClient();
//		
//		System.out.println("RESPONSE: "+ c.approveLeave("4"));;
		
	//	System.out.println("RESPONSE: "+ AssociateServlet.getAllAssociates().get(0).getAllocation());
		
		//System.out.println("RESPONSE: "+ new AssociateClient().getAllAssociates());
		String a = AssociateServlet.getAllAssociates().get(0).getAssociateId();
		String b = LeavePlanServlet.getLeavePlanViewByAssociate(a);
	//	System.out.println("RESPONSE: "+ b);;
		System.out.println("RESPONSE: "+ new Gson().fromJson(b, LeavePlanView.class));
	}

}
