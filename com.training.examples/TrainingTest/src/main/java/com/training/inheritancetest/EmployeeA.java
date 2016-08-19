package com.training.inheritancetest;

/**
 * this abstract class shows single inheritance, inheriting an abstract class
 * 
 * @author Ponmalar
 *
 */
public abstract class EmployeeA extends EmployeeB {

	@SuppressWarnings("unused")
	private String designation;

	public EmployeeA() {

		System.out.println("Parent default Constructor");
	}

	public EmployeeA(String des) {

		System.out.println("Class EmployeeA (1st level Child) Constructor");
		this.designation = des;
	}

	/**
	 * this abstract method can be overriden by child class
	 */
	public abstract void printName();

	/**
	 * this method prints the designation of an employee
	 * 
	 * @param designation
	 */
	public void printDesignation(String designation) {
		System.out.println("Designation : " + designation);
	}
}
