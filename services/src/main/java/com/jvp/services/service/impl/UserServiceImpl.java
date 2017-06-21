package com.jvp.services.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jvp.core.model.Page;
import com.jvp.core.model.Pagination;
import com.jvp.services.mapper.UserMapper;
import com.jvp.services.model.Role;
import com.jvp.services.model.User;
import com.jvp.services.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserMapper userMapper;
	
	public User findUserByUsername(String username) {
		return userMapper.selectByUserName(username);
	}

	@Override
	public Pagination<User> findAll(Page pages) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void create(User entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modify(Role entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void destroy(Integer id) {
		// TODO Auto-generated method stub
		
	}
	
}
