package com.billing.request;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OrderInfoRequest  implements Serializable {

	private static final long serialVersionUID = -187514924337443316L;
	
	//@JsonProperty("id")
	private Long id;
	
	//@JsonProperty("customer-id")
	@NotNull(message="MISSING_CUSTOMER_ID")
	private Long customerId;
	
	//@JsonProperty("user-id")
	@NotNull(message="MISSING_USER_ID")
	private Long userId;
	
	@NotNull(message="MISSING_ORDER_DATE")
	//@JsonProperty("order-date")
	private Date orderDate;
	
	//@JsonProperty("items")
	private List<OrderItemRequest> items;
	
	public List<OrderItemRequest> getItems() {
		return items;
	}

	public void setItems(List<OrderItemRequest> items) {
		this.items = items;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
	
}
