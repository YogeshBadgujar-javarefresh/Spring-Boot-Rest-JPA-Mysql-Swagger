/**
 * Copyright (c) 2004, 2020, Yogesh Badgujar and/or its affiliates. 
 * All rights reserved and PROPRIETARY/CONFIDENTIAL. 
 * Use is subject to Yogesh Badgujar terms.
 */
package javarefresh;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Purpose:Base call to set the test related setting. When we run the test case
 * then it will go and actually fetch data from DB and compare with test data.
 *
 * Description:
 *
 * @author Yogesh Badgujar email me in case any problem -
 *         badgujar.yogesh@gmail.com
 *
 */
@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
@RunWith(SpringRunner.class)
public class BaseTest {

	@Autowired
	public TestRestTemplate template;

	// No use of port as it will give 0 value if WebEnvironment.RANDOM_PORT
	// If you define the WebEnvironment.DEFINED_PORT then it will give you 8080
	@Value("${local.server.port}")
	public int randomServerPort;

	// throw Exception
	// @Autowired
	// Environment environment;
	// String port = environment.getProperty("local.server.port");

	public String path = "http://localhost:";
}
