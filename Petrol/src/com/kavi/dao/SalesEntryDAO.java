package com.kavi.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.kavi.db.DBConnection;
import com.kavi.entity.SalesEEn;
import com.kavi.util.StringUtil;

public class SalesEntryDAO {

	public boolean persistSalesEn(SalesEEn salesEn) throws SQLException {
		
		boolean result=false;
		Connection con=DBConnection.getConnection();
		con.setAutoCommit(false);
		
		// saving MS nozzle data ---- msMr

		// String str=StringUtil.createPreparedStmtNoOfVarString((salesEn.getMsMr().length)+3);
		String str=StringUtil.createPreparedStmtNoOfVarString(13);
		PreparedStatement ps= con.prepareStatement("insert into Kavi_Se_Ms_Mr VALUES  ("+str+")");

		ps.setDate(1, salesEn.getDate());
		ps.setString(2, salesEn.getUserId());  
		int [] msMr=salesEn.getMsMr();
		
		// no of ms nozzle
		System.out.println(msMr.length);
		int sumMsMr=0;
		for(int temp=0;temp<msMr.length;temp++)
		{
			ps.setInt(temp+3, msMr[temp]);
			sumMsMr=sumMsMr+msMr[temp];
		}
			
		System.out.println("ps:"+ps);
		System.out.println("ps:"+ps.toString());
		ps.setInt(13, sumMsMr);
		int i=ps.executeUpdate();
		System.out.println("msMr persist output:"+i);
		
		// saving MS nozzle data ---- msPt
		PreparedStatement ps2= con.prepareStatement("insert into Kavi_Se_Ms_Pt VALUES ("+str+")");

		ps2.setDate(1, salesEn.getDate());
		ps2.setString(2, salesEn.getUserId());  
		int [] msPt=salesEn.getMsPt();
		
		// no of ms nozzle
		int sumMsPt=0;
		for(int temp=0;temp<msPt.length;temp++)
		{
			ps2.setInt(temp+3, msPt[temp]);
			sumMsPt=sumMsPt+msPt[temp];
		}
			
		
		ps2.setInt(13, sumMsPt);
		int i2=ps2.executeUpdate();
		System.out.println("msPt persist output:"+i2);
		
		
		// saving HSD nozzle data ---- hsdMr
		
				PreparedStatement ps3= con.prepareStatement("insert into Kavi_Se_Hsd_Mr VALUES ("+str+")");

				ps3.setDate(1, salesEn.getDate());
				ps3.setString(2, salesEn.getUserId());  
				int [] hsdMr=salesEn.getHsdMr();
				
				// no of hsd nozzle
				int sumHsdMr=0;
				for(int temp=0;temp<hsdMr.length;temp++)
				{
					ps3.setInt(temp+3, hsdMr[temp]);
					sumHsdMr=sumHsdMr+ hsdMr[temp];
				}
					
				
				ps3.setInt(13, sumHsdMr);
				int i3=ps3.executeUpdate();
				System.out.println("hsdMr persist output:"+i3);
		
		
				// saving HSD nozzle data ---- hsdPt
				
				PreparedStatement ps4= con.prepareStatement("insert into Kavi_Se_Hsd_Pt VALUES ("+str+")");

				ps4.setDate(1, salesEn.getDate());
				ps4.setString(2, salesEn.getUserId());  
				int [] hsdPt=salesEn.getHsdPt();
				
				// no of hsd nozzle
				int sumHsdPt=0;
				for(int temp=0;temp<hsdMr.length;temp++)
				{
					ps4.setInt(temp+3, hsdPt[temp]);
					sumHsdPt=sumHsdPt+ hsdPt[temp];
				}
					
				
				ps4.setInt(13, sumHsdPt);
				int i4=ps4.executeUpdate();
				System.out.println("hsdPt persist output:"+i4);
		
		
		
				// saving HSD nozzle data ---- pMr
				
				PreparedStatement ps5= con.prepareStatement("insert into Kavi_Se_Power_Mr VALUES ("+str+")");

				ps5.setDate(1, salesEn.getDate());
				ps5.setString(2, salesEn.getUserId());  
				int [] pMr=salesEn.getpMr();
				
				// no of hsd nozzle
				int sumPMr=0;
				for(int temp=0;temp<pMr.length;temp++)
				{
					ps5.setInt(temp+3, pMr[temp]);
					sumPMr=sumPMr+ pMr[temp];
				}
					
				
				ps5.setInt(13, sumPMr);
				int i5=ps5.executeUpdate();
				System.out.println("pMr persist output:"+i5);
		
		
				// saving HSD nozzle data ---- pPt
				
				PreparedStatement ps6= con.prepareStatement("insert into Kavi_Se_Power_Pt VALUES ("+str+")");

				ps6.setDate(1, salesEn.getDate());
				ps6.setString(2, salesEn.getUserId());  
				int [] pPt=salesEn.getpPt();
				
				// no of hsd nozzle
				int sumPPt=0;
				for(int temp=0;temp<pPt.length;temp++)
				{
					ps6.setInt(temp+3, pPt[temp]);
					sumPPt=sumPPt+pPt[temp];
				}
					
				
				ps6.setInt(13, sumPPt);
				int i6=ps6.executeUpdate();
				System.out.println("pPt persist output:"+i6);

				// saving record update for min date
				
				PreparedStatement p= con.prepareStatement("insert into SALES_DATE_UPDATE VALUES (?,?)");

				p.setString(1, salesEn.getUserId());
				p.setDate(2, salesEn.getDate());
				int i0=p.executeUpdate();
				System.out.println("SALES_DATE_UPDATE persist output:"+i0);
				
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
		PreparedStatement ps2= con.prepareStatement("select max(DATEOFRECORD) from SALES_DATE_UPDATE where userid = ?");
		ps2.setString(1, userId);
		ResultSet rs2=ps2.executeQuery();
		while(rs2.next())
		{
			date = rs2.getDate(1);
		}			
		
	
		if(null!=rs2)
			rs2.close();
		if(null!=ps2)
			ps2.close();
		if(null!=con)
			con.close();
		System.out.println("Min date is "+date);
		return date;
	}

}
