package com.utily;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Utily {
	public static Connection provideConnection() {

		Connection conn = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		String url = "jdbc:mysql://localhost:3306/sb101";

		try {
			conn = DriverManager.getConnection(url, "root", "Prince@123");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;

	}

}
