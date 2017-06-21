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
import com.jvp.services.service.RoleService;

@Controller
@RequestMapping("/system/role")
public class RoleController {

	@Autowired
	private RoleService roleService;

	@RequestMapping("")
	public String index(ModelMap model) {
		return "system/role";
	}

	@RequestMapping("/list")
	@ResponseBody
	public Pagination<Role> list(Integer rows, Integer page) {
		Page Pages = new Page(rows, page);
		Pagination<Role> result = roleService.findAll(Pages);
		return result;
	}
	
	@RequestMapping("/add")
	@ResponseBody
	public Result add(Role entity) {
		Result  result = new Result();
		try {
			roleService.create(entity);
		} catch (Exception e) {
			result.setSuccess(false);
		}
		return result;
	}
	
	@RequestMapping("/modify")
	@ResponseBody
	public Result modify(Role entity) {
		Result  result = new Result();
		try {
			roleService.modify(entity);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}
	
	@RequestMapping("/destroy")
	@ResponseBody
	public Result destroy(Integer id) {
		Result  result = new Result();
		try {
			roleService.destroy(id);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}
	
}
