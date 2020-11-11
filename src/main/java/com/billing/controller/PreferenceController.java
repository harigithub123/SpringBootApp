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

import com.billing.dto.masterdata.PreferenceDTO;
import com.billing.model.masterdata.PreferenceId;
import com.billing.response.Errors;
import com.billing.service.PreferenceService;
import com.billing.service.impl.PreferenceServiceImpl;
import com.billing.validator.BeanValidator;

@RestController
@RequestMapping("/preference")
@Validated
public class PreferenceController {
	
	@Autowired 
	BeanValidator validator;
	
	@Autowired
	private PreferenceService preferenceService;
	
	public PreferenceController(PreferenceServiceImpl preferenceService) {
        this.preferenceService = preferenceService;
    }
	@PostMapping(path="/add", produces=MediaType.APPLICATION_JSON_VALUE)
	//@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Object> createPreference(@Valid @RequestBody PreferenceDTO preferenceRequest,BindingResult result) {
		
		Errors errorList = validator.validate(result);
		if(!errorList.getErrorList().isEmpty()) {
			return new ResponseEntity<Object>(errorList, HttpStatus.BAD_REQUEST);
		} else {                                                                   
			PreferenceDTO prefDTO = this.preferenceService.addPreference(preferenceRequest);
			return new ResponseEntity<Object>(prefDTO, HttpStatus.OK);
		}
	}
	
	@PutMapping(path="/update", produces=MediaType.APPLICATION_JSON_VALUE)
	//@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Object> updatePreference(@Valid @RequestBody PreferenceDTO preferenceRequest,BindingResult result) {
		
		Errors errorList = validator.validate(result);
		if(!errorList.getErrorList().isEmpty()) {
			return new ResponseEntity<Object>(errorList, HttpStatus.BAD_REQUEST);
		} else {
			PreferenceDTO prefDTO = this.preferenceService.updatePreference(preferenceRequest);
			return new ResponseEntity<Object>(prefDTO, HttpStatus.OK);
		}
	}
	
	@DeleteMapping(path="/remove/{shipperId}/{columnName}", produces=MediaType.APPLICATION_JSON_VALUE)
	//@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Object> removePreference(@PathVariable("shipperId") Long shipperId, @PathVariable("columnName") String columnName) {
		PreferenceId id = new PreferenceId(shipperId, columnName);
		this.preferenceService.removePreference(id);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
	
	@GetMapping(path="/get/{shipperId}/{columnName}", produces=MediaType.APPLICATION_JSON_VALUE)
	//@PreAuthorize("hasRole('SALES') or hasRole('ACCOUNT') or hasRole('ADMIN')")
	public ResponseEntity<Object> getPreference(@PathVariable("shipperId") Long shipperId, @PathVariable("columnName") String columnName) {
		PreferenceId id = new PreferenceId(shipperId, columnName);
		PreferenceDTO preference  =this.preferenceService.getPreferenceById(id);
		return new ResponseEntity<Object>(preference, HttpStatus.OK);
	}
	
	@GetMapping(path="/get", produces=MediaType.APPLICATION_JSON_VALUE)
	//@PreAuthorize("hasRole('SALES') or hasRole('ACCOUNT') or hasRole('ADMIN')")
	public ResponseEntity<Object> getPreferences() {
		List<PreferenceDTO> preferences  = this.preferenceService.listPreferences();
		return new ResponseEntity<Object>(preferences, HttpStatus.OK);
	}
	
}

