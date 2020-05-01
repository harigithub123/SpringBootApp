package com.billing.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.billing.response.ItemStockResponse;

@Service
public interface ItemStockService {

	public List<ItemStockResponse> listItemStocks();
}
