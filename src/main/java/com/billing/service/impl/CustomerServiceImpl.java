
package com.billing.service.impl;


import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.billing.dao.CustomerRepository;
import com.billing.dao.CustomerTransactionRespository;
import com.billing.model.Customer;
import com.billing.request.CustomerRequest;
import com.billing.request.CustomerTransactionRequest;
import com.billing.service.util.ServiceRequestUtil;

@Service
public class CustomerServiceImpl {
	
	private CustomerRepository customerRespository;
	private CustomerTransactionRespository custTranRepository;
	
	public CustomerServiceImpl(CustomerRepository customerRepository, CustomerTransactionRespository custTranRepository ) {
		this.customerRespository = customerRepository;
		this.custTranRepository = custTranRepository;
	}

	@Transactional
	public void addCustomer(CustomerRequest request) {
		this.customerRespository.save(ServiceRequestUtil.getCustomer(request));
	}

	@Transactional
	public void updateCustomer(CustomerRequest request) {
		this.customerRespository.save(ServiceRequestUtil.getCustomer(request));
	}

	@Transactional
	public List<Customer> listCustomers() {
		return this.customerRespository.findAll();
	}

	@Transactional
	public Optional<Customer> getCustomerById(Long id) {
		return this.customerRespository.findById(id);
	}

	@Transactional
	public void removeCustomer(Long id) {
		this.customerRespository.deleteById(id);
	}
	
	@Transactional
	public void makeCustomerTransaction(CustomerTransactionRequest request) {
		this.custTranRepository.save(ServiceRequestUtil.getCustomerTransaction(request));
	}

}
