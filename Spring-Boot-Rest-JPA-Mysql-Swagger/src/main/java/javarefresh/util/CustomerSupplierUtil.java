/**
 * Copyright (c) 2004, 2020, Yogesh Badgujar and/or its affiliates. 
 * All rights reserved and PROPRIETARY/CONFIDENTIAL. 
 * Use is subject to Yogesh Badgujar terms.
 */
package javarefresh.util;

import javarefresh.jpa.Company;
import javarefresh.jpa.Customer;
import javarefresh.jpa.Person;
import javarefresh.jpa.Supplier;
import javarefresh.model.CompanyBean;
import javarefresh.model.CustomerBean;
import javarefresh.model.PersonBean;
import javarefresh.model.SupplierBean;

/**
 * Purpose:Utility class that set the Customer and Supplier Bean object.
 *
 * Description:
 *
 * @author Yogesh Badgujar
 * email me in case any problem - badgujar.yogesh@gmail.com
 *
 */
public class CustomerSupplierUtil {

	/**
	 * Fill the CustomerBean from Customer JPA class.
	 * 
	 * @param customer - Pass the Customer JPA object
	 * @param bean     - Pass CustomerBean to set the object
	 */
	public static void getCustomerBean(Customer customer, CustomerBean bean) {
		bean.setId(customer.getId());
		bean.setCustomerNumber(customer.getCustomerNumber());
		bean.setLastOrderDate(customer.getLastOrderDate());
		bean.setCreatedBy(customer.getCreatedBy());
		bean.setCreatedDate(customer.getCreatedDate());
		bean.setModifyBy(customer.getModifyBy());
		bean.setModifyDate(customer.getModifyDate());
		if (customer.getCompany() != null) {
			Company company = customer.getCompany();
			bean.setCompanyBean(fillCompanyBean(company));
		}
		if (customer.getPerson() != null) {
			Person person = customer.getPerson();
			bean.setPersonBean(fillPersonBean(person));
		}
	}
	
	public static void getSupplierBean(Supplier supplier, SupplierBean bean) {
		bean.setId(supplier.getId());
		bean.setTaxNumber(supplier.getTaxNumber());
		bean.setOrderLeadInDays(supplier.getOrderLeadDays());
		bean.setCreatedBy(supplier.getCreatedBy());
		bean.setCreatedDate(supplier.getCreatedDate());
		bean.setModifyBy(supplier.getModifyBy());
		bean.setModifyDate(supplier.getModifyDate());
		if (supplier.getCompany() != null) {
			Company company = supplier.getCompany();
			bean.setCompanyBean(fillCompanyBean(company));
		}
		if (supplier.getPerson() != null) {
			Person person = supplier.getPerson();
			bean.setPersonBean(fillPersonBean(person));
		}
	}
	/**
	 * Set the PersonBean.
	 * @param person - Pass the Person JPA.
	 * @return - Return the PersonBean.
	 */
	public static PersonBean fillPersonBean(Person person) {
		PersonBean personBean = new PersonBean();
		personBean.setFirstName(person.getFirstName());
		personBean.setLastName(person.getLastName());
		// Set the phone number
		personBean.setAreaCode(person.getPhoneNumber().getAreaCode());
		personBean.setNumber(person.getPhoneNumber().getNumber());
		return personBean;
	}
	
	/**
	 * Set the CompanyBean.
	 * 
	 * @param company - Pass the Company JPA.
	 * @return - Return CompanyBean object.
	 */
	public static CompanyBean fillCompanyBean(Company company) {
		CompanyBean companyBean = new CompanyBean();
		companyBean.setName(company.getName());
		companyBean.setRegistrationNumber(company.getRegistrationNumber());
		// Set the phone number
		companyBean.setAreaCode(company.getPhoneNumber().getAreaCode());
		companyBean.setNumber(company.getPhoneNumber().getNumber());
		return companyBean;
	}
	
	/**
	 * Prepares string with full stack of exceptions.
	 *
	 * @param exception - initial exception
	 * @return String with all causes and trace elements
	 */
	public static String buildMessageWithCause(Throwable exception) {
		StringBuilder builder = new StringBuilder();
		int issueNo = 1;
		for (Throwable t = exception; t != null; t = t.getCause()) {
			builder.append("Issue ").append(issueNo).append(" ").append(exception != t ? "Caused by: " : "");
			builder.append(t.getLocalizedMessage()).append("\n");
			for (StackTraceElement ste : t.getStackTrace()) {
				builder.append("    ").append(ste.toString()).append("\n");
			}
			builder.append("\n");
			issueNo++;
		}

		return builder.toString();
	}
}
