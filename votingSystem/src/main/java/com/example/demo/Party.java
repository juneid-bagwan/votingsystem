package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Party {
	@Id
	private String partyname;

	@Override
	public String toString() {
		return "Party [partyname=" + partyname + "]";
	}

	public String getPartyname() {
		return partyname;
	}

	public void setPartyname(String partyname) {
		this.partyname = partyname;
	}
	

	
	
}
