package com.billing.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.billing.model.OrderInfo;

public interface OrderInfoRepository  extends JpaRepository<OrderInfo, Long> {

}
