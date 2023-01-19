package com.UseCase;

import java.util.List;
import java.util.Scanner;

import com.Dao.implementCustomer;
import com.Exception.CustomerException;
import com.Exception.TransacationException;
import com.Modal.Transaction;

import printclass.consolecolor;

public class CustomerMain {
	private String username;
	private int password;
	private String name;

	public String getUsername() {
		return username;
	}

	public int getPassword() {
		return password;
	}

	implementCustomer s = new implementCustomer();

	public boolean LoginCheckCustomer() throws CustomerException {
		boolean con1 = false;
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println(consolecolor.YELLOW_BOLD + "enter Your Username" + consolecolor.RESET);
			String Username = sc.next();
			System.out.println(consolecolor.YELLOW_BOLD + "enter Your Password" + consolecolor.RESET);
			int Password = sc.nextInt();
			boolean p = s.loginCustomer(Username, Password);
			if (p == true) {
				this.username = Username;
				this.password = Password;
				this.name = s.getName(Username, Password);
				System.out.println(consolecolor.BLACK_BACKGROUND + "login Sucessfully" + consolecolor.RESET);
				con1 = true;
				break;
			} else {
				System.out.println(consolecolor.RED + "wrong your username and password" + consolecolor.RESET);
			}
		}

		return con1;
	}

	public int CustomerWorkType() {
		Scanner sc = new Scanner(System.in);
		System.out.println(
				consolecolor.GREEN + "+-----------------------------------------------------------+\r\n"
						+ "|  ENTER YOUR NUMBER                            			|\r\n"
						+ "+-----------------------------------------------------------+\r\n"
						+ "|                                               			| \r\n"
						+ "| 1.Transfer the money from his account to other account    |\r\n"
						+ "| 2.Checking the transaction history                      	|\r\n"
						+ "| 3. Exit  													|\r\n"
						+ "+-----------------------------------------------------------+" + consolecolor.RESET);
		System.out.println(consolecolor.BROWN+"Enter your Number accoding Your Work" + consolecolor.RESET);
		int accWork = sc.nextInt();
		return accWork;
	}

	public void SenderToMoney() throws CustomerException {
		Scanner sc = new Scanner(System.in);
		System.out.println(consolecolor.YELLOW_BOLD +"Enter Reciver ID"+consolecolor.RESET);
		int id = sc.nextInt();
		String reciverUsername = s.ReciverUsername(id);
		if (reciverUsername == null) {
			System.out.println(consolecolor.RED+"Enter correcet reciver id or this person not any account"+consolecolor.RESET);
			return;
		}
		System.out.println(consolecolor.YELLOW_BOLD +"Enter Amount"+consolecolor.RESET);
		int Amount = sc.nextInt();
		int AmountCheck = s.CheckAmount(this.username);
		if (AmountCheck < Amount) {
			System.out.println(consolecolor.BROWN+"********************/ your amount is not Sufficeent /***************************"+consolecolor.RESET);
			return;
		}
		int i = s.TranforMoney(this.username, reciverUsername, Amount);
		int st = s.SubSenderMoney(Amount, this.username);
		int rt = s.AddReciverAmount(Amount, reciverUsername);
		if (i == 1&&st == 1 && rt == 1) {
			System.out
					.println(consolecolor.GREEN+"/***********************/ send your money SuccessFully /*****************************/"+consolecolor.RESET);
			System.out.println(consolecolor.LIGHT_GREEN+"process is complete......................"+consolecolor.RESET);

		}
		else {
			System.out.println(consolecolor.BROWN+"no send money"+consolecolor.RESET);
		}

	}
	public void transactionhistory () throws TransacationException {
	List<Transaction> list=s.checkTranforrmHistory(this.username);
	list.forEach(s->System.out.println(consolecolor.LIGHT_PINK+s+consolecolor.RESET));
	}

}
