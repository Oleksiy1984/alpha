package ua.nure.orlovskyi.SummaryTask4.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import ua.nure.orlovskyi.SummaryTask4.connection.DBConnection;

public class LoginService {
	public static boolean validateLogin(String username, String password) {
		boolean success = false;
		if (username.isEmpty() || password.isEmpty()) {
			return false;
		}
		try {
			Connection conn = DBConnection.getConnection();

			String query = "SELECT users.login, users.password " + "FROM users "
					+ "WHERE users.login=? AND users.password=? AND users.role = 'CLIENT';";
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setString(1, username);
			stmt.setString(2, password);
			ResultSet rs = stmt.executeQuery();

			String dbUsername = "", dbPassword = "";
			while (rs.next()) {
				dbUsername = rs.getString("login");
				dbPassword = rs.getString("password");
			}

			if (username.equals(dbUsername) && password.equals(dbPassword))
				success = true;
			else
				success = false;
		} catch (Exception e) {
			System.out.println(e);
		}
		return success;
	}

	public static boolean validateLoginCustomer1(String username, String password) {
		boolean success = false;

		try {
			Connection conn = DBConnection.getConnection();

			String query = "SELECT * FROM clientInfo WHERE username=? AND password=?";
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setString(1, username);
			stmt.setString(2, password);

			ResultSet rs = stmt.executeQuery();

			String dbUsername = "", dbPassword = "";
			while (rs.next()) {
				dbUsername = rs.getString("username");
				dbPassword = rs.getString("password");
			}

			if (username.equals(dbUsername) && password.equals(dbPassword))
				success = true;
			else
				success = false;
		} catch (Exception e) {
			System.out.println(e);
		}
		return success;
	}
}
