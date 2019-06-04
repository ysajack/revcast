package com.cognizant.revcast.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cognizant.revcast.models.Leave;
import com.cognizant.revcast.models.LeavePlanView;
import com.cognizant.revcast.models.Month;

public class LeaveDAO {
	public List<Leave> getAllLeavesByAssociate(String assoId) throws ClassNotFoundException, SQLException {
		List<Leave> leaveList = new ArrayList<Leave>();
		
		Connection cnn = DBConnection.getConnection();
		
		//sql to get only the records for the current year
		PreparedStatement psmt = cnn.prepareStatement("select * from leaveplan where associate_id=? and year_taken = (select DISTINCT year_taken from leaveplan order by year_taken desc LIMIT 1)");
		psmt.setString(1, assoId);
		ResultSet rs = psmt.executeQuery();

		while (rs.next()) {
			int id = rs.getInt("id");
			String year = rs.getString("year_taken");
			String month = rs.getString("month_taken");
			int numOfdays = rs.getInt("num_of_days");
			String dateTaken = rs.getString("date_taken");
			String leaveStatus = rs.getString("leave_status");
			String comments = rs.getString("comments");
			String associateId=rs.getString("associate_id");

			leaveList.add(new Leave(id,year, month, numOfdays, dateTaken, leaveStatus,comments,associateId));
		}

		cnn.close();
		return leaveList;
	}
	
	public List<Leave> getAllLeavesOfAllAssociates() throws ClassNotFoundException, SQLException {
		List<Leave> leaveList = new ArrayList<Leave>();
		
		Connection cnn = DBConnection.getConnection();
		
		//sql to get only the records for the current year
		PreparedStatement psmt = cnn.prepareStatement("select * from leaveplan where year_taken = (select DISTINCT year_taken from leaveplan order by year_taken desc LIMIT 1)");
		ResultSet rs = psmt.executeQuery();

		while (rs.next()) {
			int id = rs.getInt("id");
			String year = rs.getString("year_taken");
			String month = rs.getString("month_taken");
			int numOfdays = rs.getInt("num_of_days");
			String dateTaken = rs.getString("date_taken");
			String leaveStatus = rs.getString("leave_status");
			String comments = rs.getString("comments");
			String associateId=rs.getString("associate_id");

			leaveList.add(new Leave(id,year, month, numOfdays, dateTaken, leaveStatus,comments,associateId));
		}

		cnn.close();
		return leaveList;
	}

	public LeavePlanView getLeavePlanViewByAssociate(String assoId) throws ClassNotFoundException, SQLException {
		List<Leave> leaveList = getAllLeavesByAssociate(assoId);
		LeavePlanView lpv = new LeavePlanView();
		Month month = new Month();
		int[] sumMonth = new int[12];

		for(Leave lv : leaveList) {
			switch(lv.getMonth()) {
			case "January":
				sumMonth[0] += lv.getNumOfdays();
				month.setJan(sumMonth[0]);
				break;
			case "February":
				sumMonth[1] += lv.getNumOfdays();
				month.setFeb(sumMonth[1]);
				break;
			case "March":
				sumMonth[2] += lv.getNumOfdays();
				month.setMar(sumMonth[2]);
				break;
			case "April":
				sumMonth[3] += lv.getNumOfdays();
				month.setApr(sumMonth[3]);
				break;
			case "May":
				sumMonth[4] += lv.getNumOfdays();
				month.setMay(sumMonth[4]);
				break;
			case "June":
				sumMonth[5] += lv.getNumOfdays();
				month.setJun(sumMonth[5]);
				break;
			case "July":
				sumMonth[6] += lv.getNumOfdays();
				month.setJul(sumMonth[6]);
				break;
			case "August":
				sumMonth[7] += lv.getNumOfdays();
				month.setAug(sumMonth[7]);
				break;
			case "September":
				sumMonth[8] += lv.getNumOfdays();
				month.setSep(sumMonth[8]);
				break;
			case "October":
				sumMonth[9] += lv.getNumOfdays();
				month.setOct(sumMonth[9]);
				break;
			case "November":
				sumMonth[10] += lv.getNumOfdays();
				month.setNov(sumMonth[10]);
				break;
			case "December":
				sumMonth[11] += lv.getNumOfdays();
				month.setDec(sumMonth[11]);
				break;
			}
		}

		lpv.setYear(leaveList.get(0).getYear());
		lpv.setMonth(month);
		lpv.setAssociateId(assoId);
		AssociateDAO adao = new AssociateDAO();
		String name = adao.getAssociateById(assoId).getAssociateName();
		lpv.setAssociateName(name);
		
		return lpv;
	}
	
	public String getCurrentYear() throws SQLException, ClassNotFoundException {
		Connection cnn = DBConnection.getConnection();
		
		PreparedStatement psmt = cnn.prepareStatement("select DISTINCT year_taken from leaveplan order by year_taken desc LIMIT 1");
		ResultSet rs = psmt.executeQuery();
		String year = null;
		
		while (rs.next()) {
			year = rs.getString("year_taken");
		}
		cnn.close();
		return year;
	}
	
	public String insertLeaveRequest(Leave leave) {
		Connection cnn = null;
		PreparedStatement psmt = null;
		String response = null;
		
		try {
			cnn = DBConnection.getConnection();
			String sql = "insert into leaveplan (year_taken, month_taken, num_of_days, date_taken, leave_status, comments, associate_id) "
					+ "values(?,?,?,?,?,?,?)";
			
			psmt = cnn.prepareStatement(sql);
			
			psmt.setString(1, leave.getYear());
			psmt.setString(2, leave.getMonth());
			psmt.setInt(3, leave.getNumOfdays());
			psmt.setString(4, leave.getDateTaken());
			psmt.setString(5, "Requested");
			psmt.setString(6, leave.getComments());
			psmt.setString(7, leave.getAssociateId());

			psmt.executeUpdate();
			response = "Success";
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		finally {

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
	
	public List<Leave> getAllLeaveDetails(String yr, String mo, String assoId) throws ClassNotFoundException, SQLException {
		List<Leave> leaveList = new ArrayList<Leave>();

		Connection cnn = DBConnection.getConnection();
		
		//sql to get only the records for the current year
		PreparedStatement psmt = cnn.prepareStatement("select * from leaveplan where associate_id=? and year_taken=? and month_taken=?");
		psmt.setString(1, assoId);
		psmt.setString(2, yr);
		psmt.setString(3, mo);
		ResultSet rs = psmt.executeQuery();

		while (rs.next()) {
			int id=rs.getInt("id");
			String year = rs.getString("year_taken");
			String month = rs.getString("month_taken");
			int numOfdays = rs.getInt("num_of_days");
			String dateTaken = rs.getString("date_taken");
			String leaveStatus = rs.getString("leave_status");
			String comments = rs.getString("comments");
			String associateId=rs.getString("associate_id");

			leaveList.add(new Leave(id,year, month, numOfdays, dateTaken, leaveStatus,comments,associateId));
		}

		cnn.close();
		return leaveList;
	}
	
	public Leave getLeaveById(String leaveId) throws ClassNotFoundException, SQLException {
		Leave leave = null;
		int lid=Integer.parseInt(leaveId);
		
		Connection cnn = DBConnection.getConnection();
		
		PreparedStatement psmt = cnn.prepareStatement("select * from leaveplan where id=?");
		psmt.setInt(1, lid);
		ResultSet rs = psmt.executeQuery();

		while (rs.next()) {
			int id = rs.getInt("id");
			String year = rs.getString("year_taken");
			String month = rs.getString("month_taken");
			int numOfdays = rs.getInt("num_of_days");
			String dateTaken = rs.getString("date_taken");
			String leaveStatus = rs.getString("leave_status");
			String comments = rs.getString("comments");
			String associateId=rs.getString("associate_id");

			leave = new Leave(id,year, month, numOfdays, dateTaken, leaveStatus,comments,associateId);
		}

		cnn.close();
		return leave;
	}
	
	public String updateLeave(Leave leave) {
		Connection cnn = null;
		PreparedStatement psmt = null;
		String response = null;
		
		try {
			cnn = DBConnection.getConnection();
			String sql = "update leaveplan set num_of_days=?, date_taken=?, leave_status=?, comments=? where id=?";
			
			psmt = cnn.prepareStatement(sql);
			
			psmt.setInt(1, leave.getNumOfdays());
			psmt.setString(2, leave.getDateTaken());
			psmt.setString(3, leave.getStatus());
			psmt.setString(4, leave.getComments());
			psmt.setInt(5, leave.getId());

			psmt.executeUpdate();
			response = "Success";
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		finally {

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
	
}
