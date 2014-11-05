package com.smilingframework.dao.base;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.DynamicInsert;

@MappedSuperclass
@DynamicInsert
public class BaseEntity extends UUIDEntity {
	
	public BaseEntity(){
	}

	@Column(name="create_time",nullable=false)
	private Date createTime;// 创建时间
	@Column(name="update_time")
	private Date updateTime;// 更新时间
	@Column(name="delete_time")
	private Date deleteTime;// 删除时间
	@Column(columnDefinition="int default 0",name="is_delete",nullable = false)
	private Integer isDelete = 0;// 是否删除  {0 ： 未删除   1 ：已删除}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Date getDeleteTime() {
		return deleteTime;
	}

	public void setDeleteTime(Date deleteTime) {
		this.deleteTime = deleteTime;
	}

	public Integer getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}
	
}
