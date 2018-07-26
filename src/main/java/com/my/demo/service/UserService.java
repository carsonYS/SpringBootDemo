package com.my.demo.service;

import com.my.demo.entity.User;
import org.springframework.data.domain.Page;

public interface UserService {
	Page<User> test();
}
