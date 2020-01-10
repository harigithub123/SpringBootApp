package com.billing.service.util;

import com.billing.model.Customer;
import com.billing.model.CustomerTransaction;
import com.billing.model.Item;
import com.billing.model.OrderInfo;
import com.billing.request.CustomerRequest;
import com.billing.request.CustomerTransactionRequest;
import com.billing.request.ItemRequest;

public class ServiceRequestUtil {

	public static Customer getCustomer(CustomerRequest request) {
		Customer customer = new Customer();
		customer.setId(request.getId());
		customer.setContactPerson(request.getContactPersion());
		customer.setEmailId(request.getEmailId());
		customer.setPhoneNumber(request.getMobileNumber());
		customer.setOfficeNo(request.getOfficeNo());
		customer.setOfficeName(request.getOfficeName());
		customer.setNeedToSendSms(request.isNeedToSendSms());
		return customer;
	}

	public static CustomerTransaction getCustomerTransaction(CustomerTransactionRequest request) {
		CustomerTransaction tran = new CustomerTransaction();
		tran.setCustomerId(request.getCustomerId());
		tran.setReceivedBy(request.getReceivedBy());
		tran.setTranAmount(request.getTranAmount());
		tran.setTranComment(request.getTranComment());
		tran.setTranMode(request.getTranMode());
		tran.setTranDate(request.getTranDate());
		return tran;
	}
	
	public static Item getItem(ItemRequest request) {
		Item item = new Item();
		item.setId(request.getId());
		item.setDisplayOrder(request.getDisplayOrder());
		item.setItemName(request.getItemName());
		item.setItemPrice(request.getItemPrice());
		return item;
	}
	
	public static OrderInfo getOrder(OrderInfoRequest request) {
		OrderInfo orderInfo = new OrderInfo();
		orderInfo.setCustomerId(request.);
		item.setDisplayOrder(request.getDisplayOrder());
		item.setItemName(request.getItemName());
		item.setItemPrice(request.getItemPrice());
		return item;
	}
	
}
