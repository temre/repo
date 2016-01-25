package com.kavi.util;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateUtil {

	public static Date getPreviousDate(Date date)
	{
		
		return new Date(date.getTime()-86400000);
	}
	
	public static Date getNextDate(Date date)
	{
		
		return new Date(date.getTime()+86400000);
	}
	
	public static Date getStartDateOfMonth(String month) throws ParseException
	{
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date start = format.parse("2016-"+month+"-1");

		System.out.println("start Date:"+start);
		return new Date(start.getTime());
		
	}
	public static Date getEndDateOfMonth(String month) throws ParseException
	{
		
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date end = format.parse("2016-"+(Integer.parseInt(month)+1)+"-1");
		Date endSql=new Date(end.getTime());
		endSql=	getPreviousDate(endSql);
		System.out.println("end Date:"+endSql);
		return endSql;
	}

	public static Date getOsStartDateOfMonth(String month) {
		// TODO Auto-generated method stub
		return null;
	}

	public static Date getOsEndDateOfMonth(String month) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
