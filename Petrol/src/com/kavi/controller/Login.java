package com.kavi.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kavi.entity.user.LoginEn;
import com.kavi.service.LoginService;
import com.kavi.util.AppConstant;

@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   		String responsePageName="Login.jsp";
   		if(null != request.getSession().getAttribute("loginEn"))
   		try {
   			LoginEn loginEn = (LoginEn) request.getSession().getAttribute("loginEn");
   			if(loginEn.getStatus().equals(AppConstant.LoggedIn))
   			{
   				if("admin".equals(loginEn.getUserType()))
				{
					responsePageName="/WEB-INF/jsp/Home.jsp";
					request.setAttribute("message","Welcome Admin : "+ loginEn.getFullName());
				}
				else
				{
					responsePageName="/WEB-INF/jsp/Home.jsp";
					request.setAttribute("message","Welcome User : "+ loginEn.getFullName());
				}	
   			}
   			
   		}
   		catch(Exception e)
   		{
   			System.out.println("Exception occure at login servlet do get:"+e.getMessage());
   		}
   		RequestDispatcher rd= request.getRequestDispatcher(responsePageName);
   		rd.forward(request, response);
   		
   			}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String responsePageName="error.jsp";
   		LoginEn loginEn= new LoginEn();
   		loginEn.setUserId(request.getParameter("userId"));
   		loginEn.setPassword(request.getParameter("password"));
   		System.out.println("request.getRequestURI()"+request.getRequestURL());
   		loginEn.setCurrentLoginIP(request.getRequestURI());
   		LoginService loginService = new LoginService();
   		boolean result=false;
		try {
			
			loginEn=loginService.validateUser(loginEn);
			
			
			if("active".equalsIgnoreCase(loginEn.getStatus()))
			{
				System.out.println("login Active");
				loginEn.setStatus(AppConstant.LoggedIn);
				request.getSession().setAttribute("loginEn", loginEn);
				request.getSession().setAttribute("userId", loginEn.getUserId());
				request.getSession().setAttribute("loginStatus", true);
				
				result =true;
				
			}
			System.out.println("result==="+result);
			
			if(result==true)
			{
				if("admin".equals(loginEn.getUserType()))
				{
					responsePageName="/WEB-INF/jsp/Home.jsp";
					request.setAttribute("message", "Welcome Admin : "+ loginEn.getFullName());
				}
				else
				{
					responsePageName="/WEB-INF/jsp/Home.jsp";
					request.setAttribute("message", "Welcome User : "+ loginEn.getFullName());
				}
				
				
				
			}
			else
			{
				// user expire or remove from system code here. later requirement
				// for this add a if condition and check with LoginEn.status and send a different error message to user.
				
				responsePageName="Login.jsp";
				request.setAttribute("message", "fail ! Invalid credentials");
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

   		RequestDispatcher rd= request.getRequestDispatcher(responsePageName);
   		rd.forward(request, response);
	}
	
}
