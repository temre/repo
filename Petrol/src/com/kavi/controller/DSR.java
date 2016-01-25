package com.kavi.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kavi.dao.LoginDAO;
import com.kavi.entity.DSRBean;
import com.kavi.entity.user.LoginEn;
import com.kavi.service.DSRService;
import com.kavi.util.AppConstant;
/**
 * Servlet implementation class DSR
 */
@WebServlet("/DSR")
public class DSR extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("do Get of DSR");

		LoginEn loginEn=(LoginEn) request.getSession().getAttribute("loginEn");
		if(loginEn.getStatus().equals(AppConstant.LoggedIn))
		{
			RequestDispatcher rd= request.getRequestDispatcher("/WEB-INF/jsp/DSR.jsp");
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
		System.out.println("do Post of DSR");
		
		String month=request.getParameter("month");
		String product=request.getParameter("product");
		boolean result = validatMonthAndProduct(month, product);
		String pageName="Error.jsp";
		if(result==true)
		{
			LoginEn loginEn = (LoginEn) request.getSession().getAttribute("loginEn");
			DSRService dsrService = new DSRService();
			ArrayList<DSRBean> list;
			try {
				String userId=null;
				
				
				String userType= ((LoginEn) request.getSession().getAttribute("loginEn")).getUserType();
				System.out.println("userType : "+userType);
				if(null != userType && userType.equals("admin"))
				{
					String user=request.getParameter("user");
					boolean isUserExist=new LoginDAO().isUserExist(user);
					if(isUserExist)
					{
						userId=user;
					}
					else
					{
						throw new Exception("Invalid User ! Please enter correct user Id");
					}
						
				}
				else
				{
					userId=loginEn.getUserId();
				}

				
				
				
				
				
				list = dsrService.getDSR(userId, month, product);
				if(list ==null || list.isEmpty() || list.size()==0)
				{
					request.setAttribute("message","No Data Found for Product : "+product);
				}
				else
				{
				  request.setAttribute("list", list);
				  request.setAttribute("message","Online DSR Product : "+product);
				  System.out.println("servlet:"+list.size());
				}
				pageName="/WEB-INF/jsp/DSR.jsp";
				
			} catch (SQLException | ParseException e ) {
				request.setAttribute("message", e.getMessage());
				pageName="/WEB-INF/jsp/DSR.jsp";
				e.printStackTrace();
			}
			catch (NullPointerException e)
			 {
				request.setAttribute("message", "Please Enter Complete data of Sales Entry and Stock Entry ");
				pageName="/WEB-INF/jsp/DSR.jsp";
				e.printStackTrace();
			}
			catch (Exception e)
			 {
				request.setAttribute("message", e.getMessage());
				pageName="/WEB-INF/jsp/DSR.jsp";
				e.printStackTrace();
			}
			
		}
		else
		{
			request.setAttribute("message","Input data month and product is corrupted");
			pageName="/WEB-INF/jsp/DSR.jsp";
		}
		
		RequestDispatcher rd= request.getRequestDispatcher(pageName);
   		rd.forward(request, response);
	}

	private boolean validatMonthAndProduct(String month, String product) {
		boolean result = false;
		try {
		int i=Integer.parseInt(month);
		if(i>0 && i<13)
		{
			if(product.equalsIgnoreCase(AppConstant.MS) || product.equalsIgnoreCase(AppConstant.HSD) || product.equalsIgnoreCase(AppConstant.POWER))
				result=true;
		}
		}
		catch(Exception e)
		{
			System.out.println("input data month and product is corrupted");
		}
		return result;
	}

}
