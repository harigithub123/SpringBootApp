
package com.billing.controller;

import java.util.List;

import javax.validation.Valid;

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

import com.billing.model.Item;
import com.billing.request.ItemRequest;
import com.billing.response.Errors;
import com.billing.service.impl.ItemServiceImpl;
import com.billing.validator.BeanValidator;

@RestController
@RequestMapping("/item")
public class ItemController {
	
	@Autowired BeanValidator validator;
	
	private ItemServiceImpl itemService;

	public ItemController(ItemServiceImpl itemService) {
        this.itemService = itemService;
    }
	
	@PostMapping(path="/add", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> createItem(@Valid @RequestBody ItemRequest itemRequest,BindingResult result) {
		
		Errors errorList = validator.validate(result);
		if(!errorList.getErrorList().isEmpty()) {
			return new ResponseEntity<Object>(errorList, HttpStatus.BAD_REQUEST);
		} else {
			this.itemService.addItem(itemRequest);
			return new ResponseEntity<Object>(HttpStatus.OK);
		}
	}
	
	@PutMapping(path="/update", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> updateItem(@Valid @RequestBody ItemRequest itemRequest,BindingResult result) {
		
		Errors errorList = validator.validate(result);
		if(!errorList.getErrorList().isEmpty()) {
			return new ResponseEntity<Object>(errorList, HttpStatus.BAD_REQUEST);
		} else {
			this.itemService.updateItem(itemRequest);
			return new ResponseEntity<Object>(HttpStatus.OK);
		}
	}
	
	@DeleteMapping(path="/remove/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> removeItem(@PathVariable("id") Long id) {
		this.itemService.removeItem(id);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
	
	@GetMapping(path="/get/{itemId}", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> getItem(@PathVariable("itemId") String itemId) {
			return new ResponseEntity<Object>(HttpStatus.OK);
	}
	
	@GetMapping(path="/get", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> getUsers() {
		List<Item> items  = this.itemService.listItems();
		return new ResponseEntity<Object>(items, HttpStatus.OK);
	}
	
}

