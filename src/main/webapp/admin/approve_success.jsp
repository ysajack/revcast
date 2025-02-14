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
<%@ page import="com.cognizant.revcast.models.LeavePlanView" %>
<%@ page import="java.util.List" %>
<%@ page import = "com.google.gson.Gson" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Success</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link href="http://fonts.googleapis.com/css?family=Source+Sans+Pro:200,300,400,600,700,900|Quicksand:400,700|Questrial" rel="stylesheet" />
<link href="../default.css" rel="stylesheet" type="text/css" media="all" />
<link href="../fonts.css" rel="stylesheet" type="text/css" media="all" />
<script 
src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js">
</script>

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
			 <!--    <li><a href="../forecast.jsp">Forecast</a></li> -->
			    <!-- <li><a href="../report.jsp">Report</a></li> -->
			</ul>
		</li>
		<li><a href="../associates/request_leave.jsp">Associates</a>
			<ul>	
				<li><a href="../associates/request_leave.jsp">Request Leaves</a></li>
				<li><a href="../associates/view_leave.jsp">Edit Leaves</a></li>
			</ul>
		</li>
		<li><a href="add_associate.jsp">Admin</a>
			<ul>	
				<li><a href="admin/add_associate.jsp">Add Associates</a></li>
				<li><a href="admin/add_project.jsp">Add Projects</a></li>
				<li><a href="admin/view_allocation.jsp">Update Allocation</a></li>
				<li><a href="admin/approve_leave.jsp">Approve Leaves</a></li>
				<li><a href="admin/add_holiday.jsp">Add Holidays</a></li>
			</ul>
		</li>
		
		<li><a href="../about.jsp">About</a></li>
	</ul>
</div>
<!-- End of Navigation menu -->

<!-- 
			<div id="menu">
				<ul>
					<li class="current_page_item"><a href="admin/add_project.jsp" accesskey="1" title="">Add Projects</a></li>
					<li><a href="admin/add_associate.jsp" accesskey="2" title="">Add Resources</a></li>
					<li><a href="admin/view_allocation.jsp" accesskey="2" title="">Update Allocation</a></li>
					<li><a href="admin/approve_leave.jsp" accesskey="2" title="">Approve Leaves</a></li>
					<li><a href="admin/add_holiday.jsp" accesskey="2" title="">Add Holidays</a></li>
				</ul>
			</div>
</div>
-->

<div class="wrapper" >
	<!--fill order section-->
	<div id="tbldiv" class="container">
	
	<section>
	<h3 style="text-align:center;">Approve Leave is successful!</h3>
	</section>
	<div>

</div>

<div id="copyright" class="container">
	<p>&copy; Untitled. All rights reserved. | Photos by <a href="http://fotogrph.com/">Fotogrph</a> | Design by <a href="http://templated.co" rel="nofollow">TEMPLATED</a>.</p>
</div>
</body>
</html>
