package com.mobile.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DBConnection {
	
	public static final String HOST = "localhost";
	private static final String DB_NAME = "mobile_account_db";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "123456";
	private static final String ENCODEING = "utf-8";

		public static  Connection getConnection(){
			try {
				Class.forName("org.gjt.mm.mysql.Driver").newInstance();
				String url ="jdbc:mysql://"+HOST+"/"+DB_NAME+"?user="+USERNAME+"&password="+PASSWORD+"&useUnicode=true&characterEncoding="+ENCODEING; 
				Connection conn = DriverManager.getConnection(url);
				return conn;
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return null;
		}
		
		public static Statement getStatement(Connection conn){
			try {
				return conn.createStatement();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return null;
		}
		public static void closeAll(ResultSet rs , Statement smt, Connection conn){
			if(rs != null){
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			closeAll(smt, conn);
		}
		public static void closeAll(Statement smt, Connection conn){
			if(smt != null){
				try {
					smt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			if(conn != null){
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
}
