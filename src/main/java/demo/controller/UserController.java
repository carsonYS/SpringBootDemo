package com.my.demo.controller;

import com.my.demo.entity.User;
import com.my.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/user")
public class UserController {
	@Autowired
	private UserService userServiceImpl;

	@RequestMapping(value = "/test")
	@ResponseBody
	public Page<User> test() {
		return userServiceImpl.test();
	}
}
