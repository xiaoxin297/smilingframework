package com.smilingframework.dao.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.smilingframework.dao.common.UUIDEntity;

@Entity
@Table(name = "t_test")
public class Test extends UUIDEntity {
	
	private static final long serialVersionUID = -1906808771095274700L;
	
	private String name;
	private String phone;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
}
