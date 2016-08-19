package com.training.staticprac;

/**
 * this class shows an example of static method and static field
 * 
 * @author 447383
 *
 */
public class EmployeeStaticTry {

	private static String name;
	private static int i = 0;

	public EmployeeStaticTry(String n) {
		EmployeeStaticTry.name = n;
		i = i + 1;
	}

	static {
		// i=i+1;
		name = "Ruth";
		System.out.println("Name: " + name);
		i++;
	}

	public static void printDesignation() {
		System.out.println("Designation: Manager");
		i = i + 1;
	}

	public void printAllDetails() {
		i = i + 1;
		System.out.println("Name: " + name);
		System.out.println("Designation: Manager");
		i = i + 1;
	}

	public static void main(String args[]) {
		System.out.println("Initial i value:" + i);
		printDesignation();
		System.out.println("After Callong print designation i value:" + i);
		EmployeeStaticTry est = new EmployeeStaticTry("Malar");
		est.printAllDetails();
		System.out.println("Another Object i value:" + i);
	}
}
