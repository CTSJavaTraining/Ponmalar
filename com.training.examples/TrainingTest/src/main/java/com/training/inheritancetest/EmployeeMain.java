package com.training.inheritancetest;

/**
 * this class illustrates multiple inheritance using interface and abstract
 * class and constructor chanining
 * 
 * @author Ponmalar
 *
 */
public class EmployeeMain extends EmployeeA implements EmployeeInterface {

	String name = "Ruth";

	public EmployeeMain() {
		System.out.println("Child Default Constructor ");
	}

	public EmployeeMain(String name) {
		this.name = name;
	}

	public EmployeeMain(String name, String designation) {
		super(designation);
		this.name = name;
	}

	/**
	 * this method is inherited from EmployeeInterface class of the same package
	 */
	public void printAge() {

		System.out.println("Age: " + EmployeeInterface.age);
	}

	/**
	 * this method is inherited from EmployeeA class of the same package
	 */
	@Override
	public void printName() {

		System.out.println("Name: " + name);
	}

	/**
	 * this method is inherited from EmployeeA class of the same package
	 */
	@Override
	public void printDesignation(String designation) {

		super.printDesignation(designation);
	}

	/**
	 * the main method creates an object for EmployeeMain class and executes all
	 * the methods in the class
	 * 
	 * @param args
	 * @throws CloneNotSupportedException
	 */
	public static void main(String args[]) throws CloneNotSupportedException {

		EmployeeMain em = new EmployeeMain();
		System.out.println("\n\nEmployee Details\n\n");
		em.printName();
		em.printAge();
		em.printDesignation("Manager");

	}
}
