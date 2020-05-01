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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.billing.request.BillRequest;
import com.billing.request.TallyRequest;
import com.billing.response.BillResponse;
import com.billing.response.Errors;
import com.billing.response.TallyReport;
import com.billing.service.impl.OrderInfoServiceImpl;
import com.billing.validator.BeanValidator;

@RestController
@RequestMapping("/bill")
@Validated
public class BillingController {
	
	@Autowired 
	BeanValidator validator;
	
	@Autowired
	private OrderInfoServiceImpl orderServiceImpl;
	
	public BillingController(OrderInfoServiceImpl orderServiceImpl) {
        this.orderServiceImpl = orderServiceImpl;
    }
	
	@PostMapping(path="/generate", produces=MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasRole('SALES') or hasRole('ACCOUNT') or hasRole('ADMIN')")
	public ResponseEntity<Object> generateBill(@Valid @RequestBody BillRequest billRequest,BindingResult result) {
		
		Errors errorList = validator.validate(result);
		if(!errorList.getErrorList().isEmpty()) {
			return new ResponseEntity<Object>(errorList, HttpStatus.BAD_REQUEST);
		} else {
			BillResponse bill = this.orderServiceImpl.generateBill(billRequest);
			return new ResponseEntity<Object>(bill, HttpStatus.OK);
		}
	}
	
	@PostMapping(path="/pay", produces=MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasRole('SALES') or hasRole('ACCOUNT') or hasRole('ADMIN')")
	public ResponseEntity<Object> payBill(@Valid @RequestBody BillRequest billRequest,BindingResult result) {
		
		Errors errorList = validator.validate(result);
		if(!errorList.getErrorList().isEmpty()) {
			return new ResponseEntity<Object>(errorList, HttpStatus.BAD_REQUEST);
		} else {
			BillResponse bill = this.orderServiceImpl.generateBill(billRequest);
			return new ResponseEntity<Object>(bill, HttpStatus.OK);
		}
	}
	
	@PostMapping(path="/lastdate", produces=MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasRole('SALES') or hasRole('ACCOUNT') or hasRole('ADMIN')")
	public ResponseEntity<Object> getLastDate(@Valid @RequestBody BillRequest billRequest,BindingResult result) {
		
		Errors errorList = validator.validate(result);
		if(!errorList.getErrorList().isEmpty()) {
			return new ResponseEntity<Object>(errorList, HttpStatus.BAD_REQUEST);
		} else {
			BillResponse bill = this.orderServiceImpl.getLastBillEndDate(billRequest);
			return new ResponseEntity<Object>(bill, HttpStatus.OK);
		}
	}
	
	@PostMapping(path="/tally/report", produces=MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasRole('SALES') or hasRole('ACCOUNT') or hasRole('ADMIN')")
	public ResponseEntity<Object> getTallyReport(@Valid @RequestBody TallyRequest billRequest,BindingResult result) {
		Errors errorList = validator.validate(result);
		if(!errorList.getErrorList().isEmpty()) {
			return new ResponseEntity<Object>(errorList, HttpStatus.BAD_REQUEST);
		} else {
			List<TallyReport> report = this.orderServiceImpl.getTallyReport(billRequest);
			return new ResponseEntity<Object>(report, HttpStatus.OK);
		}
	}
	
}

