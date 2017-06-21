package com.jvp.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jvp.core.model.Page;
import com.jvp.core.model.Pagination;
import com.jvp.core.model.Result;
import com.jvp.services.model.Role;
import com.jvp.services.model.User;
import com.jvp.services.service.UserService;

@Controller
@RequestMapping("/system/user")
public class UserController {
	
	@Autowired
	private UserService userService;

	@RequestMapping("")
	public String index(ModelMap model) {
		return "system/user";
	}

	@RequestMapping("/list")
	@ResponseBody
	public Pagination<User> list(Integer rows, Integer page) {
		Page Pages = new Page(rows, page);
		Pagination<User> result = userService.findAll(Pages);
		return result;
	}

	@RequestMapping("/add")
	@ResponseBody
	public Result add(User entity) {
		Result result = new Result();
		try {
			userService.create(entity);
		} catch (Exception e) {
			result.setSuccess(false);
		}
		return result;
	}

	@RequestMapping("/modify")
	@ResponseBody
	public Result modify(Role entity) {
		Result result = new Result();
		try {
			userService.modify(entity);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}

	@RequestMapping("/destroy")
	@ResponseBody
	public Result destroy(Integer id) {
		Result result = new Result();
		try {
			userService.destroy(id);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}

}
