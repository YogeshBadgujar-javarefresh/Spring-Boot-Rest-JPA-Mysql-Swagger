/**
 * Copyright (c) 2004, 2020, Yogesh Badgujar and/or its affiliates. 
 * All rights reserved and PROPRIETARY/CONFIDENTIAL. 
 * Use is subject to Yogesh Badgujar terms.
 */
package javarefresh.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javarefresh.exception.CustomerSupplierException;
import javarefresh.model.CustomerBean;
import javarefresh.model.SearchCustomer;
import javarefresh.service.ICustomerService;

/**
 * Purpose:Customer Rest which will provide all services related to customer.
 *
 * Description:
 *
 * @author Yogesh Badgujar email me in case any problem -
 *         badgujar.yogesh@gmail.com
 *
 */
@RestController
public class CustomerRest {

	@Autowired
	ICustomerService customerService;

	@GetMapping(value = "/customers", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<CustomerBean> findAllCustomer() throws CustomerSupplierException {
		return customerService.getAllCustomer();
	}

	@GetMapping(value = "/customers/{id}")
	@ResponseBody
	public CustomerBean getCustomerById(@PathVariable Long id) throws CustomerSupplierException {
		return customerService.getCustomerById(id);
	}

	@GetMapping(value = "/customers/{customerNumber}")
	@ResponseBody
	public CustomerBean getCustomerByCustomerNumber(@PathVariable String customerNumber)
			throws CustomerSupplierException {
		return customerService.getCustomerByCustomerNumber(customerNumber);
	}

	@RequestMapping(value = "/customers", method = RequestMethod.POST, headers = { "Content-type=application/json" })
	@ResponseBody
	public List<CustomerBean> getCustomer(@RequestBody SearchCustomer searchCustomer) throws CustomerSupplierException {
		return customerService.getCustomer(searchCustomer);
	}

	// Create, update, delete, re-active customers
	// TODO - Will implement with ResponseEntity<UUID>
	// @PostMapping
	/// @ResponseStatus(HttpStatus.CREATED)
	@RequestMapping(value = "/customer", method = RequestMethod.POST, headers = { "Content-type=application/json" })
	public String createCustomer(@RequestBody CustomerBean customerBean) throws CustomerSupplierException {
		// TODO - Need to pretty message if you add Person and Company data at a time.
		return customerService.createCustomer(customerBean);
	}

	@RequestMapping(value = "/customers", method = RequestMethod.PUT, headers = { "Content-type=application/json" })
	public String updateCustomer(@RequestBody CustomerBean customerBean) throws CustomerSupplierException {
		return customerService.updateCustomer(customerBean);
	}

	@DeleteMapping(value = "/customers/{customerNumber}")
	@ResponseBody
	public String deleteCustomer(@PathVariable String customerNumber) throws CustomerSupplierException {
		return customerService.deleteCustomer(customerNumber);
	}

	@PutMapping(value = "/customers/{customerNumber}")
	@ResponseBody
	public String reActiveCustomer(@PathVariable String customerNumber) throws CustomerSupplierException {
		return customerService.reActiveCustomer(customerNumber);
	}
}
