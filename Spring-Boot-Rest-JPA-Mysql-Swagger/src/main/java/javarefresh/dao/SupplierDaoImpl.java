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
import org.springframework.stereotype.Repository;

import javarefresh.exception.DAOException;
import javarefresh.jpa.Supplier;

/**
 * Purpose:Get the Supplier details from reposotory
 *
 * Description:
 *
 * @author Yogesh Badgujar email me in case any problem -
 *         badgujar.yogesh@gmail.com
 *
 */
@Repository
public class SupplierDaoImpl extends CommonDao implements ISupplierDao {

	private static Logger logger = Logger.getLogger(SupplierDaoImpl.class.getName());

	/**
	 * Get the list of all supplier
	 * 
	 * @return - Return the list of supplier.
	 * @throws DAOException - Can throw DAOException.
	 */
	public List<Supplier> getAllSupplier() throws DAOException {
		Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(Supplier.class);
		criteria.add(Restrictions.eq("active", 1));
		logger.info("Supplier list size -->" + criteria.list().size());
		return (List<Supplier>) criteria.list();
	}

	/**
	 * Get the supplier by id.
	 * 
	 * @param id - Pass the id based on that search supplier.
	 * @return - Return the supplier if found otherwise null will be send
	 * @throws DAOException - Can throw DAOException.
	 */
	public Supplier getSupplierById(Long id) throws DAOException {
		return (Supplier) getSessionFactory().getCurrentSession().get(Supplier.class, id);
	}

	/**
	 * Pass the tax Number and get the particular supplier.
	 * 
	 * @param taxNumber - Pass tax Number.
	 * @return - Return SupplierBean.
	 * @throws DAOException - Can throw DAOException.
	 */
	public Supplier getSupplierByTaxNumber(String taxNumber) throws DAOException {
		Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(Supplier.class);
		criteria.add(Restrictions.eq("active", 1));
		criteria.add(Restrictions.eq("taxNumber", taxNumber));
		return (Supplier) criteria.uniqueResult();
	}

	/**
	 * Based on SearchSupplier object you will get the result. Filter will apply
	 * based on set value in the property bean.
	 * 
	 * @param customer - Pass the SearchSupplier object
	 * @return - List of SupplierBean
	 * @throws DAOException
	 */
	public List<Supplier> getSupplier(Supplier supplier) throws DAOException {
		Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(Supplier.class);
		criteria.add(Restrictions.eq("active", 1));
		if (supplier.getWithAndCondition().booleanValue()) {
			if (supplier.getId() != null) {
				criteria.add(Restrictions.eq("id", supplier.getId()));
			}
			if (supplier.getTaxNumber() != null) {
				criteria.add(Restrictions.eq("taxNumber", supplier.getTaxNumber()));
			}
		} else {
			Criterion id = null;
			Criterion taxNo = null;
			if (supplier.getId() != null & supplier.getTaxNumber() != null) {
				id = Restrictions.eq("id", supplier.getId());
				taxNo = Restrictions.eq("taxNumber", supplier.getTaxNumber());
			}
			if (id != null & taxNo != null) {
				criteria.add(Restrictions.or(id, taxNo));
			}else {
				if(supplier.getId() != null) {
					criteria.add(Restrictions.eq("id", supplier.getId()));
				}
				if(supplier.getTaxNumber() != null) {
					criteria.add(Restrictions.eq("taxNumber", supplier.getTaxNumber()));
				}
			}
		}
		//TODO Need to refine the above logic for cut shot
		return (List<Supplier>) criteria.list();
	}
}
