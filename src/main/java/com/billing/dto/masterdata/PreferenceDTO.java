package com.billing.dto.masterdata;

import javax.validation.constraints.NotNull;

public class PreferenceDTO {
	private Long id;
	
	@NotNull(message="MISSING_SHIPPER_ID")
	private Long shipperId;
	
	@NotNull(message="MISSING_COL_NAME")
	private String columName;
	
	@NotNull(message="MISSING_COL_SIZE")
	private double columnSize;

	@NotNull(message="MISSING_ALIGNMENT")
	private String alignment;
	
	@NotNull(message="MISSING_DISP_ORDER")
	private int displayOrder;

	
	public PreferenceDTO() {
		super();
	}

	public PreferenceDTO(Long id, Long shipperId, String columName,
			double columnSize, String alignment, int displayOrder) {
		super();
		this.id = id;
		this.shipperId = shipperId;
		this.columName = columName;
		this.columnSize = columnSize;
		this.alignment = alignment;
		this.displayOrder = displayOrder;
	}

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

	public double getColumnSize() {
		return columnSize;
	}

	public void setColumnSize(double columnSize) {
		this.columnSize = columnSize;
	}

	public String getAlignment() {
		return alignment;
	}

	public void setAlignment(String alignment) {
		this.alignment = alignment;
	}

	public int getDisplayOrder() {
		return displayOrder;
	}

	public void setDisplayOrder(int displayOrder) {
		this.displayOrder = displayOrder;
	}
		
	
}
