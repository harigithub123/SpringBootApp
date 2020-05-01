package com.billing.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class OrderItemResponse {

	@JsonProperty("item-name")
	private String itemName;
	
	@JsonProperty("quantity")
	private Double quantity;
	
	@JsonProperty("total")
	private Double total;
	
	public Double getQuantity() {
		return quantity;
	}

	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	
	

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public OrderItemResponse(String itemName, Double quantity, Double total) {
		super();
		this.itemName = itemName;
		this.quantity = quantity;
		this.total = total;
	}

	public OrderItemResponse() {
		super();
	}
	
	
}
