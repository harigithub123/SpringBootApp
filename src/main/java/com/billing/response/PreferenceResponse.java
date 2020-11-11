package com.billing.response;


public class PreferenceResponse {
	private Long id;
	private Long shipperId;
	private String columName;
	private String columnSize;
	private String alignment;
	private Long displayOrder;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getShipperId() {
		return shipperId;
	}

	public void setShipperId(Long shipperId) {
		this.shipperId = shipperId;
	}

	public String getColumName() {
		return columName;
	}

	public void setColumName(String columName) {
		this.columName = columName;
	}

	public String getColumnSize() {
		return columnSize;
	}

	public void setColumnSize(String columnSize) {
		this.columnSize = columnSize;
	}

	public String getAlignment() {
		return alignment;
	}

	public void setAlignment(String alignment) {
		this.alignment = alignment;
	}

	public Long getDisplayOrder() {
		return displayOrder;
	}

	public void setDisplayOrder(Long displayOrder) {
		this.displayOrder = displayOrder;
	}
		
}
