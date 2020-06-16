/**
 * Copyright (c) 2004, 2020, Yogesh Badgujar and/or its affiliates. 
 * All rights reserved and PROPRIETARY/CONFIDENTIAL. 
 * Use is subject to Yogesh Badgujar terms.
 */
package javarefresh;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import java.net.URI;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;

import javarefresh.model.CustomerBean;
import javarefresh.model.SearchCustomer;

/**
 * Purpose:Test the Customer related rest api methods.
 *
 * Description:
 *
 * @author Yogesh Badgujar email me in case any problem -
 *         badgujar.yogesh@gmail.com
 *
 */
public class CustomerTest extends BaseTest{

	@BeforeEach
	public void setup() {
		// Nothing to set
	}

	//@Test
	public void testGetAllCustomer() throws Exception {
		path = path + randomServerPort + "/custSupplierApp/customers";
		ParameterizedTypeReference<List<CustomerBean>> myBean = new ParameterizedTypeReference<List<CustomerBean>>() {
		};
		ResponseEntity<List<CustomerBean>> response = template.exchange(path, HttpMethod.GET, null, myBean);
		// INSERT INTO customer (id, version, customer_number, last_order_date, person_id,
		//created_by, created_date, modified_by, modified_date, active) 
		//VALUES ('1', '1', '1001', '2020-15-06', '1', 'Ram', '2020-15-06', 'Ram', '15-06-2020', '1');
		CustomerBean bean = new CustomerBean();
		bean.setId(1L);
		bean.setCustomerNumber("1001");
		assertThat(response.getBody()).contains(bean);
	}
	
	@Test
	public void testGetCustomerById() {
		// INSERT INTO customer (id, version, customer_number, last_order_date, person_id,
		//created_by, created_date, modified_by, modified_date, active) 
		//VALUES ('1', '1', '1001', '2020-15-06', '1', 'Ram', '2020-15-06', 'Ram', '15-06-2020', '1');
		path = path + randomServerPort + "/custSupplierApp/customer";
		CustomerBean customer = this.template.getForObject(path + "/1/", CustomerBean.class);
		assertThat(customer).extracting("id", "customerNumber").containsExactly(1L, "1001");
	}
	
	@Test
	public void testGetCustomer() throws Exception {
		path = path + randomServerPort + "/custSupplierApp/customers";
		ParameterizedTypeReference<List<CustomerBean>> myBean = new ParameterizedTypeReference<List<CustomerBean>>() {
		};
		SearchCustomer search = new SearchCustomer();
		search.setId(1L);
		search.setCustomerNumber("1001");
		RequestEntity<SearchCustomer> request = RequestEntity
	            .post(new URI(path))
	            .accept(MediaType.APPLICATION_JSON)
	            .contentType(MediaType.APPLICATION_JSON)
	            .body(search);
		ResponseEntity<List<CustomerBean>> response = template.exchange(path, HttpMethod.POST, request, myBean);
		assertEquals(200, response.getStatusCodeValue());
	}

}
