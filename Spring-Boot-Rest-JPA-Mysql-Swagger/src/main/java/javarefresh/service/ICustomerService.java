/**
 * Copyright (c) 2004, 2020, Yogesh Badgujar and/or its affiliates. 
 * All rights reserved and PROPRIETARY/CONFIDENTIAL. 
 * Use is subject to Yogesh Badgujar terms.
 */
package javarefresh.service;

import java.util.List;

import javarefresh.exception.CustomerSupplierException;
import javarefresh.model.CustomerBean;
import javarefresh.model.SearchCustomer;

/**
 * Purpose:
 *
 * Description:
 *
 * @author Yogesh Badgujar email me in case any problem -
 *         badgujar.yogesh@gmail.com
 *
 */
public interface ICustomerService {

	/**
	 * Get the list of all customers
	 * 
	 * @return - Return the list of customers.
	 * @throws CustomerSupplierException - Can throw CustomerSupplierException.
	 */
	public List<CustomerBean> getAllCustomer() throws CustomerSupplierException;

	/**
	 * Get the customer by id
	 * 
	 * @param id - Pass the id based on that search customer.
	 * @return - Return the customer if found otherwise null will be send
	 * @throws CustomerSupplierException - Can throw CustomerSupplierException.
	 */
	public CustomerBean getCustomerById(Long id) throws CustomerSupplierException;

	/**
	 * 
	 * @param customerNumber
	 * @return
	 * @throws CustomerSupplierException - Can throw CustomerSupplierException.
	 */
	public CustomerBean getCustomerByCustomerNumber(String customerNumber) throws CustomerSupplierException;

	/**
	 * Based on SearchCustomer object you will get the result. Filter will apply
	 * based on set value in the property bean.
	 * 
	 * @param customer - Pass the SearchCustomer object
	 * @return - List of CustomerBean
	 * @throws CustomerSupplierException
	 */
	public List<CustomerBean> getCustomer(SearchCustomer customer) throws CustomerSupplierException;

	/**
	 * Create the customer.
	 * 
	 * @param customerBean - Pass the customer bean.
	 * @return - Return the response code.
	 * @throws CustomerSupplierException - Can throw CustomerSupplierException if
	 *                                   any issue while creating.
	 */
	public String createCustomer(CustomerBean customerBean) throws CustomerSupplierException;
	
	/**
	 * Update the customer.
	 * 
	 * @param customerBean - Pass the customer bean.
	 * @return - Return the response code.
	 * @throws CustomerSupplierException - Can throw CustomerSupplierException if
	 *                                   any issue while updating.
	 */
	public String updateCustomer(CustomerBean customerBean) throws CustomerSupplierException;
	
	/**
	 * Delete the customer.
	 * 
	 * @param customerNumber - Pass the customer number
	 * @return - Return the status info
	 * @throws CustomerSupplierException - Can throw CustomerSupplierException if
	 *                                   any issue while deleting.
	 */
	public String deleteCustomer(String customerNumber) throws CustomerSupplierException;
	
	/**
	 * Re-active the customer.
	 * 
	* @param customerNumber - Pass the customer number
	 * @return - Return the status info
	 * @throws CustomerSupplierException - Can throw CustomerSupplierException if
	 *                                   any issue while reactivating.
	 */
	public String reActiveCustomer(String customerNumber) throws CustomerSupplierException;
	
}
