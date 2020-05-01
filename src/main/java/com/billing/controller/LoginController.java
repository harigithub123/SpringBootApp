
package com.billing.controller;

import javax.validation.Valid;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.billing.request.LoginRequest;
import com.billing.response.Errors;
import com.billing.response.LoginResponse;
import com.billing.service.impl.LoginServiceImpl;
import com.billing.validator.BeanValidator;

@RestController
@RequestMapping("/login")
public class LoginController {
	
	@Autowired 
	BeanValidator validator;
	
	@Autowired
	private LoginServiceImpl customerService;
	
	@PostMapping(path="/sendotp", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> sendOTP(@Valid @RequestBody LoginRequest request, BindingResult result) {
		
		Errors errorList = validator.validate(result);
		if(!errorList.getErrorList().isEmpty()) {
			return new ResponseEntity<Object>(errorList, HttpStatus.BAD_REQUEST);
		} else {
			this.customerService.sendOTP(request.getMobileNumber());
			return new ResponseEntity<Object>(HttpStatus.OK);
		}
	}
	
	private LoginResponse getLoginResponse(String sessionToken) {
		LoginResponse res = new LoginResponse();
		res.setSessionToken(sessionToken);
		return res;
	}

	@PutMapping(path="/validate", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> validateOTP(@Valid @RequestBody LoginRequest loginRequest,BindingResult result) {
		
		Errors errorList = validator.validate(result);
		if(!errorList.getErrorList().isEmpty()) {
			return new ResponseEntity<Object>(errorList, HttpStatus.BAD_REQUEST);
		} else {
			String sessionToken = this.customerService.validateLogin(loginRequest);
			if(StringUtils.isNotBlank(sessionToken)) {
				LoginResponse response = getLoginResponse(sessionToken);
				return new ResponseEntity<Object>(response, HttpStatus.OK);
			} else {
				return new ResponseEntity<Object>(HttpStatus.UNAUTHORIZED);
			}
		}
	}
	
}

