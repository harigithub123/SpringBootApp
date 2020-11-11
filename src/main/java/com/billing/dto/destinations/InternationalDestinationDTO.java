package com.billing.dto.destinations;

import javax.validation.constraints.NotNull;

public class InternationalDestinationDTO {

	private Long id;
	
	@NotNull(message="MISSING_COUNTRY_CODE")
	private String countryCode;
	
	@NotNull(message="MISSING_COUNTRY_NAME")
	private String countryName;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	
}
