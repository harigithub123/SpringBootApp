package com.billing.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.billing.dto.CustomerRequest;
import com.billing.model.Customer;

@Service
public interface CustomerService {

	public void addCustomer(CustomerRequest p);
	public void updateCustomer(CustomerRequest p);
	public List<Customer> listCustomers();
	public Customer getCustomerById(Long id);
	public void removeCustomer(Long id);
}
