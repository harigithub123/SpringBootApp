package com.billing.dto.destinations;

import javax.validation.constraints.NotNull;

public class DomesticDestinationDTO {

	private static final long serialVersionUID = -187514924337443316L;
	
	private Long id;
	
	@NotNull(message="MISSING_PIN_CODE")
	private String pinCode;
	
	@NotNull(message="MISSING_DESTINATION")
	private String destination;
	
	@NotNull(message="MISSING_ZONE")
	private String zone;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPinCode() {
		return pinCode;
	}

	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}
	
	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getZone() {
		return zone;
	}

	public void setZone(String zone) {
		this.zone = zone;
	}

}
