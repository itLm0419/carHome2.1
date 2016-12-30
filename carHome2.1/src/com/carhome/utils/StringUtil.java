package com.carhome.utils;

/**
 * �ַ���������
 * @author yehao
 */
public class StringUtil {
	/**
	 * ��0_1,0_2,1_3ת��������
	 */
	public static String[] String2arr(String value,String target)
	{
		
		return value.split(target);
	}
	/**
	 *�ж�values�Ƿ����value 
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
	 * ������ת����0_1,0_2,0_3����ʽ
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
	 * ��ʾ�ַ�����Ч���ȣ�Ĭ��30λ��
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
