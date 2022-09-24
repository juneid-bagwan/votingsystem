package com.example.demo;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface voteRepository extends JpaRepository<Vote, Integer>{
	@Query(value = "select count(*) from vote where partyname=?1 ", nativeQuery = true)
	public int countvots(String partyname);
	@Query(value = "select vote.uid from vote where uid=?1 ",nativeQuery = true)	
	public int uservoted(int uid);
}
