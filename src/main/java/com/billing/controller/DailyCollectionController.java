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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.billing.request.DailyCollectionRequest;
import com.billing.response.DailyCollectionResonse;
import com.billing.response.Errors;
import com.billing.service.impl.DailyCollectionServiceImpl;
import com.billing.validator.BeanValidator;

@RestController
@RequestMapping("/daily/collection")
public class DailyCollectionController {
	
	@Autowired BeanValidator validator;
	
	private DailyCollectionServiceImpl collectionService;

	public DailyCollectionController(DailyCollectionServiceImpl personService) {
        this.collectionService = personService;
    }
	
	@PostMapping(path="/add", produces=MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Object> addDailyCollection(@Valid @RequestBody DailyCollectionRequest personRequest,BindingResult result) {
		
		Errors errorList = validator.validate(result);
		if(!errorList.getErrorList().isEmpty()) {
			return new ResponseEntity<Object>(errorList, HttpStatus.BAD_REQUEST);
		} else {
			this.collectionService.addDailyCollection(personRequest);
			return new ResponseEntity<Object>(HttpStatus.OK);
		}
	}
	
	@DeleteMapping(path="/remove/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Object> removeDailyCollection(@PathVariable("id") Long id) {
		this.collectionService.removeCollection(id);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
	
	@GetMapping(path="/get/{collectionId}", produces=MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasRole('SALES') or hasRole('ACCOUNT') or hasRole('ADMIN')")
	public ResponseEntity<Object> getDayCollection(@PathVariable("collectionId") Long collectionId) {
		DailyCollectionResonse person = this.collectionService.getCollectionById(collectionId);
		return new ResponseEntity<Object>(person, HttpStatus.OK);
	}
	
	@GetMapping(path="/get", produces=MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasRole('SALES') or hasRole('ACCOUNT') or hasRole('ADMIN')")
	public ResponseEntity<Object> getCollections() {
		List<DailyCollectionResonse> collections  = this.collectionService.listCollections();
		return new ResponseEntity<Object>(collections, HttpStatus.OK);
	}
}