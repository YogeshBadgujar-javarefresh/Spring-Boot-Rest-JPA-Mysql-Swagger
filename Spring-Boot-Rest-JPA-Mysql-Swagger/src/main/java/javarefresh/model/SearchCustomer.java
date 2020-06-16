/**
 * Copyright (c) 2004, 2020, Yogesh Badgujar and/or its affiliates. 
 * All rights reserved and PROPRIETARY/CONFIDENTIAL. 
 * Use is subject to Yogesh Badgujar terms.
 */
package javarefresh.model;

import java.io.Serializable;

/**
 * Purpose:Search the customer pass set the id, customer number etc.
 *
 * Description:
 *
 * @author Yogesh Badgujar email me in case any problem -
 *         badgujar.yogesh@gmail.com
 *
 */
public class SearchCustomer implements Serializable {

	private static final long serialVersionUID = 1L;
	// Id of the Customer
	private Long id;
	// Customer number
	private String customerNumber;
	// Set the AND / OR condition
	private Boolean withAndCondition = Boolean.TRUE;

	/**
	 * Get the id of the Customer.
	 * 
	 * @return - Return id of the Customer.
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Set the id of the Customer.
	 * 
	 * @param id - Pass id of the Customer.
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Get the Customer number
	 * 
	 * @return - Return Customer number.
	 */
	public String getCustomerNumber() {
		return customerNumber;
	}

	/**
	 * Set the Customer number.
	 * 
	 * @param customerNumber - Pass the Customer number.
	 */
	public void setCustomerNumber(String customerNumber) {
		this.customerNumber = customerNumber;
	}

	/**
	 * Search with AND or OR condition, get the flag accordingly.
	 * 
	 * @return - Return the true/false value.
	 */
	public Boolean getWithAndCondition() {
		return withAndCondition;
	}

	/**
	 * Search with AND or OR condition, set the flag accordingly.
	 * 
	 * @param withAndCondition - Pass true/false value.
	 */
	public void setWithAndCondition(Boolean withAndCondition) {
		this.withAndCondition = withAndCondition;
	}

}
