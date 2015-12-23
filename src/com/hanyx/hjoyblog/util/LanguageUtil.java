package com.hanyx.hjoyblog.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.hanyx.hjoyblog.dao.LanguageDao;

/**
 * ������֧�ֹ�����
 * @author ��Ԫ��
 */
public class LanguageUtil {
	private static Log log = LogFactory.getLog(LanguageUtil.class);
	
	/** ���Ի��� ����*/
	public static String LANG;
	static {
		//TODO ȥϵͳ������Ϣ���ж�ȡ
		LANG = "CHS";
	}
	
	public static String get(String code) {
		LanguageDao dao = new LanguageDao();
		
		if (StringUtil.isEmpty(code)) {
			return code;
		}
		
		String val = dao.queryOne(
				new Query().addCriteria(Criteria.where("code").is(code))
				.addCriteria(Criteria.where("lang").is(LANG)))
		.getValue();
		
		if (StringUtil.isEmpty(val)) {
			log.error("[" + LANG + "]���Ի�ȡ[" + code + "]Ϊ��,����Language��������");
		}
		
		return val;
	}
}
