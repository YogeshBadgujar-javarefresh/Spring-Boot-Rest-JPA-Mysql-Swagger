/**
 * Copyright (c) 2004, 2020, Yogesh Badgujar and/or its affiliates. 
 * All rights reserved and PROPRIETARY/CONFIDENTIAL. 
 * Use is subject to Yogesh Badgujar terms.
 */
package javarefresh.jpa;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Purpose:PhoneNumber details.
 *
 * Description:
 *
 * @author Yogesh Badgujar email me in case any problem -
 *         badgujar.yogesh@gmail.com
 *
 */
@Entity
@Table(name = "phone_details")
public class PhoneNumber extends GenericFields implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "area_code", length = 10, nullable = false)
	private String areaCode;

	@Column(name = "number", length = 15, nullable = false)
	private String number;

	public PhoneNumber() {

	}

	public PhoneNumber(Long id, String areaCode, String number) {
		super();
		this.areaCode = areaCode;
		this.number = number;
	}

	public String getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}
}
