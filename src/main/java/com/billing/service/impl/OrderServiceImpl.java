
package com.billing.service.impl;


import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.billing.dao.OrderInfoRepository;
import com.billing.model.OrderInfo;
import com.billing.request.OrderInfoRequest;
import com.billing.service.util.ServiceRequestUtil;

@Service
public class OrderServiceImpl {
	
	private OrderInfoRepository orderRespository;
	
	public OrderServiceImpl(OrderInfoRepository orderRepository ) {
		this.orderRespository = orderRepository;
	}

	@Transactional
	public void addOrder(OrderInfoRequest request) {
		this.orderRespository.save(ServiceRequestUtil.getOrder(request));
	}

	@Transactional
	public void updateOrder(OrderInfoRequest request) {
		this.orderRespository.save(ServiceRequestUtil.getOrder(request));
	}

	@Transactional
	public List<OrderInfo> listOrders() {
		return this.orderRespository.findAll();
	}

	@Transactional
	public Optional<OrderInfo> getOrderById(Long id) {
		return this.orderRespository.findById(id);
	}

	@Transactional
	public void removeOrder(Long id) {
		this.orderRespository.deleteById(id);
	}
	
}
