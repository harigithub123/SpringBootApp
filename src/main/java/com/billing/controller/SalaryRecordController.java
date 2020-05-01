package com.billing.controller;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.billing.request.SalaryRecordRequest;
import com.billing.response.Errors;
import com.billing.response.SalaryRecordResponse;
import com.billing.service.impl.SalaryRecordServiceImpl;
import com.billing.validator.BeanValidator;

@RestController
@RequestMapping("/employee/salaries")
public class SalaryRecordController {
	
	@Autowired BeanValidator validator;
	
	private SalaryRecordServiceImpl salaryRecordService;

	public SalaryRecordController(SalaryRecordServiceImpl salaryRecordService) {
        this.salaryRecordService = salaryRecordService;
    }
	
	@PostMapping(path="/add", produces=MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Object> createSalaryRecord(@Valid @RequestBody SalaryRecordRequest salaryRecordRequest,BindingResult result) {
		
		Errors errorList = validator.validate(result);
		if(!errorList.getErrorList().isEmpty()) {
			return new ResponseEntity<Object>(errorList, HttpStatus.BAD_REQUEST);
		} else {
			this.salaryRecordService.addSalaryRecord(salaryRecordRequest);
			return new ResponseEntity<Object>(HttpStatus.OK);
		}
	}
	
	@PutMapping(path="/update", produces=MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Object> updateSalaryRecord(@Valid @RequestBody SalaryRecordRequest salaryRecordRequest,BindingResult result) {
		
		Errors errorList = validator.validate(result);
		if(!errorList.getErrorList().isEmpty()) {
			return new ResponseEntity<Object>(errorList, HttpStatus.BAD_REQUEST);
		} else {
			this.salaryRecordService.updateSalaryRecord(salaryRecordRequest);
			return new ResponseEntity<Object>(HttpStatus.OK);
		}
	}
	
	@DeleteMapping(path="/remove/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Object> removeSalaryRecord(@PathVariable("id") Long id) {
		this.salaryRecordService.removeSalaryRecord(id);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
	
	@GetMapping(path="/get/{salaryRecordId}", produces=MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasRole('ACCOUNT') or hasRole('ADMIN')")
	public ResponseEntity<Object> getSalaryRecord(@PathVariable("salaryRecordId") String salaryRecordId) {
			return new ResponseEntity<Object>(HttpStatus.OK);
	}
	
	@GetMapping(path="/get", produces=MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasRole('ACCOUNT') or hasRole('ADMIN')")
	public ResponseEntity<Object> getUsers() {
		List<SalaryRecordResponse> salaryRecords  = this.salaryRecordService.listSalaryRecords();
		return new ResponseEntity<Object>(salaryRecords, HttpStatus.OK);
	}
}