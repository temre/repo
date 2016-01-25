<!DOCTYPE html>
<%@page import="com.kavi.entity.user.LoginEn"%>
<html>

<head>

	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">

	<title>Header</title>

	<link rel="stylesheet" href="/Petrol/css/header.css">
	<link href='http://fonts.googleapis.com/css?family=Cookie' rel='stylesheet' type='text/css'>
	

</head>

<body>

<header class="header">

			<!-- <a href="Login"><img src="/Petrol/images/hplogo.jpg" style="width:150px;height:115px; position: absolute; top: 0%; left: 0%; margin-top: 5px; margin-left: 5px;"></a> -->
			<a href="Login"><h1 class="heading">Online DSR</h1></a><a href="Logout" class="logout-button">Logout</a>
			<%-- <div class="header-anchor">
				<a href="SalesEntry" class="heading-anchor-text">Sales Entry</a>
				<a href="StockEntry" class="heading-anchor-text">Stock Entry</a>
				<a href="DSR" class="heading-anchor-text">DSR</a>
				<a href="FAQ.jsp" class="heading-anchor-text">FAQ</a>
				<a href="ContactUs.jsp" class="heading-anchor-text">Contact Us</a>
				<%
							String userType= ((LoginEn) request.getSession().getAttribute("loginEn")).getUserType();
							if(null != userType && userType.equals("admin"))
							{
								out.print("<a href=\"Register\"  class=\"heading-anchor-text\">Create User</a>");
								out.print("<a href=\"Report\"  class=\"heading-anchor-text\">Report</a>");
							}
				%>
				
			</div> --%><div class="header-anchor">
				<a href="SalesEntry" class="homePage-button">Sales Entry</a>
				<a href="StockEntry" class="homePage-button">Stock Entry</a>
				<a href="DSR" class="homePage-button">DSR</a>
				<%
							String userType= ((LoginEn) request.getSession().getAttribute("loginEn")).getUserType();
							if(null != userType && userType.equals("admin"))
							{
								out.print("<a href=\"Register\"  class=\"homePage-button\">Create User</a>");
								out.print("<a href=\"Report\"  class=\"homePage-button\">Report</a>");
							}
							else {
								out.print("<a href=\"ContactUs\"  class=\"homePage-button\">Contact Us</a>");
							}
				%>
				<a href="FAQ" class="homePage-button">FAQ</a>
				<a href="ChangePassword" class="homePage-button">Change Password</a>
		</div> 

</header>


</body>

</html>
