package com.hanyx.hjoyblog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * ��̨����ҳ��
 * @author ��Ԫ��
 */
@Controller
@RequestMapping("/admin")
public class SysAdminController {
	
	@Autowired
	private MongoTemplate mongoTemplate;
	
	@RequestMapping(value = "/index.do")
	public ModelAndView toHomePage() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("hello", mongoTemplate.getDb());
		mv.setViewName("/admin/login");
		return mv;
    }
}
