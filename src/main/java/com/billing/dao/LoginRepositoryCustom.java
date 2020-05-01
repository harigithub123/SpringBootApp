
package com.billing.dao;

import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepositoryCustom {
	public String sendOtp(String mobileNumber);
	
}

