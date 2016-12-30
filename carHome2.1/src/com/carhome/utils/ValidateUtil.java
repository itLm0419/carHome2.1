package com.carhome.utils;

import java.util.Collection;
/**
 * 验证字符串，对象数组，集合，电子邮件是否有效
 */
public class ValidateUtil {
	/**
	 * 字符串是否有效
	 */
	public static boolean isValid(String src)
	{
		//为空返回false
		return !(src==null || "".equals(src.trim()));
	}
	/**
	 * 集合对象是否有效（上转型对象） 
	 */
	public static boolean isValid(Collection col)
	{
		return !(col==null||col.isEmpty());
	}
	/**
	 * 对象数组是否有效  
	 */
	public static boolean isValid(Object[] values) {
		if(values == null||values.length == 0)
		{
			return false;
		}
		return true;
	}
	
	/**
	 * 是否是一个电子邮件
	 */
	public static boolean isEmail(String email) {
		String string  = "^([a-z0-9A-Z]+[-|_|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
		if(email.matches(string))
		{
			return true;
		}
		return false;
	}
}	
