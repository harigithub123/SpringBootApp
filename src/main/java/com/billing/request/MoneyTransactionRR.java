package com.billing.request;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MoneyTransactionRR {

		private static final long serialVersionUID = -187514924337443316L;
		
		@JsonProperty("id")
		private Long id;
		
		@JsonProperty("person-id")
		private Long personId;
		
		@JsonProperty("name")
		private String name;
		
		@JsonProperty("amount")
		private double amount;
		
		@JsonProperty("transaction-mode")
		private String transactionMode;
		
		@JsonProperty("transaction-date")
		private Date transactionDate;
		
		@JsonProperty("given-by")
		private String givenBy;
		
		@JsonProperty("reference-no")
		private String referenceNo;
		
		@JsonProperty("comments")
		private String comments;
		
		@JsonProperty("type")
		private String type;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public Long getPersonId() {
			return personId;
		}

		public void setPersonId(Long personId) {
			this.personId = personId;
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

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}
		
}
