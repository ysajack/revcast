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
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.cognizant.revcast.servlets.ForecastServlet" %>
<%@ page import="com.cognizant.revcast.models.ForecastView" %>
<%@ page import = "com.google.gson.Gson" %>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Forecast</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<meta name="viewport" content="width=device-width, initial-scale=1">
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
	<!--fill order section-->
	<div id="tbldiv" class="container">
<div>
	<table id="fill-table">
		<tr>
			<th>
			Project
			</th>
			<th>
			Associate
			</th>
			<th>
			Year
			</th>
			<th>
			Jan
			</th>
			<th>
			Feb
			</th>
			<th>
			Mar
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
	
	<% ForecastView[] fcvList = new Gson().fromJson(ForecastServlet.getForecastOfAllAssociates(), ForecastView[].class); 
	   for(ForecastView fcv : fcvList){%>
	<tr>
		<td>
		<%= fcv.getProjectName() %>
		</td>
		<td>
		<%= fcv.getAssociateName() %>
		</td>
		<td>
		<%= fcv.getYear() %>
		</td>
		<td>
			$ <%= fcv.getMonth().getJan() %>
		</td>
		<td>
			$ <%= fcv.getMonth().getFeb() %>
		</td>
		<td>
			$ <%= fcv.getMonth().getMar() %>
		</td>
		<td>
			$ <%= fcv.getMonth().getApr() %>
		</td>
		<td>
			$ <%= fcv.getMonth().getMay() %>
		</td>
		<td>
			$ <%= fcv.getMonth().getJun() %>
		</td>
		<td>
			$ <%= fcv.getMonth().getJul() %>
		</td>
		<td>
			$ <%= fcv.getMonth().getAug() %>
		</td>
		<td>
			$ <%= fcv.getMonth().getSep() %>
		</td>
		<td>
			$ <%= fcv.getMonth().getOct() %>
		</td>
		<td>
			$ <%= fcv.getMonth().getNov() %>
		</td>
		<td>
			$ <%= fcv.getMonth().getDec() %>
		</td>
	</tr>
	<%} %>
	
	</table>
</div>	
	<!--end of fill order section div-->
	<div>

</div>

<div id="copyright" class="container">
	<p>&copy; Untitled. All rights reserved. | Photos by <a href="http://fotogrph.com/">Fotogrph</a> | Design by <a href="http://templated.co" rel="nofollow">TEMPLATED</a>.</p>
</div>
</body>
</html>
