package com.kavi.service;

import java.sql.Date;
import java.sql.SQLException;

import com.kavi.dao.SalesEntryDAO;
import com.kavi.entity.SalesEEn;
import com.kavi.entity.StockEEn;
import com.kavi.util.DateUtil;

public class SalesEntryService {

	public boolean persistSalesEn(SalesEEn salesEn) throws SQLException {
		SalesEntryDAO dao = new SalesEntryDAO();
			
		return dao.persistSalesEn(salesEn);
	}

	public String getMinDate(String userId) {
		
		String date;
		SalesEntryDAO dao = new SalesEntryDAO();
		try {
			
			 Date d =dao.getMinDate(userId);  
			 Date todayDate = new Date(new java.util.Date().getTime());
			 System.out.println("d:"+d +"date:"+todayDate);
			 if(null==d || (d.toString()).equals(todayDate.toString()))
			 {
				 System.out.println();
				 date=todayDate.toString(); // today's date will be minDate if no data found
				 System.out.println("if block"+date);
			 }
			 else
			 {
					/*Date dateForCompare = new Date(d.getTime()+(86400000*5)); // 5 days concept
					 if(dateForCompare.compareTo(new java.util.Date())==1) 
					 {
						 date = new Date(d.getTime()+86400000).toString(); // 86400000 is one day in millisecond : next day from last updated record		 
					 }
					 else
					 {
						 date = new Date(d.getTime()-5*86400000).toString();
						 new java.sql.Date(new java.util.Date().getTime()-5*86400000).toString(); 
					 }*/
				 
				 date = new Date(d.getTime()+86400000).toString(); 
				 System.out.println("else block"+date);
			 }
			
		} catch (SQLException e) {
			// put high priority logger message minimum date will not work
			// so explicitely setting min date to today's date;
			date=new java.sql.Date(new java.util.Date().getTime()).toString();
		}
		return date;
	}

}
