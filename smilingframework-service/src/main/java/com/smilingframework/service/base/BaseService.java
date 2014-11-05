package com.smilingframework.service.base;

import com.smilingframework.dao.base.BaseEntity;

public interface BaseService<T extends BaseEntity> {

	/**
	 * 保存
	 * @param news
	 * @return
	 */
	public T save(T news);
	
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
}
