package jp.ac.isc.cloud;

import java.sql.*;

public final class DBConnection {
	private DBConnection() {
	}

	public static Connection openConnection() {
		Connection users = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			users = DriverManager.getConnection("jdbc:mysql://localhost/servlet_db?useUnicode=true&characterEncoding=utf8", "root", "");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return users;
	}

	public static void closeConnection(Connection users, Statement state) {
		try {
			state.close();
			users.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
