package com.billing.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;

@Entity 

@Data
public class ItemTransaction {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonIgnore
    private Long id;
	
	@OneToMany(mappedBy="itemTransaction", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@Column(nullable = true)
	@JsonManagedReference
	private List<ItemTransactionDetails> itemTransactionDetails;
	
	private String transactionType;
	
	private Date transactionDate;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
	@JoinColumn(name="user_id")
	private User user;
	
	public ItemTransaction(){
		
	}
	
	public ItemTransaction(Long id) {
		this.id = id;
	}
	
	public ItemTransaction(User user, Double transactionStock, String tranType, Date saleDate) {
		this.user = user;
		this.transactionType = tranType;
		this.transactionDate = saleDate;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public List<ItemTransactionDetails> getItemTransactionDetails() {
		return itemTransactionDetails;
	}

	public void setItemTransactionDetails(List<ItemTransactionDetails> itemTransactionDetails) {
		this.itemTransactionDetails = itemTransactionDetails;
	}

	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	public Date getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}
