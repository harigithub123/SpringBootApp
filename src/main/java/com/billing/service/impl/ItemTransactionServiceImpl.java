package com.billing.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.billing.dao.ItemStockRepository;
import com.billing.dao.ItemTransactionResponsity;
import com.billing.model.Item;
import com.billing.model.ItemStock;
import com.billing.model.ItemTransaction;
import com.billing.model.ItemTransactionDetails;
import com.billing.model.User;
import com.billing.request.ItemTransactionRequest;
import com.billing.response.ItemTransactionResponse;
import com.billing.response.OrderItemResponse;
import com.billing.service.ItemTransactionService;
import com.billing.service.util.Constants;
import com.billing.service.util.ServiceRequestUtil;

@Service
public class ItemTransactionServiceImpl implements ItemTransactionService {

	private ItemTransactionResponsity itemTransactionRepository;
	private ItemStockRepository itemStockRepository;
	private ServiceRequestUtil util = new ServiceRequestUtil();
	
	public ItemTransactionServiceImpl(ItemTransactionResponsity stockTransactionRepository,
			ItemStockRepository itemStockRepository) {
		this.itemTransactionRepository = stockTransactionRepository;
		this.itemStockRepository = itemStockRepository;
	}

	@Override
	public List<ItemTransactionResponse> listItemTransactions() {
		return getTransactionResponse(this.itemTransactionRepository.findAll());
	}

	@Override
	public ItemTransactionResponse getItemTransactionById(Long id) {
		Optional<ItemTransaction> transaction = this.itemTransactionRepository.findById(id);
		if(transaction != null) {
			return getTransactionResponse(transaction.get());
		}
		return null;
	}

	@Override
	public void revertItemTransaction(Long id) {
		Optional<ItemTransaction> result = this.itemTransactionRepository.findById(id);
		if(result==null || !result.isPresent()) {
			return;
		}
		ItemTransaction t = result.get();
		List<ItemStock> stocks = itemStockRepository.findAll();
		revertInventoryForThisTransaction(stocks, t);
		this.itemStockRepository.saveAll(stocks);
		this.itemTransactionRepository.deleteById(id);
	}

	private void revertInventoryForThisTransaction(List<ItemStock> stocks, ItemTransaction t) {
		List<ItemTransactionDetails> details = t.getItemTransactionDetails();
		Map<Long, ItemStock> itemWiseStock = getItemWiseStock(stocks);
		for(ItemTransactionDetails d : details) {
			ItemStock s = itemWiseStock.get(d.getItem().getId());
			s.setQuantity(s.getQuantity()-d.getQuantity());
		}
	}

	@Override
	public void makeItemTransaction(ItemTransactionRequest request) {
		List<ItemStock> currentStock = this.itemStockRepository.findAll();
		List<ItemStock> closingStock = util.getItemStock(request);
		ItemTransaction transaction = getStockTransaction(getItemWiseStock(currentStock), getItemWiseStockFromRequest(closingStock), request);
		this.itemStockRepository.saveAll(currentStock);
		this.itemTransactionRepository.save(transaction);
	}
	
	private List<ItemTransactionResponse> getTransactionResponse(List<ItemTransaction> stocks) {
		List<ItemTransactionResponse> list = new LinkedList<ItemTransactionResponse>();
		for(ItemTransaction stock : stocks) {
			list.add(getTransactionResponse(stock));
		}
		return list;
	}
	
	private ItemTransactionResponse getTransactionResponse(ItemTransaction t) {
		ItemTransactionResponse res = new ItemTransactionResponse();
		res.setId(t.getId());
		res.setTransactionDate(t.getTransactionDate());
		res.setTransactionType(t.getTransactionType());
		res.setUserName(t.getUser().getUserName());
		res.setItems(getOrderItemResponse(t.getItemTransactionDetails(), t.getTransactionType(), res));
		return res;
	}

	public static List<OrderItemResponse> getOrderItemResponse(List<ItemTransactionDetails> items, String transactionType, ItemTransactionResponse res) {
		List<OrderItemResponse> list = new ArrayList<OrderItemResponse>();
		Double total=0.0;
		for(ItemTransactionDetails tranItem : items) {
			Item item = tranItem.getItem();
			Double price = Constants.TRAN_TYPE_SOLD.equals(transactionType) ? tranItem.getQuantity()*item.getItemPrice() : null;
			list.add(new OrderItemResponse(item.getItemName(), tranItem.getQuantity(), price));
			if(price != null) {
				total = total + price;
			}
		}
		res.setTotal(total);
		return list;
	}
	
	private Map<Long, ItemStock> getItemWiseStock(List<ItemStock> stocks) {
		Map<Long, ItemStock> items = new HashMap<Long, ItemStock>();
		for(ItemStock orderItem : stocks) {
			items.put(orderItem.getItem().getId(), orderItem);
		}
		return items;
	}
	
	private Map<Long, ItemStock> getItemWiseStockFromRequest(List<ItemStock> stocks) {
		Map<Long, ItemStock> items = new HashMap<Long, ItemStock>();
		for(ItemStock orderItem : stocks) {
			items.put(orderItem.getId(), orderItem);
		}
		return items;
	}
	
	private ItemTransaction getStockTransaction(Map<Long, ItemStock> openingStocks, Map<Long, ItemStock> updatedStocks, ItemTransactionRequest request) {
		ItemTransaction transaction = new ItemTransaction();
		transaction.setTransactionDate(request.getTransactionDate());
		transaction.setTransactionType(request.getTransactionType());
		transaction.setUser(new User(request.getUserId()));
		transaction.setItemTransactionDetails(new ArrayList<ItemTransactionDetails>());
		
		for (Map.Entry<Long,ItemStock> entry : updatedStocks.entrySet()) {
			Long itemId = entry.getKey();
			Double updatedStock = getUpdatedStock(openingStocks.get(itemId).getQuantity(), entry.getValue().getQuantity(), request.getTransactionType());
			Double transactionStock = getTransactionStock(openingStocks.get(itemId).getQuantity(), entry.getValue().getQuantity(), request.getTransactionType());
			transaction.getItemTransactionDetails().add(new ItemTransactionDetails(new Item(itemId), transactionStock, transaction));
			openingStocks.get(itemId).setQuantity(updatedStock);
		}
		return transaction;
	}
	
	private double getTransactionStock(double oldStock, double newStock, String transactionType) {
		if(Constants.TRAN_TYPE_SOLD.equals(transactionType)) {
			return oldStock-newStock;
		} else {
			return newStock;
		}
	}
	
	private double getUpdatedStock(double oldStock, double newStock, String transactionType) {
		if(Constants.TRAN_TYPE_SOLD.equals(transactionType)) {
			return newStock;
		} else {
			return oldStock+newStock;
		}
	}

	
}


