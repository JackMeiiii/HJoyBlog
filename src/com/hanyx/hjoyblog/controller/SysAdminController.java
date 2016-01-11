package com.hanyx.hjoyblog.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.hanyx.hjoyblog.bean.User;
import com.hanyx.hjoyblog.service.user.IUserSvc;
import com.hanyx.hjoyblog.util.GlobalConstraints;

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
	
	/**
	 * @desc: ��ת����¼ҳ��
	 * @author: ��Ԫ��
	 * @param request
	 * @param response
	 * @return
	 * @date  : 2016��1��11��
	 */
	@RequestMapping(value = "/index.do")
	public ModelAndView toLogin(HttpServletRequest request, 
			HttpServletResponse response) {
		//TODO У������Ѿ���¼ֱ����ת��̨ҳ��
		request.setAttribute("loginName", request.getParameter("loginName"));
		request.setAttribute("loginPwd", request.getParameter("loginPwd"));
		request.setAttribute("errorMsg", request.getParameter("errorMsg"));
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("hello", mongoTemplate.getDb());
		mv.setViewName("/admin/login");
		return mv;
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
		
		User user = userSvc.verifyAdminLogin(loginName, loginPwd);
		
		//�û�������У��ɹ�,����Session�ؽ�,��ֹSession�ٳ�
		request.getSession().invalidate();
		request.getSession(true).setAttribute(GlobalConstraints.SESSION_KEY_USER, user);
		
		//�û�cookie��¼
		Cookie cookie = new Cookie("IS_LOGIN", "true");
		cookie.setPath("/");
		cookie.setMaxAge(3600);
		response.addCookie(cookie);
		
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
