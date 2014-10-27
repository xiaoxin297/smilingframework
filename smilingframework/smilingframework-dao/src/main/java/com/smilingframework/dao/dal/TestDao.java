package com.smilingframework.dao.dal;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smilingframework.dao.model.Test;


public interface TestDao extends JpaRepository<Test, String> {
}
