package com.mjs.el;

public class CheckUtil {
	public static String checkUtil(String str,String str2){
		if(str2.contains(str)){
			return "checked='checked'";
		}
		return "";
	}
}
