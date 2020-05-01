
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

import com.billing.model.Item;
import com.billing.request.ItemRequest;
import com.billing.request.ItemTransactionRequest;
import com.billing.response.Errors;
import com.billing.response.ItemStockResponse;
import com.billing.response.ItemTransactionResponse;
import com.billing.service.ItemService;
import com.billing.service.ItemStockService;
import com.billing.service.ItemTransactionService;
import com.billing.service.impl.ItemServiceImpl;
import com.billing.service.impl.ItemStockServiceImpl;
import com.billing.service.impl.ItemTransactionServiceImpl;
import com.billing.validator.BeanValidator;

@RestController
@RequestMapping("/item")
public class ItemController {
	
	@Autowired BeanValidator validator;
	
	private ItemService itemService;
	private ItemStockService itemStockService;
	private ItemTransactionService itemTransactionService;

	public ItemController(ItemServiceImpl itemServiceImpl, ItemTransactionServiceImpl itemTransactionServiceImpl, ItemStockServiceImpl itemStockServiceImpl) {
        this.itemService = itemServiceImpl;
        this.itemStockService = itemStockServiceImpl;
        this.itemTransactionService = itemTransactionServiceImpl;
    }
	
	@PostMapping(path="/add", produces=MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasRole('ADMIN')")
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
	@PreAuthorize("hasRole('ADMIN')")
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
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Object> removeItem(@PathVariable("id") Long id) {
		this.itemService.removeItem(id);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
	
	@GetMapping(path="/get/{itemId}", produces=MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasRole('SALES') or hasRole('ACCOUNT') or hasRole('ADMIN')")
	public ResponseEntity<Object> getItem(@PathVariable("itemId") String itemId) {
			return new ResponseEntity<Object>(HttpStatus.OK);
	}
	
	@GetMapping(path="/get", produces=MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasRole('SALES') or hasRole('ACCOUNT') or hasRole('ADMIN')")
	public ResponseEntity<Object> getUsers() {
		List<Item> items  = this.itemService.listItems();
		return new ResponseEntity<Object>(items, HttpStatus.OK);
	}
	
	@PostMapping(path="/transaction/add", produces=MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasRole('ACCOUNT') or hasRole('ADMIN')")
	public ResponseEntity<Object> makeItemTransaction(@Valid @RequestBody ItemTransactionRequest itemStockRequest,BindingResult result) {
		
		Errors errorList = validator.validate(result);
		if(!errorList.getErrorList().isEmpty()) {
			return new ResponseEntity<Object>(errorList, HttpStatus.BAD_REQUEST);
		} else {
			this.itemTransactionService.makeItemTransaction(itemStockRequest);
			return new ResponseEntity<Object>(HttpStatus.OK);
		}
	}
	
	@GetMapping(path="/transaction/get", produces=MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasRole('SALES') or hasRole('ACCOUNT') or hasRole('ADMIN')")
	public ResponseEntity<Object> getTransactions() {
		List<ItemTransactionResponse> items  = this.itemTransactionService.listItemTransactions();
		return new ResponseEntity<Object>(items, HttpStatus.OK);
	}
	
	@DeleteMapping(path="/transaction/remove/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Object> removeOrder(@PathVariable("id") Long id) {
		this.itemTransactionService.revertItemTransaction(id);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
	
	@GetMapping(path="/stock/get", produces=MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasRole('SALES') or hasRole('ACCOUNT') or hasRole('ADMIN')")
	public ResponseEntity<Object> getStockDetails() {
		List<ItemStockResponse> items  = this.itemStockService.listItemStocks();
		return new ResponseEntity<Object>(items, HttpStatus.OK);
	}
	
}

