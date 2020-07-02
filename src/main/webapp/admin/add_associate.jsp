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
<title>Add and Allocate Associates</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link href="http://fonts.googleapis.com/css?family=Source+Sans+Pro:200,300,400,600,700,900|Quicksand:400,700|Questrial" rel="stylesheet" />
<link href="../default.css" rel="stylesheet" type="text/css" media="all" />
<link href="../fonts.css" rel="stylesheet" type="text/css" media="all" />

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

<!-- Navigation menu -->
  <div id="menu2">
	<ul>
		<li><a href="../index.jsp">Management</a>
			<ul>	
				<li><a href="../index.jsp">Projects</a></li>
				<li><a href="../resources.jsp">Resources</a></li>
			    <li><a href="../allocation.jsp">Allocation</a></li>
			    <li><a href="../leave.jsp">Leave Plan</a></li>
	<!-- 		    <li><a href="../forecast.jsp">Forecast</a></li> -->
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
				<li><a href="add_associate.jsp">Add Associates</a></li>
				<li><a href="add_project.jsp">Add Projects</a></li>
				<li><a href="view_allocation.jsp">Update Allocation</a></li>
				<li><a href="approve_leave.jsp">Approve Leaves</a></li>
				<li><a href="add_holiday.jsp">Add Holidays</a></li>
			</ul>
		</li>
		
		<li><a href="../about.jsp">About</a></li>
	</ul>
</div>
<!-- End of Navigation menu -->

<!--
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
-->

<!-- Adding and Allocation FORM starts - For all the form data in the whole page -->
<form action="/addAssociate" method="post">

<div class="wrapper" >

<div id="associateDiv" class="container">
<div>
	<p>Please enter the info below to add an associate</p>
</div>

<!-- Associate table -->
<table id="addAssociate">
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
						RevCat
					</th>
					<th>
						Practice
					</th>
					<th>
						Onsite/Offshore
					</th>
					<th>
						RevType
					</th>
				</tr>
				<tr>
					<td><input type="text" name="associateId" size="23" required/></td>
					<td><input type="text" name="associateName" size="23" required/></td>
					<td><input type="text" name="designation" size="23" required/></td>
					<td><input type="text" name="status" size="23" required/></td>
					<td><input type="text" name="revCat" size="23" required/></td>
					<td><input type="text" name="practice" size="23" required/></td>
					<td><input type="text" name="onsiteOffshore" size="23" required/></td>
					<td><input type="text" name="revType" size="23" required/></td>
				</tr>
		</table>
		<!-- End of Associate table -->
</div>
<!-- End of Associate div -->

<div id="filterdiv">

<div>
	<p>Please use the filtering below to select and allocate the associate to a project</p>
</div>

	<table style="width:20%">
		<tr>
			<th width="50px">
				<!-- BIO Dropdown -->
				<select id="bybio-admin" name="bybio">
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
				<select id="byproject-admin"> 
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

 <fieldset>
	<table id="allocateAssociate">
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
	<% 	ProjectAssociateView[] paList = new Gson().fromJson(ProjectServlet.getProjectAssociateView(), ProjectAssociateView[].class); 
	  	for(ProjectAssociateView pa : paList){%>
	<tr >
		<td>
			<%= pa.getProject().getBio() %>
		</td>
		<td>
		<input type="text" name="projectId" value="<%= pa.getProject().getProjectId() %>" readonly="readonly"/>
		</td>
		<td>
			<%= pa.getProject().getProjectName() %>
		</td>
		<td>
			<%= pa.getProject().getProjectType() %>
		</td>
		
	<% String associateId = request.getParameter("associateId");
  	   String associateName = request.getParameter("associateName"); %>
  	   
  	<% if(associateId == null){ 
  	%>
  		<td>
  		</td>
  		<td>
  		</td>
  	<% 	
  		}
  		else {
  		%>
  		<td>
			<%= associateId %>
		</td>
		<td>
			<%= associateName %>
		</td>
	<%}%>
			<td><input type="text" name="projStart" required/></td>
			<td><input type="text" name="projEnd" required/></td>
			<td><input type="text" name="allocation" required/></td>
			<td><input type="text" name="rateCard" required/></td>
		</tr>
		<%}%>
			
	</table>
			<input type="submit" value="Submit" class="button"/>
			<a href="admin.jsp" class="button">Cancel</a>
	</fieldset>
	
	<p>Note: To allocate an associate to multiple projects, please use Update Allocation from the menu</p>

	<!--end of fill order section div-->
	<div>

</div>

</form>
<!-- FORM ends -->

<div id="copyright" class="container">
	<p>&copy; Untitled. All rights reserved. | Photos by <a href="http://fotogrph.com/">Fotogrph</a> | Design by <a href="http://templated.co" rel="nofollow">TEMPLATED</a>.</p>
</div>
</body>
</html>
