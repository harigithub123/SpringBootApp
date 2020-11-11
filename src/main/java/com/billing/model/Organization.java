package com.billing.model;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.billing.service.util.SpringAttributeConverter;

import lombok.Data;

@Entity 

@Data
public class Organization {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Convert(converter = SpringAttributeConverter.class)
	@Column(unique = true)
	private String code;
	
	@Convert(converter = SpringAttributeConverter.class)
	@Column(unique = true)
	private String name;
	
	@Convert(converter = SpringAttributeConverter.class)
	private String phoneNo;
	
	@Convert(converter = SpringAttributeConverter.class)
	private String emailId;
	
	private String addressLine1;
	
	@Convert(converter = SpringAttributeConverter.class)
	private String taxNo;
	
	@Convert(converter = SpringAttributeConverter.class)
	@Column(unique = true)
	private String panNo; 
	
	@Convert(converter = SpringAttributeConverter.class)
	private String cinNo;
	
	private boolean isActive;
	
	public Organization() {
		
	}
	
	public Organization(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPanNo() {
		return panNo;
	}
	public void setPanNo(String panNo) {
		this.panNo = panNo;
	}
	public String getCinNo() {
		return cinNo;
	}
	public void setCinNo(String cinNo) {
		this.cinNo = cinNo;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getAddressLine1() {
		return addressLine1;
	}
	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}
	public String getTaxNo() {
		return taxNo;
	}
	public void setTaxNo(String taxNo) {
		this.taxNo = taxNo;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
}
