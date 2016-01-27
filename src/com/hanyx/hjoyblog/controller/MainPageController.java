package com.hanyx.hjoyblog.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.hanyx.hjoyblog.bean.Catalog;
import com.hanyx.hjoyblog.service.catalog.ICatalogSvc;
import com.hanyx.hjoyblog.service.sysparam.ISysParamSvc;
import com.hanyx.hjoyblog.util.GlobalConstraints;
import com.hanyx.hjoyblog.util.VerificationCode;

@Controller
public class MainPageController {

	@Autowired
	private MongoTemplate mongoTemplate;

	public ModelAndView toHomePage() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("hello", mongoTemplate.getDb());
		mv.setViewName("main");
		return mv;
	}

	@Autowired
	private ISysParamSvc sysParamSvc;
	
	@Autowired
	private ICatalogSvc iCatalogSvc;

	@RequestMapping(value = "/main.do")
	public String queryAll(HttpServletRequest request) {
		List<Catalog> list = new ArrayList<Catalog>();
//		Short i=1,j=2;
//		iCatalogSvc.insert("ad","ss", i, j, DateUtil.format1(DateUtil.getNowTime()));
		list = iCatalogSvc.queryAll();
		request.setAttribute("catalogList", list);
		return "main";
	}
	
	/**
	 * @desc: 更新博客名称
	 * @author: 梅海风
	 * @param request
	 * @date  : 2016年1月19日
	 */
	@RequestMapping(value="/updateBlogName.do")
	public void updateBlogName(HttpServletRequest request){
		String val=request.getParameter("val");
			sysParamSvc.updateValueByCode(GlobalConstraints.SYS_PARAM.BLOG_NAME,val);
	}
	
	/**
	 * @desc: 
	 * @author: 梅海风
	 * @param request
	 * @return
	 * @date  : 2016年1月19日
	 */
	@RequestMapping(value="/click1.do")
	public String click1(HttpServletRequest request) throws Exception{
		String blog_name=sysParamSvc.getValueByCode(GlobalConstraints.SYS_PARAM.BLOG_NAME);
		request.setAttribute("blog_name", blog_name);
		request.setAttribute("errorMsg",request.getParameter("errorMsg"));
		return "/admin/click1";
	}
	
	@RequestMapping(value="/verifyCode")
	public void verifyCode(HttpServletRequest request,HttpServletResponse response) throws IOException{
		response.setContentType(VerificationCode.getMimeType());
		VerificationCode.verifyCode(response.getOutputStream());
	}
}
