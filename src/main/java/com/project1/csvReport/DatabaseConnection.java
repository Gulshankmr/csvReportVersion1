package com.project1.csvReport;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {

	public static Connection getConnection() {
		Connection myConn = null;
		try {

			String dbName = "tempdb";
			String serverip = "localhost";
			String serverport = "1433";
			String url = "jdbc:sqlserver://" + serverip + "\\SQLEXPRESS:" + serverport + ";databaseName=" + dbName + "";
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			myConn = DriverManager.getConnection(url, "admin", "qwerty");

		} catch (Exception e) {
			e.printStackTrace();
		}

		return myConn;
	}
}
