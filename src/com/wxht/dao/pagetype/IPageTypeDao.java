package com.wxht.dao.pagetype;

import java.util.List;

import com.wxht.entity.PageType;

/**
 * @description 页面类型dao层接口类
 * @author 刘阳
 * @time 2016-08-04
 */
public interface IPageTypeDao {

	public void save(PageType transientInstance);
	
	public void delete(PageType persistentInstance);
	
	public PageType findById(java.lang.String id);
	
	public List findByExample(PageType instance);
	
	public List findByProperty(String propertyName, Object value);
	
	public List findAll();
	
	public PageType merge(PageType detachedInstance);
}
