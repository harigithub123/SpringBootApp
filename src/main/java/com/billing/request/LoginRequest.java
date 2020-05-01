package com.billing.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LoginRequest {

	private static final long serialVersionUID = -187514924337443316L;
	
	@JsonProperty("id")
    private Long id;
	
	@JsonProperty("mobile-number")
	private String mobileNumber;
	
	@JsonProperty("otp")
	private String otp;
	
	@JsonProperty("session-token")
	private String sessionToken;
	
	@JsonProperty("password")
	private String password;
	
	@JsonProperty("user-name")
	private String userName;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getOtp() {
		return otp;
	}

	public void setOtp(String otp) {
		this.otp = otp;
	}

	public String getSessionToken() {
		return sessionToken;
	}

	public void setSessionToken(String sessionToken) {
		this.sessionToken = sessionToken;
	}
	
}
