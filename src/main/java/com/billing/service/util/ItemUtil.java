package com.billing.service.util;

import java.util.ArrayList;
import java.util.List;

import com.billing.model.Item;
import com.billing.model.OrderInfoDetails;
import com.billing.response.OrderItemResponse;

public class ItemUtil {

	public static List<OrderItemResponse> getOrderItemResponse(List<OrderInfoDetails> items) {
		List<OrderItemResponse> list = new ArrayList<OrderItemResponse>();
		for(OrderInfoDetails item : items) {
			list.add(new OrderItemResponse(item.getItem().getItemName(), item.getQuantity(), item.getItem().getItemPrice()*item.getQuantity()));
		}
		return list;
	}
	
	public static OrderItemResponse getOrderItemResponse(OrderInfoDetails item) {
		return new OrderItemResponse(item.getItem().getItemName(), item.getQuantity(), item.getItem().getItemPrice()*item.getQuantity());
	}

}
