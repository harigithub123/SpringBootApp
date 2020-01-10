package com.billing.request;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import com.billing.constants.AppConstants;
import com.billing.validator.annotation.UserType;
import com.fasterxml.jackson.annotation.JsonProperty;

public class UserRequest implements Serializable {

	private static final long serialVersionUID = -187514924337443316L;


	@JsonProperty("user-id")
	@NotNull(message="MISSING_USER_ID")
	private String userId;
	
	@JsonProperty("name")
	@NotNull(message="MISSING_NAME")
	private String name;
	
	@NotNull(message="MISSING_EMAIL_ID")
	@Pattern(regexp=AppConstants.EMAIL_REGEX, message="INVALID_EMAIL_ID")
	@JsonProperty("email-id")
	private String emailId;
	
	@Size(min=10, max=10, message="INVALID_MOBILE_NUMBER")
	@NotNull(message="MISSING_MOBILE_NUMBER")
	@JsonProperty("mobile-number")
	private String mobileNumber;
	
	@NotNull(message="MISSING_USER_TYPE")
	@UserType
	@JsonProperty("user-type")
	private String userType;
	
	@NotNull(message="MISSING_DOB")
	@DateTimeFormat(iso=DateTimeFormat.ISO.DATE)
	@JsonProperty("dob")
	private Date dob;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
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
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	
}
