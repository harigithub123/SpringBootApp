package com.billing.request;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ItemRequest  implements Serializable {

	private static final long serialVersionUID = -187514924337443316L;
	
	@JsonProperty("id")
	private Long id;
	
	@JsonProperty("item-name")
	@NotNull(message="MISSING_ITEM_NAME")
	private String itemName;
	
	@NotNull(message="MISSING_DISPLAY_ORDER")
	@JsonProperty("display-order")
	private Integer displayOrder;
	
	@NotNull(message="MISSING_ITEM_PRICE")
	@JsonProperty("item-price")
	private Double itemPrice;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public Integer getDisplayOrder() {
		return displayOrder;
	}

	public void setDisplayOrder(Integer displayOrder) {
		this.displayOrder = displayOrder;
	}

	public Double getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(Double itemPrice) {
		this.itemPrice = itemPrice;
	}
	
}
