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
<%@ page import="com.cognizant.revcast.models.Project" %>
<%@ page import="java.util.List" %>
<%@ page import = "com.google.gson.Gson" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Report</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link href="http://fonts.googleapis.com/css?family=Source+Sans+Pro:200,300,400,600,700,900|Quicksand:400,700|Questrial" rel="stylesheet" />
<link href="default.css" rel="stylesheet" type="text/css" media="all" />
<link href="fonts.css" rel="stylesheet" type="text/css" media="all" />

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
		<li><a href="index.jsp">Management</a>
			<ul>	
				<li><a href="index.jsp">Projects</a></li>
				<li><a href="resources.jsp">Resources</a></li>
			    <li><a href="allocation.jsp">Allocation</a></li>
			    <li><a href="leave.jsp">Leave Plan</a></li>
			    <li><a href="forecast.jsp">Forecast</a></li>
			    <li><a href="report.jsp">Report</a></li>
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

<!--
			<div id="menu">
				<ul>
					<li class="current_page_item"><a href="index.jsp" accesskey="1" title="">Projects</a></li>
					<li><a href="resources.jsp" accesskey="2" title="">Resources</a></li>
					<li><a href="allocation.jsp" accesskey="3" title="">Allocation</a></li>
					<li><a href="#" accesskey="3" title="">Leave Plan</a></li>
					<li><a href="forecast.jsp" accesskey="3" title="">Forecast</a></li>
					<li><a href="report.jsp" accesskey="4" title="">Report</a></li>
				</ul>
			</div>
</div>
-->

<div class="wrapper" >
<h3 style="text-align:center">Work In Progress...</h3>
	<!--fill order section-->
	<div id="tbldiv" class="container">

		<table id="fill-table">
			<tr>
				<th>
				BIO
				</th>
				<th>
				Project
				</th>
				<th>
				Jan
				</th>
				<th>
				Feb
				</th>
				<th>
				Apr
				</th>
				<th>
				May
				</th>
				<th>
				Jun
				</th>
				<th>
				Jul
				</th>
				<th>
				Aug
				</th>
				<th>
				Sep
				</th>
				<th>
				Oct
				</th>
				<th>
				Nov
				</th>
				<th>
				Dec
				</th>
		</tr>

		<tr>
			<td>
			Digital
			</td>
			<td style="color: green">
			FDL
			</td>
			<td>
				$ 16,800
			</td>
			<td>
				$ 16,800
			</td>
			<td>
				$ 16,800
			</td>
			<td>
				$ 17,600
			</td>
			<td>
				$ 15,400
			</td>
			<td>
				$ 16,800
			</td>
			<td>
				$ 16,800
			</td>
			<td>
				$ 16,800
			</td>
			<td>
				$ 16,800
			</td>
			<td>
				$ 16,800
			</td>
			<td>
				$ 16,800
			</td>
		</tr>
	
		</table>

	<!--end of fill order section div-->
	<div>

</div>

<div id="copyright" class="container">
	<p>&copy; Untitled. All rights reserved. | Photos by <a href="http://fotogrph.com/">Fotogrph</a> | Design by <a href="http://templated.co" rel="nofollow">TEMPLATED</a>.</p>
</div>
</body>
</html>
