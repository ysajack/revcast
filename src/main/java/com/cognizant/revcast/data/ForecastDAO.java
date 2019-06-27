package com.cognizant.revcast.data;

import static java.time.temporal.TemporalAdjusters.lastDayOfMonth;

import java.sql.SQLException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import com.cognizant.revcast.models.Associate;
import com.cognizant.revcast.models.ForecastMonth;
import com.cognizant.revcast.models.ForecastView;
import com.cognizant.revcast.models.LeavePlanView;
import com.cognizant.revcast.servlets.UtilityServlet;

public class ForecastDAO {
	public ForecastView getForecastByAssociate(String assoId) {
		LeaveDAO ldao = new LeaveDAO();
		LeavePlanView lpv = null;
		AssociateDAO adao = new AssociateDAO();
		ProjectDAO pdao = new ProjectDAO();
		ForecastView fc = new ForecastView();
		ForecastMonth m = new ForecastMonth();
		Associate asso = null;
		HolidayDAO hdao = new HolidayDAO();
		HashMap<String,Integer> holidays = new HashMap<String,Integer>();
		
		int rate=0;
		int year = 0;
		String db ="";
		int allocation=0;
		
		try {
			 lpv = ldao.getLeavePlanViewByAssociate(assoId);
			 asso = adao.getAssociateById(assoId);
			 String prjId = asso.getProjectId();
			 fc.setProjectId(prjId);
			 fc.setProjectName(pdao.getProjectById(prjId).getProjectName());
			 db="Success";
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		if(db.equals("Success")) {
			year = Integer.parseInt(lpv.getYear()); //always current year
			rate = asso.getRate();
			allocation = asso.getAllocation();
						
			for(Map.Entry<String, String> month : UtilityServlet.getMonth().entrySet()) {
				int holiday = hdao.getHolidays(lpv.getYear(), month.getValue(), asso.getOnsiteOffshore().toLowerCase());
				holidays.put(month.getValue(), holiday); //put in key as the month ex. "January"		
			}
			
			//int numOfLeave = lpv.getMonth().getJan();
			//int totalDays = getTotalWorkDaysInMonth(year,1);
			//int forecast = calcForecast(totalDays,rate, numOfLeave);
			m.setJan(calcForecast(getTotalWorkDaysInMonth(year,1),rate, allocation, lpv.getMonth().getJan(), holidays.get("January")));
			m.setFeb(calcForecast(getTotalWorkDaysInMonth(year,2),rate, allocation, lpv.getMonth().getFeb(), holidays.get("February")));
			m.setMar(calcForecast(getTotalWorkDaysInMonth(year,3),rate, allocation, lpv.getMonth().getMar(), holidays.get("March")));
			m.setApr(calcForecast(getTotalWorkDaysInMonth(year,4),rate, allocation, lpv.getMonth().getApr(), holidays.get("April")));
			m.setMay(calcForecast(getTotalWorkDaysInMonth(year,5),rate, allocation, lpv.getMonth().getMay(), holidays.get("May")));
			m.setJun(calcForecast(getTotalWorkDaysInMonth(year,6),rate, allocation, lpv.getMonth().getJun(), holidays.get("June")));
			m.setJul(calcForecast(getTotalWorkDaysInMonth(year,7),rate, allocation, lpv.getMonth().getJul(), holidays.get("July")));
			m.setAug(calcForecast(getTotalWorkDaysInMonth(year,8),rate, allocation, lpv.getMonth().getAug(), holidays.get("August")));
			m.setSep(calcForecast(getTotalWorkDaysInMonth(year,9),rate, allocation, lpv.getMonth().getSep(), holidays.get("September")));
			m.setOct(calcForecast(getTotalWorkDaysInMonth(year,10),rate, allocation, lpv.getMonth().getOct(), holidays.get("October")));
			m.setNov(calcForecast(getTotalWorkDaysInMonth(year,11),rate, allocation, lpv.getMonth().getNov(), holidays.get("November")));
			m.setDec(calcForecast(getTotalWorkDaysInMonth(year,12),rate, allocation, lpv.getMonth().getDec(), holidays.get("December")));
			
			fc.setYear(String.valueOf(year));
			fc.setForecastMonth(m);
			fc.setAssociateId(assoId);
			fc.setAssociateName(asso.getAssociateName());
			
			return fc;
		}
		else {
			return null;
		}
	}
	
	public int getTotalWorkDaysInMonth(int year, int month) {
		LocalDate initial = LocalDate.of(year, month, 1);
		int last = initial.with(lastDayOfMonth()).getDayOfMonth();
		int numOfDays = 0;

		for (int i = 1; i <= last; i++) {
			DayOfWeek day = LocalDate.of(2019, month, i).getDayOfWeek();

			if (!(day == DayOfWeek.SATURDAY || day == DayOfWeek.SUNDAY)) {
				numOfDays++;
			}
		}

		return numOfDays;
	}
	
	public double calcForecast(int totalDays, int rate, int allocation, int numOfLeave, int holidays) {
		//double forecast = (((totalDays * 8) * rate) - ((numOfLeave * 8) * rate)) * ((double) allocation/100);
		double forecast = (((totalDays - numOfLeave - holidays)* 8) * rate) * ((double) allocation/100);
		return forecast;
	}
}
