package com.kavi.entity;

import java.sql.Date;

public class StockEEn {
	
	private Date date;
	private String userId;
	private int [] msRecipt;
	private int [] msOpeningStock;
	private int [] hsdRecipt;
	private int [] hsdOpeningStock;
	private int [] pRecipt;
	private int [] pOpeningStock;
	
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public int[] getMsRecipt() {
		return msRecipt;
	}
	public void setMsRecipt(int[] msRecipt) {
		this.msRecipt = msRecipt;
	}
	public int[] getMsOpeningStock() {
		return msOpeningStock;
	}
	public void setMsOpeningStock(int[] msOpeningStock) {
		this.msOpeningStock = msOpeningStock;
	}
	public int[] getHsdRecipt() {
		return hsdRecipt;
	}
	public void setHsdRecipt(int[] hsdRecipt) {
		this.hsdRecipt = hsdRecipt;
	}
	public int[] getHsdOpeningStock() {
		return hsdOpeningStock;
	}
	public void setHsdOpeningStock(int[] hsdOpeningStock) {
		this.hsdOpeningStock = hsdOpeningStock;
	}
	public int[] getpRecipt() {
		return pRecipt;
	}
	public void setpRecipt(int[] pRecipt) {
		this.pRecipt = pRecipt;
	}
	public int[] getpOpeningStock() {
		return pOpeningStock;
	}
	public void setpOpeningStock(int[] pOpeningStock) {
		this.pOpeningStock = pOpeningStock;
	}
	
	
	
	}
