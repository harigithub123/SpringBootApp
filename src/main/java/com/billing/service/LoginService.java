package com.billing.service;

import org.springframework.stereotype.Service;

import com.billing.dto.LoginRequest;

@Service
public interface LoginService {

	public void sendOTP(String mobile);
	public String validateLogin(LoginRequest login);
}
