package com.wxht.dao.user;

import java.util.List;

import com.wxht.entity.User;
/**
 * @description 用户dao层接口类
 * @author 刘阳
 * @time 2016-08-04
 */
public interface IUserDao {

	public void save(User transientInstance);
	
	public void delete(User persistentInstance);
	
	public User findById(java.lang.String id);
	
	public List findByExample(User instance);
	
	public List findByProperty(String propertyName, Object value);
	
	public List findAll();
	
	public User merge(User detachedInstance);
}
