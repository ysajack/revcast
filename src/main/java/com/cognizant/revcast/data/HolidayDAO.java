package com.cognizant.revcast.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.cognizant.revcast.models.Holiday;

public class HolidayDAO {
	
	public String addAssociate(Holiday holiday) {
		Connection cnn = null;
		PreparedStatement psmt = null;
		String response = "";

		try {
			cnn = DBConnection.getConnection();
			String sql = "insert into holiday (holiday_year,holiday_month,num_of_holidays,holiday_dates,onsite_offshore,comments) " 
			+ "values(?,?,?,?,?,?)";

			psmt = cnn.prepareStatement(sql);

			psmt.setString(1, holiday.getHolidayYear());
			psmt.setString(2, holiday.getHolidayMonth());
			psmt.setInt(3, holiday.getNumOfHolidays());
			psmt.setString(4, holiday.getHolidayDates());
			psmt.setString(5, holiday.getOnsiteOffshore());
			psmt.setString(6, holiday.getComments());
		
			psmt.executeUpdate();
			response = "Success";

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {

			if (psmt != null) {
				try {
					psmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			if (cnn != null) {
				try {
					cnn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		}

		return response;
	}
	
	public int getHolidays(String year,String month,String onsiteOffshore) {
		int numOfHoliday = 0;
		Connection cnn = null;
		PreparedStatement psmt;
		ResultSet rs = null;
		
		try {
			cnn = DBConnection.getConnection();
			psmt = cnn.prepareStatement("select num_of_holidays from holiday "+
					"where holiday_year=? and holiday_month=? and onsite_offshore=?");
			psmt.setString(1, year);
			psmt.setString(2, month);
			psmt.setString(3, onsiteOffshore);
			rs = psmt.executeQuery();
			while (rs.next()) {
				numOfHoliday = rs.getInt("num_of_holidays");
			}
			cnn.close();
		} catch (ClassNotFoundException |SQLException e) {
			e.printStackTrace();
		}
	
		return numOfHoliday;
	}

}
