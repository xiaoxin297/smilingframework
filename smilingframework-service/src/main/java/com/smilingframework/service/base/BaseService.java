package com.smilingframework.service.base;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.smilingframework.dao.base.BaseEntity;

public interface BaseService<T extends BaseEntity> {

	/**
	 * 保存
	 * @param news
	 * @return
	 */
	public T save(T t);
	
	/**
	 * 批量保存
	 * @param ts
	 */
	public void save(List<T> ts);
	
	/**
	 * 獲取
	 * @param uuid
	 * @return
	 */
	public T get(String uuid);
	
	/**
	 * 刪除 - 物理刪除
	 * @param uuid
	 * @return
	 */
	public void delete(String uuid);
	
	/**
	 * 移除 - 邏輯刪除
	 * @param uuid
	 * @return
	 */
	public void remove(String uuid);
	
	/**
	 * 批量移除 - 逻辑删除
	 * @param uuids
	 */
	public void removeBatch(String[] uuids);
	
	/**
	 * 批量删除- 物理删除
	 * @param uuids
	 */
	public void deleteBatch(String[] uuids);
	
	/**
	 * 获取所有记录
	 * @return
	 */
	public List<T> findAll();
	
}
