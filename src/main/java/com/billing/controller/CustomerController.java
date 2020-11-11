
package com.billing.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.billing.dto.CustomerRequest;
import com.billing.dto.CustomerTransactionRequest;
import com.billing.model.Customer;
import com.billing.response.CustomerTransactionResponse;
import com.billing.response.Errors;
import com.billing.service.CustomerService;
import com.billing.service.CustomerTransactionService;
import com.billing.service.impl.CustomerServiceImpl;
import com.billing.service.impl.CustomerTransactionServiceImpl;
import com.billing.validator.BeanValidator;

@RestController
@RequestMapping("/customer")
@Validated
public class CustomerController {
	
	@Autowired 
	BeanValidator validator;
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private CustomerTransactionService customerTransactionService;
	
	public CustomerController(CustomerServiceImpl customerService, CustomerTransactionServiceImpl customerTSImpl) {
        this.customerService = customerService;
        this.customerTransactionService = customerTSImpl;
    }
	@PostMapping(path="/add", produces=MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasRole('ADMIN')")
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
	@PreAuthorize("hasRole('ADMIN')")
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
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Object> removeCustomer(@PathVariable("id") Long id) {
		this.customerService.removeCustomer(id);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
	
	@GetMapping(path="/get/{customerId}", produces=MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasRole('SALES') or hasRole('ACCOUNT') or hasRole('ADMIN')")
	public ResponseEntity<Object> getCustomer(@PathVariable long customerId) {
		Customer customer  = this.customerService.getCustomerById(customerId);
		return new ResponseEntity<Object>(customer, HttpStatus.OK);
	}
	
	@GetMapping(path="/get", produces=MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasRole('SALES') or hasRole('ACCOUNT') or hasRole('ADMIN')")
	public ResponseEntity<Object> getUsers() {
		List<Customer> customers  = this.customerService.listCustomers();
		return new ResponseEntity<Object>(customers, HttpStatus.OK);
	}
	
	@GetMapping(path="/get/invoices/{customerId}", produces=MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasRole('SALES') or hasRole('ACCOUNT') or hasRole('ADMIN')")
	public ResponseEntity<Object> getInvoices() {
		List<Customer> customers  = this.customerService.listCustomers();
		return new ResponseEntity<Object>(customers, HttpStatus.OK);
	}
	
	@PostMapping(path="/transaction/add", produces=MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasRole('SALES') or hasRole('ACCOUNT') or hasRole('ADMIN')")
	public ResponseEntity<Object> makeCustomerTransation(@Valid @RequestBody CustomerTransactionRequest customerRequest,BindingResult result) {
		
		Errors errorList = validator.validate(result);
		if(!errorList.getErrorList().isEmpty()) {
			return new ResponseEntity<Object>(errorList, HttpStatus.BAD_REQUEST);
		} else {
			this.customerTransactionService.addCustomerTransaction(customerRequest);
			return new ResponseEntity<Object>(HttpStatus.OK);
		}
	}
	
	@PutMapping(path="/transaction/update", produces=MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Object> updateCustomerTransaction(@Valid @RequestBody CustomerTransactionRequest customerRequest,BindingResult result) {
		
		Errors errorList = validator.validate(result);
		if(!errorList.getErrorList().isEmpty()) {
			return new ResponseEntity<Object>(errorList, HttpStatus.BAD_REQUEST);
		} else {
			this.customerTransactionService.updateCustomerTransaction(customerRequest);
			return new ResponseEntity<Object>(HttpStatus.OK);
		}
	}
	
	@DeleteMapping(path="/transaction/remove/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Object> removeCustomerTransaction(@PathVariable("id") Long id) {
		this.customerTransactionService.removeCustomerTransaction(id);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
	
	@GetMapping(path="/transaction/get/{customerId}", produces=MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasRole('SALES') or hasRole('ACCOUNT') or hasRole('ADMIN')")
	public ResponseEntity<Object> getCustomerTransactions(@PathVariable long customerId) {
		CustomerTransactionResponse customer  = this.customerTransactionService.getCustomerTransactionById(customerId);
		return new ResponseEntity<Object>(customer, HttpStatus.OK);
	}
	
}

