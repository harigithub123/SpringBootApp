package com.billing.response;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class SalaryRecordResponse  implements Serializable {

	private static final long serialVersionUID = -187514924337443316L;
	
	@JsonProperty("id")
	private Long id;
	
	@JsonProperty("employee-name")
	//@NotNull(message="MISSING_OFFICE_NO")
	private String employeeName;
	
	//@Size(min=10, max=10, message="INVALID_MOBILE_NUMBER")
	//@NotNull(message="MISSING_MOBILE_NUMBER")
	@JsonProperty("final-amount")
	private Double finalAmount;

	//@NotNull(message="MISSING_EMAIL_ID")
	//@Pattern(regexp=AppConstants.EMAIL_REGEX, message="INVALID_EMAIL_ID")
	@JsonProperty("deduction")
	private Double deduction;
	
	//@NotNull(message="MISSING_OFFICE_NAME")
	@JsonProperty("no-of-leaves")
	private int noOfLeaves;
	
	@JsonProperty("month")
	private String month;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
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

