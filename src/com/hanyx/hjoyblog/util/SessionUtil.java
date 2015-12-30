package com.hanyx.hjoyblog.util;

import javax.servlet.http.HttpServletRequest;

/**
 * @desc:��Session�йصĹ�����
 * @author ��Ԫ��
 */
public final class SessionUtil {

	private SessionUtil() {};
	
	/**
	 * @desc: ����Ա�Ƿ��¼
	 * @author: ��Ԫ��
	 * @param request
	 * @return
	 * @date  : 2015��12��30��
	 */
	public static boolean isLogined (HttpServletRequest request) {
		//��У��
		if (request == null || request.getSession() == null) {
			return false;
		}
		return request.getAttribute(GlobalConstraints.SESSION_KEY_USER)!=null;
	}
}
