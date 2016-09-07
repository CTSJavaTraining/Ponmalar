package com.training.employeecasestudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * this class is the main class from which all other classes and methods are
 * called according to the need
 * 
 * @author 447383
 *
 */
public class MainControl {

	/**
	 * 
	 */
	private MainControl() {
		//
	}

	/**
	 * this method is used to call other methods in other classes according to
	 * user needs
	 * 
	 * @param args
	 * @throws NumberFormatException
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		System.out.println("Please enter the operation to be executed on DB");
		System.out.println("1. Insert reacords");
		System.out.println("2. Delete Records");
		System.out.println("3. Display Records");
		System.out.println("4. Update Employee Name");
		EmployeeDAO cm = new EmployeeDAO();
		InputStreamReader ir = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(ir);
		int choice = Integer.parseInt(br.readLine());
		switch (choice) {
		case 1:
			cm.insertRecords();
			break;
		case 2:
			cm.deleteRecords();
			break;
		case 3:
			cm.displayRecords();
			break;
		case 4:
			cm.updateEmployeeName();
			break;
		default:
			System.out.println("Please enter proper values");
			break;
		}
	}
}
