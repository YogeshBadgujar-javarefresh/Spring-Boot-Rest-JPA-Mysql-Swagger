/**
 * Copyright (c) 2004, 2020, Yogesh Badgujar and/or its affiliates. 
 * All rights reserved and PROPRIETARY/CONFIDENTIAL. 
 * Use is subject to Yogesh Badgujar terms.
 */
package javarefresh.model;

import java.io.Serializable;

/**
 * Purpose:Get the Supplier details.
 *
 * Description:Tax Number, Order lead time in days, Person or Company of the
 * supplier.
 *
 * @author Yogesh Badgujar email me in case any problem -
 *         badgujar.yogesh@gmail.com
 *
 */
public class SupplierBean extends GenericBean implements Serializable {

	private static final long serialVersionUID = 1L;
	// Id of the supplier
	private Long id;
	// Tax Number of the supplier
	private String taxNumber;
	// Order lead time in days
	private int orderLeadInDays;
	// Get the Person details
	private PersonBean personBean;
	// Get the Company details.
	private CompanyBean companyBean;

	/**
	 * Get the id of the Supplier.
	 * 
	 * @return - Return id of the Supplier.
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Set the id of the Supplier.
	 * 
	 * @param id - Pass id of the Supplier.
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Get the Tax Number of the supplier.
	 * 
	 * @return the taxNumber - Return Tax Number of the supplier.
	 */
	public String getTaxNumber() {
		return taxNumber;
	}

	/**
	 * Set the Tax Number of the supplier.
	 * 
	 * @param taxNumber - Pass Tax Number of the supplier.
	 */
	public void setTaxNumber(String taxNumber) {
		this.taxNumber = taxNumber;
	}

	/**
	 * Get the Order lead time in days supplier.
	 * 
	 * @return the orderLeadInDays - Return Order lead time in days supplier.
	 */
	public int getOrderLeadInDays() {
		return orderLeadInDays;
	}

	/**
	 * Set the Order lead time in days supplier.
	 * 
	 * @param orderLeadInDays the orderLeadInDays to set
	 */
	public void setOrderLeadInDays(int orderLeadInDays) {
		this.orderLeadInDays = orderLeadInDays;
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
