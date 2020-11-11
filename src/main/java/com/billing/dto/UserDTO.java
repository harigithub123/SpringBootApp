package com.billing.dto;

import com.billing.model.Role;

public class UserDTO {
	
	
	private Integer userId;
	
	private Role role;
	
	private String userName;
	
	private String password;
	
	private Boolean isActiveFlag;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getIsActiveFlag() {
		return isActiveFlag;
	}

	public void setIsActiveFlag(Boolean isActiveFlag) {
		this.isActiveFlag = isActiveFlag;
	}

	@Override
	public String toString() {
		return "UserDTO [userId=" + userId + ", role=" + role + ", userName=" + userName + ", password=" + password
				+ ", isActiveFlag=" + isActiveFlag + "]";
	}
	
	

}
