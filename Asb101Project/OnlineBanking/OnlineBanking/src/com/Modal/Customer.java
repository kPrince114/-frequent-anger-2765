package com.Modal;

public class Customer {
	private int Cid;
	private String Name;
	private String Username;
	private int Password;
	private int AccountNo;
	private int Amount;

	public Customer(int cid, String name, String username, int password2, int accountNo, int amount) {
		super();
		Cid = cid;
		Name = name;
		Username = username;
		Password = password2;
		AccountNo = accountNo;
		Amount = amount;
	}
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getCid() {
		return Cid;
	}

	public void setCid(int cid) {
		Cid = cid;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getUsername() {
		return Username;
	}

	public void setUsername(String username) {
		Username = username;
	}

	public int getPassword() {
		return Password;
	}

	public void setPassword(int password) {
		Password = password;
	}

	public int getAccountNo() {
		return AccountNo;
	}

	public void setAccountNo(int accountNo) {
		AccountNo = accountNo;
	}

	public int getAmount() {
		return Amount;
	}

	public void setAmount(int amount) {
		Amount = amount;
	}

	@Override
	public String toString() {
		return "Customer [Cid=" + Cid + ", Name=" + Name + ", Username=" + Username + ", Password=" + Password
				+ ", AccountNo=" + AccountNo + ", Amount=" + Amount + "]";
	}
	

}
