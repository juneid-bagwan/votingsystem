package com.example.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Vote;
import com.example.demo.repository.voteRepository;

@Service
@Transactional
public class VoteService {
	@Autowired
	voteRepository repo;

	public void save(Vote vote) {
		repo.save(vote);
	}

	public List<Vote> listall() {

		return repo.findAll();

	}

	public int count(String partyname) {
//		System.out.println(partyname+" " +uid);

		return repo.countvots(partyname);
	}

	public boolean votedorno(int a) {
		if(repo.uservoted(a)>0) {
		return true;
		}
		else {
			return false;
		}
	}
	

}
