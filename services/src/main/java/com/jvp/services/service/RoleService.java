package com.jvp.services.service;

import com.jvp.core.model.Page;
import com.jvp.core.model.Pagination;
import com.jvp.services.model.Role;


public interface RoleService{

	Pagination<Role> findAll(Page pages);

	void create(Role entity);

	void modify(Role entity);

	void destroy(Integer id);

}
