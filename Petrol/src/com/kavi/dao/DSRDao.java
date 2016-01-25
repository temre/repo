package com.kavi.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

import com.kavi.db.DBConnection;
import com.kavi.entity.DSRBean;
import com.kavi.util.DateUtil;

public class DSRDao {

	public ArrayList<DSRBean> getDSR(String userId, String month, String product) throws SQLException, ParseException {
		Connection con			=	DBConnection.getConnection();
		ArrayList<DSRBean> list	= 	new ArrayList<DSRBean>();
		DSRBean bean   			=	null;
		Date startDate 			= 	DateUtil.getStartDateOfMonth(month);
		Date osStartDate		=	DateUtil.getPreviousDate(startDate);
		Date endDate   			= 	DateUtil.getEndDateOfMonth(month);		
		//Date osEndDate			=	DateUtil.getPreviousDate(endDate);
		
		// ----------------------- -----------------------  Opening Stock  ------------------------------
		
		String query			=	"select sum from KAVI_STOCK_"+product+"_OS where userid =? and dateofrecord between ? and ? ";
		System.out.println("query::"+query);
		PreparedStatement psOpeningStock = con.prepareStatement(query);
		psOpeningStock.setString(1, userId);
		psOpeningStock.setDate(2, osStartDate);
		// temp psOpeningStock.setDate(3, DateUtil.getNextDate(endDate)); // fetching one extra record for nextDayOpenStock (SalesByDIP)
		psOpeningStock.setDate(3, endDate); // fetching one extra record for nextDayOpenStock (SalesByDIP)
		System.out.println(userId+"::"+ startDate +"::"+DateUtil.getNextDate(endDate));
		ResultSet rs = psOpeningStock.executeQuery();
		if(rs==null || !rs.isBeforeFirst())
		{
			System.out.println("No data found in dsr dao");
			return list;
		}
		
			
		
		while(rs.next())
		{
			bean = new DSRBean();
			bean.setOpeningStock(rs.getInt(1));
			list.add(bean);
			
		}
		System.out.println("Dsr: size"+list.size());
		if(null!=rs)
			rs.close();
		if(null!=psOpeningStock)
			psOpeningStock.close();
		
		
		// ----------------------- ----------------------- Receipt ------------------------------
		
		query =	"select sum, dateofrecord from KAVI_STOCK_"+product+"_R where userid =? and dateofrecord between ? and ? ";
		PreparedStatement psReceipt = con.prepareStatement(query);
		psReceipt.setString(1, userId);
		psReceipt.setDate(2, startDate);
		psReceipt.setDate(3, endDate);
		
		ResultSet rsReceipt = psReceipt.executeQuery();
		int beanCounter = 0;
		while(rsReceipt.next())
		{
			bean = list.get(beanCounter);
			bean.setReceipt(rsReceipt.getInt(1));
			bean.setDate(rsReceipt.getDate(2));
			bean.setTotalStock(rsReceipt.getInt(1)+bean.getOpeningStock()); // --------------- Total Stock ------------
			
			// ------------------Following line is for Sales By DIP :: Today Total Stock - next day opening stock ------------------------------	
			try {
			bean.setSalesByDip(bean.getTotalStock()-list.get(beanCounter+1).getOpeningStock()); 
			}
			catch(Exception e)
			{
				System.out.println("exception occur ddd"+e.getMessage());
			}
			// above line may vulnerable, check it if error occurs at arraylist operation or bean mismatching -------------------------
			
			list.set(beanCounter, bean);
			beanCounter++;
			System.out.println("222"+rsReceipt.getInt(1));
		}
		if(null!=rsReceipt)
			rsReceipt.close();
		if(null!=psReceipt)
			psReceipt.close();
		
		// ----------------------- ----------------------- Sales By Meter ------------------------------
		
		query =	"select sum from KAVI_SE_"+product+"_MR where userid =? and dateofrecord between ? and ? ";
		PreparedStatement psSalesByMeter = con.prepareStatement(query);
		psSalesByMeter.setString(1, userId);
		psSalesByMeter.setDate(2, startDate);
		psSalesByMeter.setDate(3, endDate);
		
		ResultSet rsSalesbyMeter = psSalesByMeter.executeQuery();
		beanCounter = 0;
		while(rsSalesbyMeter.next())
		{
			bean = list.get(beanCounter);
			bean.setSaleByMeter(rsSalesbyMeter.getInt(1));
			list.set(beanCounter, bean);
			beanCounter++;
		}
		if(null!=rsSalesbyMeter)
			rsSalesbyMeter.close();
		if(null!=psSalesByMeter)
			psSalesByMeter.close();
		
		// ----------------------- ----------------------- Pump Testing ------------------------------
		
				query =	"select sum from KAVI_SE_"+product+"_PT where userid =? and dateofrecord between ? and ? ";
				PreparedStatement psPumpTesting = con.prepareStatement(query);
				psPumpTesting.setString(1, userId);
				psPumpTesting.setDate(2, startDate);
				psPumpTesting.setDate(3, endDate);
				
				ResultSet rsPumpTesting = psPumpTesting.executeQuery();
				beanCounter = 0;
				while(rsPumpTesting.next())
				{
					bean = list.get(beanCounter);
					bean.setPumpTest(rsPumpTesting.getInt(1));
					bean.setNetSalesByMeter(bean.getSaleByMeter()-rsPumpTesting.getInt(1));  // -------------------- Net Sales By Meter ----------
					
					bean.setStockLG(bean.getNetSalesByMeter()-bean.getSalesByDip());    // -------------------------- Stock Loss/Gain ------------
					
					
					// ------------------------------------------ 	Cum Sales ---------------------------
					if(beanCounter==0)
					{
						bean.setCumSales(bean.getNetSalesByMeter()); //---first day cum sale = net sale by meter
						bean.setCumStockLG(bean.getStockLG());		 //---first day cum Stock Loss/Gain = Stock Loss/Gain
						
					}
					else
					{
						bean.setCumSales(list.get(beanCounter-1).getCumSales()+bean.getNetSalesByMeter()); 	  //--- cum sale = previous cum sale + net sale by meter
						bean.setCumStockLG(list.get(beanCounter-1).getCumStockLG() + bean.getStockLG());      //--- cum Stock Loss/Gain = previous dat cumStockLossGain + Stock Loss/Gain
					}
						
					list.set(beanCounter, bean);
					beanCounter++;
				}
				
				if(null!=rsPumpTesting)
					psPumpTesting.close();
				if(null!=psPumpTesting)
					psPumpTesting.close();
		
	
		// --------------------------------    Stock Loss/Gain   -------------------------------------		
				
		
		System.out.println("dao:"+list.size());
		for(DSRBean b : list)
		{
			System.out.println(b.getDate());
			System.out.println(b.getOpeningStock());
			System.out.println(b.getReceipt());
		}
		
		if(null!=con)
			con.close();
		return list;
	}

}
