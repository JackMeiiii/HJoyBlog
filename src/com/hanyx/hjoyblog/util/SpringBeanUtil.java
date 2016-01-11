package com.hanyx.hjoyblog.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @desc: Spring Bean ������
 * @author ��Ԫ��
 */
public final class SpringBeanUtil implements ApplicationContextAware {

	private SpringBeanUtil() {}
	
	private static ApplicationContext applicationContext;

	@Override
	public void setApplicationContext(ApplicationContext ac)
			throws BeansException {
		applicationContext = ac;
	}

	public static Object getBean(String id) {
		return id == null ? null : applicationContext.getBean(id);
	}
}
