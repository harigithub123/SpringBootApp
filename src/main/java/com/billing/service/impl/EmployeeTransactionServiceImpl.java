package com.billing.service.impl;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.billing.dao.EmployeeTransactionRepository;
import com.billing.model.CustomerTransaction;
import com.billing.model.EmployeeTransaction;
import com.billing.request.EmployeeTransactionRequest;
import com.billing.response.CustomerTransactionResponse;
import com.billing.response.EmployeeTransactionResponse;
import com.billing.service.EmployeeTransactionService;
import com.billing.service.util.ServiceRequestUtil;

@Service
public class EmployeeTransactionServiceImpl implements EmployeeTransactionService {
	
	private EmployeeTransactionRepository employeeTransactionRespository;
	
	public EmployeeTransactionServiceImpl(EmployeeTransactionRepository employeeTransactionRepository) {
		this.employeeTransactionRespository = employeeTransactionRepository;
	}

	@Transactional
	public void addEmployeeTransaction(EmployeeTransactionRequest request) {
		this.employeeTransactionRespository.save(ServiceRequestUtil.getEmployeeTransaction(request));
	}

	@Transactional
	public void updateEmployeeTransaction(EmployeeTransactionRequest request) {
		this.employeeTransactionRespository.save(ServiceRequestUtil.getEmployeeTransaction(request));
	}

	@Transactional
	public List<EmployeeTransactionResponse> listEmployeeTransactions() {
		List<EmployeeTransaction> list = this.employeeTransactionRespository.findAll();
		return getTransactionResponse(list);
	}

	@Transactional
	public EmployeeTransactionResponse getEmployeeTransactionById(Long id) {
		Optional<EmployeeTransaction> employeeTransaction = this.employeeTransactionRespository.findById(id);
		if(employeeTransaction != null) {
			return getTransactionResponse(employeeTransaction.get());
		}
		return null;
	}

	@Transactional
	public void removeEmployeeTransaction(Long id) {
		this.employeeTransactionRespository.deleteById(id);
	}
	
	public EmployeeTransactionResponse getTransactionResponse(EmployeeTransaction transaction) {
		EmployeeTransactionResponse response = new EmployeeTransactionResponse();
		response.setId(transaction.getId());
		response.setEmployeeName(transaction.getEmployee().getName());
		response.setGivenBy(transaction.getGivenBy());
		response.setReferenceNo(transaction.getReferenceNo());
		response.setTranAmount(transaction.getAmount());
		response.setTranComment(transaction.getComments());
		response.setTranMode(transaction.getTransactionMode());
		response.setTranDate(transaction.getTransactionDate());
		return response;
	}
	
	public List<EmployeeTransactionResponse> getTransactionResponse(List<EmployeeTransaction> transactions) {
		List<EmployeeTransactionResponse> response = new ArrayList<EmployeeTransactionResponse>();
		for(EmployeeTransaction transaction : transactions) {
			response.add(getTransactionResponse(transaction));
		}
		return response;
	}
	
}
