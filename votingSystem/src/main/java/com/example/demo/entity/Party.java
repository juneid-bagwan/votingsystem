package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Party")
public class Party {
	@Id
	private String partyname;

	public Party(String partyname) {
		super();
		this.partyname = partyname;
	}

	public Party() {

	}

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
