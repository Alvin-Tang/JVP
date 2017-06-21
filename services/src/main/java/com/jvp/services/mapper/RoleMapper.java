package com.jvp.services.mapper;

import java.util.List;

import com.jvp.core.model.Page;
import com.jvp.services.model.Role;

public interface RoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);

	List<Role> selectRoleListByUid(Integer uid);

	List<Role> selectPageListByPages(Page pages);

	Integer selectRowByPages(Page pages);
}