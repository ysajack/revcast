package com.cognizant.services;

import com.cognizant.data.AssociateDAO;
import com.cognizant.data.LeaveDAO;
import com.cognizant.models.*;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.sql.SQLException;
import java.util.List;

//http://localhost:8181/cognizant/ProjectService/projects

@Path("/LeaveService")
public class LeaveService {

    @GET
    @Path("/allLeavesByAssoc/{associateId}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Leave> getAllLeavesByAssociate(@PathParam(value="associateId") String assocId) {
        try {
            return new LeaveDAO().getAllLeavesByAssociate(assocId);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @GET
    @Path("/allLeavesOfAllAssocs")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Leave> getAllLeavesOfAllAssociates() {
        try {
            return new LeaveDAO().getAllLeavesOfAllAssociates();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @GET
    @Path("/getApproveLeaveViewForAllAssocs")
    @Produces(MediaType.APPLICATION_JSON)
    public List<ApproveLeaveView> getApproveLeaveViewForAllAssociates() {
        try {
            return new LeaveDAO().getApproveLeaveViewForAllAssociates();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @GET
    @Path("/leavePlanViewOffAllAssocs")
    @Produces(MediaType.APPLICATION_JSON)
    public List<LeavePlanView> getLeavePlanViewOfAllAssociates() {
        return new LeaveDAO().getLeavePlanViewOfAllAssociates();
    }

    @GET
    @Path("/leavePlanViewByAssoc/{assocId}")
    @Produces(MediaType.APPLICATION_JSON)
    public LeavePlanView getLeavePlanViewByAssociate(@PathParam(value="assocId") String assocId ){
        try {
            return new LeaveDAO().getLeavePlanViewByAssociate(assocId);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @GET
    @Path("/currentYear")
    @Produces(MediaType.TEXT_PLAIN)
    public String getCurrentYear() {
        try {
            return new LeaveDAO().getCurrentYear();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @POST
    @Path("/insertLeaveRequest")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String insertLeaveRequest(Leave leave){
        return new LeaveDAO().insertLeaveRequest(leave);
    }

    @GET
    @Path("/allLeaveDetails")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Leave> getAllLeaveDetails(@QueryParam(value="yr") String yr,
                                          @QueryParam("mo") String mo,
                                          @QueryParam("assocId") String assocId){
        try {
            return new LeaveDAO().getAllLeaveDetails(yr,mo,assocId);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @GET
    @Path("/leaveById/{leaveId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Leave getLeaveById(@PathParam(value="leaveId") String leaveId ){
        try {
            return new LeaveDAO().getLeaveById(leaveId);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @PUT
    @Path("/updateLeave")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String updateLeave(Leave leave){
        return new LeaveDAO().updateLeave(leave);
    }

    @PUT
    @Path("/approveLeave/{leaveId}")
    @Produces(MediaType.TEXT_PLAIN)
    public String approveLeave(@PathParam("leaveId") String leaveId) {
        return new LeaveDAO().approveLeave(leaveId);
    }

}
