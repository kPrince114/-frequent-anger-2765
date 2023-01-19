package com.Dao;

import java.util.List;

import com.Exception.AccountantException;
import com.Exception.CustomerException;
import com.Exception.TransacationException;
import com.Modal.Customer;
import com.Modal.Transaction;
public interface Accountant {
	public boolean CheckAndLogin(String Username,int Password ) throws AccountantException;
	public int insertCustomer(String name,String username, int password,int AccoNo,int Amount) throws CustomerException;
	public int EditingCusomer(String name,String username, int password,int AccoNo,int Amount, int id)  throws CustomerException;
	public int delectCustomer(int AccountNo) throws CustomerException;
	public int veiwParticularAccount(int AccountNo) throws CustomerException;
	public List<Customer> veiwAllCustomer() throws CustomerException;
	public List<Transaction> takeCare() throws TransacationException;
}
