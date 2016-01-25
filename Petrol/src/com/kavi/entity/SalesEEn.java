package com.kavi.entity;

import java.sql.Date;

// single entity class for sales entry page. contains data for all sales entry table
public class SalesEEn {
	
	private Date date;
	private String userId;
	private int [] msMr;
	private int [] msPt;
	private int [] hsdMr;
	private int [] hsdPt;
	private int [] pMr;
	private int [] pPt;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public int[] getMsMr() {
		return msMr;
	}
	public void setMsMr(int[] msMr) {
		this.msMr = msMr;
	}
	public int[] getMsPt() {
		return msPt;
	}
	public void setMsPt(int[] msPt) {
		this.msPt = msPt;
	}
	public int[] getHsdMr() {
		return hsdMr;
	}
	public void setHsdMr(int[] hsdMr) {
		this.hsdMr = hsdMr;
	}
	public int[] getHsdPt() {
		return hsdPt;
	}
	public void setHsdPt(int[] hsdPt) {
		this.hsdPt = hsdPt;
	}
	public int[] getpMr() {
		return pMr;
	}
	public void setpMr(int[] pMr) {
		this.pMr = pMr;
	}
	public int[] getpPt() {
		return pPt;
	}
	public void setpPt(int[] pPt) {
		this.pPt = pPt;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	
	
	

}
