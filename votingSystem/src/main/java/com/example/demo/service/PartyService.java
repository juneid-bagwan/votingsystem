package com.example.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Party;
import com.example.demo.repository.partyRepository;

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
	public void deleteParty(String partyName) {
		repo.deleteById(partyName);
	}
	
}
