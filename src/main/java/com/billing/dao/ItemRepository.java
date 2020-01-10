package com.billing.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.billing.model.Item;

public interface ItemRepository  extends JpaRepository<Item, Long> {

}
