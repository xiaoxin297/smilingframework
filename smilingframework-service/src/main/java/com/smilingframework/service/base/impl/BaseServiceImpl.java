package com.smilingframework.service.base.impl;

import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.smilingframework.dao.base.BaseDao;
import com.smilingframework.dao.base.BaseEntity;
import com.smilingframework.service.base.BaseService;

public class BaseServiceImpl<T extends BaseEntity> implements BaseService<T> {

	@Autowired
	protected BaseDao<T> dao;
	@Override
	public T save(T t) {
		t.setUuid(UUID.randomUUID().toString());
		t.setCreateTime(new Date());
		return dao.save(t);
	}

	@Override
	public T get(String uuid) {
		return dao.getOne(uuid);
	}

	@Override
	public void delete(String uuid) {
		dao.delete(uuid);
	}

	@Override
	public void remove(String uuid) {
		T t = dao.getOne(uuid);
		t.setIsDelete(1);
		dao.save(t);
	}

	@Override
	@Transactional(rollbackFor={Exception.class,RuntimeException.class})
	public void removeBatch(String[] uuids) {
		for(String uuid : uuids){
			remove(uuid);
		}
	}

	@Override
	@Transactional(rollbackFor={Exception.class,RuntimeException.class})
	public void deleteBatch(String[] uuids) {
		for(String uuid : uuids){
			delete(uuid);
		}
	}

}
