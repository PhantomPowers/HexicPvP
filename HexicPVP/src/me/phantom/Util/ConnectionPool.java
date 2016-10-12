package me.phantom.Util;

import java.sql.Connection;
import java.sql.DriverManager;



public class ConnectionPool {
	
	private static Connection con;
	
	public static boolean refresh = false;
	
	public static Connection getConnection() {
		try {
			if(refresh || con == null || con.isClosed()) {
				refresh = false;
				if(con != null) con.close();
				String sql_url = "";
				String sql_user = "";
				String sql_password = "";
				
				con = DriverManager.getConnection(sql_url, sql_user, sql_password);
			}
		} catch(Exception e) {
			System.out.println("Couldn't connect to the database!");
		}
		return con;
	}
	
}
