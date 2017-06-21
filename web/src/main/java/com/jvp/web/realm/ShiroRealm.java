package com.jvp.web.realm;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.jvp.services.model.User;
import com.jvp.services.service.UserService;

public class ShiroRealm extends AuthorizingRealm {

	private static final Logger logger = LoggerFactory
			.getLogger(ShiroRealm.class);

	@Autowired
	private UserService userService;

	/**
	 * 权限验证
	 */

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(
			PrincipalCollection principal) {

		principal.getPrimaryPrincipal();

		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();

		return info;
	}

	/**
	 * 登录验证
	 */

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken authcToken) {
		String username = (String) authcToken.getPrincipal();
		User user = userService.findUserByUsername(username);
		return new SimpleAuthenticationInfo(user.getUsername(),
				user.getPassword(), getName());
	}

}
