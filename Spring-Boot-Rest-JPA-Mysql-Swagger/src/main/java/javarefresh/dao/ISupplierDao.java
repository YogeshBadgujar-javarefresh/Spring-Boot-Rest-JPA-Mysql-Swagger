/**
 * Copyright (c) 2004, 2020, Yogesh Badgujar and/or its affiliates. 
 * All rights reserved and PROPRIETARY/CONFIDENTIAL. 
 * Use is subject to Yogesh Badgujar terms.
 */
package javarefresh.dao;

import java.util.List;

import javarefresh.exception.DAOException;
import javarefresh.jpa.Supplier;

/**
 * Purpose:
 *
 * Description:
 *
 * @author Yogesh Badgujar email me in case any problem -
 *         badgujar.yogesh@gmail.com
 *
 */
public interface ISupplierDao {

	/**
	 * Get the list of all supplier
	 * 
	 * @return - Return the list of supplier.
	 * @throws DAOException - Can throw DAOException.
	 */
	public List<Supplier> getAllSupplier() throws DAOException;

	/**
	 * Get the supplier by id.
	 * 
	 * @param id - Pass the id based on that search supplier.
	 * @return - Return the supplier if found otherwise null will be send
	 * @throws DAOException - Can throw DAOException.
	 */
	public Supplier getSupplierById(Long id) throws DAOException;

	/**
	 * Pass the tax Number and get the particular supplier.
	 * 
	 * @param taxNumber - Pass tax Number.
	 * @return - Return SupplierBean.
	 * @throws DAOException - Can throw DAOException.
	 */
	public Supplier getSupplierByTaxNumber(String taxNumber) throws DAOException;

	/**
	 * Based on SearchSupplier object you will get the result. Filter will apply
	 * based on set value in the property bean.
	 * 
	 * @param customer - Pass the SearchSupplier object
	 * @return - List of SupplierBean
	 * @throws DAOException
	 */
	public List<Supplier> getSupplier(Supplier supplier) throws DAOException;

	/**
	 * Create the Supplier.
	 * 
	 * @param supplier - Pass the Supplier bean.
	 * @return - Return the response code.
	 * @throws DAOException - Can throw DAOException if any issue while creating.
	 */
	public String createSupplier(Supplier supplier) throws DAOException;

	/**
	 * Update the supplier.
	 * 
	 * @param supplier - Pass the Supplier bean.
	 * @return - Return the response code.
	 * @throws DAOException - Can throw DAOException if any issue while updating.
	 */
	public String updateSupplier(Supplier supplier) throws DAOException;

	/**
	 * Soft delete of supplier.
	 * 
	 * @param taxNumber - Pass the tax Number
	 * @return - Return the status info
	 * @throws DAOException - Can throw DAOException if any issue while deleting.
	 */
	public String deleteSupplier(String taxNumber) throws DAOException;

	/**
	 * Re-active the supplier soft deactivate .
	 * 
	 * @param taxNumber - Pass the tax Number
	 * @return - Return the status info
	 * @throws DAOException - Can throw DAOException if any issue while
	 *                      reactivating.
	 */
	public String reActiveSupplier(String taxNumber) throws DAOException;

}
