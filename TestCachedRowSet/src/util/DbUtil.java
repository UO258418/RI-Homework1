package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtil {
	
	private static ConfigFileManager cfm = ConfigFileManager.getInstance();
	
	public static Connection getConnection() throws SQLException {
		String URL = cfm.getProperty("URL");
		String USER = cfm.getProperty("USER");
		String PASS = cfm.getProperty("PASS");
		return DriverManager.getConnection(URL, USER, PASS);
	}
	
	public static String getQuery(String query) {
		return cfm.getProperty(query);
	}

}
