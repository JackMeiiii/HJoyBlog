package com.hanyx.hjoyblog.util;

/**
 * 全局常量配置
 * @author 韩元旭
 */
public final class GlobalConstraints {
	
	private GlobalConstraints() {};
	
	/** 所有表中的数据状态 - 未用 */
	public static final short BEAN_DATA_STATE_NOTUSED = 0;
	/** 所有表中的数据状态 - 使用 */
	public static final short BEAN_DATA_STATE_ISUSED = 1;
	
	/** 用户表中角色ID - 管理员 */
	public static final short USER_ROLE_ID_ADMINISTRATOR = 0;
	/** 用户表中角色ID - 访客 */
	public static final short USER_ROLE_ID_GUEST = 1;
	
	/** Session中管理员的信息 */
	public static final String SESSION_KEY_USER = "HJOY_USER_INFO";
	
	/** 错误编码 */
	public interface ErrorCode {
		
		/** 用户名或密码为空 */
		public static final int EMPTY_NAME_OR_PWD = 10001;
		/** 用户名或密码错误 */
		public static final int WRONG_NAME_OR_PWD = 10002;
	}
	
}
