package com.billing.response;


import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class ItemTransactionResponse {

	private static final long serialVersionUID = -187514924337443316L;
	
	
	private Long id;
	
	private Double total;
	
	@NotNull(message="MISSING_TRANSACTION_DATE")
	@JsonProperty("transaction-date")
	private Date transactionDate;
	
	//@NotNull(message="MISSING_TRANSACTION_DATE")
	@JsonProperty("user-name")
	private String userName;
	
	//@NotNull(message="MISSING_TRANSACTION_DATE")
	@JsonProperty("transaction-type")
	private String transactionType;
	
	@NotNull(message="MISSING_ITEMS")
	@JsonProperty("items")
	private List<OrderItemResponse> items;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public List<OrderItemResponse> getItems() {
		return items;
	}

	public void setItems(List<OrderItemResponse> items) {
		this.items = items;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}
	
}