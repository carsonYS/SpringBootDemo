package com.my.demo.repository;

import com.my.demo.configuration.Entry;
import com.my.demo.entity.Address;
import com.my.demo.entity.User;
import com.sun.deploy.config.Config;
import org.hibernate.sql.ordering.antlr.OrderingSpecification;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.data.querydsl.QPageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = Entry.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;

    @Test
    public void testSave() {
        User user = new User();
        user.setUsername("admin");
        user.setPassword("123456");
        user.setNickname("小明");
        user.setInsertTime(new Date());
        user.setIsDelete(false);
        Set<Address> addresses = new HashSet<Address>();
        Address address = new Address();
        address.setAddressId(1);
        addresses.add(address);
        user.setAddresses(addresses);
        userRepository.save(user);
    }

    @Test
    public void testFind() {
        User user = new User();
        user.setIsDelete(false);
        user.setNickname("小");
        ExampleMatcher matcher = ExampleMatcher.matching()
                .withMatcher("nickname", ExampleMatcher.GenericPropertyMatchers.contains());
        Example<User> userExample = Example.of(user, matcher);
        Sort sort = new Sort(Sort.Direction.DESC,"insertTime");
        int pageNumber = 1;
        int pageSize = 10;
        Pageable pageable = new PageRequest(pageNumber, pageSize, sort);
        userRepository.findAll(userExample, pageable);

    }
    @Test
    public void testBatchSave() {
        User user = new User();
        user.setUsername("admin1");
        user.setPassword("123456");
        user.setNickname("小李");
        user.setInsertTime(new Date());
        user.setIsDelete(false);
        ArrayList<User> users = new ArrayList<User>();
        users.add(user);
        user = new User();
        user.setUsername("admin2");
        user.setPassword("123456");
        user.setNickname("小花");
        user.setInsertTime(new Date());
        user.setIsDelete(false);
        users.add(user);
        userRepository.save(users);
    }

    @Test
    public void testUpdate() {
        User user = new User();
        user.setUserId(1);
        user.setPassword("1234567");
        user.setUsername("admin");
        user.setNickname("小李");
        user.setInsertTime(new Date());
        user.setIsDelete(false);
        //update user set insert_time=?, is_delete=?, nickname=?, password=?, username=? where id=?
        userRepository.saveAndFlush(user);
    }
}
