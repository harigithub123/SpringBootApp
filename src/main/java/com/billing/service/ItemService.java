package com.billing.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.billing.model.Item;
import com.billing.request.ItemRequest;

@Service
public interface ItemService {

	public void addItem(ItemRequest p);
	public void updateItem(ItemRequest p);
	public List<Item> listItems();
	public Optional<Item> getItemById(Long id);
	public void removeItem(Long id);
}
