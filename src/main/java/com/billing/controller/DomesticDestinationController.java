package com.billing.controller;

import java.util.List;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.billing.dto.destinations.DomesticDestinationDTO;
import com.billing.dto.destinations.SearchDestinationDTO;
import com.billing.response.Errors;
import com.billing.service.impl.DomesticDestinationServiceImpl;
import com.billing.validator.BeanValidator;

@RestController
@RequestMapping("/destination")
public class DomesticDestinationController {
	
	@Autowired BeanValidator validator;
	@Autowired ModelMapper mapper;
	
	private DomesticDestinationServiceImpl domesticDestinationService;

	public DomesticDestinationController(DomesticDestinationServiceImpl domesticDestinationService) {
        this.domesticDestinationService = domesticDestinationService;
    }
	
	@PostMapping(path="/add", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> createDomesticDestination(@Valid @RequestBody DomesticDestinationDTO destinationRequest,BindingResult result) {
		
		Errors errorList = validator.validate(result);
		if(!errorList.getErrorList().isEmpty()) {
			return new ResponseEntity<Object>(errorList, HttpStatus.BAD_REQUEST);
		} else {
			DomesticDestinationDTO destination = this.domesticDestinationService.addDomesticDestination(destinationRequest);
			return new ResponseEntity<Object>(destination, HttpStatus.OK);
		}
	}
	
	@PutMapping(path="/update", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> updateDomesticDestination(@Valid @RequestBody DomesticDestinationDTO destinationRequest,BindingResult result) {
		
		Errors errorList = validator.validate(result);
		if(!errorList.getErrorList().isEmpty()) {
			return new ResponseEntity<Object>(errorList, HttpStatus.BAD_REQUEST);
		} else {
			DomesticDestinationDTO destination = this.domesticDestinationService.updateDomesticDestination(destinationRequest);
			return new ResponseEntity<Object>(destination, HttpStatus.OK);
		}
	}
	
	@DeleteMapping(path="/remove/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> removeDomesticDestination(@PathVariable("id") Long id) {
		this.domesticDestinationService.removeDomesticDestination(id);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
	
	@GetMapping(path="/get/{destinationId}", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> getDomesticDestination(@PathVariable long destinationId) {
		DomesticDestinationDTO destination  = this.domesticDestinationService.getDomesticDestinationById(destinationId);
		return new ResponseEntity<Object>(destination, HttpStatus.OK);
	}
	
	@PutMapping(path="/get", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> getDestinations(@RequestBody SearchDestinationDTO searchDTO) {
		List<DomesticDestinationDTO> destinations  = this.domesticDestinationService.listDomesticDestinations(searchDTO);
		return new ResponseEntity<Object>(destinations, HttpStatus.OK);
	}
	
}
