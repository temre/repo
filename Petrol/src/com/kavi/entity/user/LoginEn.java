package com.kavi.entity.user;

import java.sql.Timestamp;

public class LoginEn {
private String userId;
private String password;
private Timestamp previousLoginTime;
private String previousLoginIP;
private String currentLoginIP;
private String userType;
private String fullName;
private String status;
private String mobile;
private String email;

private int noOfMsNozzle;
private int noOfHsdNozzle;
private int noOfPowerNozzle;

private int noOfMsTank;
private int noOfHsdTank;
private int noOfPowerTank;

private String address;
private int initialOpeningStock;


public String getUserId() {
	return userId;
}
public void setUserId(String userId) {
	this.userId = userId;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public Timestamp getPreviousLoginTime() {
	return previousLoginTime;
}
public void setPreviousLoginTime(Timestamp previousLoginTime) {
	this.previousLoginTime = previousLoginTime;
}
public String getPreviousLoginIP() {
	return previousLoginIP;
}
public void setPreviousLoginIP(String previousLoginIP) {
	this.previousLoginIP = previousLoginIP;
}
public String getUserType() {
	return userType;
}
public void setUserType(String userType) {
	this.userType = userType;
}
public String getFullName() {
	return fullName;
}
public void setFullName(String fullName) {
	this.fullName = fullName;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
public String getCurrentLoginIP() {
	return currentLoginIP;
}
public void setCurrentLoginIP(String currentLoginIP) {
	this.currentLoginIP = currentLoginIP;
}
public String getMobile() {
	return mobile;
}
public void setMobile(String mobile) {
	this.mobile = mobile;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public int getNoOfMsNozzle() {
	return noOfMsNozzle;
}
public void setNoOfMsNozzle(int noOfMsNozzle) {
	this.noOfMsNozzle = noOfMsNozzle;
}
public int getNoOfHsdNozzle() {
	return noOfHsdNozzle;
}
public void setNoOfHsdNozzle(int noOfHsdNozzle) {
	this.noOfHsdNozzle = noOfHsdNozzle;
}
public int getNoOfPowerNozzle() {
	return noOfPowerNozzle;
}
public void setNoOfPowerNozzle(int noOfPowerNozzle) {
	this.noOfPowerNozzle = noOfPowerNozzle;
}
public int getNoOfMsTank() {
	return noOfMsTank;
}
public void setNoOfMsTank(int noOfMsTank) {
	this.noOfMsTank = noOfMsTank;
}
public int getNoOfHsdTank() {
	return noOfHsdTank;
}
public void setNoOfHsdTank(int noOfHsdTank) {
	this.noOfHsdTank = noOfHsdTank;
}
public int getNoOfPowerTank() {
	return noOfPowerTank;
}
public void setNoOfPowerTank(int noOfPowerTank) {
	this.noOfPowerTank = noOfPowerTank;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public int getInitialOpeningStock() {
	return initialOpeningStock;
}
public void setInitialOpeningStock(int initialOpeningStock) {
	this.initialOpeningStock = initialOpeningStock;
}

}
