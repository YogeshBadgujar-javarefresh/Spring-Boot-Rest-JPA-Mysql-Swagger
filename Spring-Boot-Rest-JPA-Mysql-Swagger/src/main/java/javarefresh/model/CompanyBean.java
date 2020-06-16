/**
 * Copyright (c) 2004, 2020, Yogesh Badgujar and/or its affiliates. 
 * All rights reserved and PROPRIETARY/CONFIDENTIAL. 
 * Use is subject to Yogesh Badgujar terms.
 */
package javarefresh.model;

/**
 * Purpose:Get the company details.
 *
 * Description:Company Name, Registration number of the company
 *
 * @author Yogesh Badgujar email me in case any problem -
 *         badgujar.yogesh@gmail.com
 *
 */
public class CompanyBean extends PhoneNumberBean {

	private static final long serialVersionUID = 1L;
	// Company Name
	private String name;
	// Registration number of the company.
	private String registrationNumber;

	/**
	 * Get the Name of the company.
	 * 
	 * @return - Return the name of the company.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Set the name of company.
	 * 
	 * @param name - Pass the company name.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Get the Registration number of the company.
	 * 
	 * @return - Return Registration number of the company.
	 */
	public String getRegistrationNumber() {
		return registrationNumber;
	}

	/**
	 * Set the Registration number of the company.
	 * 
	 * @param registrationNumber - Pass Registration number to set Registration
	 *                           number of the company.
	 */
	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

}
