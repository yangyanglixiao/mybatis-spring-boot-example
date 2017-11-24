package com.inspur.springboot.service;

import com.inspur.springboot.model.User;
import com.inspur.springboot.model.UserArchive;

public interface IUserService {
	/**
	 * 保存新增和修改后的用户信息
	 * 
	 * @param user
	 * @return
	 */
	public User save(User user);

	/**
	 * 根据ID删除用户
	 * 
	 * @param id
	 */
	public void delete(String id);

	/**
	 * 根据ID批量删除用户
	 * 
	 * @param ids
	 */
	public void delete(String[] ids);

	/**
	 * 查询所有用户数据
	 * 
	 * @param map
	 * @return
	 */
	// public List<User> findAll();

	/**
	 * 根据ID获取用户信息
	 * 
	 * @param id
	 * @return
	 */
	public User findOne(String id);

	/**
	 * 根据id查询用户档案信息
	 * 
	 * @param id
	 *            [ID主键]
	 * 
	 * @return UserArchive
	 * 
	 */
	public UserArchive findArchive(String id);
}
