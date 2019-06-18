package com.cognizant.revcast.services;

import java.sql.SQLException;
import java.util.List; 
import javax.ws.rs.GET; 
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces; 
import javax.ws.rs.core.MediaType;

import com.cognizant.revcast.data.ProjectDAO;
import com.cognizant.revcast.models.ProjectBean;  
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
   @Produces(MediaType.APPLICATION_XML) 
   public List<ProjectBean> getAllProjects() throws ClassNotFoundException, SQLException{
	   ProjectDAO prjdao = new ProjectDAO();
	   return prjdao.getAllProjectBeans();
   }  
   
	
}
