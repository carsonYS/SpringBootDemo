package com.my.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.my.demo.entity.User;
import com.my.demo.service.UserService;

@Controller
@RequestMapping(value = "/to")
public class JumpController {
	@Autowired
	private UserService userServiceImpl;

	@RequestMapping(value = "/index")
	public String index(Model model) {
		model.addAttribute("hello", "Hello World :-)");
		Page<User> page = userServiceImpl.test();
		model.addAttribute("page", page);
		return "index";
	}
}
