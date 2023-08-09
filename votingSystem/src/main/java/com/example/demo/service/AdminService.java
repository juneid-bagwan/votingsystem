package com.example.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Admin;
import com.example.demo.repository.adminRepository;
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
	public String findAdmin(String name,String password) {
		return repo.findAdmin(name, password);
	}
	public void deleteAdmin(int aid) {
		repo.deleteById(aid);
	}

}
