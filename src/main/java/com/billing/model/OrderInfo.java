package com.billing.model;

import java.util.Date;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Entity 

@Data
public class OrderInfo {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	private String customerId;
	private Date orderDate;
	
	@OneToMany(mappedBy = "orderInfo", cascade = CascadeType.ALL)
	private Set<Object> items;
	
	public OrderInfo(String customerId, OrderItem items, Date orderDate) {
        this.customerId = customerId;
        this.items = Stream.of(items).collect(Collectors.toSet());
        this.orderDate = orderDate;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public Set<Object> getItems() {
		return items;
	}

	public void setItems(Set<Object> items) {
		this.items = items;
	}
	
}
