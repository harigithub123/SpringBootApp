package com.billing.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PersonRequestResponse {

	private static final long serialVersionUID = -187514924337443316L;
	
	//@JsonProperty("id")
	private Long id;
	
	//@JsonProperty("person-name")
	@NotNull(message="MISSING_PERSON_NME")
	private String name;
	
	@Size(min=10, max=10, message="INVALID_MOBILE_NUMBER")
	@NotNull(message="MISSING_MOBILE_NUMBER")
	//@JsonProperty("mobile-number")
	private String mobileNumber;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	
	
}
