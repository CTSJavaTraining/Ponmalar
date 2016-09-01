/**
 * 
 */
package com.training.employeecasestudy;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author 447383
 *
 */
@Entity
@Table(name = "Employee")

public class Employee implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	private long id;

	@Column(name = "name")
	private String employeeName;

	@Column(name = "designation")
	private String designation;

	@Column(name = "salary")
	private double salary;

	@Column(name = "doj")
	private String doj;

	@Column(name = "grade")
	private char grade;

	@Column(name = "email")
	private String email;

	@Column(name = "bonus")
	private int bonus;

	@OneToMany(mappedBy = "foreignId", cascade = CascadeType.ALL)
	private List<Address> address = new ArrayList<>();

	/**
	 * A private constructor to update the fields of the class
	 * 
	 * @param id
	 * @param employeeName
	 * @param designation
	 * @param salary
	 * @param bonus
	 * @param doj
	 * @param grade
	 * @param email
	 */

	/*
	 * public Employee() {
	 * 
	 * }
	 * 
	 * public Employee(int id, String employeeName, String designation, double
	 * salary, String doj, char grade, String email, ArrayList<Address>
	 * address) { this.id = id; this.employeeName = employeeName;
	 * this.designation = designation; this.salary = salary; this.bonus = 0.0d;
	 * this.doj = doj; this.grade = grade; this.email = email; this.address =
	 * address; }
	 */

	/**
	 * @return the address
	 */

	public List<Address> getAddress() {
		return address;
	}

	/**
	 * @param address2
	 *            the address to set
	 */
	public void setAddress(List<Address> address) {
		this.address = address;
	}

	/**
	 * @return the id
	 */

	public long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the employeeName
	 */

	public String getEmployeeName() {
		return employeeName;
	}

	/**
	 * @param employeeName
	 *            the employeeName to set
	 */
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	/**
	 * @return the designation
	 */

	public String getDesignation() {
		return designation;
	}

	/**
	 * @param designation
	 *            the designation to set
	 */
	public void setDesignation(String designation) {
		this.designation = designation;
	}

	/**
	 * @return the salary
	 */

	public double getSalary() {
		return salary;
	}

	/**
	 * @param salary
	 *            the salary to set
	 */
	public void setSalary(double salary) {
		this.salary = salary;
	}

	/**
	 * @return the bonus
	 */

	public int getBonus() {
		return bonus;
	}

	/**
	 * @param bonus
	 *            the bonus to set
	 */
	public void setBonus(int bonus) {
		this.bonus = bonus;
	}

	/**
	 * @return the doj
	 */

	public String getDoj() {
		return doj;
	}

	/**
	 * @param doj
	 *            the doj to set
	 */
	public void setDoj(String doj) {
		this.doj = doj;
	}

	/**
	 * @return the grade
	 */

	public char getGrade() {
		return grade;
	}

	/**
	 * @param grade
	 *            the grade to set
	 */
	public void setGrade(char grade) {
		this.grade = grade;
	}

	/**
	 * @return the email
	 */

	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	public void calcBonus() {
		char temp = getGrade();
		if (temp == 'A') {
			double tempSalary = getSalary();
			setBonus(8);
			tempSalary = salary + tempSalary * getBonus();
			setSalary(tempSalary);
		} else if (temp == 'B') {
			double tempSalary = getSalary();
			setBonus(8);
			tempSalary = salary + tempSalary * getBonus();
			setSalary(tempSalary);

		}
	}

	public void displayEmploye() {
		System.out.println("Employee Details:");
		System.out.println("ID: " + id);
		System.out.println("Name:" + employeeName);
		System.out.println("Designation:" + designation);
		System.out.println("Salary:" + salary);
		System.out.println("Bonus: " + bonus);
		System.out.println("DOJ: " + doj);
		System.out.println("Grade:" + grade);
		System.out.println("Email:" + email);
	}

}
