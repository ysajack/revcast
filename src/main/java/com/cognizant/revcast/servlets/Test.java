package com.cognizant.revcast.servlets;

import java.sql.SQLException;

import com.cognizant.revcast.data.LeaveDAO;
import com.cognizant.revcast.models.Leave;

public class Test {

	public static void main(String[] args){
		// TODO Auto-generated method stub
		//ProjectServlet ps = new ProjectServlet();
		
	//	System.out.println(LeavePlanServlet.getLeavePlanView());
	//	System.out.println(LeavePlanServlet.getCurrentYear());
		LeaveDAO ldao = new LeaveDAO();
		//Leave leave = new Leave("2019","June", 1, "6/5", null, "A12345");
		//System.out.println(ldao.insertLeaveRequest(leave));
		String yr="2019";
		String mo="February";
		String assoId="A12345";
		//for(Leave lv : ldao.getAllLeaveDetails(yr, mo, assoId))
		//LeaveDetailsServlet ld = new LeaveDetailsServlet();
		System.out.println(LeaveDetailsServlet.getLeaveById("19"));
	}

}
