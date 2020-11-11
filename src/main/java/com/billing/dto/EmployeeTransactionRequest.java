package com.billing.dto;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EmployeeTransactionRequest implements Serializable {

		private static final long serialVersionUID = -187514924337443316L;
		
		//@JsonProperty("id")
		private Long id;
		
		//@JsonProperty("employee-id")
		//@NotNull(message="MISSING_OFFICE_NO")
		private Long employeeId;
		
		//@NotNull(message="MISSING_OFFICE_NAME")
		//@JsonProperty("amount")
		private double amount;
		
		//@NotNull(message="MISSING_EMAIL_ID")
		//@Pattern(regexp=AppConstants.EMAIL_REGEX, message="INVALID_EMAIL_ID")
		//@JsonProperty("transaction-mode")
		private String transactionMode;
		
		//@NotNull(message="MISSING_EMAIL_ID")
		//@Pattern(regexp=AppConstants.EMAIL_REGEX, message="INVALID_EMAIL_ID")
		//@JsonProperty("transaction-date")
		private Date transactionDate;
		
		//@Size(min=10, max=10, message="INVALID_MOBILE_NUMBER")
		//@NotNull(message="MISSING_MOBILE_NUMBER")
		//@JsonProperty("given-by")
		private String givenBy;
		
		//@NotNull(message="MISSING_CONTACT_PERSON")
		//@JsonProperty("reference-no")
		private String referenceNo;
		
		//@JsonProperty("comments")
		private String comments;

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

		public double getAmount() {
			return amount;
		}

		public void setAmount(double amount) {
			this.amount = amount;
		}

		public String getTransactionMode() {
			return transactionMode;
		}

		public void setTransactionMode(String transactionMode) {
			this.transactionMode = transactionMode;
		}

		public String getGivenBy() {
			return givenBy;
		}

		public void setGivenBy(String givenBy) {
			this.givenBy = givenBy;
		}

		public String getReferenceNo() {
			return referenceNo;
		}

		public void setReferenceNo(String referenceNo) {
			this.referenceNo = referenceNo;
		}

		public String getComments() {
			return comments;
		}

		public void setComments(String comments) {
			this.comments = comments;
		}

		public Date getTransactionDate() {
			return transactionDate;
		}

		public void setTransactionDate(Date transactionDate) {
			this.transactionDate = transactionDate;
		}
		
}
