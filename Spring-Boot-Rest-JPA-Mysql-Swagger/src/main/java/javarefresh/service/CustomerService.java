/**
 * Copyright (c) 2004, 2020, Yogesh Badgujar and/or its affiliates. 
 * All rights reserved and PROPRIETARY/CONFIDENTIAL. 
 * Use is subject to Yogesh Badgujar terms.
 */
package javarefresh.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javarefresh.dao.ICustomerDao;
import javarefresh.exception.CustomerSupplierException;
import javarefresh.exception.DAOException;
import javarefresh.jpa.Company;
import javarefresh.jpa.Customer;
import javarefresh.jpa.Person;
import javarefresh.jpa.PhoneNumber;
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
@Transactional // for future
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
			if (customer.getId() != 0) {
				tempCustomer.setId(customer.getId());
			}
			if (customer.getCustomerNumber() != null) {
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

	// Create, update, delete, re-active customers
	/**
	 * Create the customer.
	 * 
	 * @param customerBean - Pass the customer bean.
	 * @return - Return the response code.
	 * @throws CustomerSupplierException - Can throw CustomerSupplierException if
	 *                                   any issue while creating.
	 */
	public String createCustomer(CustomerBean customerBean) throws CustomerSupplierException {
		String message = null;
		try {
			Customer tempCustomer = new Customer();
			tempCustomer.setCustomerNumber(customerBean.getCustomerNumber());
			tempCustomer.setLastOrderDate(customerBean.getLastOrderDate());
			tempCustomer.setCreatedBy(customerBean.getCreatedBy());
			tempCustomer.setCreatedDate(new Date());
			tempCustomer.setModifyBy(customerBean.getCreatedBy());
			tempCustomer.setModifyDate(new Date());
			tempCustomer.setActive(1);
			if (customerBean.getPersonBean() != null) {
				Person person = new Person();
				person.setFirstName(customerBean.getPersonBean().getFirstName());
				person.setLastName(customerBean.getPersonBean().getLastName());
				person.setCreatedBy(customerBean.getCreatedBy());
				person.setCreatedDate(new Date());
				person.setModifyBy(customerBean.getCreatedBy());
				person.setModifyDate(new Date());
				PhoneNumber phoneNumber = new PhoneNumber();
				phoneNumber.setAreaCode(customerBean.getPersonBean().getAreaCode());
				phoneNumber.setNumber(customerBean.getPersonBean().getNumber());
				phoneNumber.setCreatedBy(customerBean.getCreatedBy());
				phoneNumber.setCreatedDate(new Date());
				phoneNumber.setModifyBy(customerBean.getCreatedBy());
				phoneNumber.setModifyDate(new Date());
				person.setPhoneNumber(phoneNumber);
				tempCustomer.setPerson(person);
			} else {
				Company company = new Company();
				company.setName(customerBean.getCompanyBean().getName());
				company.setRegistrationNumber(customerBean.getCompanyBean().getRegistrationNumber());
				company.setCreatedBy(customerBean.getCreatedBy());
				company.setCreatedDate(new Date());
				company.setModifyBy(customerBean.getCreatedBy());
				company.setModifyDate(new Date());
				PhoneNumber phoneNumber = new PhoneNumber();
				phoneNumber.setAreaCode(customerBean.getCompanyBean().getAreaCode());
				phoneNumber.setNumber(customerBean.getCompanyBean().getNumber());
				phoneNumber.setCreatedBy(customerBean.getCreatedBy());
				phoneNumber.setCreatedDate(new Date());
				phoneNumber.setModifyBy(customerBean.getCreatedBy());
				phoneNumber.setModifyDate(new Date());
				company.setPhoneNumber(phoneNumber);
				tempCustomer.setCompany(company);
			}
			message = customerDao.createCustomer(tempCustomer);
		} catch (DAOException e) {
			throw new CustomerSupplierException(CustomerSupplierUtil.buildMessageWithCause(e.getCause()));
		}

		return message;
	}

	/**
	 * Update the customer.
	 * 
	 * @param customerBean - Pass the customer bean.
	 * @return - Return the response code.
	 * @throws CustomerSupplierException - Can throw CustomerSupplierException if
	 *                                   any issue while updating.
	 */
	public String updateCustomer(CustomerBean customerBean) throws CustomerSupplierException {
		return null;
	}

	/**
	 * Delete the customer.
	 * 
	 * @param customerNumber - Pass the customer number
	 * @return - Return the status info
	 * @throws CustomerSupplierException - Can throw CustomerSupplierException if
	 *                                   any issue while deleting.
	 */
	public String deleteCustomer(String customerNumber) throws CustomerSupplierException {
		String message = null;
		try {
			message = customerDao.deleteCustomer(customerNumber);
		} catch (DAOException e) {
			throw new CustomerSupplierException(CustomerSupplierUtil.buildMessageWithCause(e.getCause()));
		}
		return message;
	}

	/**
	 * Re-active the customer.
	 * 
	 * @param customerNumber - Pass the customer number
	 * @return - Return the status info
	 * @throws CustomerSupplierException - Can throw CustomerSupplierException if
	 *                                   any issue while re-activting.
	 */
	public String reActiveCustomer(String customerNumber) throws CustomerSupplierException {
		String message = null;
		try {
			message = customerDao.reActiveCustomer(customerNumber);
		} catch (DAOException e) {
			throw new CustomerSupplierException(CustomerSupplierUtil.buildMessageWithCause(e.getCause()));
		}
		return message;
	}

}
