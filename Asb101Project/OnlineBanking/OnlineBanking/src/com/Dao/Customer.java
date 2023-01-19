package com.Dao;

import java.util.List;
import com.Modal.Transaction;
import com.Exception.CustomerException;
import com.Exception.TransacationException;

public interface Customer {
	public boolean loginCustomer(String Username,int password) throws CustomerException;
	public String getName(String Username,int password) throws CustomerException;
	public int TranforMoney(String senderUsername,String ReceiverUsername,int Amount) throws CustomerException;
	public String ReciverUsername(int id)throws CustomerException;
	public int CheckAmount(String username) throws CustomerException;
	public int SubSenderMoney(int Amount,String Username)throws CustomerException;
	public int AddReciverAmount(int Amount,String username) throws CustomerException;
	public List<Transaction> checkTranforrmHistory(String username)throws TransacationException;
}
