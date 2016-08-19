package com.training.clonetest;

/**
 *This Employee class illustrates CLone objects behavior
 * 
 * @author Ponmalar
 *
 */
public class Employee implements Cloneable {

	private String name;
	private String designation;

	public Employee(String name, String designation) {
		this.name = name;
		this.designation = designation;
	}

	public void printDetails() {
		System.out.println("Name: " + name);
		System.out.println("Designation: " + designation);
	}

	public static void main(String args[]) throws CloneNotSupportedException {
		Employee emp = new Employee("Ruth", "Manager");
		emp.printDetails();
		Employee emp1 = (Employee) emp.clone();
		System.out.println("\n\nAfter Clone Values\n\n ");
		System.out.println("Name: " + emp1.name);
		System.out.println("Designation: " + emp1.designation);
	}

}
