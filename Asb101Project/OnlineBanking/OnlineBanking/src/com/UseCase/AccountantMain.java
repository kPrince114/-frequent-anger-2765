package com.UseCase;

import java.util.List;
import java.util.Scanner;

import com.Dao.implementAccountant;
import com.Exception.AccountantException;
import com.Exception.CustomerException;
import com.Exception.TransacationException;
import com.Modal.Customer;
import com.Modal.Transaction;

import printclass.consolecolor;

public class AccountantMain {
	implementAccountant s = new implementAccountant();
	public int StartFunction() {
		Scanner sc = new Scanner(System.in);
		System.out.println(consolecolor.LIGHT_PINK+"+--------------+\n" + "| enter numer  |\n" + "+--------------+\n" + "| 1.Accountant |\n"
				+ "| 2.Customer   |\n" + "| 3.Exit       |\n" + "+--------------+");
		System.out.println("Enter your Number accoding Your Work"+consolecolor.RESET);
		int n = sc.nextInt();
		return n;

	}

	public boolean Loginchech() throws AccountantException {
		boolean con1 = false;
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println(consolecolor.YELLOW_BOLD + "enter Your email" + consolecolor.RESET);
			String HODEMAIL = sc.next();
			System.out.println(consolecolor.YELLOW_BOLD + "enter Your Password" + consolecolor.RESET);
			int HODPASSWORD = sc.nextInt();
			boolean p = s.CheckAndLogin(HODEMAIL, HODPASSWORD);
			if (p == true) {
				System.out.println(consolecolor.BLACK_BACKGROUND + "login Sucessfully" + consolecolor.RESET);
				con1 = true;
				break;
			} else {
				System.out.println(consolecolor.RED + "wrong your username and password" + consolecolor.RESET);
			}
		}

		return con1;
	}

	public int AccoutentWorkType() {
		Scanner sc = new Scanner(System.in);
		System.out.println(consolecolor.LIGHT_PINK+"+-----------------------------------------------------------+\r\n"
				+ "|  ENTER YOUR NUMBER                            			|\r\n"
				+ "+-----------------------------------------------------------+			\r\n"
				+ "|                                               			| \r\n"
				+ "| 1. Add new account                      					|\r\n"
				+ "| 2.Editing account                       					|\r\n"
				+ "| 3.delect the account by using account number  			|\r\n"
				+ "| 4.Viewing particular account details account number   	|\r\n"
				+ "| 5.Viewing all the account details          				|\r\n"
				+ "| 6.Taking care of deposit and withdrawal operations 		|\r\n"
				+ "| 7.Exit                                    				|\r\n"
				+ "+-----------------------------------------------------------+" + consolecolor.RESET);
		System.out.println("Enter your Number accoding Your Work");
		int accWork = sc.nextInt();
		return accWork;
	}

	public void addCustomer() throws  CustomerException {
		Scanner sc = new Scanner(System.in);
		System.out.println(consolecolor.YELLOW+"enter Customer name"+consolecolor.RESET);
		String name = sc.nextLine();
		System.out.println(consolecolor.YELLOW+"enter Customer username"+consolecolor.RESET);
		String username = sc.nextLine();
		System.out.println(consolecolor.YELLOW+"enter Customer Password"+consolecolor.RESET);
		int Password = sc.nextInt();
		System.out.println(consolecolor.YELLOW+"enter Customer Account No"+consolecolor.RESET);
		int AccountNo = sc.nextInt();
		System.out.println(consolecolor.YELLOW+"enter Customer amount"+consolecolor.RESET);
		int Amount = sc.nextInt();
		
		int p = s.insertCustomer(name, username, Password, AccountNo, Amount);
		if (p == 1) {
			System.out.println(
					consolecolor.BLACK_BACKGROUND + consolecolor.WHITE + "insert your data" + consolecolor.RESET);
		} else {
			System.out.println(consolecolor.RED+"worng Information"+consolecolor.RESET);
		}
	}
// scanner problem
	public void EditingCustomer() throws  CustomerException {
		Scanner sca = new Scanner(System.in);
		System.out.println(consolecolor.YELLOW+"enter Customer name"+consolecolor.RESET);
		String name = sca.nextLine();
		System.out.println(consolecolor.YELLOW+"enter Customer id"+consolecolor.RESET);
		int id = sca.nextInt();
		sca.nextLine();
		System.out.println(consolecolor.YELLOW+"enter Customer username"+consolecolor.RESET);
		String username = sca.nextLine();
		System.out.println(consolecolor.YELLOW+"enter Customer Password"+consolecolor.RESET);
		int Password = sca.nextInt();
		System.out.println(consolecolor.YELLOW+"enter Customer Account No"+consolecolor.RESET);
		int AccountNo = sca.nextInt();
		System.out.println(consolecolor.YELLOW+"enter Customer amount"+consolecolor.RESET);
		int Amount = sca.nextInt();
		int p = s.EditingCusomer(name, username, Password, AccountNo, Amount, id);
		if (p == 1) {
			System.out.println(
					consolecolor.BLACK_BACKGROUND + consolecolor.WHITE + "insert your data" + consolecolor.RESET);
		} else {
			System.out.println(consolecolor.RED+"worng Information"+consolecolor.RESET);
		}
	}
	public void DelectCustomerAccNo() throws CustomerException {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter your Account No");
		int AccountNo = sc.nextInt();
		int i=s.delectCustomer(AccountNo);
		if(i==1) {
			System.out.println(consolecolor.GREEN+"********************Delect your "+AccountNo+" detail*************************"+consolecolor.RESET);
		}
		else {
			System.out.println(consolecolor.RED+"************************Enter correct Account No**********************"+consolecolor.RESET);
		}
	}
	public void veiwParticularDetal() throws CustomerException {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter your Account No");
		int AccountNo = sc.nextInt();
		int i=s.veiwParticularAccount(AccountNo);
		if(i==1) {
			System.out.println(consolecolor.LIGHT_PINK+"********************print your  "+AccountNo+" detail*************************"+consolecolor.RESET);
		}
		else {
			System.out.println(consolecolor.LIGHT_PINK+"************************Enter correct Account No**********************"+consolecolor.RESET);
		}
	}
	public void AllCustomer() throws CustomerException {
		List<Customer> i=s.veiwAllCustomer();
		i.forEach(s->System.out.println(consolecolor.BLUE+s+consolecolor.RESET));
		System.out.println(consolecolor.LIGHT_PINK+"**********************************"+consolecolor.RESET);
	}
	public void AllTrangection() throws TransacationException {
		List<Transaction> ts=s.takeCare();
		ts.forEach(s->System.out.println(consolecolor.BLUE+s+consolecolor.RESET));
	}

}
