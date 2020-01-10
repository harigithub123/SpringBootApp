package com.billing.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.billing.model.OrderInfo;
import com.billing.request.OrderInfoRequest;

@Service
public interface OrderService {

	public void addOrder(OrderInfoRequest p);
	public void updateOrder(OrderInfoRequest p);
	public List<OrderInfo> listOrders();
	public OrderInfo getOrderById(int id);
	public void removeOrder(int id);
}
