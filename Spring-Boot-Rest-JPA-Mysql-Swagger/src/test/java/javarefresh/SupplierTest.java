/**
 * Copyright (c) 2004, 2020, Yogesh Badgujar and/or its affiliates. 
 * All rights reserved and PROPRIETARY/CONFIDENTIAL. 
 * Use is subject to Yogesh Badgujar terms.
 */
package javarefresh;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import javarefresh.model.SupplierBean;

/**
 * Purpose:Test the Supplier related Rest API methods.
 *
 * Description:
 *
 * @author Yogesh Badgujar email me in case any problem -
 *         badgujar.yogesh@gmail.com
 *
 */
public class SupplierTest extends BaseTest{

	@BeforeEach
	public void setup() {
		// Nothing to set
	}

	//@Test
	public void testFindAllSupplier() throws Exception {
		path = path + randomServerPort + "/custSupplierApp/suppliers";
		ParameterizedTypeReference<List<SupplierBean>> myBean = new ParameterizedTypeReference<List<SupplierBean>>() {
		};
		ResponseEntity<List<SupplierBean>> response = template.exchange(path, HttpMethod.GET, null, myBean);
		//INSERT INTO supplier(id, version, tax_number, order_lead_days, person_id,
		//created_by, created_date, modified_by, modified_date, active) 
		//VALUES ('1', '1', '7898', '2', '2', 'Yogesh', '15-06-2020', 'Yogesh', '15-06-2020', '1');

		SupplierBean bean = new SupplierBean();
		bean.setId(1L);
		bean.setTaxNumber("7898");
		assertThat(response.getBody()).contains(bean);
	}
	
	@Test
	public void testGetSupplierById() {
		path = path + randomServerPort + "/custSupplierApp/supplier";
		SupplierBean supplier = this.template.getForObject(path + "/4/", SupplierBean.class);
		assertThat(supplier).extracting("id", "taxNumber").containsExactly(4L, "5511");
	}
}
