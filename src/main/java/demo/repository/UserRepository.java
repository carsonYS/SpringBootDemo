package com.my.demo.repository;

import com.my.demo.entity.User;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	/*
	 * 无需重写改方法
	 * JPA将方法名findByNicknameLike解释为
	 * select user0_.id as id1_1_, user0_.insert_time as insert_t2_1_, user0_.is_delete as is_delet3_1_, user0_.nickname as nickname4_1_, user0_.password as password5_1_, user0_.username as username6_1_ from user user0_ where user0_.nickname like ?
	 * */
	List<User> findByNicknameLike(String nickname);
	
	/*
	 * select user0_.id as id1_1_, user0_.insert_time as insert_t2_1_, user0_.is_delete as is_delet3_1_, user0_.nickname as nickname4_1_, user0_.password as password5_1_, user0_.username as username6_1_ from user user0_ 
	 * where user0_.id<? and user0_.id>?
	 * 
	 * */
	List<User> findByUserIdLessThanAndUserIdGreaterThan(Integer id1, Integer id2);
	
	
}
