package com.training.collectionstest;

/**
 * This class EmployeeDetails has getter and setter methods of the employee that
 * is to be implemented by Employee class in the same package
 * 
 * @author Ponmalar
 *
 */
public class EmployeeDetails {

	private String id;
	private String name;
	private String designation;
	private String street;
	private double salary;

	public EmployeeDetails() {

	}

	public EmployeeDetails(String id, String name, String designation, String street, double salary) {
		this.id = id;
		this.name = name;
		this.designation = designation;
		this.street = street;
		this.salary = salary;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}
}
