package com.kavi.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jdt.internal.compiler.parser.ParserBasicInformation;

import com.kavi.dao.LoginDAO;
import com.kavi.entity.user.LoginEn;
import com.kavi.service.RegisterService;
import com.kavi.service.StockEntryService;
import com.kavi.util.AppConstant;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ArrayList<String> questionList= new AppConstant().getQuestionList();  for later use 
		// request.setAttribute("questionList", questionList);
		String pageName="Error.jsp";
		String userType= ((LoginEn) request.getSession().getAttribute("loginEn")).getUserType();
		System.out.println("Register Servlet : Do get method : userType : "+userType);
		if(null != userType && userType.equals("admin"))
		{
			pageName="/WEB-INF/jsp/Register.jsp";
			request.setAttribute("message", "");
		}
		else
		{
			request.setAttribute("message", "You are not authorize to access registration page. Please Login as an administrator");
		}
		
		
		RequestDispatcher rd=request.getRequestDispatcher(pageName);
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String responsePageName="/WEB-INF/jsp/Register.jsp";

		LoginEn loginEn= new LoginEn();
		loginEn.setFullName(request.getParameter("fullName"));
		loginEn.setUserId(request.getParameter("userId"));
		loginEn.setPassword(request.getParameter("password"));
		loginEn.setEmail(request.getParameter("email"));
		loginEn.setMobile(request.getParameter("mobile"));
		
		loginEn.setNoOfMsNozzle(Integer.parseInt(request.getParameter("noOfMsNozzle")));
		loginEn.setNoOfHsdNozzle(Integer.parseInt(request.getParameter("noOfHsdNozzle")));
		loginEn.setNoOfPowerNozzle(Integer.parseInt(request.getParameter("noOfPowerNozzle")));
		loginEn.setNoOfMsTank(Integer.parseInt(request.getParameter("noOfMsTank")));
		loginEn.setNoOfHsdTank(Integer.parseInt(request.getParameter("noOfHsdTank")));
		loginEn.setNoOfPowerTank(Integer.parseInt(request.getParameter("noOfPowerTank")));
		
		
		RegisterService registerService = new RegisterService();
		try {
			boolean result=registerService.RegisterUser(loginEn);
			
			if(result==true)
			{
				request.setAttribute("message", "New account is successfully created for user "+loginEn.getFullName()+" with User id "+loginEn.getUserId());
				
			}
			else
			{
				request.setAttribute("message", "Unable to create new account. Please try again later");
			}
			
			
		} 
		catch(java.sql.SQLIntegrityConstraintViolationException icve)
		{
			request.setAttribute("message", "Unable to create new account. User Id is already registered !");
			icve.printStackTrace();
		}
		catch (SQLException e) {
			
			request.setAttribute("message", "Unable to create new account. Please try again later : "+e.getMessage());
			e.printStackTrace();
		}
		
		RequestDispatcher rd=request.getRequestDispatcher(responsePageName);
		rd.forward(request, response);
	}

}
