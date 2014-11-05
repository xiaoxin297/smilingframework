package com.smilingframework.dao.base;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class UUIDEntity implements Serializable {

	private static final long serialVersionUID = -6588910308728470737L;
	
	public UUIDEntity(){
	}
	
	@Id
	private String uuid;

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	
}
