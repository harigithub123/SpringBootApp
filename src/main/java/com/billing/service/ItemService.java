package com.billing.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.billing.model.Item;
import com.billing.request.ItemRequest;

@Service
public interface ItemService {

	public void addItem(ItemRequest p);
	public void updateItem(ItemRequest p);
	public List<Item> listItems();
	public Item getItemById(int id);
	public void removeItem(int id);
}
