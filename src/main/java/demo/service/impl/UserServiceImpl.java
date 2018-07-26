package com.my.demo.service.impl;

import com.my.demo.entity.User;
import com.my.demo.repository.UserRepository;
import com.my.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public Page<User> test() {
		User user = new User();
		user.setIsDelete(false);
		user.setNickname("小");
		ExampleMatcher matcher = ExampleMatcher.matching().withMatcher("nickname",
				ExampleMatcher.GenericPropertyMatchers.contains());
		Example<User> userExample = Example.of(user, matcher);
		Sort sort = new Sort(Sort.Direction.DESC, "insertTime");
		int pageNumber = 0;
		int pageSize = 10;
		Pageable pageable = new PageRequest(pageNumber, pageSize, sort);
		Page<User> page = userRepository.findAll(userExample, pageable);
		return page;
	}
}
