package com.billing.service.impl;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.billing.dao.ItemStockRepository;
import com.billing.dao.ItemTransactionResponsity;
import com.billing.model.ItemStock;
import com.billing.response.ItemStockResponse;
import com.billing.service.ItemStockService;

@Service
public class ItemStockServiceImpl implements ItemStockService {

	private ItemStockRepository itemStockRepository;
	
	public ItemStockServiceImpl(ItemTransactionResponsity stockTransactionRepository, ItemStockRepository itemStockRepository ) {
		this.itemStockRepository = itemStockRepository;
	}

	@Override
	public List<ItemStockResponse> listItemStocks() {
		return getItemStockResponse(this.itemStockRepository.findAll());
	}

	private List<ItemStockResponse> getItemStockResponse(List<ItemStock> stocks) {
		List<ItemStockResponse> list = new LinkedList<ItemStockResponse>();
		for(ItemStock stock : stocks) {
			ItemStockResponse response = new ItemStockResponse();
			response.setItemName(stock.getItem().getItemName());
			response.setQuantity(stock.getQuantity());
			list.add(response);
		}
		return list;
	}

}
