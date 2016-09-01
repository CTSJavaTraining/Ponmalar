package com.training.employeecasestudy;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employe_mine")
public class Employee1 {
	@Id
	@Column(name = "id")
	private String name;

	@Column(name = "name")
	private int id;
	
	@Column(name="doj")
	private LocalDate doj;

	/**
	 * @return the doj
	 */
	public LocalDate getDoj() {
		return doj;
	}

	/**
	 * @param doj the doj to set
	 */
	public void setDoj(LocalDate doj) {
		this.doj = doj;
	}

	/**
	 * @return the id
	 */

	protected int getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	protected void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	protected String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	protected void setName(String name) {
		this.name = name;
	}
}
