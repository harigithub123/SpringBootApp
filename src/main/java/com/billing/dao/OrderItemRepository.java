package com.billing.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.billing.model.OrderItem;

public interface OrderItemRepository  extends JpaRepository<OrderItem, Long> {

}
