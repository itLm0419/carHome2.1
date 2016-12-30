package com.carhome.utils;

import java.util.Collection;
/**
 * ��֤�ַ������������飬���ϣ������ʼ��Ƿ���Ч
 */
public class ValidateUtil {
	/**
	 * �ַ����Ƿ���Ч
	 */
	public static boolean isValid(String src)
	{
		//Ϊ�շ���false
		return !(src==null || "".equals(src.trim()));
	}
	/**
	 * ���϶����Ƿ���Ч����ת�Ͷ��� 
	 */
	public static boolean isValid(Collection col)
	{
		return !(col==null||col.isEmpty());
	}
	/**
	 * ���������Ƿ���Ч  
	 */
	public static boolean isValid(Object[] values) {
		if(values == null||values.length == 0)
		{
			return false;
		}
		return true;
	}
	
	/**
	 * �Ƿ���һ�������ʼ�
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
