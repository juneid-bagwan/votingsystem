package com.example.demo;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UserService {
	@Autowired
	userRepository repo;
	public void save(User user) {
		repo.save(user);
	}
	public List<User> listall(){
		return repo.findAll();
	}
	public boolean find(int a) {
		Optional<User> ls=repo.findById(a);
		if(ls.isEmpty()) {
			return false;
		}
		return true;
	}
	public void deleteuser(int id) {
		repo.deleteById(id);
	}
	public int findUser(int uid) {
		return  repo.findUser(uid);

	}
}
