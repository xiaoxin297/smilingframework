package com.smilingframework.dao.base;

import org.springframework.data.repository.NoRepositoryBean;


public interface BaseDao<T extends BaseEntity> extends BaseJpaRepository<T, String> {

}
