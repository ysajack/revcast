<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<!--
Design by TEMPLATED
http://templated.co
Released for free under the Creative Commons Attribution License

Name       : Cerulean
Description: A two-column, fixed-width design with dark color scheme.
Version    : 1.0
Released   : 20131223

-->
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.cognizant.revcast.servlets.LeavePlanServlet" %>
<%@ page import="com.cognizant.revcast.servlets.AssociateServlet" %>
<%@ page import="com.cognizant.revcast.models.LeavePlanView" %>
<%@ page import="com.cognizant.revcast.models.Leave" %>
<%@ page import="com.cognizant.revcast.models.Associate" %>
<%@ page import="com.cognizant.revcast.servlets.LeaveDetailsServlet" %>
<%@ page import="java.util.List" %>
<%@ page import="com.google.gson.Gson" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Leave Details</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link href="http://fonts.googleapis.com/css?family=Source+Sans+Pro:200,300,400,600,700,900|Quicksand:400,700|Questrial" rel="stylesheet" />
<link href="../default.css" rel="stylesheet" type="text/css" media="all" />
<link href="../fonts.css" rel="stylesheet" type="text/css" media="all" />
<script 
src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js">
</script>
<script src="../scripts.js"></script>

<!--[if IE 6]><link href="default_ie6.css" rel="stylesheet" type="text/css" /><![endif]-->

</head>
<body>
<div id="header-wrapper">
	<div id="header" class="container">
		<div id="logo">
			<h1 style="color:#4913ec;">Cognizant</h1>
	</div>
	<div>
	<h1 style="color:white;padding-left: 200px;padding-bottom: 20px;">RevCast</h1>
</div>
</div>
<div id="page-wrapper">

<!-- Navigation menu -->
  <div id="menu2">
	<ul>
		<li><a href="../index.jsp">Management</a>
			<ul>	
				<li><a href="../index.jsp">Projects</a></li>
				<li><a href="../resources.jsp">Resources</a></li>
			    <li><a href="../allocation.jsp">Allocation</a></li>
			    <li><a href="../leave.jsp">Leave Plan</a></li>
			    <li><a href="../forecast.jsp">Forecast</a></li>
			    <!-- <li><a href="../report.jsp">Report</a></li> -->
			</ul>
		</li>
		<li><a href="request_leave.jsp">Associates</a>
			<ul>	
				<li><a href="request_leave.jsp">Request Leaves</a></li>
				<li><a href="view_leave.jsp">Edit Leaves</a></li>
			</ul>
		</li>
		<li><a href="../admin/add_associate.jsp">Admin</a>
			<ul>	
				<li><a href="../admin/add_associate.jsp">Add Associates</a></li>
				<li><a href="../admin/add_project.jsp">Add Projects</a></li>
				<li><a href="../admin/view_allocation.jsp">Update Allocation</a></li>
				<li><a href="../admin/approve_leave.jsp">Approve Leaves</a></li>
				<li><a href="../admin/add_holiday.jsp">Add Holidays</a></li>
			</ul>
		</li>
		
		<li><a href="../about.jsp">About</a></li>
	</ul>
</div>
<!-- End of Navigation menu -->

<!--
			<div id="menu">
				<ul>
					<li class="current_page_item"><a href="request_leave.jsp" accesskey="1" title="">Request Leave</a></li>
					<li><a href="view_leave.jsp" accesskey="2" title="">Edit Leave</a></li>
				</ul>
			</div>
</div>
-->

<div class="wrapper" >
	<!--fill order section-->
	<div id="tbldiv" class="container">

<h3 style="text-align:center">Your Current Outstanding Leave Plan (in days)</h3>
	<table id="fill-table">
	
	<% List<Associate> list = AssociateServlet.getAllAssociates();
	String associateId = list.get(0).getAssociateId();
	String selectedAssociate = request.getParameter("associateId");
	int e=1;
	if(selectedAssociate != null){
		associateId = selectedAssociate;
		e=0;
	}
	LeavePlanView lpv = new Gson().fromJson(LeavePlanServlet.getLeavePlanViewByAssociate(associateId), LeavePlanView.class); %>
	
		<tr>
			<th>
			Associate ID
			</th>
			<th>
			Year
			</th>
			<th>
			<a href="leave_details.jsp?month_taken=January&associateId=<%=associateId %>">Jan</a>
			</th>
			<th>
			<a href="leave_details.jsp?month_taken=February&associateId=<%=associateId %>">Feb</a>
			</th>
			<th>
			<a href="leave_details.jsp?month_taken=March&associateId=<%=associateId %>">March</a>
			</th>
			<th>
			<a href="leave_details.jsp?month_taken=April&associateId=<%=associateId %>">April</a>
			</th>
			<th>
			<a href="leave_details.jsp?month_taken=May&associateId=<%=associateId %>">May</a>
			</th>
			<th>
			<a href="leave_details.jsp?month_taken=June&associateId=<%=associateId %>">Jun</a>
			</th>
			<th>
			<a href="leave_details.jsp?month_taken=July&associateId=<%=associateId %>">Jul</a>
			</th>
			<th>
			<a href="leave_details.jsp?month_taken=August&associateId=<%=associateId %>">Aug</a>
			</th>
			<th>
			<a href="leave_details.jsp?month_taken=September&associateId=<%=associateId %>">Sep</a>
			</th>
			<th>
			<a href="leave_details.jsp?month_taken=October&associateId=<%=associateId %>">Oct</a>
			</th>
			<th>
			<a href="leave_details.jsp?month_taken=November&associateId=<%=associateId %>">Nov</a>
			</th>
			<th>
			<a href="leave_details.jsp?month_taken=December&associateId=<%=associateId %>">Dec</a>
			</th>
	</tr>
	
	<tr>

<!-- Associate selection dropdown -->	
<form action="view_leave.jsp" method="post"> 
		<td>
			<select id="select-associate" name="associateId" onchange="this.form.submit()">
				<option>
					<%= lpv.getAssociateId() %>
				</option>
				<%for(int i=e;i<list.size();i++){ 
					String populatedAssociate = list.get(i).getAssociateId();%>
					<option value="<%= populatedAssociate %>"><%= populatedAssociate %></option>
				<%}%>
			</select>
	</form>
		</td>
		
		<td>
			<%= lpv.getYear() %>
		</td>
		<td>
			<%= lpv.getMonth().getJan() %>
		</td>
		<td>
			<%= lpv.getMonth().getFeb() %>
		</td>
		<td>
			<%= lpv.getMonth().getMar() %>
		</td>
		<td>
			<%= lpv.getMonth().getApr() %>
		</td>
		<td>
			<%= lpv.getMonth().getMay() %>
		</td>
		<td>
			<%= lpv.getMonth().getJun() %>
		</td>
		<td>
			<%= lpv.getMonth().getJul() %>
		</td>
		<td>
			<%= lpv.getMonth().getAug() %>
		</td>
		<td>
			<%= lpv.getMonth().getSep() %>
		</td>
		<td>
			<%= lpv.getMonth().getOct() %>
		</td>
		<td>
			<%= lpv.getMonth().getNov() %>
		</td>
		<td>
			<%= lpv.getMonth().getDec() %>
		</td>
	</tr>
	</table>

	<!--end of fill order section div-->
	<p>Please click on the month above to view or edit leave</p>
	
	<% String str = LeaveDetailsServlet.getAllLeaveDetails(lpv.getYear(),request.getParameter("month_taken"),lpv.getAssociateId());
	   Leave[] lvArr = new Gson().fromJson(str, Leave[].class);
	   
	   if(lvArr.length == 0){%>
	   <p><h3>You have no leaves in this month</h3></p>
	 <%}else{%>
	 
	<% for(Leave lv : lvArr){
		String month = lv.getMonth();
		String numOfDays = String.valueOf(lv.getNumOfdays());
		String dates = lv.getDateTaken();
		String status = lv.getStatus();
		String comments = lv.getComments();
	%> 
	 
	<div id="leaveDetails">
	<fieldset>
			<table style="with: 50%">
				<tr>
					<td>Month:</td>
					<td><%= month %></td>
				</tr>
				<tr>
					<td>Number of Days:</td>
					<td><%= numOfDays %></td>
				</tr>
				<tr>
					<td>Dates Taken:</td>
					<td><%= dates %></td>
				</tr>
				<tr>
					<td>Status:</td>
					<td><%= status %></td>
				</tr>
				<tr>
					<td>Comments:</td>
					<td><%= comments %></td>
				</tr>
			
<% if(lvArr.length != 0){%>			
			</table>
			<% if(lv.getStatus().equals("Confirmed") || lv.getStatus().equals("Approved")){ %>
			<button class="button" style="display:none" >Edit</button>
			<%}else{ %>
			<a href="edit_leave.jsp?leaveId=<%=lv.getId() %>&associateId=<%=associateId %>"  class="button">Edit</a>
			<%}%>
			<a href="view_leave.jsp" class="button">Cancel</a>
				
	</fieldset>
	</div>	
	
<%}}%>	
 	<p></p>
	<p><strong>*Note:</strong> If the Status is approved or confirmed, it will not be editable. Please speak with your Manager!</p>
	
<%} %>	
	
	<div>

</div>


<div id="copyright" class="container">
	<p>&copy; Untitled. All rights reserved. | Photos by <a href="http://fotogrph.com/">Fotogrph</a> | Design by <a href="http://templated.co" rel="nofollow">TEMPLATED</a>.</p>
</div>
</body>
</html>
