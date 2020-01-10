package com.billing.validator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import com.billing.constants.ErrorCode;
import com.billing.response.Error;
import com.billing.response.Errors;

@Component
public class BeanValidatorImpl implements BeanValidator{

	@Override
	public Errors validate(BindingResult bindingResult) {
		List<Error> errorList = new ArrayList<Error>();
		Errors erros = new Errors();
		erros.setErrorList(errorList);
		
		if(bindingResult.hasErrors()) {
			List<ObjectError> allErrors = bindingResult.getAllErrors();
			for(ObjectError objError: allErrors) {
				String code = objError.getDefaultMessage();
				ErrorCode errorCode = ErrorCode.valueOf(code);
				Error error = new Error(errorCode.getCode(),errorCode.getMessage());
				errorList.add(error);
			}
			
		}
		
		return erros;
	}
	
}
