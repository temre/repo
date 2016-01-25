package com.kavi.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kavi.dao.LoginDAO;
import com.kavi.entity.SalesEEn;
import com.kavi.entity.user.LoginEn;
import com.kavi.service.SalesEntryService;
import com.kavi.util.AppConstant;
import com.kavi.util.SetEntityObject;


/**
 * Servlet implementation class SalesEntry
 */
@WebServlet("/SalesEntry")
public class SalesEntry extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Do get of sale entry");
		LoginEn loginEn=(LoginEn) request.getSession().getAttribute("loginEn");
		if(loginEn.getStatus().equals(AppConstant.LoggedIn))
		{
			request=setMinMaxDate(request);
			RequestDispatcher rd= request.getRequestDispatcher("/WEB-INF/jsp/SalesEntry.jsp");
	   		rd.forward(request, response);	
		}
		else
		{
			request.setAttribute("message", "Un Authorize Access ! Please Login with your credential to access the desired content");
			RequestDispatcher rd= request.getRequestDispatcher("/Login.jsp");
	   		rd.forward(request, response);	
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Do post of sale entry");
		SalesEEn salesEn;
		boolean result=false;
		try {
			
			salesEn = new SetEntityObject().setSalesEEn(request);
			SalesEntryService salesEntryService=new SalesEntryService();
			// for admin : admin will add data of a particular user
			
			String userType= ((LoginEn) request.getSession().getAttribute("loginEn")).getUserType();
			System.out.println("userType : "+userType);
			if(null != userType && userType.equals("admin"))
			{
				String user=request.getParameter("user");
				boolean isUserExist=new LoginDAO().isUserExist(user);
				if(isUserExist)
				{
					salesEn.setUserId(user);
					result = salesEntryService.persistSalesEn(salesEn);
				}
				else
				{
					request.setAttribute("message", "Invalid User ! Please enter correct user Id");
				}
					
			}
			else
			{
				result = salesEntryService.persistSalesEn(salesEn);
			}
			
			
		} catch (ParseException e) {
			// invalid date
			request.setAttribute("message", "Invalid Date. Please select date properly. Use Google Chrome for better usability");
			request.setAttribute("exmsg", e.getMessage());
			e.printStackTrace();
		} 
		catch (NumberFormatException nfe) {
			// invalid date
			request.setAttribute("message", "Invalid Data. Please Enter only Positive Numbers");
			request.setAttribute("exmsg", "Error is "+nfe.getMessage());
			nfe.printStackTrace();
		} 
		
		catch(java.sql.SQLIntegrityConstraintViolationException icve)
		{
			request.setAttribute("message", "Invalid Data ! you have already filled data for selected date");
			request.setAttribute("exmsg", "If problem persist contact your administrator");
			// use it for logging .   request.setAttribute("exmsg", icve.getMessage());
			icve.printStackTrace();
		}
		catch (SQLException e) {
			request.setAttribute("message", "Invalid Data ! Something went wrong in Data Layer");
			request.setAttribute("exmsg", e.getMessage());
			e.printStackTrace();
		}
		catch (Exception e) {
			request.setAttribute("message", "Something went wrong. Please Try again or contact your administrator");
			request.setAttribute("exmsg", e.getMessage());
			e.printStackTrace();
		}
		
		if(result==true)
			request.setAttribute("successMessage", "Your Data for date "+request.getParameter("date")+" (yyyy-mm-dd) is submitted succesfully");
		request=setMinMaxDate(request);
		RequestDispatcher rd= request.getRequestDispatcher("/WEB-INF/jsp/SalesEntry.jsp");
   		rd.forward(request, response);
		
	}
	
	public HttpServletRequest setMinMaxDate(HttpServletRequest request) {

		String userType = ((LoginEn) request.getSession().getAttribute("loginEn")).getUserType();
		if (null != userType && userType.equals("admin")) {
			request.setAttribute("maxDate", new java.sql.Date(new java.util.Date().getTime()).toString()); // max is today date																								// date
		} else {
			String minDate = new SalesEntryService().getMinDate((String) request.getSession().getAttribute("userId")); // fetch min date from db table

			System.out.println("usertype = user :mindate-" + minDate);
			request.setAttribute("minDate", minDate); //
			request.setAttribute("maxDate", minDate);
			// request.setAttribute("maxDate", new java.sql.Date(new java.util.Date().getTime()).toString()); // max date is today date
		}

		return request;
	}

}
