package com.cognizant.services;

import com.cognizant.data.AssociateDAO;
import com.cognizant.models.*;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Logger;

//http://localhost:8181/cognizant/ProjectService/projects

@Path("/AssociateService")
public class AssociateService {

    @GET
    @Path("/associateById/{associateId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Associate getAssociateById(@PathParam(value="associateId") String assocId) {
        try {
            return new AssociateDAO().getAssociateById(assocId);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @GET
    @Path("/allAssociates")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Associate> getAllAssociates() {
        try {
            return new AssociateDAO().getAllAssociates();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @POST
    @Path("/addAssociate")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String addAssociate(Associate assoc){
        return new AssociateDAO().addAssociate(assoc);
    }

    @GET
    @Path("/isAssocExistingInProj/{associateId}/{projectId}")
    @Produces(MediaType.TEXT_PLAIN)
    public boolean isAssocExistingInProj(@PathParam("associateId") String assocId, @PathParam("projectId") String projId){
        try {
            return new AssociateDAO().isAssociateExistingInProject(assocId,projId);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @PUT
    @Path("/updateAssocAllocation")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String updateAssocAllocation(AllocationBean allocBean){
        return new AssociateDAO().updateAssociateAllocation(allocBean);
    }

}
