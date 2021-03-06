package com.baobaotao.web;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.baobaotao.domain.User;
import com.baobaotao.service.UserService;

@Controller
public class LoginController {

	@Autowired
	private UserService userService;
	
	@RequestMapping("/index.html")
	public String loginPage() {
		return "login";
	}
	
	@RequestMapping("/loginCheck.html")
	public ModelAndView loginCheck(HttpServletRequest request, LoginBean loginBean) {
		boolean isValidUser = userService.hasMatchUser(loginBean.getUserName(), loginBean.getPassword());
		
		if (!isValidUser) {
			return new ModelAndView("login", "error", "用户名密码错误");
		} else {
			User user = userService.findUserByUserName(loginBean.getUserName());
			user.setLastIp(request.getLocalAddr());
			user.setLastVisit(new Date());
			userService.loginSuccess(user);
			request.getSession().setAttribute("user", user);
			return new ModelAndView("main");
		}
	}
}
