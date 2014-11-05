package com.smilingframework.web.controller.model;

import org.hibernate.validator.constraints.NotEmpty;

public class TestReq {

	@NotEmpty(message = "名称不能為空")
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
