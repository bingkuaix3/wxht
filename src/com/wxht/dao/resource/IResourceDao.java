package com.wxht.dao.resource;

import java.util.List;

import com.wxht.entity.Resource;
/**
 * @description 资源dao层接口类
 * @author 刘阳
 * @time 2016-08-04
 */
public interface IResourceDao {

	public void save(Resource transientInstance);
	
	public void delete(Resource persistentInstance);
	
	public Resource findById(java.lang.String id);
	
	public List findByExample(Resource instance);
	
	public List findByProperty(String propertyName, Object value);
	
	public List findAll();
	
	public Resource merge(Resource detachedInstance);
}
