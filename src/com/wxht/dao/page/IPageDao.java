package com.wxht.dao.page;

import java.util.List;

import com.wxht.entity.Page;
/**
 * @description 页面dao层接口类
 * @author 刘阳
 * @time 2016-08-04
 */
public interface IPageDao {

	public void save(Page transientInstance);
	
	public void delete(Page persistentInstance);
	
	public Page findById(java.lang.String id);
	
	public List findByExample(Page instance);
	
	public List findByProperty(String propertyName, Object value);
	
	public List findAll();
	
	public Page merge(Page detachedInstance);
}
