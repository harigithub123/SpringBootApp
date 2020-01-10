package com.billing.validator;

import org.springframework.validation.BindingResult;

import com.billing.response.Errors;

public interface BeanValidator {
	
	public Errors validate(BindingResult bindingResult);

}
