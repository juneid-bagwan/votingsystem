package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.Admin;

public interface adminRepository extends JpaRepository<Admin, Integer>{
	@Query(value = "select admin.aname from admin where aname=?1 and password=?2", nativeQuery = true)
public String findAdmin(String name,String password);

}
