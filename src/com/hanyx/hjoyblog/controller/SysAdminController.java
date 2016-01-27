package com.hanyx.hjoyblog.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hanyx.hjoyblog.bean.User;
import com.hanyx.hjoyblog.service.sysparam.ISysParamSvc;
import com.hanyx.hjoyblog.service.user.IUserSvc;
import com.hanyx.hjoyblog.util.GlobalConstraints;
import com.hanyx.hjoyblog.util.SessionUtil;
import com.hanyx.hjoyblog.util.StringUtil;

/**
 * ��̨����ҳ��
 * @author ��Ԫ��
 */
@Controller
@RequestMapping("/admin")
public class SysAdminController {
	
	@Autowired
	private MongoTemplate mongoTemplate;
	
	@Autowired
	private IUserSvc userSvc;
	
	@Autowired
	private ISysParamSvc sysParamSvc;
	/**
	 * @desc: ��ת����¼ҳ��
	 * @author: ��Ԫ��
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception 
	 * @date  : 2016��1��11��
	 */
	@RequestMapping(value = "/index.do")
	public String toLogin(HttpServletRequest request, 
			HttpServletResponse response) throws Exception {
		Cookie[] cookies = request.getCookies();
		
		if (cookies != null && cookies.length > 0) {
			for (Cookie c : cookies) {
				if (GlobalConstraints.COOKIE_KEY_AUTO_LOGIN.equals(c.getName())
						&& GlobalConstraints.COOKIE_VALUE_AUTO_LOGIN.equals(c.getValue())) {
					String ip = SessionUtil.getIpAddress(request);
					User user = userSvc.autoLogin(ip);
					return loginSuccess(request, user);
				}
			}
		}
		
		request.setAttribute("loginName", request.getParameter("loginName"));
		request.setAttribute("loginPwd", request.getParameter("loginPwd"));
		request.setAttribute("errorMsg", request.getParameter("errorMsg"));
		
		return "/admin/login";
    }
	
	/**
	 * @desc: �����¼ 
	 * @author: ��Ԫ��
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 * @date  : 2016��1��11��
	 */
	@RequestMapping(value = "/login.do")
	public String login(HttpServletRequest request, 
			HttpServletResponse response) throws Exception {
		//��ȡ����
		String loginName = request.getParameter("loginName");
		String loginPwd = request.getParameter("loginPwd");
		String autoLogin = request.getParameter("autoLogin");
		String loginIP = SessionUtil.getIpAddress(request);
		
		//У������
		User user = userSvc.verifyAdminLogin(loginName, loginPwd);
		
		//��¼�Զ���¼IP
		if (!StringUtil.isRealEmpty(autoLogin) && "true".equals(autoLogin)) {
			Cookie c= new Cookie(GlobalConstraints.COOKIE_KEY_AUTO_LOGIN,
					GlobalConstraints.COOKIE_VALUE_AUTO_LOGIN);
			c.setPath("/");
			c.setMaxAge(60 * 60 * 24);
			response.addCookie(c);
			userSvc.logLoginIP(loginName, loginIP);
		}
		
		return loginSuccess(request, user);
    }

	/**
	 * @desc: ��¼�ɹ� ҳ���ض���
	 * @author: ��Ԫ��
	 * @param request
	 * @param user
	 * @return
	 * @date  : 2016��1��12��
	 */
	private String loginSuccess(HttpServletRequest request, User user) {
		//�û�������У��ɹ�,����Session�ؽ�,��ֹSession�ٳ�
		request.getSession().invalidate();
		request.getSession(true).setAttribute(GlobalConstraints.SESSION_KEY_USER, user);
		
		return "redirect:/admin/settings.do";
	}
	
	/**
	 * @desc: ��̨��ҳ
	 * @author: ��Ԫ��
	 * @param request
	 * @param response
	 * @return
	 * @date  : 2016��1��11��
	 */
	@RequestMapping(value = "/settings.do")
	public String settings(HttpServletRequest request, 
			HttpServletResponse response) {
		return "/admin/setting";
	}
}
