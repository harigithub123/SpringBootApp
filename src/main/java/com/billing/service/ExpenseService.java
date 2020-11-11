package com.billing.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.billing.dto.ExpenseRequest;
import com.billing.response.ExpenseResponse;

@Service
public interface ExpenseService {
	public void addExpense(ExpenseRequest p);
	public void updateExpense(ExpenseRequest p);
	public List<ExpenseResponse> listExpenses();
	public ExpenseResponse getExpenseById(Long id);
	public void removeExpense(Long id);
}
