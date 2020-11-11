package com.billing.dto;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.billing.constants.AppConstants;

public class CustomerRequest  implements Serializable {

	private static final long serialVersionUID = -187514924337443316L;
	
	//@JsonProperty("id")
	private Long id;
	
	//@NotNull(message="MISSING_NAME")
	//@JsonProperty("name")
	private String name;
	
	//@NotNull(message="MISSING_EMAIL_ID")
	@Pattern(regexp=AppConstants.EMAIL_REGEX, message="INVALID_EMAIL_ID")
	//@JsonProperty("email_id")
	private String emailId;
	
	@Size(min=10, max=10, message="INVALID_MOBILE_NUMBER")
	@NotNull(message="MISSING_MOBILE_NUMBER")
	//@JsonProperty("mobile_number")
	private String mobileNumber;
	
	@NotNull(message="MISSING_ADDRESS")
	//@JsonProperty("contact_person")
	private String address;
	
	//@JsonProperty("need_to_send_sms")
	private boolean needToSendSms;

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

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public boolean isNeedToSendSms() {
		return needToSendSms;
	}

	public void setNeedToSendSms(boolean needToSendSms) {
		this.needToSendSms = needToSendSms;
	}

}
