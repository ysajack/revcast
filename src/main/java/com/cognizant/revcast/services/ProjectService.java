package com.cognizant.revcast.services;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List; 
import javax.ws.rs.GET; 
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces; 
import javax.ws.rs.core.MediaType;

import com.cognizant.revcast.data.ProjectDAO;
import com.cognizant.revcast.models.ProjectBean;
import com.google.gson.Gson;  
@Path("/ProjectService") 

public class ProjectService {  //This is just a test - Rest Services for scaling in future use
  
   @GET 
   @Path("/projects/{bio}") 
   @Produces(MediaType.APPLICATION_XML) 
   public ProjectBean getProjects(@PathParam(value="bio") String bio) throws ClassNotFoundException, SQLException{
	   ProjectDAO prjdao = new ProjectDAO();
	   return prjdao.getProjectBeanById(bio);
   }  
   
	//http://localhost:8181/cognizant/ProjectService/projects
	
   @GET 
   @Path("/projects") 
   @Produces(MediaType.APPLICATION_JSON) 
   public List<ProjectBean> getAllProjects() throws ClassNotFoundException, SQLException{
	   ProjectDAO prjdao = new ProjectDAO();
	   return prjdao.getAllProjectBeans();
   }  
   
   @GET 
   @Path("/distinctProjects") 
   @Produces(MediaType.APPLICATION_JSON) 
	public static List<ProjectBean> getAllDistinctProjects() {
	//	Gson gs = new Gson();
		ProjectDAO prjdao = new ProjectDAO();
		List<ProjectBean> pjList = new ArrayList<ProjectBean>();

		try {
			pjList = prjdao.getAllDistinctProjects();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return pjList;
//		//Converting to json
//		String str = gs.toJson(pjList);
//		return str;
	}
   
   @GET 
   @Path("/test") 
   @Produces(MediaType.APPLICATION_JSON) 
   public HashMap<String, String> getTest() throws ClassNotFoundException, SQLException{
		HashMap<String,String> hm = new HashMap<>();
		hm.put("one","apple");
		hm.put("two","orange");
		return hm;
   }  
   
	
}
