package com.smilingframework.web.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.smilingframework.web.controller.common.BaseController;
import com.smilingframework.web.controller.common.BaseResponse;

@Controller
public class TestController extends BaseController {
	
	
	@RequestMapping("/test")
	@ResponseBody
	public BaseResponse test(@RequestBody @Valid TestReq req,BindingResult result){
		TestResp resp = new TestResp();
		if(result.hasErrors()){
			return setErrorResult(result, "400", "请求错误");
		}
		resp.setResult("返回数据");
		return setSuccestResult(resp);
	}
	@RequestMapping("/forword/{page}")
	public String forword(@PathVariable String page){
		return "/" + page;
	}
}