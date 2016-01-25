package com.kavi.service;

import java.sql.Date;
import java.sql.SQLException;

import com.kavi.dao.StockEntryDAO;
import com.kavi.entity.StockEEn;

public class StockEntryService {

	public boolean persistSalesEn(StockEEn stockEn) throws SQLException {
		StockEntryDAO dao = new StockEntryDAO();
		return dao.persistSalesEn(stockEn);
	}

	public String getMinDate(String userId) {
		String date;
		StockEntryDAO dao = new StockEntryDAO();
		
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
				 date = new Date(d.getTime()+86400000).toString(); 
				 System.out.println("else block"+date);
			 }
			
		} catch (SQLException e) {
			date=new java.sql.Date(new java.util.Date().getTime()).toString();
		}
		return date;
	}

}
