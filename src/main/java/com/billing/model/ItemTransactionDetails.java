package com.billing.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity 

@Data
public class ItemTransactionDetails {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonIgnore
    private Long id;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name="transaction_id")
	@JsonBackReference
	private ItemTransaction itemTransaction;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
	@JoinColumn(name="item_id")
	private Item item;
	
	private Double quantity;

	public ItemTransactionDetails() {
		
	}
	
	public ItemTransactionDetails(Item item2, Double transactionStock, ItemTransaction transaction) {
		this.item = item2;
		this.quantity = transactionStock;
		this.itemTransaction = transaction;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ItemTransaction getItemTransaction() {
		return itemTransaction;
	}

	public void setItemTransaction(ItemTransaction itemTransaction) {
		this.itemTransaction = itemTransaction;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public Double getQuantity() {
		return quantity;
	}

	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}
	
}
