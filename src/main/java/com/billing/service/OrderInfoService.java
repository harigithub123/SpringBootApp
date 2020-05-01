package com.billing.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.billing.model.OrderInfo;
import com.billing.request.OrderInfoRequest;
import com.billing.response.OrderInfoResponse;

@Service
public interface OrderInfoService {

	public void addOrder(OrderInfoRequest p);
	public void updateOrder(OrderInfoRequest p);
	public List<OrderInfoResponse> listOrders();
	public OrderInfo getOrderById(int id);
	public void removeOrder(int id);
}
