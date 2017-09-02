package ua.nure.orlovskyi.SummaryTask4.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DBUtil {
	
	private static final ResourceBundle db = ResourceBundle.getBundle("db");
	private static final String url = db.getString("url");
	private static final String user = db.getString("username");
	private static final String password = db.getString("password");
	
	
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url, user, password);
	}
	
	public static void showErrorMessage(SQLException e){
		System.err.println("Error :" + e.getMessage());
		System.err.println("Error Code :" + e.getErrorCode());
	}


}
