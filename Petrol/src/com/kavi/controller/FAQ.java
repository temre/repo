package com.kavi.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FAQ
 */
@WebServlet("/FAQ")
public class FAQ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FAQ() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean status=(boolean) request.getSession().getAttribute("loginStatus");
		 System.out.println("loginStatus ::: "+request.getSession().getAttribute("loginStatus"));
		 System.out.println(status);
		if(status)
		{
			RequestDispatcher rd= request.getRequestDispatcher("/WEB-INF/jsp/FAQ.jsp");
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
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
