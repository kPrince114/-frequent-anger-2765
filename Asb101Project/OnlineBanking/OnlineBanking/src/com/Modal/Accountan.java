package com.Modal;

public class Accountan {
	private int Aid;
	private String name;
	private String username;
	private String password;
	
	public Accountan(int aid, String name, String username, String password) {
		super();
		Aid = aid;
		this.name = name;
		this.username = username;
		this.password = password;
	}

	public int getAid() {
		return Aid;
	}

	public void setAid(int aid) {
		Aid = aid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	@Override
	public String toString() {
		return "Accountant [Aid=" + Aid + ", name=" + name + ", username=" + username + ", password=" + password + "]";
	}

	public Accountan() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
