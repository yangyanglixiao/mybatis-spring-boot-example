package com.inspur.springboot.service.impl;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.inspur.springboot.mapper.ArchiveMapper;
import com.inspur.springboot.mapper.UserMapper;
import com.inspur.springboot.model.User;
import com.inspur.springboot.model.UserArchive;
import com.inspur.springboot.service.IUserService;

@Service("userService")
public class UserServiceImpl implements IUserService {

	@Autowired
	private UserMapper userMapper;

	@Autowired
	private ArchiveMapper archiveMapper;

	@Transactional
	public User save(User user) {

		if (user.getId() != null && !user.getId().equals(" ")) {
			// 更新用户信息
			userMapper.updateByPrimaryKey(user);
			// 更新用户档案信息
			user.getArchive().setId(user.getId());
			archiveMapper.updateByPrimaryKey(user.getArchive());
		} else {
			// 保存用户信息
			user.setId(UUID.randomUUID().toString());
			userMapper.insert(user);
			// 保存用户档案信息
			user.getArchive().setId(user.getId());
			archiveMapper.insert(user.getArchive());
		}
		return user;
	}

	@Transactional
	public void delete(String[] ids) {
		for (int i = 0; i < ids.length; i++) {
			archiveMapper.deleteByPrimaryKey(ids[i]);
			userMapper.deleteByPrimaryKey(ids[i]);
		}
	}

	@Transactional
	public void delete(String id) {
		archiveMapper.deleteByPrimaryKey(id);
		userMapper.deleteByPrimaryKey(id);
	}

	public List<User> findAll(Map<String, Object> parameters) {
		// TODO Auto-generated method stub
		// List<User> aa = userMapper.findAlls();
		PageHelper.startPage((Integer) parameters.get("start"), (Integer) parameters.get("limit"));
		return userMapper.selectAll();
	}

	@Override
	public User findOne(String id) {
		// TODO Auto-generated method stub
		return userMapper.selectByPrimaryKey(id);
	}

	/**
	 * 根据id查询用户档案信息
	 * 
	 * @param id
	 *            [ID主键]
	 * 
	 * @return UserArchive
	 * 
	 */
	public UserArchive findArchive(String id) {
		return archiveMapper.selectByPrimaryKey(id);
	}
}
