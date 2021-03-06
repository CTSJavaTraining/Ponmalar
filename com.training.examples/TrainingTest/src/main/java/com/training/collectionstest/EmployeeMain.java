package com.training.collectionstest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.log4j.Logger;

/**
 * this class creates object for the Employee class in the same package and
 * calls the method according to the user choice
 * 
 * @author Ponmalar
 *
 */
public class EmployeeMain {
	private static org.apache.log4j.Logger log = Logger.getLogger(EmployeeMain.class);
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		int choice;
		System.out.println("Please enter numberSelect Operations");
		System.out.println("1. Display");
		System.out.println("2. Sort and Display");
		System.out.println("3. Delete Employee");
		System.out.println("4. Sort employee according to salary");
		InputStreamReader is = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(is);
		System.out.println("Enter Option: ");
		choice = Integer.parseInt(br.readLine());
		Employee emp = new Employee();
		emp.addEmployee();
		switch (choice) {
		case 1:
			log.info("User has chose to print emplouyees");
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
		case 4:
			emp.sortEmployeeJAVA8();
		default:
			System.out.println("Please enter right value");
			break;

		}
		

	}

}
