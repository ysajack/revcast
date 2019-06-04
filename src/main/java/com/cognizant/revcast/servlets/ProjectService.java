package com.cognizant.revcast.servlets;

import java.sql.SQLException;
import java.util.List; 
import javax.ws.rs.GET; 
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces; 
import javax.ws.rs.core.MediaType;

import com.cognizant.revcast.data.ProjectDAO;  
@Path("/ProjectService") 

public class ProjectService {  
   ProjectDAO projectDao = new ProjectDAO();  
   @GET 
   @Path("/projects/{bio}") 
   @Produces(MediaType.TEXT_PLAIN) 
   public List<String> getProjects(@PathParam(value="bio") String bio) throws ClassNotFoundException, SQLException{
	return null; //Rest Services for scaling in future use
   }  
}
