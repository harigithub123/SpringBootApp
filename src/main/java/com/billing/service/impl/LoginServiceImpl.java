package com.billing.service.impl;

import java.util.Optional;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.billing.dao.LoginRepository;
import com.billing.model.Login;
import com.billing.request.LoginRequest;
import com.billing.service.LoginService;
import com.billing.service.util.Constants;
import com.billing.service.util.SMSHelper;

@Service
public class LoginServiceImpl implements LoginService {

	private LoginRepository loginRespository;
	
	public LoginServiceImpl(LoginRepository loginRespository ) {
		this.loginRespository = loginRespository;
	}

	@Override
	public void sendOTP(String mobile) {
		String otp = this.loginRespository.sendOtp(mobile);
		Login l =new Login(mobile, otp);
		this.loginRespository.save(l);
	}

	@Override
	public String validateLogin(LoginRequest request) {
		Optional<Login> l =  this.loginRespository.findByMobileNumber(request.getMobileNumber());
		Login currentLogin = l.get();
		boolean isValid=false;
		String sessionToken = null;
		if(StringUtils.isNotBlank(request.getOtp())) {
			isValid = request.getOtp().equalsIgnoreCase(currentLogin.getOtp());
			sessionToken=SMSHelper.getToken(Constants.TOKEN_LENGTH);
		} else if(StringUtils.isNotBlank(request.getSessionToken())) {
			isValid = request.getSessionToken().equalsIgnoreCase(currentLogin.getSessionToken());
			sessionToken = request.getSessionToken();
		}
		if(isValid) {
			currentLogin.setSessionToken(sessionToken);
			this.loginRespository.save(currentLogin);
			return sessionToken;
		} else {
			return null;
		}
	}


	
}
