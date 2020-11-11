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

import com.billing.model.masterdata.Charge;
import com.billing.response.Errors;
import com.billing.service.ChargeService;
import com.billing.service.impl.ChargeServiceImpl;
import com.billing.validator.BeanValidator;

@RestController
@RequestMapping("/charge")
@Validated
public class ChargeController {
	
	@Autowired 
	BeanValidator validator;
	
	@Autowired
	private ChargeService chargeService;
	
	public ChargeController(ChargeServiceImpl chargeService) {
        this.chargeService = chargeService;
    }
	@PostMapping(path="/add", produces=MediaType.APPLICATION_JSON_VALUE)
	//@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Object> createCharge(@Valid @RequestBody Charge chargeRequest,BindingResult result) {
		
		Errors errorList = validator.validate(result);
		if(!errorList.getErrorList().isEmpty()) {
			return new ResponseEntity<Object>(errorList, HttpStatus.BAD_REQUEST);
		} else {                                                                   
			this.chargeService.addCharge(chargeRequest);
			return new ResponseEntity<Object>(HttpStatus.OK);
		}
	}
	
	@PutMapping(path="/update", produces=MediaType.APPLICATION_JSON_VALUE)
	//@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Object> updateCharge(@Valid @RequestBody Charge chargeRequest,BindingResult result) {
		
		Errors errorList = validator.validate(result);
		if(!errorList.getErrorList().isEmpty()) {
			return new ResponseEntity<Object>(errorList, HttpStatus.BAD_REQUEST);
		} else {
			this.chargeService.updateCharge(chargeRequest);
			return new ResponseEntity<Object>(HttpStatus.OK);
		}
	}
	
	@DeleteMapping(path="/remove/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	//@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Object> removeCharge(@PathVariable("id") Long id) {
		this.chargeService.removeCharge(id);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
	
	@GetMapping(path="/get/{chargeId}", produces=MediaType.APPLICATION_JSON_VALUE)
	//@PreAuthorize("hasRole('SALES') or hasRole('ACCOUNT') or hasRole('ADMIN')")
	public ResponseEntity<Object> getCharge(@PathVariable long chargeId) {
		Charge charge  = this.chargeService.getChargeById(chargeId);
		return new ResponseEntity<Object>(charge, HttpStatus.OK);
	}
	
	@GetMapping(path="/get", produces=MediaType.APPLICATION_JSON_VALUE)
	//@PreAuthorize("hasRole('SALES') or hasRole('ACCOUNT') or hasRole('ADMIN')")
	public ResponseEntity<Object> getCharges() {
		List<Charge> charges  = this.chargeService.listCharges();
		return new ResponseEntity<Object>(charges, HttpStatus.OK);
	}
	
}

