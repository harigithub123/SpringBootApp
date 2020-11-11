package com.billing.response;

public class ChargesTaxesResponse {

	private Long id;
	
	private String tax;
	
	private Long shipperId;

	private Long chargeId;

	public ChargesTaxesResponse() {
		super();
	}

	public ChargesTaxesResponse(Long id, String tax, Long shipperId, Long chargeId) {
		super();
		this.id = id;
		this.tax = tax;
		this.shipperId = shipperId;
		this.chargeId = chargeId;
	}

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
