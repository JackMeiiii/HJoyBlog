package com.hanyx.hjoyblog.service.error;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.hanyx.hjoyblog.bean.ErrorCode;
import com.hanyx.hjoyblog.dao.ErrorCodeDao;
import com.hanyx.hjoyblog.util.GlobalConstraints;

/**
 * @desc:�����������ʵ��
 * @author ��Ԫ��
 */
public class ErrorCodeSvcImpl implements IErrorCodeSvc {
	@Autowired
	private ErrorCodeDao errorCodeDao;
	
	private static Log log = LogFactory.getLog(ErrorCodeSvcImpl.class);
	
	@Override
	public String getMessage(int code) {
		ErrorCode bean = errorCodeDao.queryById(code);
		if(bean != null){
			return bean.getMessage();
		}
		log.error("����ID:["+code+"]"+"�Ҳ�����Ӧ�Ĵ�����Ϣ");
		return GlobalConstraints.ErrorCode.UNKNOW_ERROR_MESSAGE;
	}


}
