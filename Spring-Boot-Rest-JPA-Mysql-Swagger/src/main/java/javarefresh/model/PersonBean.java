/**
 * Copyright (c) 2004, 2020, Yogesh Badgujar and/or its affiliates. 
 * All rights reserved and PROPRIETARY/CONFIDENTIAL. 
 * Use is subject to Yogesh Badgujar terms.
 */
package javarefresh.model;

/**
 * Purpose:Get the Person details.
 *
 * Description:First Name and Last Name of the person.
 *
 * @author Yogesh Badgujar email me in case any problem -
 *         badgujar.yogesh@gmail.com
 *
 */
public class PersonBean extends PhoneNumberBean {

	private static final long serialVersionUID = 1L;

	// First Name
	private String firstName;
	// Last Name
	private String lastName;

	/**
	 * Get the First Name.
	 * 
	 * @return Return the First Name.
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Set the First Name.
	 * 
	 * @param Pass the First Name.
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Get the last name.
	 * 
	 * @return - Return the last name.
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Set the last name.
	 * 
	 * @param Pass the last name.
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}
