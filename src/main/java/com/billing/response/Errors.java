package com.billing.response;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Errors {

	@JsonProperty(value="errors")
	public List<Error> errorList = new ArrayList<Error>();
	
	public void setErrorList(List<Error> errorList) {
		this.errorList = errorList;
	}
	
	public List<Error> getErrorList() {
		return errorList;
	}
}
