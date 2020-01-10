
package com.billing.service.impl;


import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.billing.dao.ItemRepository;
import com.billing.model.Item;
import com.billing.request.ItemRequest;
import com.billing.service.util.ServiceRequestUtil;

@Service
public class ItemServiceImpl {
	
	private ItemRepository itemRespository;
	
	public ItemServiceImpl(ItemRepository itemRepository ) {
		this.itemRespository = itemRepository;
	}

	@Transactional
	public void addItem(ItemRequest request) {
		this.itemRespository.save(ServiceRequestUtil.getItem(request));
	}

	@Transactional
	public void updateItem(ItemRequest request) {
		this.itemRespository.save(ServiceRequestUtil.getItem(request));
	}

	@Transactional
	public List<Item> listItems() {
		return this.itemRespository.findAll();
	}

	@Transactional
	public Optional<Item> getItemById(Long id) {
		return this.itemRespository.findById(id);
	}

	@Transactional
	public void removeItem(Long id) {
		this.itemRespository.deleteById(id);
	}
	
}
