package com.jvp.services.mapper;

import com.jvp.services.model.User;

public interface UserMapper{

	User selectByUserName(String username);

}