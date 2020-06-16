/**
 * Copyright (c) 2004, 2020, Yogesh Badgujar and/or its affiliates. 
 * All rights reserved and PROPRIETARY/CONFIDENTIAL. 
 * Use is subject to Yogesh Badgujar terms.
 */
package javarefresh.model;

import java.io.Serializable;

/**
 * Purpose: Get the Phone Number details of customer and suppliers.
 *
 * Description:Area code and phone number will get from PhoneNumberBean class.
 *
 * @author Yogesh Badgujar email me in case any problem -
 *         badgujar.yogesh@gmail.com
 *
 */
public class PhoneNumberBean implements Serializable {

	private static final long serialVersionUID = 1L;
	// Area code of company or customer
	private String areaCode;
	// Phone Number of company or customer
	private String number;

	/**
	 * Get the area code of company or customer
	 * 
	 * @return - Return area code of company or customer.
	 */
	public String getAreaCode() {
		return areaCode;
	}

	/**
	 * Set the area code of company or customer.
	 * 
	 * @param areaCode - Pass the area code of company or customer.
	 */
	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}

	/**
	 * Get the Phone number of company or customer.
	 * 
	 * @return - Return the Phone number of company or customer.
	 */
	public String getNumber() {
		return number;
	}

	/**
	 * Set the Phone number of company or customer.
	 * 
	 * @param number - Pass the Phone number of company or customer.
	 */
	public void setNumber(String number) {
		this.number = number;
	}

}
