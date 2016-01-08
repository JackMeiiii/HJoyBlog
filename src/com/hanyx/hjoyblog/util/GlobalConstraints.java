package com.hanyx.hjoyblog.util;

/**
 * ȫ�ֳ�������
 * @author ��Ԫ��
 */
public final class GlobalConstraints {
	
	private GlobalConstraints() {};
	
	/** ���б��е�����״̬ - δ�� */
	public static final short BEAN_DATA_STATE_NOTUSED = 0;
	/** ���б��е�����״̬ - ʹ�� */
	public static final short BEAN_DATA_STATE_ISUSED = 1;
	
	/** �û����н�ɫID - ����Ա */
	public static final short USER_ROLE_ID_ADMINISTRATOR = 0;
	/** �û����н�ɫID - �ÿ� */
	public static final short USER_ROLE_ID_GUEST = 1;
	
	/** Session�й���Ա����Ϣ */
	public static final String SESSION_KEY_USER = "HJOY_USER_INFO";
	
	/** ������� */
	public interface ErrorCode {
		/** δ֪�쳣����ʾ��Ϣ */
		public static final String UNKNOW_ERROR_MESSAGE = "δ֪�쳣";
		
		/** �û���������Ϊ�� */
		public static final int EMPTY_NAME_OR_PWD = 10001;
		/** �û������������ */
		public static final int WRONG_NAME_OR_PWD = 10002;
	}
	
}
