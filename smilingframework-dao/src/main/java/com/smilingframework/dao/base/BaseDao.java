package com.smilingframework.dao.base;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BaseDao<T extends BaseEntity> extends JpaRepository<T, String> {

}
