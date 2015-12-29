package com.hanyx.hjoyblog.service.user;

import com.hanyx.hjoyblog.bean.User;

/**
 * �û���ķ���
 * @author ��Ԫ��
 */
public interface IUserSvc {

	/**
	 * ���ݵ�¼���Ʋ�ѯ�û���Ϣ
	 * @param loginName
	 * @return
	 */
	User getUserInfoByLoginName(String loginName);
	
	/**
	 * ��֤����Ա��¼������
	 * @param loginName
	 * @param loginPwd
	 * @throws Exception
	 * @return
	 */
	User verifyAdminLogin(String loginName, String loginPwd) throws Exception;
}
