package com.billing.controller;

import java.util.LinkedList;
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

import com.billing.dto.masterdata.ChargesTaxesRequest;
import com.billing.model.masterdata.ChargesTaxes;
import com.billing.response.ChargesTaxesResponse;
import com.billing.response.Errors;
import com.billing.service.ChargesTaxesService;
import com.billing.service.impl.ChargesTaxesServiceImpl;
import com.billing.validator.BeanValidator;

@RestController
@RequestMapping("/chargesTaxes")
@Validated
public class ChargesTaxesController {
	
	@Autowired 
	BeanValidator validator;
	
	@Autowired
	private ChargesTaxesService chargesTaxesService;
	
	public ChargesTaxesController(ChargesTaxesServiceImpl chargesTaxesService) {
        this.chargesTaxesService = chargesTaxesService;
    }
	@PostMapping(path="/add", produces=MediaType.APPLICATION_JSON_VALUE)
	//@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Object> createChargesTaxes(@Valid @RequestBody ChargesTaxesRequest chargesTaxesRequest,BindingResult result) {
		
		Errors errorList = validator.validate(result);
		if(!errorList.getErrorList().isEmpty()) {
			return new ResponseEntity<Object>(errorList, HttpStatus.BAD_REQUEST);
		} else {                                                                   
			this.chargesTaxesService.addChargesTaxes(chargesTaxesRequest);
			return new ResponseEntity<Object>(HttpStatus.OK);
		}
	}
	
	@PutMapping(path="/update", produces=MediaType.APPLICATION_JSON_VALUE)
	//@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Object> updateChargesTaxes(@Valid @RequestBody ChargesTaxesRequest chargesTaxesRequest,BindingResult result) {
		
		Errors errorList = validator.validate(result);
		if(!errorList.getErrorList().isEmpty()) {
			return new ResponseEntity<Object>(errorList, HttpStatus.BAD_REQUEST);
		} else {
			this.chargesTaxesService.updateChargesTaxes(chargesTaxesRequest);
			return new ResponseEntity<Object>(HttpStatus.OK);
		}
	}
	
	@DeleteMapping(path="/remove/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	//@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Object> removeChargesTaxes(@PathVariable("id") Long id) {
		this.chargesTaxesService.removeChargesTaxes(id);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
	
	@GetMapping(path="/get/{chargesTaxesId}", produces=MediaType.APPLICATION_JSON_VALUE)
	//@PreAuthorize("hasRole('SALES') or hasRole('ACCOUNT') or hasRole('ADMIN')")
	public ResponseEntity<Object> getChargesTaxes(@PathVariable long chargesTaxesId) {
		ChargesTaxesResponse chargesTaxes  = getChargesTaxesResponse(this.chargesTaxesService.getChargesTaxesById(chargesTaxesId));
		return new ResponseEntity<Object>(chargesTaxes, HttpStatus.OK);
	}
	
	@GetMapping(path="/get", produces=MediaType.APPLICATION_JSON_VALUE)
	//@PreAuthorize("hasRole('SALES') or hasRole('ACCOUNT') or hasRole('ADMIN')")
	public ResponseEntity<Object> getChargesTaxess() {
		List<ChargesTaxesResponse> chargesTaxess  = getChargesTaxesResponse(this.chargesTaxesService.listChargesTaxess());
		return new ResponseEntity<Object>(chargesTaxess, HttpStatus.OK);
	}
	
	private List<ChargesTaxesResponse> getChargesTaxesResponse(List<ChargesTaxes> listChargesTaxess) {
		List<ChargesTaxesResponse> chargesTaxess = new LinkedList<ChargesTaxesResponse>();
		for(ChargesTaxes chargesTaxes : listChargesTaxess) {
			chargesTaxess.add(getChargesTaxesResponse(chargesTaxes));
		}
		return chargesTaxess;
	}
	
	private ChargesTaxesResponse getChargesTaxesResponse(ChargesTaxes chargesTaxes) {
		return new ChargesTaxesResponse(chargesTaxes.getId(), chargesTaxes.getTax(), 
					chargesTaxes.getShipper().getId(), chargesTaxes.getCharge().getId());
	}
	
}

