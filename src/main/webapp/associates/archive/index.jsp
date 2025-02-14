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
<title></title>
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
			<div id="menu">
				<ul>
					<li class="current_page_item"><a href="request_leave.jsp" accesskey="1" title="">Request Leave</a></li>
					<li><a href="view_leave.jsp" accesskey="2" title="">Edit Leave</a></li>
				</ul>
			</div>
</div>

<div class="wrapper" >
	<!--fill order section-->
	<div id="tbldiv" class="container">

<h3 style="text-align:center">Your Current Outstanding Leave Plan (in days)</h3>
	<table id="fill-table">
		<tr>
			<th>
			Associate ID
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
	
	<tr>
	
	<% LeavePlanView lpv = new Gson().fromJson(LeavePlanServlet.getLeavePlanView(), LeavePlanView.class); %>
		<td>
			<%= lpv.getAssociateId() %>
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
	<p>Please enter the info below to request leave</p>
	<div id="leave-entry">
	<fieldset>
	<form action="/leaveRequest" method="post">
			<table style="with: 50%">
			<!--  
				<tr>
					<td>Year</td>
					<td><input type="text" name="year_taken" value="${LeavePlanServlet.getCurrentYear()}" required /></td>
				</tr>
				<tr>
					<td>Month</td>
					<td>
						<select name="month_taken" required>
						    <option value="January" selected>January</option>
						    <option value="February">February</option>
						    <option value="March">March</option>
						    <option value="April">April</option>
						    <option value="May">May</option>
						    <option value="June">June</option>
						    <option value="July">July</option>
						    <option value="August">August</option>
						    <option value="September">September</option>
						    <option value="October">October</option>
						    <option value="November">November</option>
						    <option value="December">December</option>
  						</select>
					</td>
				</tr> 
			-->
				<tr>
					<td>Number of Days</td>
					<td><input type="number" name="num_of_days" value="1" min="1" max="3" onchange="checkNumOfDays(this.value)" required/></td>
				</tr>
				<tr>
					<td>Date(s) Taken</td>
					<td>
					<input type="date" name="date_taken_1" required/>
					<input id="date2" type="hidden" name="date_taken_2" required/>
					<input id="date3" type="hidden" name="date_taken_3" required/>
					</td>
				</tr>
				<tr>
					<td>Comments</td>
					<td><input type="text" name="comments"/></td>
				</tr>
			</table>
			<input type="submit" value="Submit" class="button"/>
			<a href="view_leave.jsp" class="button">Cancel</a>
			</form>
	</fieldset>
	</div>	
	
 	<p></p>
	<p><strong>*Note:</strong> If more than 3 leave days are requested, please seek out and get approval from your Manager!</p>

	<div>

</div>

<div id="copyright" class="container">
	<p>&copy; Untitled. All rights reserved. | Photos by <a href="http://fotogrph.com/">Fotogrph</a> | Design by <a href="http://templated.co" rel="nofollow">TEMPLATED</a>.</p>
</div>
</body>
</html>
