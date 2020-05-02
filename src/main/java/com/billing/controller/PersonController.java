package com.billing.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.billing.request.PersonRequestResponse;
import com.billing.response.Errors;
import com.billing.service.impl.PersonServiceImpl;
import com.billing.validator.BeanValidator;

@RestController
@RequestMapping("/person")
public class PersonController {
	
	@Autowired BeanValidator validator;
	
	private PersonServiceImpl personService;

	public PersonController(PersonServiceImpl personService) {
        this.personService = personService;
    }
	
	@PostMapping(path="/add", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> createPerson(@Valid @RequestBody PersonRequestResponse personRequest,BindingResult result) {
		
		Errors errorList = validator.validate(result);
		if(!errorList.getErrorList().isEmpty()) {
			return new ResponseEntity<Object>(errorList, HttpStatus.BAD_REQUEST);
		} else {
			this.personService.addPerson(personRequest);
			return new ResponseEntity<Object>(HttpStatus.OK);
		}
	}
	
	@GetMapping(path="/get/{personId}", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> getPerson(@PathVariable Long personId) {
		PersonRequestResponse p = this.personService.getPersonById(personId);
		return new ResponseEntity<Object>(p, HttpStatus.OK);
	}
	
	@GetMapping(path="/get", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> getPersons() {
			List<PersonRequestResponse> list = this.personService.listPersons();
			return new ResponseEntity<Object>(list, HttpStatus.OK);
			
	}
	
}
