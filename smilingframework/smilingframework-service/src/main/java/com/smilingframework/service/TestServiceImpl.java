package com.smilingframework.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smilingframework.dao.dal.TestDao;
import com.smilingframework.dao.model.Test;

@Service
public class TestServiceImpl implements TestService{

	@Autowired
	private TestDao testDao;
	@Override
	public void print() {
		System.out.println("这是一个测试");
		Test test = new Test();
		test.setUuid(UUID.randomUUID().toString());
		test.setPhone("phone");
		test.setName("name");
		testDao.save(test);
	}
}
