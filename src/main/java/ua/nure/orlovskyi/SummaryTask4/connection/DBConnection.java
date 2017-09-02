package ua.nure.orlovskyi.SummaryTask4.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	private static String url = "jdbc:mysql://localhost/rental?useSSL=false";
	private static String user = "java";
	private static String password = "java";

	private static Connection conn;

	private DBConnection() {

	}

	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			DBConnection.conn = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			System.out.println(e);
		}

		return conn;
	}

}