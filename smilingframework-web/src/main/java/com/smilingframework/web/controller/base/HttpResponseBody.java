package com.smilingframework.web.controller.base;

public class HttpResponseBody extends BaseResponse{
	
	
	public HttpResponseBody(){
		
	}
	public HttpResponseBody(Object object){
		this.result = object;
	}
	
	private Object result;

	public Object getResult() {
		if(result == null){
			return "";
		}
		return result;
	}

	public void setResult(Object result) {
		this.result = result;
	}
	
}
