package com.hanyx.hjoyblog.test;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.hanyx.hjoyblog.bean.User;
import com.hanyx.hjoyblog.dao.UserDao;
import com.hanyx.hjoyblog.util.GlobalConstraints;
import com.hanyx.hjoyblog.util.JBcrypt;

/**
 * @desc:��User�û����в����ʼ������
 * @author ��Ԫ��
 */
@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration(locations = {"file:WebContent/WEB-INF/spring-servlet.xml"})
public class UserInit{

	@Autowired
	private MongoTemplate mongoTemplate;
	@Autowired
	private UserDao userDao;
	
	@Test
	public void Test() {
		this.init();
		System.out.println(userDao.queryById("hanyx").getNickName());
	}
	
	public void init() {
		//��ռ���
		mongoTemplate.dropCollection(User.class);
		
		//��ʼ������
		User u = new User();
		u.setLoginName("hanyx");
		u.setLoginPwd(JBcrypt.hashpw("123456", JBcrypt.gensalt()));
		u.setNickName("��ؼJoy");
		u.setRole(GlobalConstraints.USER_ROLE_ID_ADMINISTRATOR);
		u.setTel("13803648899");
		u.setEmail("hanyx1992@sina.com");
		u.setIsUsed(GlobalConstraints.BEAN_DATA_STATE_ISUSED);
		u.setCreateDate(new Date());
		userDao.save(u);
	}
	
}
