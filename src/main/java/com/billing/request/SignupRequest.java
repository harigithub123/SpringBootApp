package com.billing.request;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SignupRequest {
	//@JsonProperty("password")
	private String password;
	
	//@JsonProperty("user-name")
	private String userName;
	
	//@JsonProperty("email-id")
	private String emailId;
	
	//@JsonProperty("roles")
	private Set<String> roles;

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

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public Set<String> getRoles() {
		return roles;
	}

	public void setRoles(Set<String> roles) {
		this.roles = roles;
	}
	
}
