package com.billing.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.billing.model.ItemStock;

@Repository
public interface ItemStockRepository extends JpaRepository<ItemStock, Long> {

}
