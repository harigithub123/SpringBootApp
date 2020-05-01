
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

import com.billing.request.ExpenseRequest;
import com.billing.response.Errors;
import com.billing.response.ExpenseResponse;
import com.billing.service.impl.ExpenseServiceImpl;
import com.billing.validator.BeanValidator;

@RestController
@RequestMapping("/expense")
@Validated
public class ExpenseController {
	
	@Autowired 
	BeanValidator validator;
	
	@Autowired
	private ExpenseServiceImpl expenseService;
	
	public ExpenseController(ExpenseServiceImpl expenseService) {
        this.expenseService = expenseService;
    }
	@PostMapping(path="/add", produces=MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasRole('ACCOUNT') or hasRole('ADMIN')")
	public ResponseEntity<Object> createExpense(@Valid @RequestBody ExpenseRequest expenseRequest,BindingResult result) {
		
		Errors errorList = validator.validate(result);
		if(!errorList.getErrorList().isEmpty()) {
			return new ResponseEntity<Object>(errorList, HttpStatus.BAD_REQUEST);
		} else {
			this.expenseService.addExpense(expenseRequest);
			return new ResponseEntity<Object>(HttpStatus.OK);
		}
	}
	
	@PutMapping(path="/update", produces=MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Object> updateExpense(@Valid @RequestBody ExpenseRequest expenseRequest,BindingResult result) {
		
		Errors errorList = validator.validate(result);
		if(!errorList.getErrorList().isEmpty()) {
			return new ResponseEntity<Object>(errorList, HttpStatus.BAD_REQUEST);
		} else {
			this.expenseService.updateExpense(expenseRequest);
			return new ResponseEntity<Object>(HttpStatus.OK);
		}
	}
	
	@DeleteMapping(path="/remove/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Object> removeExpense(@PathVariable("id") Long id) {
		this.expenseService.removeExpense(id);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
	
	@GetMapping(path="/get/{expenseId}", produces=MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasRole('ACCOUNT') or hasRole('ADMIN')")
	public ResponseEntity<Object> getExpense(@PathVariable long expenseId) {
		ExpenseResponse expense  = this.expenseService.getExpenseById(expenseId);
		return new ResponseEntity<Object>(expense, HttpStatus.OK);
	}
	
	@GetMapping(path="/get", produces=MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasRole('ACCOUNT') or hasRole('ADMIN')")
	public ResponseEntity<Object> getUsers() {
		List<ExpenseResponse> expenses  = this.expenseService.listExpenses();
		return new ResponseEntity<Object>(expenses, HttpStatus.OK);
	}
	
}

