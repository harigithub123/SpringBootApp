package com.billing.request;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.billing.constants.AppConstants;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CustomerRequest  implements Serializable {

	private static final long serialVersionUID = -187514924337443316L;
	
	@JsonProperty("id")
	private Long id;
	
	@JsonProperty("office-no")
	@NotNull(message="MISSING_OFFICE_NO")
	private String officeNo;
	
	@NotNull(message="MISSING_OFFICE_NAME")
	@JsonProperty("office-name")
	private String officeName;
	
	@NotNull(message="MISSING_EMAIL_ID")
	@Pattern(regexp=AppConstants.EMAIL_REGEX, message="INVALID_EMAIL_ID")
	@JsonProperty("email-id")
	private String emailId;
	
	@Size(min=10, max=10, message="INVALID_MOBILE_NUMBER")
	@NotNull(message="MISSING_MOBILE_NUMBER")
	@JsonProperty("mobile-number")
	private String mobileNumber;
	
	@NotNull(message="MISSING_CONTACT_PERSON")
	@JsonProperty("contact-person")
	private String contactPersion;
	
	@JsonProperty("need-to-send-sms")
	private boolean needToSendSms;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOfficeNo() {
		return officeNo;
	}

	public void setOfficeNo(String officeNo) {
		this.officeNo = officeNo;
	}

	public String getOfficeName() {
		return officeName;
	}

	public void setOfficeName(String officeName) {
		this.officeName = officeName;
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

	public String getContactPersion() {
		return contactPersion;
	}

	public void setContactPersion(String contactPersion) {
		this.contactPersion = contactPersion;
	}

	public boolean isNeedToSendSms() {
		return needToSendSms;
	}

	public void setNeedToSendSms(boolean needToSendSms) {
		this.needToSendSms = needToSendSms;
	}
}
