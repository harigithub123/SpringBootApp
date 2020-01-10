package com.billing.response;

import com.fasterxml.jackson.annotation.JsonProperty;


public class Error {
	
	@JsonProperty(value="code")
	public String code;
	@JsonProperty(value="message")
	public String message;
	
	
	public Error(String code, String message) {

		this.code= code;
		this.message = message;
	
	}
}
