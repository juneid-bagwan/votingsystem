package com.example.demo;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
@Transactional
public class AdminService {
	@Autowired
	adminRepository repo;
	public void save(Admin admin) {
		repo.save(admin);
	}
	public List<Admin> listall(){
		return repo.findAll();
	}
	public int findAdmin(String name,String password) {
		return repo.findAdmin(name, password);
	}

}
