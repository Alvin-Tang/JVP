package com.jvp.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class ErrorController {
	
	@RequestMapping("/error")
	public String index(ModelMap model) {
		return "error";
	}
	
}
