/**
 * Copyright (c) 2004, 2020, Yogesh Badgujar and/or its affiliates. 
 * All rights reserved and PROPRIETARY/CONFIDENTIAL. 
 * Use is subject to Yogesh Badgujar terms.
 */
package javarefresh.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Purpose:Get the Customer details.
 *
 * Description:Get the Customer details.
 *
 * @author Yogesh Badgujar email me in case any problem -
 *         badgujar.yogesh@gmail.com
 *
 */
public class CustomerBean implements Serializable {

	private static final long serialVersionUID = 1L;
	// Id of the Customer
	private Long id;
	// Customer number
	private String customerNumber;
	// Last order date
	private Date lastOrderDate;
	// Get the Person details
	private PersonBean personBean;
	// Get the Company details.
	private CompanyBean companyBean;

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
	 * Get the Last order date.
	 * 
	 * @return - Return Last order date.
	 */
	public Date getLastOrderDate() {
		return lastOrderDate;
	}

	/**
	 * Set the Last order date.
	 * 
	 * @param lastOrderDate - Pass Last order date.
	 */
	public void setLastOrderDate(Date lastOrderDate) {
		this.lastOrderDate = lastOrderDate;
	}

	/**
	 * Get the Person details.
	 * 
	 * @return - Get the Person details.
	 */
	public PersonBean getPersonBean() {
		return personBean;
	}

	/**
	 * Set the Person details.
	 * 
	 * @param personBean - Pass Person details.
	 */
	public void setPersonBean(PersonBean personBean) {
		this.personBean = personBean;
	}

	/**
	 * Get the Company details.
	 * 
	 * @return - Return Company details.
	 */
	public CompanyBean getCompanyBean() {
		return companyBean;
	}

	/**
	 * Set the Company details.
	 * 
	 * @param companyBean - Pass the Company details.
	 */
	public void setCompanyBean(CompanyBean companyBean) {
		this.companyBean = companyBean;
	}

}
