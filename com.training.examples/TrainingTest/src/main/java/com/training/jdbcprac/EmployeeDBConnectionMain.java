package com.training.jdbcprac;

import java.sql.SQLException;

public class EmployeeDBConnectionMain {

	public static void main(String[] args) throws SQLException {
		EmployeeDBConnection edb = new EmployeeDBConnection();
		edb.getEmployees();
	}

}
