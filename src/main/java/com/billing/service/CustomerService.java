package com.billing.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.billing.model.Customer;
import com.billing.request.CustomerRequest;

@Service
public interface CustomerService {

	public void addCustomer(CustomerRequest p);
	public void updateCustomer(CustomerRequest p);
	public List<Customer> listCustomers();
	public Customer getCustomerById(int id);
	public Customer getCustomerByMobileNumber(int id);
	public void removeCustomer(int id);
}
