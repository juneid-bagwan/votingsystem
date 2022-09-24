package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Vote {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int vid;
	@ManyToOne
	@JoinColumn(name = "uid")
	private User user;

	@OneToOne
	@JoinColumn(name="partyname")
	private Party party;
	public int getVid() {
		return vid;
	}
	public void setVid(int vid) {
		this.vid = vid;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Party getParty() {
		return party;
	}
	public void setParty(Party party) {
		this.party = party;
	}
	
	
	

}
