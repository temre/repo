package com.kavi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.kavi.db.DBConnection;
import com.kavi.entity.user.LoginEn;

public class LoginDAO {

	public LoginEn validateUser(LoginEn loginEn) throws SQLException {
		Connection con=DBConnection.getConnection();
		PreparedStatement ps= con.prepareStatement("select * from Login where USERID = ?");
		System.out.println("ID: "+loginEn.getUserId());
		ps.setString(1, loginEn.getUserId());
		
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			System.out.println("while loop");
			if(rs.getString(2).equals(loginEn.getPassword()))
			{
				loginEn.setStatus(rs.getString(3));
				loginEn.setPreviousLoginTime(rs.getTimestamp(4));
				loginEn.setPreviousLoginIP(rs.getString(5));
				loginEn.setUserType(rs.getString(6));
				loginEn.setFullName(rs.getString(7));
				// column 8 is reserved for future use: just for assumption. not required actually				
				loginEn.setNoOfMsNozzle(rs.getInt(9));
				loginEn.setNoOfHsdNozzle(rs.getInt(10));
				loginEn.setNoOfPowerNozzle(rs.getInt(11));
				loginEn.setNoOfMsTank(rs.getInt(12));
				loginEn.setNoOfHsdTank(rs.getInt(13));
				loginEn.setNoOfPowerTank(rs.getInt(14));
				loginEn.setAddress(rs.getString(15));
				
				
				/*ps=con.prepareStatement("UPDATE Login SET PREVIOUS_LOGIN_TIME=?, PREVIOUS_LOGIN_IP=?  WHERE userId = ?");
				ps.setTimestamp(1, new Timestamp(new java.util.Date().getTime()));
				ps.setString(2, loginEn.getCurrentLoginIP());
				ps.setString(3, loginEn.getUserId());
				int i=ps.executeUpdate();
				System.out.println("Number of rows updated="+i);*/
			}
				
			System.out.println("end while");
		}
		
		if(null !=rs)
			rs.close();
		if(null!=ps)
			ps.close();
		if(null!=con)
			con.close();
		return loginEn;
	}

	public boolean isUserExist(String user) throws SQLException {
		boolean result=false;
		Connection con=DBConnection.getConnection();
		PreparedStatement ps=null;
		ResultSet rs=null;
			ps = con.prepareStatement("select USERID from Login where USERID = ? and usertype='user' and status ='active'");
			ps.setString(1, user);
			rs=ps.executeQuery();
			while(rs.next())
			{
				System.out.println("valid user in DAO : "+rs.getString(1));
				result=true;
				
			}
		
		if(null !=rs)
			rs.close();
		if(null!=ps)
			ps.close();
		if(null!=con)
			con.close();
		
		return result;

	}

	
	public boolean RegisterUser(LoginEn loginEn) throws SQLException {
		boolean result=false;
		Connection con=DBConnection.getConnection();
		PreparedStatement ps= con.prepareStatement("insert into Login ( USERID ,PASSWORD,STATUS,USERTYPE,FULLNAME,MOBILE,EMAIL"
				+ ",MSNOZZLECOUNT,HSDNOZZLECOUNT, POWERNOZZLECOUNT,MSTANKCOUNT,HSDTANKCOUNT,POWERTANKCOUNT) values (?,?,?,?,?,?,?,?,?,?,?,?,?)");

		ps.setString(1 ,loginEn.getUserId());
		ps.setString(2 ,loginEn.getPassword());
		ps.setString(3 ,"active");
		ps.setString(4 ,"user");
		ps.setString(5 ,loginEn.getFullName());
		ps.setString(6 ,loginEn.getMobile());
		ps.setString(7 ,loginEn.getEmail());
		
		// for time being : setting all no to 10 and 6 as we have already set accordingly in other dao
		/*ps.setInt(8 ,loginEn.getNoOfMsNozzle());
		ps.setInt(9 ,loginEn.getNoOfHsdNozzle());
		ps.setInt(10 ,loginEn.getNoOfPowerNozzle());
		ps.setInt(11 ,loginEn.getNoOfMsTank());
		ps.setInt(12 ,loginEn.getNoOfHsdTank());
		ps.setInt(13 ,loginEn.getNoOfPowerTank());*/
		
		ps.setInt(8 ,10);
		ps.setInt(9 ,10);
		ps.setInt(10 ,10);
		ps.setInt(11 ,10);
		ps.setInt(12 ,10);
		ps.setInt(13 ,10);
		
		int i=ps.executeUpdate();
		if(i==1)
			result =true;
		
		if(null!=ps)
			ps.close();
		if(null!=con)
			con.close();
		return result;
	}

	public String changePassword( String userId, String oldPassword, String newPassword) throws SQLException {
		String result="Some Error occured. Please try again";
		boolean flag=false;
		Connection con=DBConnection.getConnection();
		PreparedStatement ps= con.prepareStatement("select * from Login where USERID = ? and password = ?");
		ps.setString(1, userId);
		ps.setString(2 , oldPassword);
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			System.out.println("valid user in DAO : "+rs.getString(1));
			flag=true;
			
		}
		System.out.println("flag"+flag);
		if(flag)
		{
			ps= con.prepareStatement("update Login set password = ? where USERID = ?");
			
			ps.setString(1 , newPassword);
			ps.setString(2, userId);
			
			int i=ps.executeUpdate();
			System.out.println(i);
			result="success";
		}
		else
		{
			result="Incorrect Old Password";
		}
		System.out.println(result);
		
		if(null !=rs)
			rs.close();
		if(null!=ps)
			ps.close();
		if(null!=con)
			con.close();
		
		return result;
	}

	
}
