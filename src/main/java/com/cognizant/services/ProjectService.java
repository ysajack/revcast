package com.cognizant.services;

import com.cognizant.data.ProjectDAO;
import com.cognizant.models.Associate;
import com.cognizant.models.Project;
import com.cognizant.models.ProjectAssociateView;
import com.cognizant.models.ProjectBean;
import com.google.gson.Gson;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Logger;

//http://localhost:8181/cognizant/ProjectService/projects

@Path("/ProjectService")
public class ProjectService {
	
   @GET 
   @Path("/allProjects")
   @Produces(MediaType.APPLICATION_JSON) 
   public List<Project> getAllProjects() {
       try {
           return new ProjectDAO().getAllProjects();
       } catch (ClassNotFoundException | SQLException e) {
           e.printStackTrace();
           return null;
       }
   }

    @GET
    @Path("/projectById/{projectId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Project getProjectById(@PathParam(value="projectId") String prjId) {
        try {
            return new ProjectDAO().getProjectById(prjId);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @GET
    @Path("/distinctBios")
    @Produces(MediaType.APPLICATION_JSON)
    public static List<String> getAllDistinctBios() {
        ProjectDAO prjdao = new ProjectDAO();
        List<String> bioList = new ArrayList<>();

        try {
            bioList = prjdao.getAllDistinctBios();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return bioList;
    }

    @GET
    @Path("/distinctProjects")
    @Produces(MediaType.APPLICATION_JSON)
	public static List<ProjectBean> getAllDistinctProjects() {
		ProjectDAO prjdao = new ProjectDAO();
		List<ProjectBean> pjList = new ArrayList<>();

		try {
			pjList = prjdao.getAllDistinctProjects();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return pjList;
	}

    @GET
    @Path("/projectsByBio/{bio}")
    @Produces(MediaType.APPLICATION_JSON)
    public static List<ProjectBean> getAllProjectsByBio(@PathParam(value="bio") String bio) {
        ProjectDAO prjdao = new ProjectDAO();
        List<ProjectBean> pjList = new ArrayList<>();

        try {
            pjList = new ProjectDAO().getAllProjectsByBio(bio);

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return pjList;
    }

    @GET
    @Path("/allAssociates")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Associate> getAllAssociates() {
        try {
            return new ProjectDAO().getAllAssociates();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @GET
    @Path("/projAssocView")
    @Produces(MediaType.APPLICATION_JSON)
    public List<ProjectAssociateView> getProjAssocView() {
        try {
            return new ProjectDAO().getProjectAssociateView();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @GET
    @Path("/projAssocViewByProjId/{projectId}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<ProjectAssociateView> getProjAssocViewByProjId(@PathParam(value="projectId") String prjId) {
        try {
            return new ProjectDAO().getProjectAssociateViewByProjectId(prjId);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @GET
    @Path("/projAssocViewByAssocId/{associateId}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<ProjectAssociateView> getProjAssocViewByAssocId(@PathParam(value="associateId") String assocId) {
        try {
            return new ProjectDAO().getProjectAssociateViewByAssociateId(assocId);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @GET
    @Path("/projAssocViewByBio/{bio}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<ProjectAssociateView> getProjAssocViewByBio(@PathParam(value="bio") String bio) {
        try {
            return new ProjectDAO().getProjectAssociateViewByBio(bio);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @GET
    @Path("/allProjectBeans")
    @Produces(MediaType.APPLICATION_JSON)
    public List<ProjectBean> getAllProjectBeans() {
        try {
            return new ProjectDAO().getAllProjectBeans();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @GET
    @Path("/projBeanById/{projectId}")
    @Produces(MediaType.APPLICATION_JSON)
    public ProjectBean getProjectBeanById(@PathParam(value="projectId") String prjId) {
        try {
            return new ProjectDAO().getProjectBeanById(prjId);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @POST
    @Path("/addProject")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String addProject(Project prj,@QueryParam("associateId") String assocId){
       //Logger.getLogger("BEAN PARAM").info(prj.toString());
       return new ProjectDAO().addProject(prj,assocId);
    }

    @GET
    @Path("/isProjMappedToAssoc")
    @Produces(MediaType.TEXT_PLAIN)
    public boolean isProjMappedToAssoc(@QueryParam("associateId") String assocId, @QueryParam("projectId") String projId){
        try {
            return new ProjectDAO().isProjectMappedToAssociate(assocId,projId);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @GET
    @Path("/isProjLeftUnmapped")
    @Produces(MediaType.TEXT_PLAIN)
    public boolean isProjLeftUnmapped(@QueryParam("projectId") String projId){
        try {
            return new ProjectDAO().isProjectLeftUnmapped(projId);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @PUT
    @Path("/updateProjAssocAlloc/{projId}")
    @Produces(MediaType.TEXT_PLAIN)
    public String updateProjAssocAlloc(@PathParam("projId") String projId, String assocId){
       return new ProjectDAO().updateProjectAssociateAllocation(projId,assocId);
    }

   /******For Debugging****/
   @GET 
   @Path("/test") 
   @Produces(MediaType.APPLICATION_JSON)
   public HashMap<String, String> getTest(){
		HashMap<String,String> hm = new HashMap<>();
		hm.put("one","apple");
		hm.put("two","orange");
		return hm;
   }

    @GET
    @Path("/ping")
    @Produces(MediaType.TEXT_PLAIN)
    public String getString(){
        return "Hello String";
    }

    @POST
    @Path("/pingPost")
    @Produces(MediaType.TEXT_PLAIN)
    public String getPostResponse(String str){
        Logger.getLogger("BEAN PARAM").info(str);
        return "Hello Post";
    }


}
