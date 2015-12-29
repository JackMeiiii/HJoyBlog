package com.hanyx.hjoyblog.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import sun.misc.BASE64Encoder;

public final class StringUtil {
	
	private StringUtil() {};
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
	
	/**
	 * @desc: ��MD5�����ַ���
	 * @author: ��Ԫ��
	 * @param str
	 * @return
	 * @date  : 2015��12��29��
	 */
	public static String encryptByMD5(String str) {
		if (StringUtil.isEmpty(str)) {
		     return str;
		}
		String retStr = null;
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("md5");
		} catch (NoSuchAlgorithmException e) {
			//������û��....���Ժ�����...
		}
		byte[] buf = md.digest(str.getBytes());
		BASE64Encoder encoder = new BASE64Encoder();
		retStr = encoder.encode(buf);
		return retStr;

	}
}
