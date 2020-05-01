package com.billing.response;

import java.sql.Date;
import java.util.List;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class SaleResponse {

	private static final long serialVersionUID = -187514924337443316L;
	
	@NotNull(message="MISSING_TRANSACTION_DATE")
	@JsonProperty("transaction-date")
	private Date transactionDate;
	
	@NotNull(message="MISSING_ITEMS")
	@JsonProperty("items")
	private List<OrderItemResponse> items;
	
	private Double total;
	
	public SaleResponse() {
		// TODO Auto-generated constructor stub
	}

	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
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
