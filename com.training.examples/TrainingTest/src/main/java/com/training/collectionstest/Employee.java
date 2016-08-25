package com.training.collectionstest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;

import com.mysql.jdbc.log.Log;

/**
 * This class manipulates the employee details using the getters, setters and
 * constructor of EmployeeDetails Class
 * 
 * @author Ponmalar
 *
 */

public class Employee {
	private static org.apache.log4j.Logger log = Logger.getLogger(Employee.class);
	private static List<EmployeeDetails> employeeList = new LinkedList<EmployeeDetails>();
	private static EmployeeDetails empdet = new EmployeeDetails();

	/**
	 * this method prints the employee details
	 */
	public void printEmployee() {
		Iterator<EmployeeDetails> empDetailsIterator = employeeList.iterator();
		while (empDetailsIterator.hasNext()) {
			empdet = (EmployeeDetails) empDetailsIterator.next();
			System.out.println(empdet.getName());
		}
	}

	/**
	 * this method populates the employee details
	 */
	public void addEmployee() {
		log.info("Employee details are loaded");
		empdet = new EmployeeDetails("08CSC26", "Ruth", "PA", "Madu", 45000);
		employeeList.add(empdet);
		empdet = new EmployeeDetails("08CSC27", "Malar", "PA", "Viru", 25000);
		employeeList.add(empdet);
		empdet = new EmployeeDetails("08CSC28", "PonMalar", "PA", "Vada", 35000);
		employeeList.add(empdet);
		empdet = new EmployeeDetails("08CSC29", "XXX", "PA", "Vada", 15000);
		employeeList.add(empdet);
	}

	/**
	 * this method sorts the employee by their names
	 */
	public void sortEmployee() {
		Collections.sort(employeeList, new CompareSort());
	}

	/**
	 * this method gets the employee id whose details are to be deleted and
	 * deletes the details of the employee if the person id is not present
	 * informs the user
	 * 
	 * @throws IOException
	 */
	public void deleteEmployee() throws IOException {
		System.out.println("Please enter the employee ID to be deleted:");
		boolean flag = false;
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String empid = br.readLine();
		Iterator<EmployeeDetails> empDetailsIterator = employeeList.iterator();
		while (empDetailsIterator.hasNext()) {
			empdet = (EmployeeDetails) empDetailsIterator.next();
			if (empdet.getId().equals(empid)) {
				empDetailsIterator.remove();
				flag = true;
			}
		}
		if (flag == false) {
			System.out.println("Employee not found");
		}
	}

	/**
	 * this method sorts employee according to their salary
	 */
	public void sortEmployeeJAVA8() {
		employeeList.sort((EmployeeDetails h1, EmployeeDetails h2) -> String.valueOf((h1.getSalary()))
				.compareTo(String.valueOf((h2.getSalary()))));
		printEmployee();
	}
}
