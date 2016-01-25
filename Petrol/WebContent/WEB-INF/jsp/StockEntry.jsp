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
<title>StockEntry</title>
<jsp:include page="Header.jsp" />
<link rel="stylesheet" href="/Petrol/css/Main.css">
</head>
<body>
	<form action="StockEntry" method="post">

		<div class="wrapper">

		<table width="100%">  
				<tr >
					<%-- <td align="left">Select Date  <input type="date" class="inputDate" name="date" min=<%=request.getAttribute("minDate")%> max=<%=request.getAttribute("maxDate")%> required></td> --%>
					<td align="left">Select Date  <input type="date" class="inputDate" name="date" required></td>
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
					
					<td align="right"><h1 style="padding-right: 20px;"> STOCK ENTRY </h1></td>
				</tr>
		</table>
			<table border="1" style=" width: 100% " padding: 5px >
				<tr>
					<td align="center">Tank</td>
					<td align="center">1</td>
					<td align="center">2</td>
					<td align="center">3</td>
					<td align="center">4</td>
					<td align="center">5</td>
					<td align="center">6</td>
				</tr>
				<tr>
					<td align="center">MS - Receipt</td>
					<td align="center"><input type="number" name="msReceipt1" /></td>
					<td align="center"><input type="number" name="msReceipt2" /></td>
					<td align="center"><input type="number" name="msReceipt3" /></td>
					<td align="center"><input type="number" name="msReceipt4" /></td>
					<td align="center"><input type="number" name="msReceipt5" /></td>
					<td align="center"><input type="number" name="msReceipt6" /></td>
				</tr>
				<tr>
					<td align="center">MS - Closing Stock</td>
					<td align="center"><input type="number" name="msOpeningStock1" /></td>
					<td align="center"><input type="number" name="msOpeningStock2" /></td>
					<td align="center"><input type="number" name="msOpeningStock3" /></td>
					<td align="center"><input type="number" name="msOpeningStock4" /></td>
					<td align="center"><input type="number" name="msOpeningStock5" /></td>
					<td align="center"><input type="number" name="msOpeningStock6" /></td>
				</tr>

			</table>
			<br/><br/>
			<table border="1" style="width: 100%"padding: 5px; >
				<tr>
					<td align="center">Tank</td>
					<td align="center">1</td>
					<td align="center">2</td>
					<td align="center">3</td>
					<td align="center">4</td>
					<td align="center">5</td>
					<td align="center">6</td>
				</tr>
				<tr>
					<td align="center">HSD - Receipt</td>
					<td align="center"><input type="number" name="hsdReceipt1" /></td>
					<td align="center"><input type="number" name="hsdReceipt2" /></td>
					<td align="center"><input type="number" name="hsdReceipt3" /></td>
					<td align="center"><input type="number" name="hsdReceipt4" /></td>
					<td align="center"><input type="number" name="hsdReceipt5" /></td>
					<td align="center"><input type="number" name="hsdReceipt6" /></td>
				</tr>
				<tr>
					<td align="center">HSD - Closing Stock</td>
					<td align="center"><input type="number" name="hsdOpeningStock1" /></td>
					<td align="center"><input type="number" name="hsdOpeningStock2" /></td>
					<td align="center"><input type="number" name="hsdOpeningStock3" /></td>
					<td align="center"><input type="number" name="hsdOpeningStock4" /></td>
					<td align="center"><input type="number" name="hsdOpeningStock5" /></td>
					<td align="center"><input type="number" name="hsdOpeningStock6" /></td>
				</tr>


			</table>
			<br/><br/>
			<table border="1" style="width: 100%"padding: 5px; >
				<tr>
					<td align="center">Tank</td>
					<td align="center">1</td>
					<td align="center">2</td>
					<td align="center">3</td>
					<td align="center">4</td>
					<td align="center">5</td>
					<td align="center">6</td>
				</tr>
				<tr>
					<td align="center">Power - Receipt</td>
					<td align="center"><input type="number" name="powerReceipt1" /></td>
					<td align="center"><input type="number" name="powerReceipt2" /></td>
					<td align="center"><input type="number" name="powerReceipt3" /></td>
					<td align="center"><input type="number" name="powerReceipt4" /></td>
					<td align="center"><input type="number" name="powerReceipt5" /></td>
					<td align="center"><input type="number" name="powerReceipt6" /></td>
				</tr>
				<tr>
					<td align="center">Power - Closing Stock</td>
					<td align="center"><input type="number" name="powerOpeningStock1" /></td>
					<td align="center"><input type="number" name="powerOpeningStock2" /></td>
					<td align="center"><input type="number" name="powerOpeningStock3" /></td>
					<td align="center"><input type="number" name="powerOpeningStock4" /></td>
					<td align="center"><input type="number" name="powerOpeningStock5" /></td>
					<td align="center"><input type="number" name="powerOpeningStock6" /></td>
				</tr>
			</table>
			<br /><br />
			<div style=" text-align: center; margin: 0 auto 10px auto; width: 250px;">
					<input type="submit" value="Submit"/>
			</div> 
		</div>
	</form>
</body>
</html>