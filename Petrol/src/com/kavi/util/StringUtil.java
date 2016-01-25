package com.kavi.util;

public class StringUtil {

	public static String createPreparedStmtNoOfVarString(int number) {
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < number; i++)
			sb.append("?,");
		sb.deleteCharAt(sb.length()-1);
		System.out.println("sb="+sb);
		return sb.toString();
	}
	
	
	/*public static void main(String[] args) {
		System.out.println(createPreparedStmtNoOfVarString(10));;
	}*/

}
