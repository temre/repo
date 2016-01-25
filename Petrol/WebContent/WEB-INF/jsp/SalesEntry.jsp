<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@page import="com.kavi.entity.user.LoginEn"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"
	xmlns:f="http://java.sun.com/jsf/core"
	xmlns:h="http://java.sun.com/jsf/html">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>SalesEntry</title>
<jsp:include page="Header.jsp" />
<link rel="stylesheet" href="/Petrol/css/Main.css">
</head>
<body>
	<form action="SalesEntry" method="post">

		<div class="wrapper">

	<table width="100%">  
				<tr >
					<%-- <td align="left">Select Date  <input type="date" class="inputDate" name="date" min=<%=request.getAttribute("minDate")%> max=<%=request.getAttribute("maxDate")%> required></td> --%>
					<td align="left">Select Date  <input type="date" class="inputDate" name="date"  required></td>
					<td align="center">
						<%
							String userType= ((LoginEn) request.getSession().getAttribute("loginEn")).getUserType();
							if(null != userType && userType.equals("admin"))
							{
								out.print("User Id <input type=\"text\" placeholder=\"enter user id\" name=\"user\" required>");
							}
						%>	
					</td>
					
					<td align="center"><h3 align="center" style="color:black"><%	if(null != request.getAttribute("message")) out.print(request.getAttribute("message")); %></h3>
							<h3 align="center" style="color:black"><% if(null != request.getAttribute("exmsg")) out.print(request.getAttribute("exmsg"));%></h3>
							<h3 align="center"><% if(null != request.getAttribute("successMessage")) out.print(request.getAttribute("successMessage"));%></h3>
					</td>
					
					<td align="right"><h1 style="padding-right: 20px;"> SALES ENTRY </h1></td>
				</tr>
	</table>
 			 
	<br/>
			<table width="100%" border="1">  
				<tr >
					<td align="center">Nozzle</td>
					<td align="center">1</td>
					<td align="center">2</td>
					<td align="center">3</td>
					<td align="center">4</td>
					<td align="center">5</td>
					<td align="center">6</td>
					<td align="center">7</td>
					<td align="center">8</td>
					<td align="center">9</td>
					<td align="center">10</td>
				</tr>
				<tr>
					<td align="center">MS - Meter Reading</td>
					<td align="center"><input type="number" style="width:100px;" name="msMeterReading1" /></td>
					<td align="center"><input type="number" style="width:100px;" name="msMeterReading2" /></td>
					<td align="center"><input type="number" style="width:100px;" name="msMeterReading3" /></td>
					<td align="center"><input type="number" style="width:100px;" name="msMeterReading4" /></td>
					<td align="center"><input type="number" style="width:100px;" name="msMeterReading5" /></td>
					<td align="center"><input type="number" style="width:100px;" name="msMeterReading6" /></td>
					<td align="center"><input type="number" style="width:100px;" name="msMeterReading7" /></td>
					<td align="center"><input type="number" style="width:100px;" name="msMeterReading8" /></td>
					<td align="center"><input type="number" style="width:100px;" name="msMeterReading9" /></td>
					<td align="center"><input type="number" style="width:100px;" name="msMeterReading10" /></td>
				</tr>
				<tr>
					<td align="center">MS - Pump Testing</td>
					<td align="center"><input type="number" style="width:100px;" name="msPumpTesting1" /></td>
					<td align="center"><input type="number" style="width:100px;" name="msPumpTesting2" /></td>
					<td align="center"><input type="number" style="width:100px;" name="msPumpTesting3" /></td>
					<td align="center"><input type="number" style="width:100px;" name="msPumpTesting4" /></td>
					<td align="center"><input type="number" style="width:100px;" name="msPumpTesting5" /></td>
					<td align="center"><input type="number" style="width:100px;" name="msPumpTesting6" /></td>
					<td align="center"><input type="number" style="width:100px;" name="msPumpTesting7" /></td>
					<td align="center"><input type="number" style="width:100px;" name="msPumpTesting8" /></td>
					<td align="center"><input type="number" style="width:100px;" name="msPumpTesting9" /></td>
					<td align="center"><input type="number" style="width:100px;" name="msPumpTesting10" /></td>
				</tr>

			</table>
			<br/><br/>
			<table border="1" style="width:100%"padding: 5px; >
				<tr>
					<td align="center">Nozzle</td>
					<td align="center">1</td>
					<td align="center">2</td>
					<td align="center">3</td>
					<td align="center">4</td>
					<td align="center">5</td>
					<td align="center">6</td>
					<td align="center">7</td>
					<td align="center">8</td>
					<td align="center">9</td>
					<td align="center">10</td>
				</tr>
				<tr>
					<td align="center">HSD - Meter Reading</td>
					<td align="center"><input type="number" style="width:100px;" name="hsdMeterReading1" /></td>
					<td align="center"><input type="number" style="width:100px;" name="hsdMeterReading2" /></td>
					<td align="center"><input type="number" style="width:100px;" name="hsdMeterReading3" /></td>
					<td align="center"><input type="number" style="width:100px;" name="hsdMeterReading4" /></td>
					<td align="center"><input type="number" style="width:100px;" name="hsdMeterReading5" /></td>
					<td align="center"><input type="number" style="width:100px;" name="hsdMeterReading6" /></td>
					<td align="center"><input type="number" style="width:100px;" name="hsdMeterReading7" /></td>
					<td align="center"><input type="number" style="width:100px;" name="hsdMeterReading8" /></td>
					<td align="center"><input type="number" style="width:100px;" name="hsdMeterReading9" /></td>
					<td align="center"><input type="number" style="width:100px;" name="hsdMeterReading10" /></td>
				</tr>
				<tr>
					<td align="center">HSD - Pump Testing</td>
					<td align="center"><input type="number" style="width:100px;" name="hsdPumpTesting1" /></td>
					<td align="center"><input type="number" style="width:100px;" name="hsdPumpTesting2" /></td>
					<td align="center"><input type="number" style="width:100px;" name="hsdPumpTesting3" /></td>
					<td align="center"><input type="number" style="width:100px;" name="hsdPumpTesting4" /></td>
					<td align="center"><input type="number" style="width:100px;" name="hsdPumpTesting5" /></td>
					<td align="center"><input type="number" style="width:100px;" name="hsdPumpTesting6" /></td>
					<td align="center"><input type="number" style="width:100px;" name="hsdPumpTesting7" /></td>
					<td align="center"><input type="number" style="width:100px;" name="hsdPumpTesting8" /></td>
					<td align="center"><input type="number" style="width:100px;" name="hsdPumpTesting9" /></td>
					<td align="center"><input type="number" style="width:100px;" name="hsdPumpTesting10" /></td>
				</tr>


			</table>
			<br/><br/>
			<table border="1" style="width: 100%"padding: 5px; >
				<tr>
					<td align="center">Nozzle</td>
					<td align="center">1</td>
					<td align="center">2</td>
					<td align="center">3</td>
					<td align="center">4</td>
					<td align="center">5</td>
					<td align="center">6</td>
					<td align="center">7</td>
					<td align="center">8</td>
					<td align="center">9</td>
					<td align="center">10</td>
				</tr>
				<tr>
					<td align="center">Power - Meter Reading</td>
					<td align="center"><input type="number" style="width:100px;" name="powerMeterReading1" /></td>
					<td align="center"><input type="number" style="width:100px;" name="powerMeterReading2" /></td>
					<td align="center"><input type="number" style="width:100px;" name="powerMeterReading3" /></td>
					<td align="center"><input type="number" style="width:100px;" name="powerMeterReading4" /></td>
					<td align="center"><input type="number" style="width:100px;" name="powerMeterReading5" /></td>
					<td align="center"><input type="number" style="width:100px;" name="powerMeterReading6" /></td>
					<td align="center"><input type="number" style="width:100px;" name="powerMeterReading7" /></td>
					<td align="center"><input type="number" style="width:100px;" name="powerMeterReading8" /></td>
					<td align="center"><input type="number" style="width:100px;" name="powerMeterReading9" /></td>
					<td align="center"><input type="number" style="width:100px;" name="powerMeterReading10" /></td>
				</tr>
				<tr>
					<td align="center">Power - Pump Testing</td>
					<td align="center"><input type="number" style="width:100px;" name="powerPumpTesting1" /></td>
					<td align="center"><input type="number" style="width:100px;" name="powerPumpTesting2" /></td>
					<td align="center"><input type="number" style="width:100px;" name="powerPumpTesting3" /></td>
					<td align="center"><input type="number" style="width:100px;" name="powerPumpTesting4" /></td>
					<td align="center"><input type="number" style="width:100px;" name="powerPumpTesting5" /></td>
					<td align="center"><input type="number" style="width:100px;" name="powerPumpTesting6" /></td>
					<td align="center"><input type="number" style="width:100px;" name="powerPumpTesting7" /></td>
					<td align="center"><input type="number" style="width:100px;" name="powerPumpTesting8" /></td>
					<td align="center"><input type="number" style="width:100px;" name="powerPumpTesting9" /></td>
					<td align="center"><input type="number" style="width:100px;" name="powerPumpTesting10" /></td>
				</tr>


			</table>
			<br/><br/>
			<div style=" text-align: center; margin: 0 auto 10px auto; width: 250px;">
					<input type="submit" value="Submit"/>
			</div> 


		</div>
		

	</form>
</body>
</html>