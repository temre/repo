package com.kavi.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Logout
 */
@WebServlet("/Logout")
public class Logout extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Logout called");
		
		try {
		HttpSession session=request.getSession();
		session.removeAttribute("loginEn");
		session.removeAttribute("userId");
		session.removeAttribute("loginStatus");
		session.invalidate();
		request.setAttribute("message", "Thank You !! You are successfully Logged Out");
		
		}
		catch(Exception t)
		{
			request.getSession().invalidate();
			System.out.println("Something went wrong during logout : "+t.getMessage());
			t.printStackTrace();
		}
		RequestDispatcher rd= request.getRequestDispatcher("Login.jsp");
   		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
