package com.billing.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.billing.model.EmployeeTransaction;
import com.billing.request.EmployeeTransactionRequest;
import com.billing.response.EmployeeTransactionResponse;

@Service
public interface EmployeeTransactionService {
	public void addEmployeeTransaction(EmployeeTransactionRequest p);
	public void updateEmployeeTransaction(EmployeeTransactionRequest p);
	public List<EmployeeTransactionResponse> listEmployeeTransactions();
	public EmployeeTransactionResponse getEmployeeTransactionById(Long id);
	public void removeEmployeeTransaction(Long id);
}
