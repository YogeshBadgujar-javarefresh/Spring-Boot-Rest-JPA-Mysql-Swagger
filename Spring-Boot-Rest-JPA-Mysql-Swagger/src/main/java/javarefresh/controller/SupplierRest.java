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
import javarefresh.model.SearchSupplier;
import javarefresh.model.SupplierBean;
import javarefresh.service.ISupplierService;

/**
 * Purpose:Supplier Rest which will provide all services related to supplier.
 *
 * Description:
 *
 * @author Yogesh Badgujar email me in case any problem -
 *         badgujar.yogesh@gmail.com
 *
 */
@RestController
public class SupplierRest {

	@Autowired
	ISupplierService supplierService;

	@GetMapping(value = "/suppliers", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<SupplierBean> findAllSupplier() throws CustomerSupplierException {
		return supplierService.getAllSupplier();
	}

	// @ResponseBody also produce JSON format output.
	@GetMapping(value = "/supplier/{id}")
	@ResponseBody
	public SupplierBean getSupplierById(@PathVariable Long id) throws CustomerSupplierException {
		return supplierService.getSupplierById(id);
	}

	@GetMapping(value = "/supplierTaxNumber/{taxNumber}")
	@ResponseBody
	public SupplierBean getSupplierByTaxNumber(@PathVariable String taxNumber) throws CustomerSupplierException {
		return supplierService.getSupplierByTaxNumber(taxNumber);
	}

	@RequestMapping(value = "/suppliers", method = RequestMethod.POST, headers = { "Content-type=application/json" })
	@ResponseBody
	public List<SupplierBean> getSupplier(@RequestBody SearchSupplier searchSupplier) throws CustomerSupplierException {
		return supplierService.getSupplier(searchSupplier);
	}

	// Create, update, delete, re-active supplier
	@RequestMapping(value = "/supplier", method = RequestMethod.POST, headers = { "Content-type=application/json" })
	public String createSupplier(@RequestBody SupplierBean supplierBean) throws CustomerSupplierException {
		// TODO - Need to pretty message if you add Person and Company data at a time.
		return supplierService.createSupplier(supplierBean);
	}

	@RequestMapping(value = "/supplier", method = RequestMethod.PUT, headers = { "Content-type=application/json" })
	public String updateSupplier(@RequestBody SupplierBean supplierBean) throws CustomerSupplierException {
		return supplierService.updateSupplier(supplierBean);
	}

	@DeleteMapping(value = "/supplier/{taxNumber}")
	@ResponseBody
	public String deleteCustomer(@PathVariable String taxNumber) throws CustomerSupplierException {
		return supplierService.deleteSupplier(taxNumber);
	}

	@PutMapping(value = "/supplier/{taxNumber}")
	@ResponseBody
	public String reActiveCustomer(@PathVariable String taxNumber) throws CustomerSupplierException {
		return supplierService.reActiveSupplier(taxNumber);
	}

}
