package com.billing.security;

import java.util.Set;

import com.billing.dto.UserRoleAuthorityDTO;


public class Token {
	
	private Integer id;
	private Integer userId;
	private String username;
	private Integer roleId;
	private String role;
	private boolean isAccountExpired;
	private boolean accountLocked;
	private boolean credentialsExpired;
	private boolean accountDisabled;
	private Integer userRoleAuthorityId;
	private Set<UserRoleAuthorityDTO> authorities;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public boolean isAccountExpired() {
		return isAccountExpired;
	}
	public void setAccountExpired(boolean isAccountExpired) {
		this.isAccountExpired = isAccountExpired;
	}
	public boolean isAccountLocked() {
		return accountLocked;
	}
	public void setAccountLocked(boolean accountLocked) {
		this.accountLocked = accountLocked;
	}
	public boolean isCredentialsExpired() {
		return credentialsExpired;
	}
	public void setCredentialsExpired(boolean credentialsExpired) {
		this.credentialsExpired = credentialsExpired;
	}
	public boolean isAccountDisabled() {
		return accountDisabled;
	}
	public void setAccountDisabled(boolean accountDisabled) {
		this.accountDisabled = accountDisabled;
	}
	public Integer getUserRoleAuthorityId() {
		return userRoleAuthorityId;
	}
	public void setUserRoleAuthorityId(Integer userRoleAuthorityId) {
		this.userRoleAuthorityId = userRoleAuthorityId;
	}
	public Set<UserRoleAuthorityDTO> getAuthorities() {
		return authorities;
	}
	public void setAuthorities(Set<UserRoleAuthorityDTO> authorities) {
		this.authorities = authorities;
	}
	

}
