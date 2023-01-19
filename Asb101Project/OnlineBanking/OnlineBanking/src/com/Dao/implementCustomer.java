package com.Dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.Exception.CustomerException;
import com.Exception.TransacationException;
import com.Modal.Transaction;
import com.utily.Utily;
//import java.text.SimpleDateFormat;
//import java.util.Date;  
public class implementCustomer implements Customer {

	@Override
	public boolean loginCustomer(String Username, int password) throws CustomerException {

		boolean t = false;
		try (Connection conn = Utily.provideConnection()) {

			PreparedStatement ps = conn.prepareStatement("select * from Customer where UserName=? and Password=?");
			ps.setString(1, Username);
			ps.setInt(2, password);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				t = true;
			}

		} catch (SQLException e) {
			throw new CustomerException(e.getMessage());

		}

		return t;
	}

	@Override
	public String getName(String Username, int password) throws CustomerException {
		String name = null;
		try (Connection conn = Utily.provideConnection()) {

			PreparedStatement ps = conn.prepareStatement("select * from Customer where UserName=? and Password=?");
			ps.setString(1, Username);
			ps.setInt(2, password);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				name = rs.getString("name");
			}

		} catch (SQLException e) {
			throw new CustomerException(e.getMessage());

		}
		return name;
	}

	@Override
	public int TranforMoney(String senderUsername, String ReceiverUsername, int Amount) throws CustomerException {

		int i = 0;
		java.util.Date date = Calendar.getInstance().getTime();  
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");  
        String strDate = dateFormat.format(date);  
        System.out.println(strDate);
		try (Connection conn = Utily.provideConnection()) {

			PreparedStatement ps = conn
					.prepareStatement("insert into transSaction (sender,Receiver,Amount,data)  values(?,?,?,?)");

			ps.setString(1, senderUsername);
			ps.setString(2, ReceiverUsername);
			ps.setInt(3, Amount);
			ps.setString(4, strDate);
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
	public String ReciverUsername(int id) throws CustomerException {
		String username = null;
		try (Connection conn = Utily.provideConnection()) {

			PreparedStatement ps = conn.prepareStatement("select * from Customer where cid=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				username = rs.getString("UserName");
			}

		} catch (SQLException e) {
			throw new CustomerException(e.getMessage());

		}
		return username;
	}

	@Override
	public int CheckAmount(String username) throws CustomerException {
		int i = 0;
		try (Connection conn = Utily.provideConnection()) {

			PreparedStatement ps = conn.prepareStatement("select * from Customer where Username=?");
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				i = rs.getInt("Amount");
			}

		} catch (SQLException e) {
			throw new CustomerException(e.getMessage());

		}
		return i;
	}

	@Override
	public int SubSenderMoney(int Amou, String Username) throws CustomerException {
		int i = 0;
		try (Connection conn = Utily.provideConnection()) {

			PreparedStatement ps = conn.prepareStatement("update Customer set amount=amount-? where username=? ");
			ps.setInt(1, Amou);
			ps.setString(2, Username);
//			ps.setInt(3, Amou);
			int rs = ps.executeUpdate();
			if (rs > 0) {
				i++;
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
//			throw new CustomerException(e.getMessage());

		}
		return i;
	}

	@Override
	public int AddReciverAmount(int Amount, String username) throws CustomerException {
		int i = 0;
		try (Connection conn = Utily.provideConnection()) {

			PreparedStatement ps = conn.prepareStatement("update Customer set amount=amount+? where username=? ");
			ps.setInt(1, Amount);
			ps.setString(2, username);
			int rs = ps.executeUpdate();
			if (rs > 0) {
				i++;
			}

		} catch (SQLException e) {
			throw new CustomerException(e.getMessage());

		}
		return i;
	}

	@Override
	public List<Transaction> checkTranforrmHistory(String username) throws TransacationException {
		List<Transaction> list = new ArrayList<>();
		try (Connection conn = Utily.provideConnection()) {
			PreparedStatement ps = conn.prepareStatement("select * from transSaction where sender=? ");
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				int cid = rs.getInt("Tid");
				String Sender = rs.getString("Sender");
				String Receiver = rs.getString("Receiver");
				int Amount = rs.getInt("Amount");
				String date = rs.getString("data");
				Transaction t = new Transaction(cid, Sender, Receiver, Amount, date);
				list.add(t);
			}
		} catch (SQLException e) {
			System.out.print(e.getMessage());
		}

		return list;
	}

}
