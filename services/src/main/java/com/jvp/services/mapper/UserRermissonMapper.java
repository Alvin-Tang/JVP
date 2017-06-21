package com.jvp.services.mapper;

import com.jvp.services.model.UserRermisson;

public interface UserRermissonMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserRermisson record);

    int insertSelective(UserRermisson record);

    UserRermisson selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserRermisson record);

    int updateByPrimaryKey(UserRermisson record);
}