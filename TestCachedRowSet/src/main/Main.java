package main;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.RowSet;

import oracle.jdbc.rowset.OracleCachedRowSet;
import util.DbUtil;

public class Main {
	
	private final static String GET_TABLE = DbUtil.getQuery("SQL_GET_TABLE");
	private final static String NEW_ROW = DbUtil.getQuery("SQL_NEW_ROW");
	private final static String UPDATE_ROW1 = DbUtil.getQuery("SQL_UPDATE_ROW1");
	private final static String DELETE_ID2 = DbUtil.getQuery("SQL_DELETE_ID2");
	private final static int SECONDS_TO_SLEEP = 20;

	public static void main(String[] args) {
		try {
			RowSet rowset = new OracleCachedRowSet();
			rowset.setUrl("jdbc:oracle:thin:@156.35.94.99:1521:DESA");
			rowset.setUsername("uo258418");
			rowset.setPassword("passuo258418");
			rowset.setCommand(GET_TABLE);
			rowset.execute();
			display(rowset);
			rowset.setCommand(NEW_ROW);
			rowset.execute();
			rowset.setCommand(UPDATE_ROW1);
			rowset.execute();
			rowset.setCommand(DELETE_ID2);
			rowset.execute();
			display(rowset);
			Thread.sleep(SECONDS_TO_SLEEP * 1000);
			rowset.setCommand("commit");
			rowset.execute();
		} catch (SQLException | InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void display(RowSet rs) throws SQLException {
		while (rs.next ())
		{
			System.out.printf("id: %d price: %d stock: %f\nO", rs.getInt(1), rs.getInt(2), rs.getFloat(3));
		}
	}

}
