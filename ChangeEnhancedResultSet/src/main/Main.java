package main;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import util.DbUtil;

public class Main {
	
	private final static String GET_TABLE = DbUtil.getQuery("SQL_GET_TABLE");
	private final static String NEW_ROW = DbUtil.getQuery("SQL_NEW_ROW");
	private final static String UPDATE_ROW1 = DbUtil.getQuery("SQL_UPDATE_ROW1");
	private final static String DELETE_ID2 = DbUtil.getQuery("SQL_DELETE_ID2");
	private final static int SECONDS_TO_SLEEP = 20;

	public static void main(String[] args) {
		try {
			Connection con = DbUtil.getConnection();
			Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = stmt.executeQuery(GET_TABLE);
			display(rs);
			stmt.executeUpdate(NEW_ROW);
			stmt.executeUpdate(UPDATE_ROW1);
			stmt.executeUpdate(DELETE_ID2);
			Thread.sleep(SECONDS_TO_SLEEP * 1000);
			display(rs);
			con.close();
		} catch (SQLException | InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void display(ResultSet rs) throws SQLException {
		rs.beforeFirst();
		System.out.println();
		while(rs.next()) System.out.printf(" - Id: %d Price: %d Stock: %f\n", 
				rs.getInt("id"), rs.getInt("price"), rs.getFloat("stock"));
	}

}
