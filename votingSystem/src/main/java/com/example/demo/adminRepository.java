package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface adminRepository extends JpaRepository<Admin, Integer>{
	@Query(value = "select * from admin where aname=?1 and password=?2", nativeQuery = true)
public int findAdmin(String name,String password);

}
