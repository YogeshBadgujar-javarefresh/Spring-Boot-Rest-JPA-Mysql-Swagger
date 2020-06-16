/**
 * Copyright (c) 2004, 2020, Yogesh Badgujar and/or its affiliates. 
 * All rights reserved and PROPRIETARY/CONFIDENTIAL. 
 * Use is subject to Yogesh Badgujar terms.
 */
package javarefresh.model;

import java.io.Serializable;

/**
 * Purpose:Search the supplier by setting id, tax number etc.
 *
 * Description:
 *
 * @author Yogesh Badgujar email me in case any problem -
 *         badgujar.yogesh@gmail.com
 *
 */
public class SearchSupplier implements Serializable {

	private static final long serialVersionUID = 1L;
	// Id of the supplier
	private Long id;
	// Tax Number of the supplier
	private String taxNumber;
	// Set the AND / OR condition
	private Boolean withAndCondition = Boolean.TRUE;

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
