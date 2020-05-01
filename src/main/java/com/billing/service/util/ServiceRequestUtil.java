package com.billing.service.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.billing.dao.ItemRepository;
import com.billing.model.Customer;
import com.billing.model.CustomerTransaction;
import com.billing.model.DailyCollection;
import com.billing.model.Employee;
import com.billing.model.EmployeeTransaction;
import com.billing.model.Expense;
import com.billing.model.Item;
import com.billing.model.ItemStock;
import com.billing.model.ItemTransaction;
import com.billing.model.ItemTransactionDetails;
import com.billing.model.Login;
import com.billing.model.OrderInfo;
import com.billing.model.OrderInfoDetails;
import com.billing.model.SalaryRecord;
import com.billing.model.User;
import com.billing.request.CustomerRequest;
import com.billing.request.CustomerTransactionRequest;
import com.billing.request.DailyCollectionRequest;
import com.billing.request.EmployeeRequest;
import com.billing.request.EmployeeTransactionRequest;
import com.billing.request.ExpenseRequest;
import com.billing.request.ItemRequest;
import com.billing.request.ItemTransactionRequest;
import com.billing.request.LoginRequest;
import com.billing.request.OrderInfoRequest;
import com.billing.request.OrderItemRequest;
import com.billing.request.SalaryRecordRequest;
import com.billing.request.UserRequest;
import com.billing.response.ExpenseResponse;
import com.billing.response.ItemTransactionResponse;
import com.billing.response.OrderItemResponse;

public class ServiceRequestUtil {
	
	@Autowired
	ItemRepository itemRepository; 
	
	public static Customer getCustomer(CustomerRequest request) {
		Customer customer = new Customer();
		customer.setId(request.getId());
		customer.setContactPerson(request.getContactPersion());
		customer.setEmailId(request.getEmailId());
		customer.setMobileNumber(request.getMobileNumber());
		customer.setOfficeNo(request.getOfficeNo());
		customer.setOfficeName(request.getOfficeName());
		customer.setIsSmsRequired(request.isNeedToSendSms());
		return customer;
	}
	
	public List<ItemStock> getItemStock(ItemTransactionRequest request) {
		List<ItemStock> items = getStockItems(request.getItems());
		return items;
	}

	public static CustomerTransaction getCustomerTransaction(CustomerTransactionRequest request) {
		CustomerTransaction tran = new CustomerTransaction();
		tran.setId(request.getId());
		tran.setCustomer(new Customer(request.getCustomerId()));
		tran.setReceivedBy(request.getReceivedBy());
		tran.setAmount(request.getTranAmount());
		tran.setComments(request.getTranComment());
		tran.setTransactionMode(request.getTranMode());
		tran.setTransactionDate(request.getTranDate());
		tran.setReferenceNo(request.getReferenceNo());
		return tran;
	}
	
	public Item getItem(ItemRequest request) {
		Item item = new Item();
		item.setId(request.getId());
		item.setDisplayOrder(request.getDisplayOrder());
		item.setItemName(request.getItemName());
		item.setItemPrice(request.getItemPrice());
		return item;
	}
	
	public OrderInfo getOrder(OrderInfoRequest request) {
		OrderInfo orderInfo = new OrderInfo();
		orderInfo.setCustomer(new Customer(request.getCustomerId()));
		orderInfo.setUser(new User(request.getUserId()));
		orderInfo.setOrderDate(request.getOrderDate());
		orderInfo.setItems(getOrderItems(request.getItems(), orderInfo));
		orderInfo.setPaymentStatus("Pending");
		orderInfo.setModificationDate(new Date());
		return orderInfo;
	}

	private static List<OrderInfoDetails> getOrderItems(List<OrderItemRequest> requestItems, OrderInfo orderInfo) {
		List<OrderInfoDetails> orderItems = new ArrayList<OrderInfoDetails>();
		for(OrderItemRequest requestItem : requestItems) {
			OrderInfoDetails item = new OrderInfoDetails();
			item.setQuantity(requestItem.getQuantity());
			item.setItem(new Item(requestItem.getItemId()));
			item.setOrderInfo(orderInfo);
			orderItems.add(item);
		}
		return orderItems;
	}
	
	private static List<ItemStock> getStockItems(List<OrderItemRequest> requestItems) {
		List<ItemStock> orderItems = new ArrayList<ItemStock>();
		for(OrderItemRequest requestItem : requestItems) {
			ItemStock item = new ItemStock();
			item.setQuantity(requestItem.getQuantity());
			item.setId(requestItem.getItemId());
			orderItems.add(item);
		}
		return orderItems;
	}
	
	public User getUser(UserRequest request) {
		User user = new User();
		user.setEmailId(request.getEmailId());
		user.setUserName(request.getMobileNumber());
		user.setUserName(request.getUserId());
		return user;
	}
	
	public static Login getLogin(LoginRequest request) {
		Login login = new Login();
		login.setMobileNumber(request.getMobileNumber());
		login.setOtp(request.getOtp());
		return login;
	}

	public static Employee getEmployee(EmployeeRequest request) {
		Employee e = new Employee();
		e.setId(request.getId());
		e.setJoiningDate(request.getJoiningDate());
		e.setMonthSalary(request.getMonthSalary());
		e.setAadharNo(request.getAadharNo());
		e.setAddress(request.getAddress());
		e.setDob(request.getDob());
		e.setMobileNumber(request.getMobileNumber());
		e.setName(request.getName());
		e.setPanNo(request.getPanNo());
		return e;
	}

	public static EmployeeTransaction getEmployeeTransaction(EmployeeTransactionRequest request) {
		EmployeeTransaction t = new EmployeeTransaction();
		t.setId(request.getId());
		t.setAmount(request.getAmount());
		t.setComments(request.getComments());
		t.setEmployee(new Employee(request.getEmployeeId()));
		t.setGivenBy(request.getGivenBy());
		t.setReferenceNo(request.getReferenceNo());
		t.setTransactionDate(request.getTransactionDate());
		t.setTransactionMode(request.getTransactionMode());
		return t;
	}

	public static DailyCollection getDailyCollection(DailyCollectionRequest request) {
		DailyCollection p = new DailyCollection();
		p.setCash(request.getCash());
		p.setCredit(request.getCredit());
		p.setId(request.getId());
		p.setOnline(request.getOnline());
		p.setTransactionDate(request.getTransactionDate());
		return p;
	}

	public static SalaryRecord getSalaryRecord(SalaryRecordRequest request) {
		SalaryRecord r = new SalaryRecord();
		r.setId(request.getId());
		r.setMonth(request.getMonth());
		r.setDeduction(request.getDeduction());
		r.setFinalPayment(request.getFinalAmount());
		r.setNoOfLeaves(request.getNoOfLeaves());
		r.setEmployee(new Employee(request.getEmployeeId()));
		return r;
	}

	public static Expense getExpense(ExpenseRequest request) {
		Expense e = new Expense();
		e.setId(request.getId());
		e.setAmount(request.getAmount());
		e.setCategory(request.getCategory());
		e.setGoods(request.getGoods());
		e.setNote(request.getNote());
		e.setTransactionDate(request.getTransactionDate());
		e.setUser(new User(request.getUserId()));
		e.setPaid(request.getPaid());
		return e;
	}
	
	public static List<ExpenseResponse> getExpenseResponse(List<Expense> list) {
		List<ExpenseResponse> res = new ArrayList<ExpenseResponse>();
		if(list == null) {
			return res;
		}
		for(Expense e : list) {
			res.add(getExpenseResponse(e));
		}
		return res;
	}
	
	public static ExpenseResponse getExpenseResponse(Expense e) {
		ExpenseResponse r = new ExpenseResponse();
		r.setAmount(e.getAmount());
		r.setCategory(e.getCategory());
		r.setGoods(e.getGoods());
		r.setTransactionDate(e.getTransactionDate());
		r.setId(e.getId());
		r.setNote(e.getNote());
		r.setPaid(e.getPaid());
		r.setUserName(e.getUser().getUserName());
		return r;
	}
	
	public static Map<Long, List<OrderItemResponse>> getTransactionResponse(List<ItemTransaction> stocks) {
		Map<Long, List<OrderItemResponse>> map = new HashMap<Long, List<OrderItemResponse>>();
		for(ItemTransaction stock : stocks) {
			map.put(stock.getTransactionDate().getTime(), ServiceRequestUtil.getOrderItemResponse(stock.getItemTransactionDetails(), "SOLD"));
		}
		return map;
	}
	
	private static ItemTransactionResponse getTransactionResponse(ItemTransaction t) {
		ItemTransactionResponse res = new ItemTransactionResponse();
		res.setId(t.getId());
		res.setTransactionDate(t.getTransactionDate());
		res.setTransactionType(t.getTransactionType());
		res.setUserName(t.getUser().getUserName());
		res.setItems(getOrderItemResponse(t.getItemTransactionDetails(), t.getTransactionType(), res));
		return res;
	}

	public static List<OrderItemResponse> getOrderItemResponse(List<ItemTransactionDetails> items, String transactionType, ItemTransactionResponse res) {
		List<OrderItemResponse> list = new ArrayList<OrderItemResponse>();
		Double total=0.0;
		for(ItemTransactionDetails tranItem : items) {
			Item item = tranItem.getItem();
			Double price = Constants.TRAN_TYPE_SOLD.equals(transactionType) ? tranItem.getQuantity()*item.getItemPrice() : null;
			list.add(new OrderItemResponse(item.getItemName(), tranItem.getQuantity(), price));
			if(price != null) {
				total = total + price;
			}
		}
		res.setTotal(total);
		return list;
	}
	
	public static List<OrderItemResponse> getOrderItemResponse(List<ItemTransactionDetails> items, String transactionType) {
		List<OrderItemResponse> list = new ArrayList<OrderItemResponse>();
		Double total=0.0;
		for(ItemTransactionDetails tranItem : items) {
			Item item = tranItem.getItem();
			Double price = Constants.TRAN_TYPE_SOLD.equals(transactionType) ? tranItem.getQuantity()*item.getItemPrice() : null;
			list.add(new OrderItemResponse(item.getItemName(), tranItem.getQuantity(), price));
			if(price != null) {
				total = total + price;
			}
		}
		return list;
	}

	public static Double getOrderTotal(OrderInfo e) {
		Double amount=0.0;
		List<OrderInfoDetails> details = e.getItems();
		for(OrderInfoDetails d : details) {
			amount+=d.getQuantity()*d.getItem().getItemPrice();
		}
		return amount;
	}
}
