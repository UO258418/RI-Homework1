package main;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import util.DbUtil;

public class Main {
	
	private final static String GET_TABLE = DbUtil.getQuery("SQL_GET_TABLE");
	private final static int SECONDS_TO_SLEEP = 20;

	public static void main(String[] args) {
		try {
			Connection con = DbUtil.getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(GET_TABLE);
			display(rs);
			Thread.sleep(SECONDS_TO_SLEEP * 1000);
			display(rs);
			con.close();
		} catch (SQLException | InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void display(ResultSet rs) throws SQLException {
		while(rs.next()) System.out.printf(" - Id: %d Price: %d Stock: %f\n", 
				rs.getInt("id"), rs.getInt("price"), rs.getFloat("stock"));
	}

}
