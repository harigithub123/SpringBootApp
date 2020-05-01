
package com.billing.service.impl;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.billing.dao.CustomerBillRepository;
import com.billing.dao.DailyCollectionRepository;
import com.billing.dao.ExpenseRespository;
import com.billing.dao.ItemTransactionResponsity;
import com.billing.dao.OrderInfoRepository;
import com.billing.model.BillItem;
import com.billing.model.Customer;
import com.billing.model.CustomerBill;
import com.billing.model.DailyCollection;
import com.billing.model.Expense;
import com.billing.model.ItemTransaction;
import com.billing.model.ItemTransactionDetails;
import com.billing.model.OrderInfo;
import com.billing.model.OrderInfoDetails;
import com.billing.request.BillRequest;
import com.billing.request.OrderInfoRequest;
import com.billing.request.TallyRequest;
import com.billing.response.BillResponse;
import com.billing.response.OrderInfoResponse;
import com.billing.response.OrderItemResponse;
import com.billing.response.TallyReport;
import com.billing.service.OrderInfoService;
import com.billing.service.util.Constants;
import com.billing.service.util.ServiceRequestUtil;

@Service
public class OrderInfoServiceImpl implements OrderInfoService {
	
	private OrderInfoRepository orderRespository;
	private CustomerBillRepository customerBillRespository;
	private ExpenseRespository expenseRepository;
	private DailyCollectionRepository dailyCollectionRepository;
	private ItemTransactionResponsity itemStockTransaction;
	
	ServiceRequestUtil util = new ServiceRequestUtil();
	
	public OrderInfoServiceImpl(OrderInfoRepository orderRespository, CustomerBillRepository customerBillRespository,
			ExpenseRespository expenseRepository, ItemTransactionResponsity itemStockTransaction,
			DailyCollectionRepository dailyCollectionRepository) {
		this.orderRespository = orderRespository;
		this.customerBillRespository = customerBillRespository; 
		this.expenseRepository = expenseRepository;
		this.itemStockTransaction = itemStockTransaction;
		this.dailyCollectionRepository=dailyCollectionRepository;
	}
	
	@Transactional
	public void addOrder(OrderInfoRequest request) {
		this.orderRespository.save(util.getOrder(request));
	}

	@Transactional
	public void updateOrder(OrderInfoRequest request) {
		this.orderRespository.save(util.getOrder(request));
	}

	@Transactional
	public List<OrderInfoResponse> listOrders() {
		List<OrderInfo> orders =  this.orderRespository.findAll();
		return getOrderInfoResponse(orders);
	}

	private OrderInfoResponse getOrderInfoResponse(OrderInfo order) {
		OrderInfoResponse response = new OrderInfoResponse();
		response.setId(order.getId());
		response.setOfficeName(order.getCustomer().getOfficeName());
		response.setOrderDate(order.getOrderDate());
		response.setItems(getOrderItemResponse(order.getItems()));
		return response;
	}

	
	private List<OrderInfoResponse> getOrderInfoResponse(List<OrderInfo> orders) {
		List<OrderInfoResponse> list = new ArrayList<OrderInfoResponse>();
		OrderInfoResponse response = null;
		for(OrderInfo order : orders) {
			list.add(getOrderInfoResponse(order));
		}
		return list;
	}
	
	private List<OrderItemResponse> getOrderItemResponse(List<OrderInfoDetails> items) {
		List<OrderItemResponse> list = new ArrayList<OrderItemResponse>();
		for(OrderInfoDetails item : items) {
			list.add(new OrderItemResponse(item.getItem().getItemName(), item.getQuantity(), item.getItem().getItemPrice()*item.getQuantity()));
		}
		return list;
	}

	@Transactional
	public OrderInfoResponse getOrderById(Long id) {
		Optional<OrderInfo> order = this.orderRespository.findById(id);
		if(order.isPresent()) {
			return getOrderInfoResponse(order.get());
		} else {
			return null;	
		}
	}

	@Transactional
	public void removeOrder(Long id) {
		this.orderRespository.deleteById(id);
	}

	@Override
	public OrderInfo getOrderById(int id) {
		return null;
	}

	@Override
	public void removeOrder(int id) {
	}
	
	public List<TallyReport> getTallyReport(TallyRequest tallyRequest) {
		List<TallyReport> r = new ArrayList<TallyReport>();
		List<Expense> expenses = expenseRepository.find(tallyRequest.getFromDate(), tallyRequest.getToDate());
		List<ItemTransaction> transactions = itemStockTransaction.find(tallyRequest.getFromDate(), tallyRequest.getToDate(), "SOLD");
		List<DailyCollection>  collections = this.dailyCollectionRepository.find(tallyRequest.getFromDate(), tallyRequest.getToDate());
		List<OrderInfo> orders = this.orderRespository.find(tallyRequest.getFromDate(), tallyRequest.getToDate());
		
		Map<Long, List<Expense>> l = getDateWiseExpense(expenses);
		Map<Long, ItemTransaction> itemsSale = getDateWiseTransaction(transactions);
		Map<Long, DailyCollection> collectionMap = getDateWiseCollection(collections);
		Map<Long, List<OrderInfo>> ordersMap = getDateWiseOrders(orders);
 		
		
		Set<Entry<Long, ItemTransaction>> entries = itemsSale.entrySet();
		for(Entry<Long, ItemTransaction> e : entries) {
			r.add(getTallyReport(l.get(e.getKey()), itemsSale.get(e.getKey()), collectionMap.get(e.getKey()), ordersMap.get(e.getKey())));
		}
		return r;
	}
	
	public TallyReport getTallyReport(List<Expense> expenses, ItemTransaction t, DailyCollection c, List<OrderInfo> orders) {
		TallyReport r = new TallyReport();
		Double total = 0.0;
		for(Expense e : expenses) {
			total = total + e.getAmount();
		}
		r.setExpense(total);
		
		total=0.0;
		List<ItemTransactionDetails> list = t.getItemTransactionDetails(); 
		for(ItemTransactionDetails d : list) {
			total = total + d.getQuantity()*d.getItem().getItemPrice();
		}
		r.setExpectedAmount(total);
		
		total=0.0;
		for(OrderInfo e : orders) {
			Double orderTotal = ServiceRequestUtil.getOrderTotal(e);
			total = total + orderTotal;
		}
		r.setCredit(total);
		
		r.setDate(t.getTransactionDate());
		r.setCash(c.getCash());
		r.setOnline(c.getOnline());
		r.setActualAmount(r.getCash()+r.getCredit()+r.getExpense()+r.getOnline());
		return r;
	}
	
	private Map<Long, List<Expense>> getDateWiseExpense(List<Expense> expenses) {
		Map<Long, List<Expense>> map = new HashMap<Long, List<Expense>>();
		for(Expense e : expenses) {
			if(map.containsKey(e.getTransactionDate().getTime())) {
				map.get(e.getTransactionDate().getTime()).add(e);
			} else {
				List<Expense> exp = new ArrayList<Expense>();
				exp.add(e);
				map.put(e.getTransactionDate().getTime(), exp);
			}
		}
		return map;
	}
	
	private Map<Long, ItemTransaction> getDateWiseTransaction(List<ItemTransaction> transactions) {
		Map<Long, ItemTransaction> map = new HashMap<Long, ItemTransaction>();
		for(ItemTransaction t : transactions) {
			map.put(t.getTransactionDate().getTime(), t);
		}
		return map;
	}
	
	private Map<Long, DailyCollection> getDateWiseCollection(List<DailyCollection> collections) {
		Map<Long, DailyCollection> map = new HashMap<Long, DailyCollection>();
		for(DailyCollection c : collections) {
			map.put(c.getTransactionDate().getTime(), c);
		}
		return map;
	}
	
	private Map<Long, List<OrderInfo>> getDateWiseOrders(List<OrderInfo> orders) {
		Map<Long, List<OrderInfo>> map = new HashMap<Long, List<OrderInfo>>();
		for(OrderInfo e : orders) {
			if(map.containsKey(e.getOrderDate().getTime())) {
				map.get(e.getOrderDate().getTime()).add(e);
			} else {
				List<OrderInfo> exp = new ArrayList<OrderInfo>();
				exp.add(e);
				map.put(e.getOrderDate().getTime(), exp);
			}
		}
		return map;
	}
	
	public BillResponse getLastBillEndDate(BillRequest billRequest) {
		BillResponse bill = new BillResponse();
		Long customerId = billRequest.getCustomerId();
		List<CustomerBill> bills = customerBillRespository.findLastBillDate(customerId);
		if(!bills.isEmpty()) {
			bill.setToDate(bills.get(0).getEndDate());
			return bill;
		}
		return new BillResponse("No Bill Generated for this customer as of now."); 
	}
	
	public BillResponse generateBill(BillRequest billRequest) {
		CustomerBill customerBill = new CustomerBill();
		Date fromDate = billRequest.getFromDate();
		Date toDate = billRequest.getToDate();
		Long customerId = billRequest.getCustomerId();
		List<CustomerBill> bills = customerBillRespository.find(customerId, fromDate, toDate);
		if(!bills.isEmpty()) {
			CustomerBill bill = getBillForSamePeriod(bills, fromDate, toDate);
			if(bill == null) {
				bill = bills.get(0);
				BillResponse response = new BillResponse("Bill is generated for below mentioned period which is overlapping with given dates.");
				response.setFromDate(bill.getStartDate());
				response.setToDate(bill.getEndDate());
				return response;
			}
			return getExitingBill(bills.get(0));
		}
		List<OrderInfo> orders = this.orderRespository.find(customerId, fromDate, toDate);
		BillResponse bill = getBill(orders, customerBill);
		if(!orders.isEmpty()) {
			bill.setOfficeName(orders.get(0).getCustomer().getOfficeName());
		} else {
			return new BillResponse("No Orders found between this period. So bill is not generated");
		}
		bill.setFromDate(fromDate);
		bill.setToDate(toDate);
		
		customerBill.setStartDate(fromDate);
		customerBill.setEndDate(toDate);
		customerBill.setCustomer(new Customer(customerId));
		customerBillRespository.save(customerBill);
		return bill;
	}

	private CustomerBill getBillForSamePeriod(List<CustomerBill> bills, Date fromDate, Date toDate) {
		for(CustomerBill bill : bills) {
			if(bill.getStartDate().compareTo(fromDate) == 0 && bill.getEndDate().compareTo(toDate) == 0) {
				return bill;
			}
		}
		return null;
	}

	private List<Date> populateDates(BillRequest billRequest) {
		List<Date> dates = new ArrayList<Date>();
		Date monthLastDate = billRequest.getBillLastDate();
		String billPeriod = billRequest.getBillPeriod();
		Calendar cal = Calendar.getInstance();
		cal.setTime(monthLastDate);
		int year =cal.get(Calendar.YEAR);
		int month =cal.get(Calendar.MONTH);
		if(Constants.PERIOR_FIRST_TO_TEN.equals(billPeriod)) {
			dates.add(new GregorianCalendar(year, month, 1).getTime());
			dates.add(new GregorianCalendar(year, month, 10).getTime());
		} else if(Constants.PERIOR_ELEV_TO_TWENTY.equals(billPeriod)) {
			dates.add(new GregorianCalendar(year, month, 11).getTime());
			dates.add(new GregorianCalendar(year, month, 20).getTime());
		} else if(Constants.PERIOR_TWENTY_ONE_TO_LAST.equals(billPeriod)) {
			dates.add(new GregorianCalendar(year, month, 21).getTime());
			dates.add(monthLastDate);
		} else {
			dates.add(new GregorianCalendar(year, month, 1).getTime());
			dates.add(monthLastDate);
		}
		return dates;
	}

	private BillResponse getExitingBill(CustomerBill customerBill) {
		BillResponse bill = new BillResponse();
		List<OrderItemResponse> responseItems = new LinkedList<OrderItemResponse>();
		bill.setFromDate(customerBill.getStartDate());
		bill.setToDate(customerBill.getEndDate());
		bill.setOfficeName(customerBill.getCustomer().getOfficeName());
		bill.setTotal(customerBill.getBillAmount());
		for(BillItem billItem : customerBill.getItems()) {
			responseItems.add(new OrderItemResponse(billItem.getItem().getItemName(), billItem.getQuantity(),
					billItem.getItem().getItemPrice() * billItem.getQuantity()));
		}
		bill.setItems(responseItems);
		return bill;
	}

	private BillResponse getBill(List<OrderInfo> orders, CustomerBill customerBill) {
		BillResponse bill = new BillResponse();
		List<OrderItemResponse> reponseItems = new LinkedList<OrderItemResponse>();
		List<BillItem> billItems = new LinkedList<BillItem>();
		Map<String, Double> itemMap = new HashMap<String, Double>();
		Map<String, Double> itemPricing = new HashMap<String, Double>();
		Map<String, Long> itemNameIdMap = new HashMap<String, Long>();
		Double finalTotal = 0.0;
		populateOrderDetails(orders, itemMap, itemPricing, itemNameIdMap);
		Set<Entry<String, Double>> entrySet = itemMap.entrySet();
		for(Entry<String, Double> entry : entrySet) {
			Double total = entry.getValue() * itemPricing.get(entry.getKey());
			finalTotal += total;
			reponseItems.add(new OrderItemResponse(entry.getKey() + "", entry.getValue(), total));
			billItems.add(new BillItem(itemNameIdMap.get(entry.getKey()), entry.getValue(), customerBill));
		}
		bill.setTotal(finalTotal);
		customerBill.setBillAmount(finalTotal);
		customerBill.setItems(billItems);
		bill.setItems(reponseItems);
		return bill;
	}

	private void populateOrderDetails(List<OrderInfo> orders, Map<String, Double> itemMap,
			Map<String, Double> itemPricing, Map<String, Long> itemNameIdMap) {
		for(OrderInfo order : orders) {
			List<OrderInfoDetails> items =  order.getItems();
			for(OrderInfoDetails orderItem : items) {
				if(itemMap.containsKey(orderItem.getItem().getItemName())) {
					itemMap.put(orderItem.getItem().getItemName(), itemMap.get(orderItem.getItem().getItemName())+orderItem.getQuantity());
				} else {
					itemMap.put(orderItem.getItem().getItemName(), orderItem.getQuantity());
				}
				itemPricing.put(orderItem.getItem().getItemName(), orderItem.getItem().getItemPrice());
				itemNameIdMap.put(orderItem.getItem().getItemName(), orderItem.getItem().getId());
			}
		}
	}
	
}
