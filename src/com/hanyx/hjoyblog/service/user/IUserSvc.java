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
	
	/**
	 * @desc: ��¼����IP��ַ
	 * @author: ��Ԫ��
	 * @param loginName
	 * @param loginIP
	 * @throws Exception
	 * @date  : 2016��1��12��
	 */
	void logLoginIP(String loginName, String loginIP) throws Exception;

	/**
	 * @desc: �Զ���¼
	 * @author: ��Ԫ��
	 * @param ip
	 * @return
	 * @date  : 2016��1��12��
	 */
	User autoLogin(String ip)  throws Exception;
}
