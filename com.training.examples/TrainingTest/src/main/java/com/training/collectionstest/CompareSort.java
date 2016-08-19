package com.training.collectionstest;

import java.util.Comparator;

/**
 * This class implements comparator and overrides the compare method to sort the
 * employee details according to their names
 * 
 * @author Ponmalar
 *
 */

public class CompareSort implements Comparator<EmployeeDetails> {

	/**
	 * This compare method of Comparator interface is overriden to compare the
	 * employee objects and sort according to the names of teh employees
	 */
	public int compare(EmployeeDetails o1, EmployeeDetails o2) {

		EmployeeDetails e1 = (EmployeeDetails) o1;
		EmployeeDetails e2 = (EmployeeDetails) o2;
		return e1.getName().compareTo(e2.getName());
	}

}
