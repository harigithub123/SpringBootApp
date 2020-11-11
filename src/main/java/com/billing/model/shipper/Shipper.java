package com.billing.model.shipper;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.billing.model.Organization;
import com.billing.service.util.SpringAttributeConverter;

import lombok.Data;

@Entity 

@Data
public class Shipper {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Convert(converter = SpringAttributeConverter.class)
	@Column(unique = true)
	private String code;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
	@JoinColumn(name="organization_id")
	private Organization organization;
	
	@Convert(converter = SpringAttributeConverter.class)
	private String name;
	
	private boolean dispFscForEachAWB;
	private boolean dispGstForEachAWB;
	private boolean roundUpBoxWeight;
	private String service;
	private String serviceType;
	
	public Shipper() {
		
	}
	
	public Shipper(Long id) {
		this.id = id;
	}
	public String getServiceType() {
		return serviceType;
	}
	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}
	public String getService() {
		return service;
	}
	public void setService(String service) {
		this.service = service;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String shipperCode) {
		this.code = shipperCode;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Organization getOrganization() {
		return organization;
	}
	public void setOrganization(Organization organization) {
		this.organization = organization;
	}
	public String getName() {
		return name;
	}
	public void setName(String shipperName) {
		this.name = shipperName;
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
