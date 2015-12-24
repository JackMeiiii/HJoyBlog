package com.hanyx.hjoyblog.util;

public class StringUtil {
	/**
	 * �ж��Ƿ�Ϊ��
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String str) {
		return str == null || str.length() == 0;
	}

	/**
	 * ���ݷָ��������ַ���
	 * 
	 * @param string
	 * @param expr
	 * @return
	 */
	public static String[] string2Array(String string, String expr) {
		return string.split(expr);
	}

	/**
	 * �ж��ַ����Ƿ�����ո�
	 */
	public static boolean isSpace(String str){
		return str.contains("/s");
	}
}
