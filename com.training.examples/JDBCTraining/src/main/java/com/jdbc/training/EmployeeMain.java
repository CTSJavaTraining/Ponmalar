package com.jdbc.training;

import java.sql.SQLException;

public class EmployeeMain {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		
		EmployeeJDBC edb = new EmployeeJDBC();
		edb.getEmployees();
		edb.updateEmployee();
		edb.addEmployee();
		edb.deleteEmployee();
		edb.transactionCheck();
		}

}
