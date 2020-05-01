package com.billing.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.billing.model.OrderInfoDetails;

@Repository
public interface OrderItemRepository  extends JpaRepository<OrderInfoDetails, Long> {

}
