
package com.billing.service.impl;


import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.billing.dao.ItemRepository;
import com.billing.model.Item;
import com.billing.request.ItemRequest;
import com.billing.service.ItemService;
import com.billing.service.util.ServiceRequestUtil;

@Service
public class ItemServiceImpl implements ItemService {
	
	private ItemRepository itemRepository;
	private ServiceRequestUtil util = new ServiceRequestUtil();
	
	public ItemServiceImpl(ItemRepository itemRepository) {
		this.itemRepository = itemRepository;
	}

	@Transactional
	public void addItem(ItemRequest request) {
		this.itemRepository.save(util.getItem(request));
	}

	@Transactional
	public void updateItem(ItemRequest request) {
		this.itemRepository.save(util.getItem(request));
	}

	@Transactional
	public List<Item> listItems() {
		Sort s = new Sort(Sort.Direction.ASC, "displayOrder");
		return this.itemRepository.findAll(s);
	}

	@Override
	public Optional<Item> getItemById(Long id) {
		return this.itemRepository.findById(id);
	}

	@Override
	public void removeItem(Long id) {
		this.itemRepository.deleteById(id);
		
	}
	
}
