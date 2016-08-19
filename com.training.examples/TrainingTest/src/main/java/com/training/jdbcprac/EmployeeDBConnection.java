package com.training.jdbcprac;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EmployeeDBConnection {

	private Connection dbConnection = null;
	private Statement queryStmt = null;
	private ResultSet results = null;
	private String connectionUrl = "jdbc:mysql://10.242.133.153:3306/test";
	private String connectionUser = "root";
	private String connectionPassword = "root";

	public void getConnection() throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.jdbc.Driver");
		dbConnection = DriverManager.getConnection(connectionUrl, connectionUser, connectionPassword);
		queryStmt = dbConnection.createStatement();
	}

	public void getEmployees() throws SQLException {
		results = queryStmt.executeQuery("SELECT * FROM products");
		while (results.next()) {
			String id = results.getString("productID");
			System.out.println("id is " + id);
		}
	}

}
