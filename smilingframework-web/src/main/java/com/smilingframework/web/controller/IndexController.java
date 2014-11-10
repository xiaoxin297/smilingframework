package com.smilingframework.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.smilingframework.web.controller.base.BaseController;
import com.smilingframework.web.controller.base.BaseResponse;

@Controller
@RequestMapping("/")
public class IndexController extends BaseController {

	@RequestMapping("index")
	public String index(){
		return "index";
	}
}
