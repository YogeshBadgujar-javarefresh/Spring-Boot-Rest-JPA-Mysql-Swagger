/**
 * Copyright (c) 2004, 2020, Yogesh Badgujar and/or its affiliates. 
 * All rights reserved and PROPRIETARY/CONFIDENTIAL. 
 * Use is subject to Yogesh Badgujar terms.
 */
package javarefresh.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javarefresh.dao.ISupplierDao;
import javarefresh.exception.CustomerSupplierException;
import javarefresh.exception.DAOException;
import javarefresh.jpa.Supplier;
import javarefresh.model.SearchSupplier;
import javarefresh.model.SupplierBean;
import javarefresh.util.CustomerSupplierUtil;

/**
 * Purpose:
 *
 * Description:
 *
 * @author Yogesh Badgujar email me in case any problem -
 *         badgujar.yogesh@gmail.com
 *
 */
@Service
public class SupplierService implements ISupplierService {

	@Autowired
	private ISupplierDao supplierDao;

	/**
	 * Get the list of all supplier
	 * 
	 * @return - Return the list of supplier.
	 * @throws CustomerSupplierException - Can throw CustomerSupplierException.
	 */
	public List<SupplierBean> getAllSupplier() throws CustomerSupplierException {
		List<SupplierBean> suppliers = new ArrayList<>();
		try {
			List<Supplier> supplierList = supplierDao.getAllSupplier();
			if (!supplierList.isEmpty()) {
				supplierList.stream().forEach(x -> {
					SupplierBean bean = new SupplierBean();
					CustomerSupplierUtil.getSupplierBean(x, bean);
					suppliers.add(bean);
				});
			}
		} catch (DAOException e) {
			throw new CustomerSupplierException(CustomerSupplierUtil.buildMessageWithCause(e.getCause()));
		}
		return suppliers;
	}

	/**
	 * Get the supplier by id.
	 * 
	 * @param id - Pass the id based on that search supplier.
	 * @return - Return the supplier if found otherwise null will be send
	 * @throws CustomerSupplierException - Can throw CustomerSupplierException.
	 */
	public SupplierBean getSupplierById(Long id) throws CustomerSupplierException {
		SupplierBean bean = new SupplierBean();
		try {
			Supplier supplier = supplierDao.getSupplierById(id);
			if (supplier != null) {
				CustomerSupplierUtil.getSupplierBean(supplier, bean);
			}
		} catch (DAOException e) {
			throw new CustomerSupplierException(CustomerSupplierUtil.buildMessageWithCause(e.getCause()));
		}
		return bean;
	}

	/**
	 * Pass the tax Number and get the particular supplier
	 * 
	 * @param taxNumber - Pass tax Number.
	 * @return - Return SupplierBean.
	 * @throws CustomerSupplierException - Can throw CustomerSupplierException.
	 */
	public SupplierBean getSupplierByTaxNumber(String taxNumber) throws CustomerSupplierException {
		SupplierBean bean = new SupplierBean();
		try {
			Supplier supplier = supplierDao.getSupplierByTaxNumber(taxNumber);
			if (supplier != null) {
				CustomerSupplierUtil.getSupplierBean(supplier, bean);
			}
		} catch (DAOException e) {
			throw new CustomerSupplierException(CustomerSupplierUtil.buildMessageWithCause(e.getCause()));
		}
		return bean;
	}

	/**
	 * Based on SearchSupplier object you will get the result. Filter will apply
	 * based on set value in the property bean.
	 * 
	 * @param customer - Pass the SearchSupplier object
	 * @return - List of SupplierBean
	 * @throws CustomerSupplierException
	 */
	public List<SupplierBean> getSupplier(SearchSupplier supplier) throws CustomerSupplierException {
		List<SupplierBean> suppliers = new ArrayList<>();
		try {
			Supplier tempSupplier = new Supplier();
			if (supplier.getId() != 0) {
				tempSupplier.setId(supplier.getId());
			}
			if (supplier.getTaxNumber() != null) {
				tempSupplier.setTaxNumber(supplier.getTaxNumber());
			}
			tempSupplier.setWithAndCondition(supplier.getWithAndCondition());

			List<Supplier> supplierList = supplierDao.getSupplier(tempSupplier);
			if (!supplierList.isEmpty()) {
				supplierList.stream().forEach(x -> {
					SupplierBean bean = new SupplierBean();
					CustomerSupplierUtil.getSupplierBean(x, bean);
					suppliers.add(bean);
				});
			}
		} catch (DAOException e) {
			throw new CustomerSupplierException(CustomerSupplierUtil.buildMessageWithCause(e.getCause()));
		}
		return suppliers;
	}
}
