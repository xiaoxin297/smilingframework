package com.smilingframework.dao.base;


public interface BaseDao<T extends BaseEntity> extends BaseJpaRepository<T, String> {

}
