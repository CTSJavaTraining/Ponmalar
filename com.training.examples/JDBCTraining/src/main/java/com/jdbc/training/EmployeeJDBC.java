package com.jdbc.training;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.PreparedStatement;

/**
 * this class incorporates all JDBC functionalities
 * 
 * @author 447383
 *
 */
public class EmployeeJDBC {

	private Connection dbConnection = null;
	private Statement queryStmt = null;
	private ResultSet results = null;
	private String pass = "root";
	private String sqlurl = "jdbc:mysql://";
	private String ip = null;
	private String dataBaseName = "/Employee";
	private String connectionUrl = null;
	private String connectionUser = "root";
	private String connectionPassword = pass;
	private int id;
	private String name;
	private PreparedStatement ps = null;
	private String tempStatement = null;

	/**
	 * this method returns ip address to which the database connection has to be
	 * made
	 * 
	 * @return
	 */
	public String getSqlURL() {
		ip = "10.242.133.153:3306";
		return ip;
	}

	/**
	 * this method forms the database connection and returns the connection
	 * object
	 * 
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public Connection getConnection() throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.jdbc.Driver");
		getSqlURL();
		connectionUrl = sqlurl + ip + dataBaseName;
		dbConnection = DriverManager.getConnection(connectionUrl, connectionUser, connectionPassword);
		queryStmt = dbConnection.createStatement();
		return dbConnection;
	}

	/**
	 * this function displays all the employyes in employee database
	 * 
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public void getEmployees() throws SQLException, ClassNotFoundException {
		dbConnection = getConnection();
		results = queryStmt.executeQuery("SELECT * FROM Employee");
		System.out.println("Employee Details \n");
		while (results.next()) {
			id = results.getInt("id");
			name = results.getString("name");
			System.out.println("id: " + id + " Name: " + name);
		}
	}

	/**
	 * this method updates the details of the employee using update query
	 * 
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public void updateEmployee() throws ClassNotFoundException, SQLException {
		tempStatement = "update Employee set name = 'Ponmalar' where id=2";
		dbConnection = getConnection();
		ps = (PreparedStatement) dbConnection.prepareStatement(tempStatement);
		ps.executeUpdate();
		System.out.println("Employee Details after update");
		getEmployees();
		dbConnection.close();
	}

	/**
	 * this method adds a new record to the employee table
	 * 
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public void addEmployee() throws ClassNotFoundException, SQLException {
		tempStatement = "insert into Employee (id, name) values (15, 'Malar')";
		dbConnection = getConnection();
		ps = (PreparedStatement) dbConnection.prepareStatement(tempStatement);
		ps.executeUpdate();
		System.out.println("After  Insertion: \n");
		getEmployees();
		dbConnection.close();
	}

	/**
	 * this method deletes a record from the employee table
	 * 
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public void deleteEmployee() throws ClassNotFoundException, SQLException {
		tempStatement = "delete from Employee where id=5";
		dbConnection = getConnection();
		ps = (PreparedStatement) dbConnection.prepareStatement(tempStatement);
		ps.executeUpdate();
		System.out.println("After Deletion:");
		getEmployees();
		dbConnection.close();

	}

	/**
	 * this method checks the rollback() option in transaction management
	 * 
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public void transactionCheck() throws ClassNotFoundException, SQLException {
		Connection dbConnection = null;
		try {
			dbConnection = getConnection();
			dbConnection.setAutoCommit(false);
			tempStatement = "insert into Employee (id, name) values (22, 'XXX')";
			ps = (PreparedStatement) dbConnection.prepareStatement(tempStatement);
			ps.executeUpdate();
			tempStatement = "insert into Employee (id, name) values (23, 'XXX')";
			ps = (PreparedStatement) dbConnection.prepareStatement(tempStatement);
			ps.executeUpdate();
			/*
			 * if (true) { //throw new Exception("Ohhhh.."); }
			 */
			dbConnection.commit();
			System.out.println("success");
		} catch (Exception e) {
			System.out.println("Exception");
			dbConnection.rollback();
		}
	}
}
