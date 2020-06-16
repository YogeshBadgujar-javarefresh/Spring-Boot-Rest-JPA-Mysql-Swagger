/**
 * Copyright (c) 2004, 2020, Yogesh Badgujar and/or its affiliates. 
 * All rights reserved and PROPRIETARY/CONFIDENTIAL. 
 * Use is subject to Yogesh Badgujar terms.
 */
package javarefresh.dao;

import java.util.List;

import javarefresh.exception.DAOException;
import javarefresh.jpa.Customer;

/**
 * Purpose:
 *
 * Description:
 *
 * @author Yogesh Badgujar
 * email me in case any problem - badgujar.yogesh@gmail.com
 *
 */
public interface ICustomerDao {
	
	/**
	 * Get the list of all customers
	 * 
	 * @return - Return the list of customers.
	 * @throws DAOException - Can throw DAOException.
	 */
	public List<Customer> getAllCustomer() throws DAOException;

	/**
	 * Get the customer by id
	 * 
	 * @param id - Pass the id based on that search customer.
	 * @return - Return the customer if found otherwise null will be send
	 * @throws DAOException - Can throw DAOException.
	 */
	public Customer getCustomerById(Long id) throws DAOException;

	/**
	 * Get the customer by customer number.
	 * 
	 * @param customerNumber - Pass the customer number.
	 * @return
	 * @throws DAOException - Can throw DAOException.
	 */
	public Customer getCustomerByCustomerNumber(String customerNumber) throws DAOException;

	/**
	 * Based on SearchCustomer object you will get the result. Filter will apply
	 * based on set value in the property bean.
	 * 
	 * @param customer - Pass the Customer object
	 * @return - List of CustomerBean
	 * @throws DAOException - Can throw DAOException.
	 */
	public List<Customer> getCustomer(Customer customer) throws DAOException;


}
