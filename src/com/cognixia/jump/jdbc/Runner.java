package com.cognixia.jump.jdbc;

import java.sql.Connection;
import java.sql.SQLException;

public class Runner {
	
	public static void main(String[] args){
		Connection conn = ConnectionManager.getConnection();
		System.out.println("Connection to mysql database has been started.");
		try {
			System.out.println("Something didn't go wrong.");
			conn.close();
		}
		catch(SQLException e) {
			System.out.println("something went wrong");
			e.printStackTrace();
		}
	}
}
