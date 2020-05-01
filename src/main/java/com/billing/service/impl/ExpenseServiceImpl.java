package com.billing.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.billing.dao.ExpenseRespository;
import com.billing.model.Expense;
import com.billing.request.ExpenseRequest;
import com.billing.response.ExpenseResponse;
import com.billing.service.ExpenseService;
import com.billing.service.util.ServiceRequestUtil;

@Service
public class ExpenseServiceImpl implements ExpenseService {
	
	private ExpenseRespository expenseRespository;
	
	public ExpenseServiceImpl(ExpenseRespository expenseRepository) {
		this.expenseRespository = expenseRepository;
	}

	@Transactional
	public void addExpense(ExpenseRequest request) {
		this.expenseRespository.save(ServiceRequestUtil.getExpense(request));
	}

	@Transactional
	public void updateExpense(ExpenseRequest request) {
		this.expenseRespository.save(ServiceRequestUtil.getExpense(request));
	}

	@Transactional
	public List<ExpenseResponse> listExpenses() {
		return getExpenseResponse(this.expenseRespository.findAll());
	}

	@Transactional
	public ExpenseResponse getExpenseById(Long id) {
		Optional<Expense> expense = this.expenseRespository.findById(id);
		if(expense != null) {
			return getExpenseResponse(expense.get());
		}
		return null;
	}

	@Transactional
	public void removeExpense(Long id) {
		this.expenseRespository.deleteById(id);
	}
	
	public ExpenseResponse getExpenseResponse(Expense e) {
		ExpenseResponse r = new ExpenseResponse();
		r.setAmount(e.getAmount());
		r.setCategory(e.getCategory());
		r.setGoods(e.getGoods());
		r.setTransactionDate(e.getTransactionDate());
		r.setId(e.getId());
		r.setNote(e.getNote());
		r.setPaid(e.getPaid());
		r.setUserName(e.getUser().getUserName());
		return r;
	}
	
	public List<ExpenseResponse> getExpenseResponse(List<Expense> list) {
		List<ExpenseResponse> res = new ArrayList<ExpenseResponse>();
		for(Expense e : list) {
			res.add(getExpenseResponse(e));
		}
		return res;
	}
	
}
