package com.carhome.utils;

/**
 * 字符串工具类
 * @author yehao
 */
public class StringUtil {
	/**
	 * 把0_1,0_2,1_3转换成数组
	 */
	public static String[] String2arr(String value,String target)
	{
		
		return value.split(target);
	}
	/**
	 *判断values是否包含value 
	 */
	public static boolean contains(String[] values, String value) {
		if(ValidateUtil.isValid(values))
		{
			for(String s : values)
			{
				if(s.equals(value))
				{
					return true;
				}
			}
		}
		return false;
	}

	
	/**
	 * 将数组转换成0_1,0_2,0_3的形式
	 */
	public static String arr2String(Object[] value) {
		String temp = "";
		if(ValidateUtil.isValid(value))
		{
			for(Object s : value)
			{
				temp = temp +s+ ",";
			}
			return temp.substring(0,temp.length()-1);
		}
		return temp;
	}
	
	/**
	 * 显示字符串有效长度（默认30位）
	 */
	public static String getDescString(String str)
	{
		if(ValidateUtil.isValid(str)&&str.length()>30)
		{
			return str.substring(0,30);
		}
		return str;
	}

}
