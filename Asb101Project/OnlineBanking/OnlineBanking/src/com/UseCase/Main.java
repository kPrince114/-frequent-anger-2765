package com.UseCase;

import java.util.Scanner;

import com.Exception.AccountantException;
import com.Exception.CustomerException;
import com.Exception.TransacationException;;

public class Main {
	public static void main(String[] args) throws AccountantException, CustomerException, TransacationException {

		Scanner sc = new Scanner(System.in);

		AccountantMain s = new AccountantMain();
		CustomerMain c = new CustomerMain();
		while (true) {
			int n = s.StartFunction();
			if (n == 1) {
				boolean ch = s.Loginchech();
				if (ch == true) {
					while (true) {
						int an = s.AccoutentWorkType();
						if (an == 1) {
							s.addCustomer();
						} else if (an == 2) {
							s.EditingCustomer();
						} else if (an == 3) {
							s.DelectCustomerAccNo();
						} else if (an == 4) {
							s.veiwParticularDetal();
						} else if (an == 5) {
							s.AllCustomer();
						} else if (an == 6) {
							s.AllTrangection();
						} else {
							break;
						}

					}
				}
			} else if (n == 2) {
				boolean bh = c.LoginCheckCustomer();
				if (bh == true) {
					while (true) {
						int cw = c.CustomerWorkType();
						if (cw == 1) {
							c.SenderToMoney();
						} else if (cw == 2) {
							c.transactionhistory();
						} else {
							break;
						}
					}
				}
			} else if (n == 3) {
				break;
			}
		}

	}

}
