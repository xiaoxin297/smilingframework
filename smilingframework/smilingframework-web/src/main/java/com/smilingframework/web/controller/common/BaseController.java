package com.smilingframework.web.controller.common;

import java.util.List;

import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

/**
 * Controller基类
 * @author 王继永
 *
 */
public class BaseController {
	
	
	/**
	 * 设置参数错误响应信息
	 * @param result
	 * @param code
	 * @param memo
	 * @return
	 */
	protected BaseResponse setErrorResult(BindingResult result,String code,String memo) {
		BaseResponse response = new BaseResponse();
		response.setCode(code);
		response.setMemo(memo + " : " + getErrorMessages(result.getAllErrors()));
		return response;
	}
	
	/**
	 * 设置请求成功信息
	 * @param response
	 * @return
	 */
	protected BaseResponse setSuccestResult(BaseResponse response) {
		response.setCode("000000");
		response.setMemo("成功");
		return response;
	}

	/**
	 * 从result中获取错误信息
	 * @param errors
	 * @return
	 */
	private String getErrorMessages(List<ObjectError> errors) {
		StringBuffer buffer = new StringBuffer();
		for(ObjectError error:errors) {
			if(buffer.length() > 0){
				buffer.append(", ");
			}
			buffer.append(error.getDefaultMessage());
		}
		return buffer.toString();
	}
}
