package com.training.serielizableprac;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * this class illustrates an serialization sample
 * 
 * @author Ponmalar
 *
 */
public class EmployeeSerielize implements Serializable {

	private static final long serialVersionUID = 1L;
	private String name;
	private int age;
	private transient String secondName;
	private static String designation;

	public EmployeeSerielize() {

	}

	public EmployeeSerielize(String name, int age, String sn, String status) {

		this.name = name;
		this.age = age;
		EmployeeSerielize.designation = status;
		this.secondName = sn;
	}

	/**
	 * The details are serialized and written into file d://Employee.txt as
	 * objects
	 * 
	 * @param ts
	 * @throws IOException
	 */

	public void serielizeMethod(EmployeeSerielize ts) throws IOException {

		FileOutputStream fos = new FileOutputStream("d://Employee.txt");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(ts);
		oos.close();
		fos.close();
	}

	/**
	 * The details are deserialized from file d://Employee.txt and read as
	 * objects
	 * 
	 * @param ts
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public void deserielizeMethod(EmployeeSerielize ts) throws IOException, ClassNotFoundException {

		FileInputStream fos = new FileInputStream("d://Employee.txt");
		ObjectInputStream oos = new ObjectInputStream(fos);
		ts = (EmployeeSerielize) oos.readObject();
		System.out.println(ts.name);
		System.out.println(ts.age);
		System.out.println(ts.secondName);
		System.out.println(EmployeeSerielize.designation);
		oos.close();
		fos.close();
	}

	/**
	 * main method creates an object for EmployeeSerielize class and calls
	 * serialization and deserielization example
	 * 
	 * @param args
	 * @throws IOException
	 * @throws ClassNotFoundException
	 * @throws CloneNotSupportedException
	 */
	public static void main(String[] args) throws IOException, ClassNotFoundException, CloneNotSupportedException {

		EmployeeSerielize ts = new EmployeeSerielize("Ruth", 49, "Lalitha", "Manager");
		ts.serielizeMethod(ts);
		ts.deserielizeMethod(ts);

	}

}
