package com.smilingframework.dao.dal;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * @author JpaRepository封装基类
 *
 * @param <T>
 * @param <ID>
 */
@NoRepositoryBean
public interface BaseJpaRepository<T,ID extends Serializable> extends JpaRepository<T, ID> {

}
