<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@page import="com.kavi.entity.user.LoginEn"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"
	xmlns:f="http://java.sun.com/jsf/core"
	xmlns:h="http://java.sun.com/jsf/html">
	
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>DSR</title>
<jsp:include page="Header.jsp" />
<link rel="stylesheet" href="/Petrol/css/Main.css">
</head>
<body>
	<form action="DSR" method="post">

		<div class="wrapper">

			<table width="100%">
				<tr>
					<td align="left">Select Month
							<select name="month" id="month" required>
						    	<!-- <option value="">-- Select Month --</option> -->
							    <option value="1">January</option>
							    <option value="2">February</option>
							    <option value="3">March</option>
							    <option value="4">April</option>
							    <option value="5">May</option>
							    <option value="6">June</option>
							    <option value="7">July</option>
							    <option value="8">August</option>
							    <option value="9">September</option>
							    <option value="10">October</option>
							    <option value="11">November</option>
							    <option value="12">December</option>
							 </select>
					</td>
					<td align="center">
						<%
							String userType= ((LoginEn) request.getSession().getAttribute("loginEn")).getUserType();
							if(null != userType && userType.equals("admin"))
							{
								out.print("User Id <input type=\"text\" placeholder=\"enter user id\" name=\"user\" required>");
							}
						%>	
					</td>
					<td align="left">Select Product <select name="product" required>
							<option value="">-- Select a Product --</option>
							<option value="MS">MS</option>
							<option value="HSD">HSD</option>
							<option value="POWER">Power</option>
					</select></td>
					<td align="right"><h1 style="padding-right: 25px;">DSR</h1></td>
				</tr>
			</table>
				<div
					style="text-align: center; margin: 0 auto 10px auto; width: 250px;">
					<input type="submit" value="Get DSR" />
				</div>
			<h2 align="center" style="color: green"><%	if (null != request.getAttribute("message")) out.print(request.getAttribute("message")); %></h2>
			<table width="100%" border="1">
				<tr>
					<!-- Column Heading -->
					<td align="center"  style="width:100px;">Date</td>
					<!-- everyday date -->
					<td align="center"  style="width:100px;">Opening Stock</td>
					<!-- initial stock/ total stock of all tank of a user  SUM OF ALL OPENING STOCK OF TANK OF CURRENT DATE-->
					<td align="center"  style="width:100px;">Receipt</td>
					<!--  total sum of all receIpt. FIRST DAY IS ZERO.   -->
					<td align="center"  style="width:100px;">Total Stock</td>
					<!--  opening stock + total receipt-->
					<td align="center"  style="width:100px;">Sales By Meter</td>
					<!--  Sales Entry -> sum of all meter reading -->
					<td align="center"  style="width:100px;">Pump Test</td>
					<!-- Sales Entry -> sum of all pump testing -->
					<td align="center"  style="width:100px;">Net Sales By Meter</td>
					<!--   Sales By meter - pump test -->
					<td align="center"  style="width:100px;">Cum Sales</td>
					<!--  -->
					<td align="center"  style="width:100px;">Sales By DIP</td>
					<!-- today total stock - yesterday total stock -->
					<td align="center"  style="width:100px;">Stock Loss/Gain</td>
					<!-- Sales By dip - sales by meter -->
					<td align="center"  style="width:100px;">Cum Stock Loss/Gain</td>
					<!--  previous day +/- today gain or loss-->
				</tr>
				
				<c:forEach items="${list}" var="row">
					<tr>
						<td><c:out value="${row.date}" /></td>
						<td><c:out value="${row.openingStock}" /></td>
						<td><c:out value="${row.receipt}" /></td>
						<td><c:out value="${row.totalStock}" /></td>
						<td><c:out value="${row.saleByMeter}" /></td>
						<td><c:out value="${row.pumpTest}" /></td>
						<td><c:out value="${row.netSalesByMeter}" /></td>
						<td><c:out value="${row.cumSales}" /></td>
						<td><c:out value="${row.salesByDip}" /></td>
						<td><c:out value="${row.stockLG}" /></td>
						<td><c:out value="${row.cumStockLG}" /></td>
					</tr>
				</c:forEach>
			</table>
			<br />
			<br />



		</div>


	</form>
	<jsp:include page="Footer.jsp" />
</body>

</html>