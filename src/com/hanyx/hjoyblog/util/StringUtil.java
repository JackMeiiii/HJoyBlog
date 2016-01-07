package com.hanyx.hjoyblog.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.lang.StringUtils;

import sun.misc.BASE64Encoder;

/**
 * @desc:�ַ���������  ��չ Apache StringUtils
 * @author ��Ԫ��
 */
public final class StringUtil extends StringUtils {
	
	private StringUtil() {};

	/**
	 * @desc: �ж��ַ����Ƿ�Ϊ��,�հ��ַ�ҲΪ��
	 * @author: ��Ԫ��
	 * @param str
	 * @return
	 * @date  : 2016��1��7��
	 */
	public static boolean isRealEmpty(String str) {
		return str == null || str.trim().length() == 0;
	}

	/**
	 * @desc: ��MD5�����ַ���
	 * @author: ��Ԫ��
	 * @param str
	 * @return
	 * @date  : 2015��12��29��
	 */
	public static String encryptByMD5(String str) {
		if (StringUtil.isRealEmpty(str)) {
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
