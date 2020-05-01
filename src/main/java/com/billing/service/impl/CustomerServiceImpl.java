
package com.billing.service.impl;


import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.billing.dao.CustomerRepository;
import com.billing.model.Customer;
import com.billing.request.CustomerRequest;
import com.billing.service.CustomerService;
import com.billing.service.util.ServiceRequestUtil;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	private CustomerRepository customerRespository;
	
	public CustomerServiceImpl(CustomerRepository customerRepository) {
		this.customerRespository = customerRepository;
	}

	@Override
	public void addCustomer(CustomerRequest request) {
		this.customerRespository.save(ServiceRequestUtil.getCustomer(request));
	}

	@Override
	public void updateCustomer(CustomerRequest request) {
		this.customerRespository.save(ServiceRequestUtil.getCustomer(request));
	}

	@Override
	public List<Customer> listCustomers() {
		return this.customerRespository.findAll();
	}

	@Override
	public Customer getCustomerById(Long id) {
		Optional<Customer> customer = this.customerRespository.findById(id);
		if(customer != null) {
			return customer.get();
		}
		return null;
	}

	@Override
	public void removeCustomer(Long id) {
		this.customerRespository.deleteById(id);
		
	}

}
