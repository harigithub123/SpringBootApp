
package com.billing.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.billing.model.Customer;
import com.billing.request.CustomerRequest;
import com.billing.request.CustomerTransactionRequest;
import com.billing.response.Errors;
import com.billing.service.impl.CustomerServiceImpl;
import com.billing.validator.BeanValidator;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired BeanValidator validator;
	
	private CustomerServiceImpl customerService;

	public CustomerController(CustomerServiceImpl customerService) {
        this.customerService = customerService;
    }
	
	@PostMapping(path="/add", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> createCustomer(@Valid @RequestBody CustomerRequest customerRequest,BindingResult result) {
		
		Errors errorList = validator.validate(result);
		if(!errorList.getErrorList().isEmpty()) {
			return new ResponseEntity<Object>(errorList, HttpStatus.BAD_REQUEST);
		} else {
			this.customerService.addCustomer(customerRequest);
			return new ResponseEntity<Object>(HttpStatus.OK);
		}
	}
	
	@PutMapping(path="/update", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> updateCustomer(@Valid @RequestBody CustomerRequest customerRequest,BindingResult result) {
		
		Errors errorList = validator.validate(result);
		if(!errorList.getErrorList().isEmpty()) {
			return new ResponseEntity<Object>(errorList, HttpStatus.BAD_REQUEST);
		} else {
			this.customerService.updateCustomer(customerRequest);
			return new ResponseEntity<Object>(HttpStatus.OK);
		}
	}
	
	@DeleteMapping(path="/remove/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> removeCustomer(@PathVariable("id") Long id) {
		this.customerService.removeCustomer(id);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
	
	@GetMapping(path="/get/{customerId}", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> getCustomer(@PathVariable String customerId) {
			return new ResponseEntity<Object>(HttpStatus.OK);
	}
	
	@GetMapping(path="/get", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> getUsers() {
		List<Customer> customers  = this.customerService.listCustomers();
		return new ResponseEntity<Object>(customers, HttpStatus.OK);
	}
	
	@PostMapping(path="/transaction", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> makeCustomerTransaction(@Valid @RequestBody CustomerTransactionRequest request,BindingResult result) {
		
		Errors errorList = validator.validate(result);
		if(!errorList.getErrorList().isEmpty()) {
			return new ResponseEntity<Object>(errorList, HttpStatus.BAD_REQUEST);
		} else {
			this.customerService.makeCustomerTransaction(request);
			return new ResponseEntity<Object>(HttpStatus.OK);
		}
	}
}

