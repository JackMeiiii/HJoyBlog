package com.hanyx.hjoyblog.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.hanyx.hjoyblog.bean.ErrorCode;
import com.hanyx.hjoyblog.dao.ErrorCodeDao;

/**
 * @desc:��ErrorCode���������в����ʼ������
 * @author ��Ԫ��
 */
@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration(locations = {"file:WebContent/WEB-INF/spring-servlet.xml"})
public class ErrorCodeInit{

	@Autowired
	private ErrorCodeDao errorCodeDao;
	
	@Test
	public void Test() {
		this.init();
		System.out.println(this.query().getMessage());
	}
	
	public void init() {
		ErrorCode data = new ErrorCode();
		data.setCode(10001);
		data.setMessage("�û����������벻��Ϊ��");
		errorCodeDao.save(data);
	}
	
	public ErrorCode query () {
		return errorCodeDao.queryById(10001);
	}
	
}
