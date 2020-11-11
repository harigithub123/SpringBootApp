package com.billing.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.billing.dao.CustomerTransactionRespository;
import com.billing.dto.CustomerTransactionRequest;
import com.billing.model.CustomerTransaction;
import com.billing.response.CustomerTransactionResponse;
import com.billing.service.CustomerTransactionService;
import com.billing.service.util.ServiceRequestUtil;

@Service
public class CustomerTransactionServiceImpl implements CustomerTransactionService{
	private CustomerTransactionRespository custTranRepository;
	
	public CustomerTransactionServiceImpl(CustomerTransactionRespository customerRepository, CustomerTransactionRespository custTranRepository ) {
		this.custTranRepository = custTranRepository;
	}

	@Transactional
	public void addCustomerTransaction(CustomerTransactionRequest request) {
		this.custTranRepository.save(ServiceRequestUtil.getCustomerTransaction(request));
	}

	@Transactional
	public void updateCustomerTransaction(CustomerTransactionRequest request) {
		this.custTranRepository.save(ServiceRequestUtil.getCustomerTransaction(request));
	}

	@Transactional
	public List<CustomerTransactionResponse> listCustomerTransactions() {
		List<CustomerTransaction> transactions = this.custTranRepository.findAll();
		return getTransactionResponse(transactions);
	}

	@Transactional
	public CustomerTransactionResponse getCustomerTransactionById(Long id) {
		Optional<CustomerTransaction> customer = this.custTranRepository.findById(id);
		if(customer.isPresent()) {
			return getTransactionResponse(customer.get());
		} else {
			return null;
		}
	}

	@Transactional
	public void removeCustomerTransaction(Long id) {
		this.custTranRepository.deleteById(id);
	}
	
	@Transactional
	public void makeCustomerTransaction(CustomerTransactionRequest request) {
		this.custTranRepository.save(ServiceRequestUtil.getCustomerTransaction(request));
	}
	
	public CustomerTransactionResponse getTransactionResponse(CustomerTransaction transaction) {
		CustomerTransactionResponse response = new CustomerTransactionResponse();
		response.setId(transaction.getId());
		response.setName(transaction.getCustomer().getName());
		response.setReceivedBy(transaction.getReceivedBy());
		response.setReferenceNo(transaction.getReferenceNo());
		response.setTranAmount(transaction.getAmount());
		response.setTranComment(transaction.getComments());
		response.setTranMode(transaction.getTransactionMode());
		response.setTranDate(transaction.getTransactionDate());
		return response;
	}
	
	public List<CustomerTransactionResponse> getTransactionResponse(List<CustomerTransaction> transactions) {
		List<CustomerTransactionResponse> response = new ArrayList<CustomerTransactionResponse>();
		for(CustomerTransaction transaction : transactions) {
			response.add(getTransactionResponse(transaction));
		}
		return response;
	}

}
