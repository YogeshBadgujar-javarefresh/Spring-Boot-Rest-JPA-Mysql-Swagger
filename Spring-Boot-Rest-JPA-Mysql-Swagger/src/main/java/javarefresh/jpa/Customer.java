/**
 * Copyright (c) 2004, 2020, Yogesh Badgujar and/or its affiliates. 
 * All rights reserved and PROPRIETARY/CONFIDENTIAL. 
 * Use is subject to Yogesh Badgujar terms.
 */
package javarefresh.jpa;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.Hibernate;

/**
 * Purpose:Customer details. For Person/Company object pull the FetchType.LAZY.
 *
 * Description:
 *
 * @author Yogesh Badgujar email me in case any problem -
 *         badgujar.yogesh@gmail.com
 *
 */
@Entity
@Table(name = "customer")
public class Customer extends GenericFields implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "customer_number", length = 25, nullable = false)
	private String customerNumber;

	@Column(name = "last_order_date", nullable = false)
	private Date lastOrderDate;

	@OneToOne(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name = "person_id")
	private Person person;

	@OneToOne(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name = "company_id")
	private Company company;

	@Transient // Set the AND / OR condition
	private Boolean withAndCondition;

	public Customer() {

	}

	public Customer(Long id, String customerNumber, Date lastOrderDate, Person person, Company company) {
		super();
		this.customerNumber = customerNumber;
		this.lastOrderDate = lastOrderDate;
		this.person = person;
		this.company = company;
	}

	public String getCustomerNumber() {
		return customerNumber;
	}

	public void setCustomerNumber(String customerNumber) {
		this.customerNumber = customerNumber;
	}

	public Date getLastOrderDate() {
		return lastOrderDate;
	}

	public void setLastOrderDate(Date lastOrderDate) {
		this.lastOrderDate = lastOrderDate;
	}

	/**
	 * Set the Person object if mapping exist.
	 * 
	 * @return - Return the Person object or null.
	 */
	public Person getPerson() {
		if (!Hibernate.isInitialized(person)) {
			try {
				Hibernate.initialize(person);
			} catch (org.hibernate.ObjectNotFoundException one) {
				person = null;
			}
		}
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	/**
	 * Set the Company object if mapping exist.
	 * 
	 * @return - Return the Company object or null.
	 */
	public Company getCompany() {
		if (!Hibernate.isInitialized(company)) {
			try {
				Hibernate.initialize(company);
			} catch (org.hibernate.ObjectNotFoundException one) {
				company = null;
			}
		}
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public Boolean getWithAndCondition() {
		return withAndCondition;
	}

	public void setWithAndCondition(Boolean withAndCondition) {
		this.withAndCondition = withAndCondition;
	}
}
