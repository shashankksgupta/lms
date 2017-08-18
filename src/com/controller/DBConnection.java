package com.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.log4j.Logger;

public class DBConnection {
	final static Logger conlog=Logger.getLogger(DBConnection.class);
	public static Connection con = null;
	static String username = "postgres";
	static String password = "Atidan@123";
	static String conUrl = "jdbc:postgresql://localhost:5432/LMS";

	public static Connection getConnection() {
		if (con != null) {
			conlog.info("Connection already active. Returning Exidting Connection");
			return con;
		} else {
			try {
				Class.forName("org.postgresql.Driver");
				conlog.info("Driver Registered");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			try {
				con = DriverManager.getConnection(conUrl, username, password);
				conlog.info("Connection to database " +con.getCatalog()+" successfull. Transferring control to ModelClass");
				
			} catch (SQLException e) {
				e.printStackTrace();
			}

			return con;
		}
	}
}
