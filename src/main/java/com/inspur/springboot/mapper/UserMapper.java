package com.inspur.springboot.mapper;

import java.util.List;

import com.inspur.springboot.model.User;
import com.inspur.springboot.util.MyMapper;

public interface UserMapper extends MyMapper<User> {
	/**
	 * 查询所有用户数据
	 * 
	 * @param map,
	 *            key 分别为 ： <code>orderfield<code>[排序列]
	 *            <code>orderdir<code>[排序方向desc或asc] <code>start<code>[起始行]
	 *            <code>limit<code>[每页显示条数]
	 * 
	 * @return List, 内容为User对象列表
	 * 
	 */
	List<User> findAlls();
}
