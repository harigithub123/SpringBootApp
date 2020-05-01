package com.billing.response;

import org.springframework.validation.DefaultBindingErrorProcessor;


public class ErrorProcessor extends DefaultBindingErrorProcessor {
	
	@Override
	protected Object[] getArgumentsForBindError(String objectName, String field) {
		
		if(objectName.equals("UserRequest") && field.equals("first-day-of-job")) {
			System.out.println("Hello");
		}
		
		return super.getArgumentsForBindError(objectName, field);
	}

}
