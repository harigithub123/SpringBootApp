package com.billing.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.billing.request.UserRequest;
import com.billing.response.Errors;
import com.billing.service.impl.UserServiceImpl;
import com.billing.validator.BeanValidator;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired BeanValidator validator;
	
	private UserServiceImpl userService;

	public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }
	
	@PostMapping(path="/register", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> createUser(@Valid @RequestBody UserRequest userRequest,BindingResult result) {
		
		Errors errorList = validator.validate(result);
		if(!errorList.getErrorList().isEmpty()) {
			return new ResponseEntity<Object>(errorList, HttpStatus.BAD_REQUEST);
		} else {
			this.userService.addUser(userRequest);
			return new ResponseEntity<Object>(HttpStatus.OK);
		}
	}
	
	@GetMapping(path="/get/{userId}", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> getUser(@PathVariable String userId) {
			return new ResponseEntity<Object>(HttpStatus.OK);
	}
	
	/*@GetMapping(path="/getby", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> getUsers() {
		Optional<User> users  = this.userService.getUserByPhoneNumber("1234123412");
		return new ResponseEntity<Object>(users, HttpStatus.OK);
	}*/
	
}
