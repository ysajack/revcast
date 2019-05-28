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
<%@ page import="com.cognizant.revcast.smoke.HelloAppEngine" %>
<%@ page import="com.cognizant.revcast.models.Project" %>
<%@ page import="java.util.List" %>
<%@ page import = "com.google.appengine.repackaged.com.google.gson.Gson" %>
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
					<li><a href="#" accesskey="3" title="">Leave Plan</a></li>
					<li><a href="forecast.jsp" accesskey="3" title="">Forecast</a></li>
					<li><a href="#" accesskey="4" title="">Overview</a></li>
				</ul>
			</div>
</div>



<div class="wrapper" >
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
			Project Name
			</th>
			<th>
			Type
			</th>
			<th>
			Associate ID
			</th>
			<th>
			Associate Name
			</th>
			<th>
			Start
			</th>
			<th>
			Project End Date
			</th>
			<th>
			Allocation
			</th>
			<th>
			Rate Card
			</th>
	</tr>

	<tr>
		<td>
			Digital
		</td>
		<td>
			P1234567
		</td>
		<td>
			Client Support Project
		</td>
		<td>
			BTM
		</td>
		<td>
			A12345
		</td>
		<td>
			Orange Apple
		</td>
		<td>
			5/1/18
		</td>
		<td>
			TBD
		</td>
		<td>
			100%
		</td>
		<td>
			$100
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
