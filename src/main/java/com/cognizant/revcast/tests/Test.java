package com.cognizant.revcast.tests;

import static java.time.temporal.TemporalAdjusters.firstDayOfMonth;
import static java.time.temporal.TemporalAdjusters.lastDayOfMonth;

import java.sql.SQLException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Calendar;

import com.cognizant.revcast.data.AssociateDAO;
import com.cognizant.revcast.data.LeaveDAO;
import com.cognizant.revcast.data.ProjectDAO;
import com.cognizant.revcast.models.Associate;
import com.cognizant.revcast.models.Leave;
import com.cognizant.revcast.models.LeavePlanView;

public class Test {

	public static void main(String[] args){
		// TODO Auto-generated method stub
		//ProjectServlet ps = new ProjectServlet();
		
		for(LeavePlanView lpv : new LeaveDAO().getLeavePlanViewOfAllAssociates()) {
			System.out.println(lpv.getYear());
			System.out.println(lpv);
			System.out.println(lpv.getAssociateId());
		} 
		
		
	/*
		try {
			for(Associate a : new AssociateDAO().getAllAssociates()) {
				System.out.println(a.getAssociateId());
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} */
		
	//	System.out.println(LeavePlanServlet.getCurrentYear());
		LeaveDAO ldao = new LeaveDAO();
		//Leave leave = new Leave("2019","June", 1, "6/5", null, "A12345");
		//System.out.println(ldao.insertLeaveRequest(leave));
		String yr="2019";
		String mo="February";
		String assoId="A12345";
		//for(Leave lv : ldao.getAllLeaveDetails(yr, mo, assoId))
		//LeaveDetailsServlet ld = new LeaveDetailsServlet();
		//System.out.println(LeaveDetailsServlet.getLeaveById("19"));

		//System.out.println(ForecastServlet.getTotalWorkDaysInMonth(2019, 5));
	/*	
		LocalDate initial = LocalDate.of(2019, 12, 1);
		int last = initial.with(lastDayOfMonth()).getDayOfMonth();
		int days =0;
		
		for(int i=1;i<=last;i++) {
			DayOfWeek day = LocalDate.of(2019,12,i).getDayOfWeek();
		
			if(!(day == DayOfWeek.SATURDAY ||day == DayOfWeek.SUNDAY)) {
				days++;
			}
		}
		System.out.println(days); */
		
		
		//System.out.println(ForecastServlet.getForecastByAssociate("A12345"));
		//System.out.println(ForecastServlet.calcForecast(days, 100, 100, 0));
	/*	
		try {
			System.out.println(new AssociateDAO().getAssociateById("A12345"));
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		*/
	}

}
