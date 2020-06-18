/**
 * Copyright (c) 2004, 2020, Yogesh Badgujar and/or its affiliates. 
 * All rights reserved and PROPRIETARY/CONFIDENTIAL. 
 * Use is subject to Yogesh Badgujar terms.
 */
package javarefresh.dao;

import java.util.List;
import java.util.logging.Logger;

import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javarefresh.exception.DAOException;
import javarefresh.jpa.Customer;

/**
 * Purpose:CustomerDaoImpl is to get the data from JPA model.
 *
 * Description:
 *
 * @author Yogesh Badgujar email me in case any problem -
 *         badgujar.yogesh@gmail.com
 *
 */
@Repository
@Component
public class CustomerDaoImpl extends CommonDao implements ICustomerDao {

	private static Logger logger = Logger.getLogger(CustomerDaoImpl.class.getName());
	private final static String STATUS = "sucess";

	/**
	 * Get the list of all customers
	 * 
	 * @return - Return the list of customers.
	 * @throws DAOException - Can throw DAOException.
	 */
	@SuppressWarnings("unchecked")
	public List<Customer> getAllCustomer() throws DAOException {
		Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(Customer.class);
		criteria.add(Restrictions.eq("active", 1));
		logger.info("Customer list size -->" + criteria.list().size());
		return (List<Customer>) criteria.list();
	}

	/**
	 * Get the customer by id
	 * 
	 * @param id - Pass the id based on that search customer.
	 * @return - Return the customer if found otherwise null will be send
	 * @throws DAOException - Can throw DAOException.
	 */
	public Customer getCustomerById(Long id) throws DAOException {
		return (Customer) getSessionFactory().getCurrentSession().get(Customer.class, id);
	}

	/**
	 * Get the customer by customer number.
	 * 
	 * @param customerNumber - Pass the customer number.
	 * @return
	 * @throws DAOException - Can throw DAOException.
	 */
	public Customer getCustomerByCustomerNumber(String customerNumber) throws DAOException {
		Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(Customer.class);
		criteria.add(Restrictions.eq("active", 1));
		criteria.add(Restrictions.eq("customerNumber", customerNumber));
		return (Customer) criteria.uniqueResult();
	}

	/**
	 * Based on SearchCustomer object you will get the result. Filter will apply
	 * based on set value in the property bean.
	 * 
	 * @param customer - Pass the Customer object
	 * @return - List of CustomerBean
	 * @throws DAOException - Can throw DAOException.
	 */
	public List<Customer> getCustomer(Customer customer) throws DAOException {
		Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(Customer.class);
		criteria.add(Restrictions.eq("active", 1));
		if (customer.getWithAndCondition().booleanValue()) {
			if (customer.getId() != null) {
				criteria.add(Restrictions.eq("id", customer.getId()));
			}
			if (customer.getCustomerNumber() != null) {
				criteria.add(Restrictions.eq("customerNumber", customer.getCustomerNumber()));
			}
		} else {
			Criterion id = null;
			Criterion custNo = null;
			if (customer.getId() != null & customer.getCustomerNumber() != null) {
				id = Restrictions.eq("id", customer.getId());
				custNo = Restrictions.eq("customerNumber", customer.getCustomerNumber());
			}
			if (id != null & custNo != null) {
				criteria.add(Restrictions.or(id, custNo));
			} else {
				if (customer.getId() != null) {
					criteria.add(Restrictions.eq("id", customer.getId()));
				}
				if (customer.getCustomerNumber() != null) {
					criteria.add(Restrictions.eq("customerNumber", customer.getCustomerNumber()));
				}
			}
		}
		return (List<Customer>) criteria.list();
	}

	// Create, update, delete, re-active customers
	/**
	 * Create the customer.
	 * 
	 * @param customerBean - Pass the customer bean.
	 * @return - Return the response code.
	 * @throws DAOException - Can throw DAOException if any issue while creating.
	 */
	public String createCustomer(Customer customer) throws DAOException {
		getSessionFactory().getCurrentSession().save(customer);
		return STATUS;
	}

	/**
	 * Update the customer.
	 * 
	 * @param customerBean - Pass the customer bean.
	 * @return - Return the response code.
	 * @throws DAOException - Can throw DAOException if any issue while updating.
	 */
	public String updateCustomer(Customer customerBean) throws DAOException {
		return STATUS;
	}

	/**
	 * Delete the customer.
	 * 
	 * @param customerNumber - Pass the customer number
	 * @return - Return the status info
	 * @throws DAOException - Can throw DAOException if any issue while deleting.
	 */
	public String deleteCustomer(String customerNumber) throws DAOException {
		Customer customer = getCustomerByCustomerNumber(customerNumber);
		customer.setActive(0);
		customer.setVersion(customer.getVersion() + 1);
		getSessionFactory().getCurrentSession().update(customer);
		return STATUS;
	}

	/**
	 * Re-active the customer.
	 * 
	 * @param customerNumber - Pass the customer number
	 * @return - Return the status info
	 * @throws DAOException - Can throw DAOException if any issue while
	 *                      reactivating.
	 */
	public String reActiveCustomer(String customerNumber) throws DAOException {
		Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(Customer.class);
		criteria.add(Restrictions.eq("customerNumber", customerNumber));
		Customer customer = (Customer) criteria.uniqueResult();
		customer.setActive(1);
		customer.setVersion(customer.getVersion() + 1);
		getSessionFactory().getCurrentSession().update(customer);
		return STATUS;
	}

}
