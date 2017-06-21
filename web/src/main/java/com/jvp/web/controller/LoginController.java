package com.jvp.web.controller;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

	@RequestMapping("/login")
	public String login(ModelMap model) {
		return "login";
	}
	
	@RequestMapping("/doLogin")
	public String doLogin(ModelMap model,String username,String password,String rememberMe) {
		password = DigestUtils.sha256Hex(password);
		UsernamePasswordToken token = new UsernamePasswordToken(username, password);
		if (rememberMe!=null) {
			token.setRememberMe(true);
		}
		Subject subject = SecurityUtils.getSubject();
		try {
			subject.login(token);
			if (subject.isAuthenticated()) {
				return "redirect:index";
			}
		} catch (AuthenticationException e) {
			model.addAttribute("msg", "登录失败：账号或密码不正确");
		}
		return "redirect:login";
	}
	
	@RequestMapping("/logout")
	public String logout(ModelMap model) {
		Subject subject = SecurityUtils.getSubject();
		subject.logout();
		return "redirect:login";
	}
	
}
