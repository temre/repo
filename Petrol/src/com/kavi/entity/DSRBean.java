package com.kavi.entity;

import java.sql.Date;

public class DSRBean {
	
	private Date  date;
	private int  openingStock;
	private int  receipt;
	private int  totalStock;
	private int  saleByMeter;
	private int  pumpTest;
	private int  netSalesByMeter;
	private int  cumSales;
	private int  salesByDip;
	private int  stockLG;
	private int  cumStockLG;
	
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getOpeningStock() {
		return openingStock;
	}
	public void setOpeningStock(int openingStock) {
		this.openingStock = openingStock;
	}
	public int getReceipt() {
		return receipt;
	}
	public void setReceipt(int receipt) {
		this.receipt = receipt;
	}
	public int getTotalStock() {
		return totalStock;
	}
	public void setTotalStock(int totalStock) {
		this.totalStock = totalStock;
	}
	public int getSaleByMeter() {
		return saleByMeter;
	}
	public void setSaleByMeter(int saleByMeter) {
		this.saleByMeter = saleByMeter;
	}
	public int getPumpTest() {
		return pumpTest;
	}
	public void setPumpTest(int pumpTest) {
		this.pumpTest = pumpTest;
	}
	public int getNetSalesByMeter() {
		return netSalesByMeter;
	}
	public void setNetSalesByMeter(int netSalesByMeter) {
		this.netSalesByMeter = netSalesByMeter;
	}
	public int getCumSales() {
		return cumSales;
	}
	public void setCumSales(int cumSales) {
		this.cumSales = cumSales;
	}
	public int getSalesByDip() {
		return salesByDip;
	}
	public void setSalesByDip(int salesByDip) {
		this.salesByDip = salesByDip;
	}
	public int getStockLG() {
		return stockLG;
	}
	public void setStockLG(int stockLG) {
		this.stockLG = stockLG;
	}
	public int getCumStockLG() {
		return cumStockLG;
	}
	public void setCumStockLG(int cumStockLG) {
		this.cumStockLG = cumStockLG;
	}
}
