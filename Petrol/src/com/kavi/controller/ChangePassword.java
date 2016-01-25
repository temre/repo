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

/**
 * Servlet implementation class ChangePassword
 */
@WebServlet("/ChangePassword")
public class ChangePassword extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		boolean status=(boolean) request.getSession().getAttribute("loginStatus");
		 System.out.println("loginStatus ::: "+request.getSession().getAttribute("loginStatus"));
		 System.out.println(status);
		if(status)
		{
			RequestDispatcher rd= request.getRequestDispatcher("/WEB-INF/jsp/ChangePassword.jsp");
	   		rd.forward(request, response);	
		}
		else
		{
			request.setAttribute("message", "Un Authorize Access ! Please Login with your credential to access the desired content");
			RequestDispatcher rd= request.getRequestDispatcher("/Login.jsp");
	   		rd.forward(request, response);	
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String page="/WEB-INF/jsp/ChangePassword.jsp";
		String userId	   = request.getParameter("userId");
		String oldPassword = request.getParameter("oldPassword");
		String newPassword = request.getParameter("newPassword");
		
		try {
			String result=new LoginService().changePassword(userId,oldPassword,newPassword);
			
			if(result.equalsIgnoreCase("success"))
			{
				request.setAttribute("message", "Your Password change succesfully");
				page="/WEB-INF/jsp/Home.jsp";
			}
			else{
				request.setAttribute("message", result);
			}
			
		} catch (SQLException e) {
			request.setAttribute("message", "Exception occure : "+ e.getMessage());
			e.printStackTrace();
		}
		RequestDispatcher rd= request.getRequestDispatcher(page);
   		rd.forward(request, response);	
	}

}
