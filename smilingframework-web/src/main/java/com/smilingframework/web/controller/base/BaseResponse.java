package com.smilingframework.web.controller.base;

public class BaseResponse {

	private String memo;
	private String code;
	
	private BaseResult result;
	
	
	public BaseResult getResult() {
		return result;
	}
	public void setResult(BaseResult result) {
		this.result = result;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
}
