package com.cognizant.services;

import com.cognizant.data.AssociateDAO;
import com.cognizant.data.HolidayDAO;
import com.cognizant.models.AllocationBean;
import com.cognizant.models.Associate;
import com.cognizant.models.Holiday;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.sql.SQLException;
import java.util.List;

//http://localhost:8181/cognizant/ProjectService/projects

@Path("/HolidayService")
public class HolidayService {

    @POST
    @Path("/addHoliday")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String addHoliday(Holiday hol){
        return new HolidayDAO().addHoliday(hol);
    }

    @GET
    @Path("/getHolidays")
    @Produces(MediaType.TEXT_PLAIN)
    public int getHolidays(@QueryParam("year") String year,
                           @QueryParam("month") String month,
                           @QueryParam("onOff") String onsiteOffshore) {
        return new HolidayDAO().getHolidays(year,month,onsiteOffshore);
    }
}
