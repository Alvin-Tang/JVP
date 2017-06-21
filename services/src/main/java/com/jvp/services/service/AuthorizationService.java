package com.jvp.services.service;

import java.util.List;

import com.jvp.services.model.Permission;

public interface AuthorizationService {

	List<Permission> findPermissionListByUid(Integer username);

}
