package com.billing.validator.annotation.impl;

import java.util.HashSet;
import java.util.Set;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.util.StringUtils;

import com.billing.constants.AppConstants;
import com.billing.validator.annotation.UserType;

public class UserTypeValidator implements ConstraintValidator<UserType, String> {

	public static final Set<String> userTypeSet = new HashSet<String>();

	static {
		userTypeSet.add(AppConstants.USER_TYPE_SALES);
		userTypeSet.add(AppConstants.USER_TYPE_ADMIN);
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if (StringUtils.isEmpty(value)) {
			return true;
		}
		return userTypeSet.contains(value.toLowerCase());
	}

}
