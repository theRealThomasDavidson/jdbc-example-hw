package com.cognixia.jump.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.TimeUnit;
import java.sql.Date;

public class ResultSetExample {

	public static void main(String[] args) {
		try {
			Connection conn = ConnectionManager.getConnection();
			Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			
			ResultSet rs = stmt.executeQuery("select * from student");
			java.sql.Date today = new Date(System.currentTimeMillis());
			
			if (rs.first()) {
				do {
					System.out.println("\nName:\t" + rs.getString("first_name") + " " + rs.getString("last_name"));
					@SuppressWarnings("deprecation")
					int diff = today.getYear() - rs.getDate("date_of_birth").getYear();
					System.out.println("Age: "+ diff);
				}
				while(rs.next());
			}
			else {
				System.out.println("No results were found.");
			}
			
			rs.close();
			stmt.close();
			conn.close();
			
		}
		catch(SQLException e){
			e.printStackTrace();
		}
	}
}
