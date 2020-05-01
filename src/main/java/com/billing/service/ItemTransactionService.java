package com.billing.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.billing.request.ItemTransactionRequest;
import com.billing.response.ItemTransactionResponse;

@Service
public interface ItemTransactionService {
	public List<ItemTransactionResponse> listItemTransactions();
	public ItemTransactionResponse getItemTransactionById(Long id);
	void makeItemTransaction(ItemTransactionRequest request);
	public void revertItemTransaction(Long id);
}
