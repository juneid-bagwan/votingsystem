package com.example.demo;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class VoteService {
	@Autowired
	voteRepository repo;
	public void save(Vote vote) {
		repo.save(vote);
	}
	public List<Vote> listall(){
		
		return repo.findAll();
		
	}
	public int count(String partyname) {
//		System.out.println(partyname+" " +uid);
		
		return repo.countvots(partyname);
	}
	public int votedorno(int a) {
		return repo.uservoted(a);
	}
	

}
