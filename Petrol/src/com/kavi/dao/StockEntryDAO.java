package com.kavi.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.kavi.db.DBConnection;
import com.kavi.entity.StockEEn;
import com.kavi.util.DateUtil;
import com.kavi.util.StringUtil;

public class StockEntryDAO {

	public boolean persistSalesEn(StockEEn stockEn) throws SQLException {
		boolean result=false;
		Connection con=DBConnection.getConnection();
		con.setAutoCommit(false);
		
		// saving MS tank data ---- msReceipt

		// String str=StringUtil.createPreparedStmtNoOfVarString((stockEn.getMsRecipt().length)+3);
		String str=StringUtil.createPreparedStmtNoOfVarString(13);
		PreparedStatement ps= con.prepareStatement("insert into KAVI_STOCK_MS_R VALUES ("+str+")");

		ps.setDate(1, stockEn.getDate());
		ps.setString(2, stockEn.getUserId());  
		int [] msReceipt=stockEn.getMsRecipt();
		
		// no of ms tank
		System.out.println(msReceipt.length);
		int sumMsReceipt=0;
		for(int temp=0;temp<msReceipt.length;temp++)
		{
			ps.setInt(temp+3, msReceipt[temp]);
			sumMsReceipt=sumMsReceipt+msReceipt[temp];
		}
			
		ps.setInt(13, sumMsReceipt);
		int i=ps.executeUpdate();
		System.out.println("msReceipt persist output:"+i);
		
		// saving MS tank data ---- msOs
		
		PreparedStatement ps2= con.prepareStatement("insert into KAVI_STOCK_MS_OS VALUES ("+str+")");

		ps2.setDate(1, stockEn.getDate());
		ps2.setString(2, stockEn.getUserId());  
		int [] msOs=stockEn.getMsOpeningStock();
		
		// no of ms tank
		int sumMsOs=0;
		for(int temp=0;temp<msOs.length;temp++)
		{
			ps2.setInt(temp+3, msOs[temp]);
			sumMsOs=sumMsOs+msOs[temp];
		}
		
		ps2.setInt(13, sumMsOs);
		int i2=ps2.executeUpdate();
		System.out.println("msOs persist output:"+i2);
		
		
		// saving HSD tank data ---- hsdReceipt
		
				PreparedStatement ps3= con.prepareStatement("insert into KAVI_STOCK_HSD_R VALUES ("+str+")");

				ps3.setDate(1, stockEn.getDate());
				ps3.setString(2, stockEn.getUserId());  
				int [] hsdReceipt=stockEn.getHsdRecipt();
				
				// no of hsd tank
				int sumHsdReceipt=0;
				for(int temp=0;temp<hsdReceipt.length;temp++)
				{
					ps3.setInt(temp+3, hsdReceipt[temp]);
					sumHsdReceipt=sumHsdReceipt+hsdReceipt[temp];
				}
					
				
				ps3.setInt(13, sumHsdReceipt);
				int i3=ps3.executeUpdate();
				System.out.println("hsdReceipt persist output:"+i3);
		
		
				// saving HSD tank data ---- hsdOs
				
				PreparedStatement ps4= con.prepareStatement("insert into KAVI_STOCK_HSD_OS VALUES ("+str+")");

				ps4.setDate(1, stockEn.getDate());
				ps4.setString(2, stockEn.getUserId());  
				int [] hsdOs=stockEn.getHsdOpeningStock();
				
				// no of hsd tank
				int sumHsdOs=0;
				for(int temp=0;temp<hsdOs.length;temp++)
				{
					ps4.setInt(temp+3, hsdOs[temp]);
					sumHsdOs=sumHsdOs+hsdOs[temp];
				}
					
				
				ps4.setInt(13, sumHsdOs);
				int i4=ps4.executeUpdate();
				System.out.println("hsdOs persist output:"+i4);
		
		
		
				// saving power tank data ---- pRecipt
				
				PreparedStatement ps5= con.prepareStatement("insert into KAVI_STOCK_POWER_R VALUES ("+str+")");

				ps5.setDate(1, stockEn.getDate());
				ps5.setString(2, stockEn.getUserId());  
				int [] pRecipt=stockEn.getpRecipt();
				
				// no of power tank
				int sumPowerReceipt=0;
				for(int temp=0;temp<pRecipt.length;temp++)
				{
					ps5.setInt(temp+3, pRecipt[temp]);
					sumPowerReceipt=sumPowerReceipt+pRecipt[temp];
				}
				
				
				ps5.setInt(13, sumPowerReceipt);
				int i5=ps5.executeUpdate();
				System.out.println("pRecipt persist output:"+i5);
		
		
				// saving power tank data ---- pOs
				
				PreparedStatement ps6= con.prepareStatement("insert into KAVI_STOCK_POWER_OS VALUES ("+str+")");

				ps6.setDate(1, stockEn.getDate());
				ps6.setString(2, stockEn.getUserId());  
				int [] pOs=stockEn.getpOpeningStock();
				
				// no of power tank
				int sumPoweOs=0;
				for(int temp=0;temp<pOs.length;temp++)
				{
					ps6.setInt(temp+3, pOs[temp]);
					sumPoweOs=sumPoweOs+pOs[temp];
				}
					
				
				ps6.setInt(13, sumPoweOs);
				int i6=ps6.executeUpdate();
				System.out.println("pOs persist output:"+i6);

				// saving record update for min date
				
				PreparedStatement p= con.prepareStatement("insert into STOCK_DATE_UPDATE VALUES (?,?)");

				p.setString(1, stockEn.getUserId());
				p.setDate(2, stockEn.getDate());
				int i0=p.executeUpdate();
				System.out.println("STOCK_DATE_UPDATE persist output:"+i0);
				
		con.commit();
		
		if(null!=ps)
			ps.close();
		if(null!=con)
			con.close();
		
		return true;
	}

	public Date getMinDate(String userId) throws SQLException {
		Date date=null;
		Connection con=DBConnection.getConnection();
		PreparedStatement ps1= con.prepareStatement("select max(DATEOFRECORD) from STOCK_DATE_UPDATE where userid = ?");
		ps1.setString(1, userId);
		ResultSet rs1=ps1.executeQuery();
		while(rs1.next())
		{
			date = rs1.getDate(1);
		}			
		
		if(null!=rs1)
			rs1.close();
		if(null!=ps1)
			ps1.close();
		if(null!=con)
			con.close();
		return date;
	}

}
