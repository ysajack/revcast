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
<%@ page import="com.cognizant.revcast.models.Project" %>
<%@ page import="com.cognizant.revcast.models.ProjectBean" %>
<%@ page import="java.util.List" %>
<%@ page import = "com.google.gson.Gson" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
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
			<div> <!-- an gian -->
		<h1 style="color:white;padding-left: 200px;padding-bottom: 20px;">RevCast</h1>
   </div>
</div>

<div id="page-wrapper">

<!-- Navigation menu -->
  <div id="menu2">
	<ul>
		<li><a href="index.jsp">Management</a>
			<ul>
				<li><a href="resources.jsp">Resources</a></li>
				<li><a href="index.jsp">Projects</a></li>
			    <li><a href="allocation.jsp">Allocation</a></li>
			    <li><a href="leave.jsp">Leave Plan</a></li>
			    <li><a href="forecast.jsp">Forecast</a></li>
			    <!-- <li><a href="report.jsp">Report</a></li> -->
			</ul>
		</li>
		<li><a href="associates/request_leave.jsp">Associates</a>
			<ul>
				<li><a href="associates/request_leave.jsp">Request Leaves</a></li>
				<li><a href="associates/view_leave.jsp">Edit Leaves</a></li>
			</ul>
		</li>
		<li><a href="admin/add_associate.jsp">Admin</a>
			<ul>	
				<li><a href="admin/add_associate.jsp">Add Associates</a></li>
				<li><a href="admin/add_project.jsp">Add Projects</a></li>
				<li><a href="admin/view_allocation.jsp">Update Allocation</a></li>
				<li><a href="admin/approve_leave.jsp">Approve Leaves</a></li>
				<li><a href="admin/add_holiday.jsp">Add Holidays</a></li>
			</ul>
		</li>

		<li><a href="about.jsp">About</a></li>
	</ul>
</div>
<!-- End of Navigation menu -->

<div class="wrapper">

<!--fill order section-->
<div style="margin-left: 10%;text-align:left;">
	<br>
	<h2>This app is built in:</h2>
	<br>
		<ul>
			<li>Java, JSP, Servlet, Java Rest Services</li>
			<li>App and Services hosted in Google App Engine</li>
			<li>Connecting to MySQL hosted in Google Cloud SQL</li>
		</ul>
	<br>
	<hr>
	<br>

	<h2>Other design, techniques, and tools used:</h2>
	<br>
		<ul>
			<li>Maven App Engine, Google Cloud CLI and SDK</li>
			<li>MVC, JAX-RS Jersey</li>
		</ul>
	<br>
	<hr>
	<br>

	<h2>Application:</h2>
	<br>
	<p>Revenue Forecast System is to generate revenue forecast for Managers, and for Associates to schedule/request days off.</p>
	
	<br>
	<hr>
	<br>

	<h2>Other Applications:</h2>
	<br>
	<ul>
			<li>RX2U - Python Flask Neo4J hosted in Heroku and Google Compute Engine:</li>
			<li><a href="https://rx2u-pyflask.herokuapp.com/">https://rx2u-pyflask.herokuapp.com/</a></li>
			<br>
			<li>RX2U - Angular 4 and Java Rest Services hosted in Google Firebase, Google Compute Engine and Google Cloud SQL:</li>
			<li><a href="https://rx2u-ng4.firebaseapp.com/">https://rx2u-ng4.firebaseapp.com//</a></li>
			<br>
			<li>PHO-SG - PHP and MySQL hosted in 000WebHost:</li>
			<li><a href="http://phosg.000webhostapp.com/">http://phosg.000webhostapp.com/</a></li>
	</ul>

<div> <!-- an gian -->	
<!--end of fill order section div -->

<!--</div> an gian-->
<!-- End of wrapper -->
</div>
<!-- End of page-wrapper -->

<div id="copyright" class="container">
	<p>&copy; Untitled. All rights reserved. | Photos by <a href="http://fotogrph.com/">Fotogrph</a> | Theme Design by <a href="http://templated.co" rel="nofollow">TEMPLATED</a>.</p>
</div>
</body>
</html>
