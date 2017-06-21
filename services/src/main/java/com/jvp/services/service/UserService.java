package com.jvp.services.service;

import com.jvp.core.model.Page;
import com.jvp.core.model.Pagination;
import com.jvp.services.model.Role;
import com.jvp.services.model.User;

public interface UserService{

	User findUserByUsername(String username);

	Pagination<User> findAll(Page pages);

	void create(User entity);

	void modify(Role entity);

	void destroy(Integer id);

}
