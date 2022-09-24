package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Admin {
	@Id
	private int aid;
	private String password;
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	private String aname;
	public String getAname() {
		return aname;
	}
	@Override
	public String toString() {
		return "Admin [aid=" + aid + ", password=" + password + ", aname=" + aname + "]";
	}
	public void setAname(String aname) {
		this.aname = aname;
	}

}
