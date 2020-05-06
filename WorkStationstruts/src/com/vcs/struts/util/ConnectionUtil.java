package com.vcs.struts.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionUtil {

	private static ConnectionUtil connectionUtil = null;

	private ConnectionUtil() {
	}

	public static ConnectionUtil getInstance() {
		if (connectionUtil == null) {
			connectionUtil = new ConnectionUtil();
		}
		return connectionUtil;
	}

	public Object clone() throws CloneNotSupportedException {
		return connectionUtil;
	}

	public Connection getConnetion() throws Exception {

		Class.forName("oracle.jdbc.driver.OracleDriver");
		String user="system";
		String pass="student";
		Connection connection = DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521:xe", user,pass);

		return connection;
	}
}
