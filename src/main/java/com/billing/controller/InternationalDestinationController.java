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

import com.billing.dto.destinations.InternationalDestinationDTO;
import com.billing.response.Errors;
import com.billing.service.impl.InternationalDestinationServiceImpl;
import com.billing.validator.BeanValidator;

@RestController
@RequestMapping("/destination/international")
public class InternationalDestinationController {
	
	@Autowired BeanValidator validator;
	
	private InternationalDestinationServiceImpl internationalDestinationService;

	public InternationalDestinationController(InternationalDestinationServiceImpl InternationalDestinationService) {
        this.internationalDestinationService = InternationalDestinationService;
    }
	
	@PostMapping(path="/add", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> createInternationalDestination(@Valid @RequestBody InternationalDestinationDTO destinationRequest,BindingResult result) {
		
		Errors errorList = validator.validate(result);
		if(!errorList.getErrorList().isEmpty()) {
			return new ResponseEntity<Object>(errorList, HttpStatus.BAD_REQUEST);
		} else {
			InternationalDestinationDTO destination = this.internationalDestinationService.addInternationalDestination(destinationRequest);
			return new ResponseEntity<Object>(destination, HttpStatus.OK);
		}
	}
	
	@PutMapping(path="/update", produces=MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Object> updateInternationalDestination(@Valid @RequestBody InternationalDestinationDTO destinationRequest,BindingResult result) {
		
		Errors errorList = validator.validate(result);
		if(!errorList.getErrorList().isEmpty()) {
			return new ResponseEntity<Object>(errorList, HttpStatus.BAD_REQUEST);
		} else {
			InternationalDestinationDTO destination = this.internationalDestinationService.updateInternationalDestination(destinationRequest);
			return new ResponseEntity<Object>(destination, HttpStatus.OK);
		}
	}
	
	@DeleteMapping(path="/remove/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	//@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Object> removeInternationalDestination(@PathVariable("id") Long id) {
		this.internationalDestinationService.removeInternationalDestination(id);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
	
	@GetMapping(path="/get/{destinationId}", produces=MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasRole('SALES') or hasRole('ACCOUNT') or hasRole('ADMIN')")
	public ResponseEntity<Object> getInternationalDestination(@PathVariable long destinationId) {
		InternationalDestinationDTO destination  = this.internationalDestinationService.getInternationalDestinationById(destinationId);
		return new ResponseEntity<Object>(destination, HttpStatus.OK);
	}
	
	@GetMapping(path="/get", produces=MediaType.APPLICATION_JSON_VALUE)
	//@PreAuthorize("hasRole('SALES') or hasRole('ACCOUNT') or hasRole('ADMIN')")
	public ResponseEntity<Object> getDestinations() {
		List<InternationalDestinationDTO> destinations  = this.internationalDestinationService.listInternationalDestinations();
		return new ResponseEntity<Object>(destinations, HttpStatus.OK);
	}
	
}
