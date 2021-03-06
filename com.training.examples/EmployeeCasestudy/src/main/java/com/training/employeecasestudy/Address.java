package com.training.employeecasestudy;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * this class is an entity class that corresponds to Address table in DB
 * 
 * @author 447383
 *
 */
@Entity
@Table(name = "address")
public class Address implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */

	@Id
	@ManyToOne
	@JoinColumn(name = "id")
	private Employee foreignId;

	@Id
	@Column(name = "doorno")
	private String doorNo;

	@Column(name = "streetname")
	private String streetName;

	@Column(name = "state")
	private String state;

	/**
	 * A private constructor to update the fields of the class
	 * 
	 * @param doorNo
	 * @param streetName
	 * @param state
	 */

	/**
	 * 
	 * this non parameterized constructor is used to initiate Address class
	 */
	public Address() {
		// this method is empty because it is just used to initiate the class
	}

	/**
	 * this parameterized constructor is used to initiate address values
	 * 
	 * @param id
	 * @param doorNo
	 * @param streetName
	 * @param state
	 */
	public Address(Employee id, String doorNo, String streetName, String state) {
		this.foreignId = id;
		this.doorNo = doorNo;
		this.streetName = streetName;
		this.state = state;
	}

	/**
	 * @return the id
	 */

	public Employee getId() {
		return foreignId;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Employee foreignId) {
		this.foreignId = foreignId;
	}

	/**
	 * @return the doorNo
	 */

	protected String getDoorNo() {
		return doorNo;
	}

	/**
	 * @param doorNo
	 *            the doorNo to set
	 */
	protected void setDoorNo(String doorNo) {
		this.doorNo = doorNo;
	}

	/**
	 * @return the streetName
	 */

	protected String getStreetName() {
		return streetName;
	}

	/**
	 * @param streetName
	 *            the streetName to set
	 */
	protected void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	/**
	 * @return the state
	 */

	protected String getState() {
		return state;
	}

	/**
	 * @param state
	 *            the state to set
	 */
	protected void setState(String state) {
		this.state = state;
	}
}
