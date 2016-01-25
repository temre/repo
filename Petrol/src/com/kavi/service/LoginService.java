package com.kavi.service;

import java.sql.SQLException;

import com.kavi.dao.LoginDAO;
import com.kavi.entity.user.LoginEn;

public class LoginService {

	public LoginEn validateUser(LoginEn loginEn) throws SQLException {
		LoginDAO loginDAO= new LoginDAO();
		loginEn=loginDAO.validateUser(loginEn);
		return loginEn;
	}

	public String changePassword(String userId, String oldPassword, String newPassword) throws SQLException {
		return	new LoginDAO().changePassword(userId ,oldPassword,newPassword);
	}

}
