package com.Modal;

import java.util.Date;

public class Transaction {
	private int id;
	private String SenderName;
	private String ReciverName;
	private int Amount;
	private String date;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Transaction(int id, String senderName, String reciverName, int amount, String date) {
		super();
		this.id = id;
		SenderName = senderName;
		ReciverName = reciverName;
		Amount = amount;
		this.date = date;
	}
	public Transaction() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getSenderName() {
		return SenderName;
	}
	public void setSenderName(String senderName) {
		SenderName = senderName;
	}
	public String getReciverName() {
		return ReciverName;
	}
	public void setReciverName(String reciverName) {
		ReciverName = reciverName;
	}
	public int getAmount() {
		return Amount;
	}
	public void setAmount(int amount) {
		Amount = amount;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "Transaction [id=" + id + ", SenderName=" + SenderName + ", ReciverName=" + ReciverName + ", Amount="
				+ Amount + ", date=" + date + "]";
	}
	
	
	
}
