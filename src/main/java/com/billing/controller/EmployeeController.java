
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

import com.billing.model.Employee;
import com.billing.request.EmployeeRequest;
import com.billing.request.EmployeeTransactionRequest;
import com.billing.response.EmployeeTransactionResponse;
import com.billing.response.Errors;
import com.billing.service.EmployeeService;
import com.billing.service.EmployeeTransactionService;
import com.billing.service.impl.EmployeeServiceImpl;
import com.billing.service.impl.EmployeeTransactionServiceImpl;
import com.billing.validator.BeanValidator;

@RestController
@RequestMapping("/employee")
@Validated
public class EmployeeController {
	
	@Autowired 
	BeanValidator validator;
	
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private EmployeeTransactionService transactionService;
	
	public EmployeeController(EmployeeServiceImpl employeeService, EmployeeTransactionServiceImpl transactionService) {
        this.employeeService = employeeService;
        this.transactionService = transactionService;
    }
	@PostMapping(path="/add", produces=MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Object> createEmployee(@Valid @RequestBody EmployeeRequest employeeRequest,BindingResult result) {
		
		Errors errorList = validator.validate(result);
		if(!errorList.getErrorList().isEmpty()) {
			return new ResponseEntity<Object>(errorList, HttpStatus.BAD_REQUEST);
		} else {
			this.employeeService.addEmployee(employeeRequest);
			return new ResponseEntity<Object>(HttpStatus.OK);
		}
	}
	
	@PutMapping(path="/update", produces=MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Object> updateEmployee(@Valid @RequestBody EmployeeRequest employeeRequest,BindingResult result) {
		
		Errors errorList = validator.validate(result);
		if(!errorList.getErrorList().isEmpty()) {
			return new ResponseEntity<Object>(errorList, HttpStatus.BAD_REQUEST);
		} else {
			this.employeeService.updateEmployee(employeeRequest);
			return new ResponseEntity<Object>(HttpStatus.OK);
		}
	}
	
	@DeleteMapping(path="/remove/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Object> removeEmployee(@PathVariable("id") Long id) {
		this.employeeService.removeEmployee(id);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
	
	@GetMapping(path="/get/{employeeId}", produces=MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasRole('SALES') or hasRole('ACCOUNT') or hasRole('ADMIN')")
	public ResponseEntity<Object> getEmployee(@PathVariable long employeeId) {
		Employee employee  = this.employeeService.getEmployeeById(employeeId);
		return new ResponseEntity<Object>(employee, HttpStatus.OK);
	}
	
	@GetMapping(path="/get", produces=MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasRole('SALES') or hasRole('ACCOUNT') or hasRole('ADMIN')")
	public ResponseEntity<Object> getUsers() {
		List<Employee> employees  = this.employeeService.listEmployees();
		return new ResponseEntity<Object>(employees, HttpStatus.OK);
	}
	
	@PostMapping(path="/transaction/add", produces=MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasRole('ACCOUNT') or hasRole('ADMIN')")
	public ResponseEntity<Object> createEmployeeTransaction(@Valid @RequestBody EmployeeTransactionRequest employeeTransactionRequest,BindingResult result) {
		
		Errors errorList = validator.validate(result);
		if(!errorList.getErrorList().isEmpty()) {
			return new ResponseEntity<Object>(errorList, HttpStatus.BAD_REQUEST);
		} else {
			this.transactionService.addEmployeeTransaction(employeeTransactionRequest);
			return new ResponseEntity<Object>(HttpStatus.OK);
		}
	}
	
	@PutMapping(path="/transaction/update", produces=MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Object> updateEmployeeTransaction(@Valid @RequestBody EmployeeTransactionRequest employeeTransactionRequest,BindingResult result) {
		
		Errors errorList = validator.validate(result);
		if(!errorList.getErrorList().isEmpty()) {
			return new ResponseEntity<Object>(errorList, HttpStatus.BAD_REQUEST);
		} else {
			this.transactionService.updateEmployeeTransaction(employeeTransactionRequest);
			return new ResponseEntity<Object>(HttpStatus.OK);
		}
	}
	
	@DeleteMapping(path="/transaction/remove/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Object> removeEmployeeTransaction(@PathVariable("id") Long id) {
		this.transactionService.removeEmployeeTransaction(id);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
	
	@GetMapping(path="/transaction/get/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasRole('SALES') or hasRole('ACCOUNT') or hasRole('ADMIN')")
	public ResponseEntity<Object> getTransactionById(@PathVariable Long id) {
		EmployeeTransactionResponse employeeTransaction  = this.transactionService.getEmployeeTransactionById(id);
		return new ResponseEntity<Object>(employeeTransaction, HttpStatus.OK);
	}
	
	@GetMapping(path="/transaction/get", produces=MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasRole('SALES') or hasRole('ACCOUNT') or hasRole('ADMIN')")
	public ResponseEntity<Object> getTransactions() {
		List<EmployeeTransactionResponse> employeeTransactions  = this.transactionService.listEmployeeTransactions();
		return new ResponseEntity<Object>(employeeTransactions, HttpStatus.OK);
	}
	
}

