package com.billing.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.billing.dto.CustomerTransactionRequest;
import com.billing.model.CustomerTransaction;
import com.billing.response.CustomerTransactionResponse;

@Service
public interface CustomerTransactionService {
	public void addCustomerTransaction(CustomerTransactionRequest p);
	public void updateCustomerTransaction(CustomerTransactionRequest p);
	public List<CustomerTransactionResponse> listCustomerTransactions();
	public CustomerTransactionResponse getCustomerTransactionById(Long id);
	public void removeCustomerTransaction(Long id);
}
