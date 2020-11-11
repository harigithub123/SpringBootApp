package com.billing.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SalaryRecordRequest  implements Serializable {

	private static final long serialVersionUID = -187514924337443316L;
	
	//@JsonProperty("id")
	private Long id;
	
	//@JsonProperty("employee-id")
	//@NotNull(message="MISSING_OFFICE_NO")
	private Long employeeId;
	
	//@Size(min=10, max=10, message="INVALID_MOBILE_NUMBER")
	//@NotNull(message="MISSING_MOBILE_NUMBER")
	//@JsonProperty("final-amount")
	private Double finalAmount;

	//@NotNull(message="MISSING_EMAIL_ID")
	//@Pattern(regexp=AppConstants.EMAIL_REGEX, message="INVALID_EMAIL_ID")
	//@JsonProperty("deduction")
	private Double deduction;
	
	//@NotNull(message="MISSING_OFFICE_NAME")
	//@JsonProperty("number-of-leaves")
	private int noOfLeaves;
	
	//@JsonProperty("month")
	private String month;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	public Double getFinalAmount() {
		return finalAmount;
	}

	public void setFinalAmount(Double finalAmount) {
		this.finalAmount = finalAmount;
	}

	public Double getDeduction() {
		return deduction;
	}

	public void setDeduction(Double deduction) {
		this.deduction = deduction;
	}

	public int getNoOfLeaves() {
		return noOfLeaves;
	}

	public void setNoOfLeaves(int noOfLeaves) {
		this.noOfLeaves = noOfLeaves;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

}

