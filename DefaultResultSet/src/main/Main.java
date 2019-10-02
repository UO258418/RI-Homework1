package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import util.DbUtil;

public class Main {
	
	private final static String GET_TABLE = DbUtil.getQuery("SQL_GET_TABLE");

	public static void main(String[] args) {
		try {
			//Connection con = DbUtil.getConnection();
			Connection con = DriverManager.getConnection("156.35.94.99", "uo258418", "passuo258418");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(GET_TABLE);
			display(rs);
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void display(ResultSet rs) throws SQLException {
		while(rs.next()) System.out.printf("Id: %d / Price: %d / Stock: %f\n", 
				rs.getInt("id"), rs.getInt("price"), rs.getFloat("stock"));
	}

}
