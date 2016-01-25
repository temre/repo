package com.kavi.service;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

import com.kavi.dao.DSRDao;
import com.kavi.entity.DSRBean;

public class DSRService {

	public ArrayList<DSRBean> getDSR(String userId, String month, String product) throws SQLException, ParseException {
		DSRDao dao = new DSRDao();
		
		
		
		
		
		
		
		
		ArrayList<DSRBean> list=dao.getDSR(userId,month, product);
		return list;
	}

}
