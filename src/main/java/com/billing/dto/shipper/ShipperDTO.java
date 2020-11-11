package com.billing.dto.shipper;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

public class ShipperDTO  implements Serializable {

	private static final long serialVersionUID = -187514924337443316L;
	
	//@JsonProperty("id")
	private Long id;
	
	@NotNull(message="MISSING_CODE")
	private String code;
	
	@NotNull(message="MISSING_NAME")
	private String name;
	
	@NotNull(message="MISSING_SERVICE")
	private String service;

	@NotNull(message="MISSING_SERVICE_TYPE")
	private String serviceType;
	
	@NotNull(message="MISSING_ORGANIZATION_ID")
	private Long organizationId;
	
	private boolean dispFscForEachAWB;
	
	private boolean dispGstForEachAWB;
	
	private boolean roundUpBoxWeight;

	
	
	public ShipperDTO() {
		super();
	}

	public ShipperDTO(Long id, String code,
			String name, String service,
			String serviceType,
			Long organizationId, boolean dispFscForEachAWB,
			boolean dispGstForEachAWB, boolean roundUpBoxWeight) {
		super();
		this.id = id;
		this.code = code;
		this.name = name;
		this.service = service;
		this.serviceType = serviceType;
		this.organizationId = organizationId;
		this.dispFscForEachAWB = dispFscForEachAWB;
		this.dispGstForEachAWB = dispGstForEachAWB;
		this.roundUpBoxWeight = roundUpBoxWeight;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}

	public String getServiceType() {
		return serviceType;
	}

	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}

	public Long getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(Long organizationId) {
		this.organizationId = organizationId;
	}

	public boolean isDispFscForEachAWB() {
		return dispFscForEachAWB;
	}

	public void setDispFscForEachAWB(boolean dispFscForEachAWB) {
		this.dispFscForEachAWB = dispFscForEachAWB;
	}

	public boolean isDispGstForEachAWB() {
		return dispGstForEachAWB;
	}

	public void setDispGstForEachAWB(boolean dispGstForEachAWB) {
		this.dispGstForEachAWB = dispGstForEachAWB;
	}

	public boolean isRoundUpBoxWeight() {
		return roundUpBoxWeight;
	}

	public void setRoundUpBoxWeight(boolean roundUpBoxWeight) {
		this.roundUpBoxWeight = roundUpBoxWeight;
	}


}
