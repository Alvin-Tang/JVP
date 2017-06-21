package com.jvp.web.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.jvp.common.model.Tree;
import com.jvp.common.util.TreeUtil;
import com.jvp.services.model.Permission;
import com.jvp.services.model.User;
import com.jvp.services.service.AuthorizationService;
import com.jvp.services.service.PermissionService;
import com.jvp.services.service.UserService;

@Controller
public class IndexController {
	
	@Autowired
	private UserService userService;

	@Autowired
	private AuthorizationService authorizationService;

	@RequestMapping("/index")
	public String index(ModelMap model) {
		Subject subject = SecurityUtils.getSubject();
		model.addAttribute("username", subject.getPrincipal());
		return "index";
	}

	@RequestMapping("/getMenu")
	@ResponseBody
	public List<Tree> getMenu()  {
		Subject subject = SecurityUtils.getSubject();
		String username = (String) subject.getPrincipal();
		User user = userService.findUserByUsername(username);
		List<Permission> permissions = authorizationService
				.findPermissionListByUid(user.getId());
		List<Tree> trees = new ArrayList<Tree>();
		for (Permission permission : permissions) {
			Tree tree = new Tree();
			tree.setId(permission.getId());
			tree.setPid(permission.getParentId());
			tree.setText(permission.getName());
			tree.setUrl(permission.getUrl());
			trees.add(tree);
		}
		return TreeUtil.formatTree(trees);
	}

}
