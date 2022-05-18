package com.cognixia.jump.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.cognixia.jump.jdbc.ConnectionManager;

public class StatementExample {
	
	public static void main(String[] args) {
		try {
			Connection conn = ConnectionManager.getConnection();
			Statement stmt = conn.createStatement();
			int rows = stmt.executeUpdate("insert into student(first_name, last_name, gender, date_of_birth"+
										  ", credits, address_id, dept_id) values('Thomas', 'Davidson', 'M'"+
										  ", '2013-6-14', 80, 10000, 10000);");
			System.out.println("updated "+ rows + " records in table");
			rows = stmt.executeUpdate("delete from student where first_name like 'Thomas' and last_name like 'Davidson'");
			System.out.println("updated "+ rows + " records in table");
			stmt.close();
			conn.close();
			System.out.println("Everything closed properly. Have a lovely day.");
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
