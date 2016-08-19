package com.training.collectionstest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * this class creates object for the Employee class in the same package and
 * calls the method according to the user choice
 * 
 * @author Ponmalar
 *
 */
public class EmployeeMain {

	public static void main(String[] args) throws NumberFormatException, IOException {
		int choice;
		System.out.println("Please enter numberSelect Operations");
		System.out.println("1. Display");
		System.out.println("2. Sort and Display");
		System.out.println("3. Delete Employee");
		InputStreamReader is = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(is);
		System.out.println("Enter Option: ");
		choice = Integer.parseInt(br.readLine());
		Employee emp = new Employee();
		emp.addEmployee();
		switch (choice) {
		case 1:
			emp.printEmployee();
			break;
		case 2:
			emp.sortEmployee();
			emp.printEmployee();
			break;
		case 3:
			emp.deleteEmployee();
			emp.printEmployee();
			break;
		default:
			System.out.println("Please enter right value");
			break;

		}

	}

}
