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
<%@ page import="com.cognizant.revcast.servlets.ProjectServlet" %>
<%@ page import="com.cognizant.revcast.servlets.LeavePlanServlet" %>
<%@ page import="com.cognizant.revcast.models.ProjectAssociateView" %>
<%@ page import="com.cognizant.revcast.models.ApproveLeaveView" %>
<%@ page import="com.cognizant.revcast.models.Project" %>
<%@ page import="com.cognizant.revcast.models.ProjectBean" %>
<%@ page import="java.util.List" %>
<%@ page import = "com.google.gson.Gson" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Approve Leaves</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link href="http://fonts.googleapis.com/css?family=Source+Sans+Pro:200,300,400,600,700,900|Quicksand:400,700|Questrial" rel="stylesheet" />
<link href="../default.css" rel="stylesheet" type="text/css" media="all" />
<link href="fonts.css" rel="stylesheet" type="text/css" media="all" />

<!--[if IE 6]><link href="default_ie6.css" rel="stylesheet" type="text/css" /><![endif]-->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
<script src="../scripts.js" ></script>

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
			<div id="menu">
				<ul>
					<li class="current_page_item"><a href="add_project.jsp" accesskey="1" title="">Add Projects</a></li>
					<li><a href="add_associate.jsp" accesskey="2" title="">Add Resources</a></li>
					<li><a href="view_allocation.jsp" accesskey="2" title="">Update Allocation</a></li>
					<li><a href="approve_leave.jsp" accesskey="2" title="">Approve Leaves</a></li>
					<li><a href="add_holiday.jsp" accesskey="2" title="">Add Holidays</a></li>
				</ul>
			</div>
</div>

<div class="wrapper" >

<div style="text-align:center;"><h2>Outstanding Leave Requests</h2></div>

<div id="filterdiv">
</div>
	
	<!--fill order section-->
	<div id="tbldiv" class="container">

	<table id="approve-leave">
		<tr>
			<th>
			BIO
			</th>
			<th>
			Project
			</th>
			<th>
			Project Name
			</th>
			<th>
			Associate ID
			</th>
			<th>
			Associate Name
			</th>
			<th>
			Year
			</th>
			<th>
			Month
			</th>
			<th>
			Leave Request
			</th>
			<th>
			Comments
			</th>
			<th>
			Action
			</th>
	</tr>
	<% 	ApproveLeaveView[] list = new Gson().fromJson(LeavePlanServlet.getApproveLeaveViewForAllAssociates(), ApproveLeaveView[].class); 
	  	for(ApproveLeaveView apl : list){%>
	<tr >
		<td>
			<%= apl.getProject().getBio() %>
		</td>
		<td>
			<%= apl.getProject().getProjectId() %>
		</td>
		<td>
			<%= apl.getProject().getProjectName() %>
		</td>
		<td>
			<%= apl.getAssociate().getAssociateId() %>
		</td>
		<td>
			<%= apl.getAssociate().getAssociateName() %>
		</td>
		<td>
			<%= apl.getLeave().getYear() %>
		</td>
		<td>
			<%= apl.getLeave().getMonth() %>
		</td>
		<td>
			<%= apl.getLeave().getDateTaken() %>
		</td>
		<td>
			<%= apl.getLeave().getComments() %>
		</td>
		<td>
			<form method="post" action="/approveLeave?leaveId=<%= apl.getLeave().getId() %>">
			<input type="submit" value="Approve">
			</form>
		</td>
		
	</tr>
		<%}%>
			
	</table>

	<!--end of fill order section div-->
	<div>

</div>

<!-- <div><p>Note: If there're empty fields, it means projects or associates have not been allocated.</p></div>-->

<div id="copyright" class="container">
	<p>&copy; Untitled. All rights reserved. | Photos by <a href="http://fotogrph.com/">Fotogrph</a> | Design by <a href="http://templated.co" rel="nofollow">TEMPLATED</a>.</p>
</div>
</body>
</html>
