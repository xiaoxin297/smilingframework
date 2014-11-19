package com.smilingframework.service.base.impl;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.smilingframework.dao.base.BaseDao;
import com.smilingframework.dao.base.BaseEntity;
import com.smilingframework.service.base.BaseService;
@Service
public class BaseServiceImpl<T extends BaseEntity> implements BaseService<T> {

	protected Class<T> clazz;
	
	public  BaseServiceImpl(){
		this.clazz = getParameterizeClass(this.getClass(), 0);
	}
	
	@PersistenceContext
	protected EntityManager em;
	
	@Autowired
	protected BaseDao<T> dao;
	@Override
	public T save(T t) {
		if(t.getUuid() == null){
			t.setUuid(UUID.randomUUID().toString());
			t.setCreateTime(new Date());
		}else{
			t.setUpdateTime(new Date());
		}
		return dao.save(t);
	}
	
	@Override
	@Transactional(rollbackFor = {Exception.class})
	public void save(List<T> ts){
		for(T t : ts){
			save(t);
		}
	}
	

	@Override
	public T get(String uuid) {
		return em.find(clazz, uuid);
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
	
	
	private static Class getParameterizeClass(Class clazz, int index) {
		Type genType = clazz.getGenericSuperclass();
		if (!(genType instanceof ParameterizedType)) {
			return Object.class;
		}
		Type[] params = ((ParameterizedType) genType).getActualTypeArguments();
		if (index >= params.length || index < 0) {
			return Object.class;
		}
		if (!(params[index] instanceof Class)) {
			return Object.class;
		}
		return (Class) params[index];
	}
}
