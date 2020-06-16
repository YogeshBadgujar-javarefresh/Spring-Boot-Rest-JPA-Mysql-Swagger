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
import org.springframework.transaction.annotation.Transactional;

import javarefresh.dao.ICustomerDao;
import javarefresh.exception.CustomerSupplierException;
import javarefresh.exception.DAOException;
import javarefresh.jpa.Customer;
import javarefresh.model.CustomerBean;
import javarefresh.model.SearchCustomer;
import javarefresh.util.CustomerSupplierUtil;

/**
 * Purpose:Get the Customer details through CustomerService.
 *
 * Description:
 *
 * @author Yogesh Badgujar email me in case any problem -
 *         badgujar.yogesh@gmail.com
 *
 */
@Service
@Transactional //for future
public class CustomerService implements ICustomerService {

	@Autowired
	private ICustomerDao customerDao;

	/**
	 * Get the list of all customers
	 * 
	 * @return - Return the list of customers.
	 * @throws CustomerSupplierException - Can throw CustomerSupplierException.
	 */
	public List<CustomerBean> getAllCustomer() throws CustomerSupplierException {
		List<CustomerBean> customers = new ArrayList<>();
		try {
			List<Customer> custList = customerDao.getAllCustomer();
			if (!custList.isEmpty()) {
				custList.stream().forEach(x -> {
					CustomerBean bean = new CustomerBean();
					CustomerSupplierUtil.getCustomerBean(x, bean);
					customers.add(bean);
				});
			}
		} catch (DAOException e) {
			throw new CustomerSupplierException(CustomerSupplierUtil.buildMessageWithCause(e.getCause()));
		}

		return customers;
	}

	/**
	 * Get the customer by id
	 * 
	 * @param id - Pass the id based on that search customer.
	 * @return - Return the customer if found otherwise null will be send
	 * @throws CustomerSupplierException - Can throw CustomerSupplierException.
	 */
	public CustomerBean getCustomerById(Long id) throws CustomerSupplierException {
		CustomerBean bean = new CustomerBean();
		try {
			Customer customer = customerDao.getCustomerById(id);
			if (customer != null) {
				CustomerSupplierUtil.getCustomerBean(customer, bean);
			}
		} catch (DAOException e) {
			throw new CustomerSupplierException(CustomerSupplierUtil.buildMessageWithCause(e.getCause()));
		}
		return bean;
	}

	/**
	 * 
	 * @param customerNumber
	 * @return
	 * @throws CustomerSupplierException - Can throw CustomerSupplierException.
	 */
	public CustomerBean getCustomerByCustomerNumber(String customerNumber) throws CustomerSupplierException {
		CustomerBean bean = new CustomerBean();
		try {
			Customer customer = customerDao.getCustomerByCustomerNumber(customerNumber);
			if (customer != null) {
				CustomerSupplierUtil.getCustomerBean(customer, bean);
			}
		} catch (DAOException e) {
			throw new CustomerSupplierException(CustomerSupplierUtil.buildMessageWithCause(e.getCause()));
		}
		return bean;
	}

	/**
	 * Based on SearchCustomer object you will get the result. Filter will apply
	 * based on set value in the property bean.
	 * 
	 * @param customer - Pass the SearchCustomer object
	 * @return - List of CustomerBean
	 * @throws CustomerSupplierException
	 */
	public List<CustomerBean> getCustomer(SearchCustomer customer) throws CustomerSupplierException {
		List<CustomerBean> customers = new ArrayList<>();
		try {
			Customer tempCustomer = new Customer();
			if(customer.getId() != 0) {
				tempCustomer.setId(customer.getId());
			}
			if(customer.getCustomerNumber() != null) {
				tempCustomer.setCustomerNumber(customer.getCustomerNumber());
			}
			tempCustomer.setWithAndCondition(customer.getWithAndCondition());
			
			List<Customer> custList = customerDao.getCustomer(tempCustomer);
			if (!custList.isEmpty()) {
				custList.stream().forEach(x -> {
					CustomerBean bean = new CustomerBean();
					CustomerSupplierUtil.getCustomerBean(x, bean);
					customers.add(bean);
				});
			}
		} catch (DAOException e) {
			throw new CustomerSupplierException(CustomerSupplierUtil.buildMessageWithCause(e.getCause()));
		}

		return customers;
	}

}
