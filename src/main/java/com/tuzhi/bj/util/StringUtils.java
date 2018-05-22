package com.tuzhi.bj.util;

/**
 * 字符串的非空判断
 * @author 郑德超
 *
 */
public class StringUtils {

	public static boolean isNotEmpty(String str){
		return !isEmpty(str);
	}
	
	public static boolean isEmpty(String str){
		return str == null || str.trim().length()==0;
	}
	
	public static boolean hasEmpty(String... str){
		for (String string : str) {
			if(string == null || string.trim().length()==0){
				return true;
			}
		}
		return false;
	}
	public static boolean hasNoEmpty(String... str){
		return !hasEmpty(str);
	}
	
}
