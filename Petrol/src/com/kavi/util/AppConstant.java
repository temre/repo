package com.kavi.util;

import java.util.ArrayList;

public class AppConstant {
	private ArrayList<String> questionList = new ArrayList<String>(5);

	public ArrayList<String> getQuestionList() {
		questionList.add(0, "question0");
		questionList.add(1, "question1");
		questionList.add(2, "question2");
		questionList.add(3, "question3");
		questionList.add(4, "question4");
		questionList.add(5, "question5");
		System.out.println(questionList.size());
		return questionList;
	}

	public static void main(String[] args) {
		new AppConstant().getQuestionList();

	}
	public static final String LoggedIn 		= "LoggedIn";
	
	public static final String MS 		= "MS";
	public static final String HSD 	 	= "HSD";
	public static final String POWER 	= "POWER";

	public static final String January   	= "1";
	public static final String February		= "2";
	public static final String March		= "3";
	public static final String April		= "4";
	public static final String May			= "5";
	public static final String June			= "6";
	public static final String July			= "7";
	public static final String August		= "8";
	public static final String September	= "9";
	public static final String October		= "10";
	public static final String November		= "11";
	public static final String December		= "12";
}
