package com.example.demo;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class PartyService {
	
	@Autowired
	partyRepository repo;
	public void save(Party party) {
		repo.save(party);
	}
	public List<Party> listall(){
		return repo.findAll();
	}

}
