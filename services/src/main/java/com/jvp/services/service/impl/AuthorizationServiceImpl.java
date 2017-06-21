package com.jvp.services.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.jvp.services.mapper.PermissionMapper;
import com.jvp.services.mapper.RoleMapper;
import com.jvp.services.model.Permission;
import com.jvp.services.model.Role;
import com.jvp.services.service.AuthorizationService;

@Service
public class AuthorizationServiceImpl implements AuthorizationService {
	
	@Autowired
	private RoleMapper roleMapper;

	@Autowired
	private PermissionMapper permissionMapper;

	public List<Permission> findPermissionListByUid(Integer uid) {
		List<Permission> list = new ArrayList<Permission>();
		List<Role> roleList = roleMapper.selectRoleListByUid(uid);
		if (!CollectionUtils.isEmpty(roleList)) {
			for (Role role : roleList) {
				List<Permission> plist = permissionMapper
						.selectPermissionListByRid(role.getId());
				for (Permission permission : plist) {
					boolean had =false;
					for (Permission p : list) {
						if (p.getId().equals(permission.getId())) {
							had =true;
							break;
						}
					}
					if (!had) {
						list.add(permission);	
					}					
				}
			}
		}
		return list;
	}

}
