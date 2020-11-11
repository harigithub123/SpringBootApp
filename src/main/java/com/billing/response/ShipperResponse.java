package com.billing.response;

import java.io.Serializable;

public class ShipperResponse  implements Serializable {

	private static final long serialVersionUID = -187514924337443316L;
	
	//@JsonProperty("id")
	private Long id;
	
	private String code;
	
	private String name;
	
	private String service;

	private String serviceType;
	
	private Long organizationId;
	
	private boolean dispFscForEachAWB;
	
	private boolean dispGstForEachAWB;
	
	private boolean roundUpBoxWeight;

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
