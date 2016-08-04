package com.wxht.dao.admin;

import java.util.List;

import com.wxht.entity.Admin;
/**
 * @description 管理员dao层接口类
 * @author 刘阳
 * @time 2016-08-04
 */
public interface IAdminDao {

	public void save(Admin transientInstance);
	
	public void delete(Admin persistentInstance);
	
	public Admin findById(java.lang.String id);
	
	public List findByExample(Admin instance);
	
	public List findAll();
}
