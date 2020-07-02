package com.cognizant.models;

public class Holiday {
	  String holidayYear;
	  String holidayMonth;
	  int numOfHolidays;
	  String holidayDates;
	  String onsiteOffshore;
	  String comments;

	public Holiday(){}

	public Holiday(String holidayYear, String holidayMonth, int numOfHolidays, String holidayDates,
			String onsiteOffshore, String comments) {
		super();
		this.holidayYear = holidayYear;
		this.holidayMonth = holidayMonth;
		this.numOfHolidays = numOfHolidays;
		this.holidayDates = holidayDates;
		this.onsiteOffshore = onsiteOffshore;
		this.comments = comments;
	}
	public String getHolidayYear() {
		return holidayYear;
	}
	public void setHolidayYear(String holidayYear) {
		this.holidayYear = holidayYear;
	}
	public String getHolidayMonth() {
		return holidayMonth;
	}
	public void setHolidayMonth(String holidayMonth) {
		this.holidayMonth = holidayMonth;
	}
	public int getNumOfHolidays() {
		return numOfHolidays;
	}
	public void setNumOfHolidays(int numOfHolidays) {
		this.numOfHolidays = numOfHolidays;
	}
	public String getHolidayDates() {
		return holidayDates;
	}
	public void setHolidayDates(String holidayDates) {
		this.holidayDates = holidayDates;
	}
	public String getOnsiteOffshore() {
		return onsiteOffshore;
	}
	public void setOnsiteOffshore(String onsiteOffshore) {
		this.onsiteOffshore = onsiteOffshore;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	  
}
