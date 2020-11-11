package com.billing.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity 

@Data
public class Customer {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Column(unique = true)
	private String address;
	
	@Column(unique = true)
	private String name;
	
	@Column(unique = true)
	private String mobileNumber;
	
	@Column(unique = true)
	private String emailId;
	
	private boolean needToSendSms;
	
	
	public Customer() {
	}
	
	public Customer(Long customerId) {
		this.id = customerId;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public boolean isNeedToSendSms() {
		return needToSendSms;
	}

	public void setNeedToSendSms(boolean needToSendSms) {
		this.needToSendSms = needToSendSms;
	}
	
}
