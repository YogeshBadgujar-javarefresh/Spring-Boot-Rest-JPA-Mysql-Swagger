/**
 * Copyright (c) 2004, 2020, Yogesh Badgujar and/or its affiliates. 
 * All rights reserved and PROPRIETARY/CONFIDENTIAL. 
 * Use is subject to Yogesh Badgujar terms.
 */
package javarefresh.jpa;

import java.io.Serializable;

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
 * Purpose:Supplier details.
 *
 * Description:
 *
 * @author Yogesh Badgujar email me in case any problem -
 *         badgujar.yogesh@gmail.com
 *
 */
@Entity
@Table(name = "supplier")
public class Supplier extends GenericFields implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "tax_number", length = 25, nullable = false)
	private String taxNumber;

	@Column(name = "order_lead_days", length = 5, nullable = false)
	private Integer orderLeadDays;

	@OneToOne(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name = "person_id")
	private Person person;

	@OneToOne(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name = "company_id")
	private Company company;

	@Transient // Set the AND / OR condition
	private Boolean withAndCondition = Boolean.TRUE;

	public Supplier() {

	}

	public Supplier(String taxNumber, Integer orderLeadDays, Person person, Company company) {
		super();
		this.taxNumber = taxNumber;
		this.orderLeadDays = orderLeadDays;
		this.person = person;
		this.company = company;
	}

	public String getTaxNumber() {
		return taxNumber;
	}

	public void setTaxNumber(String taxNumber) {
		this.taxNumber = taxNumber;
	}

	public Integer getOrderLeadDays() {
		return orderLeadDays;
	}

	public void setOrderLeadDays(Integer orderLeadDays) {
		this.orderLeadDays = orderLeadDays;
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
