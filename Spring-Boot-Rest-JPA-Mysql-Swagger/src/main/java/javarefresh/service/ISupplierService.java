/**
 * Copyright (c) 2004, 2020, Yogesh Badgujar and/or its affiliates. 
 * All rights reserved and PROPRIETARY/CONFIDENTIAL. 
 * Use is subject to Yogesh Badgujar terms.
 */
package javarefresh.service;

import java.util.List;

import javarefresh.exception.CustomerSupplierException;
import javarefresh.model.SearchSupplier;
import javarefresh.model.SupplierBean;

/**
 * Purpose:
 *
 * Description:
 *
 * @author Yogesh Badgujar
 * email me in case any problem - badgujar.yogesh@gmail.com
 *
 */
public interface ISupplierService {

	/**
	 * Get the list of all supplier
	 * 
	 * @return - Return the list of supplier.
	 * @throws CustomerSupplierException - Can throw CustomerSupplierException.
	 */
	public List<SupplierBean> getAllSupplier() throws CustomerSupplierException;

	/**
	 * Get the supplier by id.
	 * 
	 * @param id - Pass the id based on that search supplier.
	 * @return - Return the supplier if found otherwise null will be send
	 * @throws CustomerSupplierException - Can throw CustomerSupplierException.
	 */
	public SupplierBean getSupplierById(Long id) throws CustomerSupplierException;

	/**
	 * Pass the tax Number and get the particular supplier
	 * @param taxNumber - Pass tax Number.
	 * @return - Return SupplierBean.
	 * @throws CustomerSupplierException - Can throw CustomerSupplierException.
	 */
	public SupplierBean getSupplierByTaxNumber(String taxNumber) throws CustomerSupplierException;

	/**
	 * Based on SearchSupplier object you will get the result. Filter will apply
	 * based on set value in the property bean.
	 * 
	 * @param customer - Pass the SearchSupplier object
	 * @return - List of SupplierBean
	 * @throws CustomerSupplierException
	 */
	public List<SupplierBean> getSupplier(SearchSupplier supplier) throws CustomerSupplierException;
	
	/**
	 * Create the Supplier.
	 * 
	 * @param supplierBean - Pass the Supplier bean.
	 * @return - Return the response code.
	 * @throws CustomerSupplierException - Can throw CustomerSupplierException if
	 *                                   any issue while creating.
	 */
	public String createSupplier(SupplierBean supplierBean) throws CustomerSupplierException;
	
	/**
	 * Update the supplier.
	 * 
	 * @param supplierBean - Pass the Supplier bean.
	 * @return - Return the response code.
	 * @throws CustomerSupplierException - Can throw CustomerSupplierException if
	 *                                   any issue while updating.
	 */
	public String updateSupplier(SupplierBean supplierBean) throws CustomerSupplierException;
	
	/**
	 * Soft delete of supplier.
	 * 
	 * @param taxNumber - Pass the tax Number
	 * @return - Return the status info
	 * @throws CustomerSupplierException - Can throw CustomerSupplierException if
	 *                                   any issue while deleting.
	 */
	public String deleteSupplier(String taxNumber) throws CustomerSupplierException;
	
	/**
	 * Re-active the supplier soft deactivate .
	 * 
	* @param taxNumber - Pass the tax Number
	 * @return - Return the status info
	 * @throws CustomerSupplierException - Can throw CustomerSupplierException if
	 *                                   any issue while reactivating.
	 */
	public String reActiveSupplier(String taxNumber) throws CustomerSupplierException;
	

}
