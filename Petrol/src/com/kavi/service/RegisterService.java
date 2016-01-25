package com.kavi.service;

import java.sql.SQLException;

import com.kavi.dao.LoginDAO;
import com.kavi.entity.user.LoginEn;

public class RegisterService {

	public boolean RegisterUser(LoginEn loginEn) throws SQLException {
		LoginDAO loginDAO= new LoginDAO();
		
		return loginDAO.RegisterUser(loginEn);
	}

}
