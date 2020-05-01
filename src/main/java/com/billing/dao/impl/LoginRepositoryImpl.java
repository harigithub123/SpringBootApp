package com.billing.dao.impl;

import org.springframework.stereotype.Repository;

import com.billing.dao.LoginRepositoryCustom;
import com.billing.service.util.Constants;
import com.billing.service.util.SMSHelper;

@Repository
public class LoginRepositoryImpl implements LoginRepositoryCustom {
	
	@Override
	public String sendOtp(String mobileNumber) {
		String otp = SMSHelper.getOTP(Constants.OTP_LENGTH);
		SMSHelper sms = new SMSHelper(mobileNumber, "Your verification code is "+otp);
		sms.sendMessage();
		return otp;
	}

	
}
