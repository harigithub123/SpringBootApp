package com.billing.dto.masterdata;

import javax.validation.constraints.NotNull;

public class ChargesTaxesRequest {

	private Long id;
	
	@NotNull(message="MISSING_TAX")
	private String tax;
	
	@NotNull(message="MISSING_SHIPPER_ID")
	private Long shipperId;

	@NotNull(message="MISSING_CHARGE_ID")
	private Long chargeId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTax() {
		return tax;
	}

	public void setTax(String tax) {
		this.tax = tax;
	}

	public Long getShipperId() {
		return shipperId;
	}

	public void setShipperId(Long shipperId) {
		this.shipperId = shipperId;
	}

	public Long getChargeId() {
		return chargeId;
	}

	public void setChargeId(Long chargeId) {
		this.chargeId = chargeId;
	}

}
