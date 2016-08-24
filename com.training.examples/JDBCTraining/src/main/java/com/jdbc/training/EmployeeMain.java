package com.jdbc.training;

import java.sql.SQLException;

/**
 * this class has main method that calls methods in EmployeeJDBC class of the
 * same package
 * 
 * @author 447383
 *
 */
public class EmployeeMain {

	private EmployeeMain() {

	}

	/**
	 * the main method creates an object for the EmployyJDBC class and calls the
	 * methods of EmployeeJDBC class
	 * 
	 * @param args
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public static void main(String[] args) throws SQLException, ClassNotFoundException {

		EmployeeJDBC edb = new EmployeeJDBC();
		edb.getEmployees();
		edb.updateEmployee();
		edb.addEmployee();
		edb.deleteEmployee();
		edb.transactionCheck();
	}

}
