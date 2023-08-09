package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Party;

public interface partyRepository  extends JpaRepository<Party, String>{

}
