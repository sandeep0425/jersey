package com.Jersey.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement 
public class Employee 
{
public Employee() {
	// TODO Auto-generated constructor stub
	
	
}
	public Employee(int id, String username, String password) {
	super();
	this.id = id;
	this.username = username;
	this.password = password;
}
	private int id;
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	private String username;

	private String password;
	
}
