
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

import com.billing.request.OrderInfoRequest;
import com.billing.response.Errors;
import com.billing.response.OrderInfoResponse;
import com.billing.service.impl.OrderInfoServiceImpl;
import com.billing.validator.BeanValidator;

@RestController
@RequestMapping("/order")
public class OrderInfoController {
	
	@Autowired 
	BeanValidator validator;
	
	@Autowired
	private OrderInfoServiceImpl orderService;
	
	@PostMapping(path="/add", produces=MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasRole('SALES') or hasRole('ACCOUNT') or hasRole('ADMIN')")
	public ResponseEntity<Object> createOrder(@Valid @RequestBody OrderInfoRequest orderRequest,BindingResult result) {
		
		Errors errorList = validator.validate(result);
		if(!errorList.getErrorList().isEmpty()) {
			return new ResponseEntity<Object>(errorList, HttpStatus.BAD_REQUEST);
		} else {
			this.orderService.addOrder(orderRequest);
			return new ResponseEntity<Object>(HttpStatus.OK);
		}
	}
	
	@PutMapping(path="/update", produces=MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasRole('SALES') or hasRole('ACCOUNT') or hasRole('ADMIN')")
	public ResponseEntity<Object> updateOrder(@Valid @RequestBody OrderInfoRequest orderRequest,BindingResult result) {
		
		Errors errorList = validator.validate(result);
		if(!errorList.getErrorList().isEmpty()) {
			return new ResponseEntity<Object>(errorList, HttpStatus.BAD_REQUEST);
		} else {
			this.orderService.updateOrder(orderRequest);
			return new ResponseEntity<Object>(HttpStatus.OK);
		}
	}
	
	@DeleteMapping(path="/remove/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasRole('SALES') or hasRole('ACCOUNT') or hasRole('ADMIN')")
	public ResponseEntity<Object> removeOrder(@PathVariable("id") Long id) {
		this.orderService.removeOrder(id);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
	
	@GetMapping(path="/get/{orderId}", produces=MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasRole('SALES') or hasRole('ACCOUNT') or hasRole('ADMIN')")
	public ResponseEntity<Object> getOrder(@PathVariable Long orderId) {
		OrderInfoResponse order  = this.orderService.getOrderById(orderId);
		if(order != null) {
			return new ResponseEntity<Object>(order, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}
	
	@GetMapping(path="/get", produces=MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasRole('SALES') or hasRole('ACCOUNT') or hasRole('ADMIN')")
	public ResponseEntity<Object> getUsers() {
		List<OrderInfoResponse> orders  = this.orderService.listOrders();
		return new ResponseEntity<Object>(orders, HttpStatus.OK);
	}
	
}

