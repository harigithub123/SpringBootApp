package com.billing.request;

import java.sql.Date;
import java.util.List;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ItemTransactionRequest {

	private static final long serialVersionUID = -187514924337443316L;
	
	@NotNull(message="MISSING_TRANSACTION_DATE")
	//@JsonProperty("transaction-date")
	private Date transactionDate;
	
	//@NotNull(message="MISSING_TRANSACTION_DATE")
	//@JsonProperty("user-id")
	private Long userId;
	
	//@NotNull(message="MISSING_TRANSACTION_DATE")
	//@JsonProperty("transaction-type")
	private String transactionType;
	
	@NotNull(message="MISSING_ITEMS")
	//@JsonProperty("items")
	private List<OrderItemRequest> items;
	
	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	public List<OrderItemRequest> getItems() {
		return items;
	}

	public void setItems(List<OrderItemRequest> items) {
		this.items = items;
	}
	
}