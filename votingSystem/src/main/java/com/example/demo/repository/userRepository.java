package com.example.demo.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.User;

public interface userRepository extends JpaRepository<User, Integer>{
	@Query(value = "select user.uid from user where uid=?1",nativeQuery = true)
	public int findUser(int uid);
	@Query(value = "select * from user where fname like %:name%",nativeQuery = true)
	public List<User> searchUser(@Param("name") String name);

}
