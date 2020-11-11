package com.billing.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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

import com.billing.dto.shipper.ShipperDTO;
import com.billing.response.Errors;
import com.billing.service.ShipperService;
import com.billing.service.impl.ShipperServiceImpl;
import com.billing.validator.BeanValidator;

@RestController
@RequestMapping("/shipper")
@Validated
public class ShipperController {
	
	@Autowired 
	BeanValidator validator;
	
	@Autowired
	private ShipperService shipperService;
	
	public ShipperController(ShipperServiceImpl shipperService) {
        this.shipperService = shipperService;
    }
	@PostMapping(path="/add", produces=MediaType.APPLICATION_JSON_VALUE)
	//@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Object> createShipper(@Valid @RequestBody ShipperDTO shipperRequest,BindingResult result) {
		
		Errors errorList = validator.validate(result);
		if(!errorList.getErrorList().isEmpty()) {
			return new ResponseEntity<Object>(errorList, HttpStatus.BAD_REQUEST);
		} else {                                                                   
			ShipperDTO shipper = this.shipperService.addShipper(shipperRequest);
			return new ResponseEntity<Object>(shipper, HttpStatus.OK);
		}
	}
	
	@PutMapping(path="/update", produces=MediaType.APPLICATION_JSON_VALUE)
	//@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Object> updateShipper(@Valid @RequestBody ShipperDTO shipperRequest,BindingResult result) {
		
		Errors errorList = validator.validate(result);
		if(!errorList.getErrorList().isEmpty()) {
			return new ResponseEntity<Object>(errorList, HttpStatus.BAD_REQUEST);
		} else {
			ShipperDTO shipper = this.shipperService.updateShipper(shipperRequest);
			return new ResponseEntity<Object>(shipper, HttpStatus.OK);
		}
	}
	
	@DeleteMapping(path="/remove/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	//@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Object> removeShipper(@PathVariable("id") Long id) {
		this.shipperService.removeShipper(id);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
	
	@GetMapping(path="/get/{shipperId}", produces=MediaType.APPLICATION_JSON_VALUE)
	//@PreAuthorize("hasRole('SALES') or hasRole('ACCOUNT') or hasRole('ADMIN')")
	public ResponseEntity<Object> getShipper(@PathVariable long shipperId) {
		ShipperDTO shipper  = this.shipperService.getShipperById(shipperId);
		return new ResponseEntity<Object>(shipper, HttpStatus.OK);
	}
	
	@GetMapping(path="/get", produces=MediaType.APPLICATION_JSON_VALUE)
	//@PreAuthorize("hasRole('SALES') or hasRole('ACCOUNT') or hasRole('ADMIN')")
	public ResponseEntity<Object> getShippers() {
		List<ShipperDTO> shippers  = this.shipperService.listShippers();
		return new ResponseEntity<Object>(shippers, HttpStatus.OK);
	}
	
}

