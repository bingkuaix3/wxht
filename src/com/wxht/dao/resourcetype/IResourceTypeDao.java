package com.wxht.dao.resourcetype;

import java.util.List;

import com.wxht.entity.ResourceType;
/**
 * @description 资源类型dao层接口类
 * @author 刘阳
 * @time 2016-08-04
 */
public interface IResourceTypeDao {

	public void save(ResourceType transientInstance);
	
	public void delete(ResourceType persistentInstance);
	
	public ResourceType findById(java.lang.String id);
	
	public List findByExample(ResourceType instance);
	
	public List findByProperty(String propertyName, Object value);
	
	public List findAll();
	
	public ResourceType merge(ResourceType detachedInstance);
}
