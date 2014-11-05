package com.smilingframework.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.smilingframework.web.controller.base.BaseController;


@Controller
public class ContextController extends BaseController{

	/**
	 * 获取request contextPath
	 * @param request
	 * @return
	 */
	@RequestMapping("/context/path")
	@ResponseBody
	public String  getContextPath(HttpServletRequest request){
		return request.getContextPath();
	}
}
