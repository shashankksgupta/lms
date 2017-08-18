package lms;

import java.sql.Connection;
import java.sql.DriverManager;

import org.apache.log4j.Logger;

public class DAO {

	static Connection con = null;
	final static Logger testlog = Logger.getLogger(DAO.class);
	public static Connection getConnection() {

		try {

			Class.forName("org.postgresql.Driver");
			testlog.info("driver connected");
		} catch (java.lang.ClassNotFoundException e) {
			System.out.println(e);
			testlog.error("driver not connected");
		}

		try {
			con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/LMS", "postgres", "Atidan@123");
			System.out.println("connection successfully established");
		} catch (Exception e1) {
			System.out.println(e1);

		}
		return con;

	}
}
