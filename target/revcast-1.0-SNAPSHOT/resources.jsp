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
<%@ page import="com.cognizant.revcast.models.ProjectAssociateView" %>
<%@ page import="com.cognizant.revcast.models.ProjectBean" %>
<%@ page import="java.util.List" %>
<%@ page import = "com.google.gson.Gson" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Resources</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link href="http://fonts.googleapis.com/css?family=Source+Sans+Pro:200,300,400,600,700,900|Quicksand:400,700|Questrial" rel="stylesheet" />
<link href="default.css" rel="stylesheet" type="text/css" media="all" />
<link href="fonts.css" rel="stylesheet" type="text/css" media="all" />

<!--[if IE 6]><link href="default_ie6.css" rel="stylesheet" type="text/css" /><![endif]-->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
<script src="scripts.js" ></script>

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
					<li class="current_page_item"><a href="index.jsp" accesskey="1" title="">Projects</a></li>
					<li><a href="resources.jsp" accesskey="2" title="">Resources</a></li>
					<li><a href="allocation.jsp" accesskey="3" title="">Allocation</a></li>
					<li><a href="leave.jsp" accesskey="4" title="">Leave Plan</a></li>
					<li><a href="forecast.jsp" accesskey="5" title="">Forecast</a></li>
					<li><a href="report.jsp" accesskey="6" title="">Report</a></li>
				</ul>
			</div>
</div>

<div class="wrapper" >

<div id="filterdiv">
	<table style="width:20%">
		<tr>
			<th width="50px">
				<!-- BIO Dropdown -->
				<select id="bybio-res" name="bio-res">
					<option value="All BIOs">All BIOs</option>
					<%String[] bioList = new Gson().fromJson(ProjectServlet.getAllDistinctBios(), String[].class);  
					 for(String bio : bioList){%>
					<option value="<%= bio %>"><%= bio %></option>
					<%} %>
				</select>
			</th>
			
			<th></th>
			
			<th width="50px">
				<!-- Project Dropdown Default list - It will be updated once BIO is selected-->
				<!-- The project dropdown will come from AJAX/scripts.js which has contents comming from ProjectDropdownServlet -->
				<select id="byproject-res"> 
				<option value="All Projects" name="allprojects">All Projects</option>
				<%ProjectBean[] prjList = new Gson().fromJson(ProjectServlet.getAllDistinctProjects(), ProjectBean[].class);  
					 for(ProjectBean prj : prjList){%>
					 <option value="<%= prj.getProjectId() %>"><%= prj.getProjectName() %></option>
					<%} %>
				</select>
			</th>
		</tr>
	</table>
</div>

	<!--fill order section-->
	<div id="tbldiv" class="container">
	<table id="fill-table">
		<tr>
			<th>
			Associate ID
			</th>
			<th>
			Associate Name
			</th>
			<th>
			Designation
			</th>
			<th>
			Status
			</th>
			<th>
			Rev Cat
			</th>
			<th>
			Practice
			</th>
			<th>
			Onsite/Offshore
			</th>
			<th>
			Rev Type
			</th>
			<th>
			BIO
			</th>
			<th>
			Project
			</th>
			<th>
			Project Name
			</th>
	</tr>
		<%
			ProjectAssociateView[] paList = new Gson().fromJson(ProjectServlet.getProjectAssociateView(), ProjectAssociateView[].class); 
				for(ProjectAssociateView pa : paList){
		%>
	<tr>
		<td>
			<%= pa.getAssociate().getAssociateId() %>
		</td>
		<td>
			<%= pa.getAssociate().getAssociateName() %>
		</td>
		<td>
			<%= pa.getAssociate().getDesignation() %>
		</td>
		<td>
			<%= pa.getAssociate().getStatus() %>
		</td>
		<td>
			<%= pa.getAssociate().getRevcat() %>
		</td>
		<td>
			<%= pa.getAssociate().getPractice() %>
		</td>
		<td>
			<%= pa.getAssociate().getOnsiteOffshore() %>
		</td>
		<td>
			<%= pa.getAssociate().getRevType() %>
		</td>
		<td>
			<%= pa.getProject().getBio() %>
		</td>
		<td>
			<%= pa.getProject().getProjectId() %>
		</td>
		<td>
			<%= pa.getProject().getProjectName() %>
		</td>
	</tr>
	<%}%>
	</table>

	<!--end of fill order section div-->
	<div>

</div>

<!-- div><p>Note: If there're empty fields, it means projects or associates have not been allocated.</p></div> -->

<div id="copyright" class="container">
	<p>&copy; Untitled. All rights reserved. | Photos by <a href="http://fotogrph.com/">Fotogrph</a> | Design by <a href="http://templated.co" rel="nofollow">TEMPLATED</a>.</p>
</div>
</body>
</html>
