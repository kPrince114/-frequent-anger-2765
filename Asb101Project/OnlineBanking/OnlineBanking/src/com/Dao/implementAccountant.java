package com.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.Exception.AccountantException;
import com.Exception.CustomerException;
import com.Exception.TransacationException;
import com.utily.Utily;
import com.Modal.Customer;
import com.Modal.Transaction;

public class implementAccountant implements Accountant {

	@Override
	public boolean CheckAndLogin(String Username, int Password) throws AccountantException {
		boolean t = false;
		try (Connection conn = Utily.provideConnection()) {

			PreparedStatement ps = conn.prepareStatement("select * from Accountant where UserName=? and Password=?");
			ps.setString(1, Username);
			ps.setInt(2, Password);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				t = true;
			}

		} catch (SQLException e) {
			throw new AccountantException(e.getMessage());

		}

		return t;
	}

	@Override
	public int insertCustomer(String name, String username, int password, int AccoNo, int Amount)
			throws CustomerException {

		int i = 0;
		try (Connection conn = Utily.provideConnection()) {

			PreparedStatement ps = conn.prepareStatement(
					"insert into Customer (name,username,password,AccountNo,Amount)  values(?,?,?,?,?)");

			ps.setString(1, name);
			ps.setString(2, username);
			ps.setInt(3, password);
			ps.setInt(4, AccoNo);
			ps.setInt(5, Amount);
			int x = ps.executeUpdate();

			if (x > 0) {
				i++;
			}

		} catch (SQLException e) {
			throw new CustomerException(e.getMessage());
		}

		return i;
	}

	@Override
	public int EditingCusomer(String name, String username, int password, int AccoNo, int Amount,int id)
			throws CustomerException {
		int i = 0;
		String st;
		try (Connection conn = Utily.provideConnection()) {

			PreparedStatement ps = conn.prepareStatement(
					"UPDATE Customer SET name = ? , UserName = ?,Password=?,AccountNo=?,Amount=? WHERE cid = ?");

			ps.setString(1, name);
			ps.setString(2, username);
			ps.setInt(3, password);
			ps.setInt(4, AccoNo);
			ps.setInt(5, Amount);
			ps.setInt(6, id);
			int x = ps.executeUpdate();
			
			if (x > 0) {
				i++;
			}

		} catch (SQLException e) {
			throw new CustomerException(e.getMessage());
			
		}

		return i;
	}

	@Override
	public int delectCustomer(int AccountNo) throws CustomerException {
		int i=0;
		try(Connection conn= Utily.provideConnection()) {
			PreparedStatement ps= conn.prepareStatement("DELETE FROM Customer where AccountNo=? ");
			ps.setInt(1,AccountNo);
			int s= ps.executeUpdate();
			
			if(s>0) {
				i++;
				
			}
				
			
		}
		catch (SQLException e) {
			throw new CustomerException(e.getMessage());
		}
		
		return i;
	}

	@Override
	public int veiwParticularAccount(int AccountNo) throws CustomerException {
		int i=0;
		try (Connection conn = Utily.provideConnection()) {

			PreparedStatement ps = conn.prepareStatement("select * from customer where AccountNo=?");
			ps.setInt(1,AccountNo);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				i++;
				System.out.println("id id "+rs.getInt("cid")+"name is :" + rs.getString("name") + " is username" + rs.getString("username")+" password is"
						+ " "+ rs.getInt("AccountNo") +" Amount is "+ rs.getInt("Amount"));
			}

		} catch (SQLException e) {
			throw new CustomerException(e.getMessage());
		}

		return i;
	}

	@Override
	public List<Customer> veiwAllCustomer() throws CustomerException{
		List<Customer> list = new ArrayList<>();
		try (Connection conn= Utily.provideConnection()){
			PreparedStatement ps= conn.prepareStatement("select * from customer ");
			ResultSet rs= ps.executeQuery();
			
				while(rs.next()) {
					int cid=rs.getInt("cid");
					String name=rs.getString("name");
					String username=rs.getString("username");
					int password=rs.getInt("password");
					int Amount=rs.getInt("Amount");
					int AccuntNo=rs.getInt("AccountNo");
					Customer c=new Customer(cid,name,username,password,AccuntNo,Amount);
					list.add(c);
				}
		} 
		catch (SQLException e) {
			System.out.print(e.getMessage());
		}

		return list;
	}

	@Override
	public List<Transaction> takeCare() throws TransacationException {
		List<Transaction> list = new ArrayList<>();
		try (Connection conn= Utily.provideConnection()){
			PreparedStatement ps= conn.prepareStatement("select * from transSaction ");
			ResultSet rs= ps.executeQuery();
			
				while(rs.next()) {
					int cid=rs.getInt("Tid");
					String Sender=rs.getString("Sender");
					String Receiver=rs.getString("Receiver");
					int Amount=rs.getInt("Amount");
					String date=rs.getString("data");
					Transaction t=new Transaction(cid, Sender, Receiver, Amount, date);
					list.add(t);
				}
		} 
		catch (SQLException e) {
			System.out.print(e.getMessage());
		}

		return list;
	}
	
	
	

}
