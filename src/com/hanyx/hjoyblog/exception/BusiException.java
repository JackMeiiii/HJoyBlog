package com.hanyx.hjoyblog.exception;

/**
 * @desc: ͳһ�쳣Bean
 * @author ��Ԫ��
 */
public class BusiException extends Exception{

	private static final long serialVersionUID = 9999L;

	/** ������� */
	private static int code;
	/** ������Ϣ */
	private static String msg;

	public BusiException(int code) {
		//TODO ����Msg
	}

	public static int getCode() {
		return code;
	}

	public static String getMsg() {
		return msg;
	}
}
