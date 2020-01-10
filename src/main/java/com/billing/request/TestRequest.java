package com.billing.request;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TestRequest implements Serializable {

	private static final long serialVersionUID = -187514924337443316L;


	@JsonProperty("user-id")
	@NotNull(message="MISSING_USER_ID")
	private String userId;
	
}
