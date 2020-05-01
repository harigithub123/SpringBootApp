package com.billing.response;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ExpenseResponse implements Serializable {

		private static final long serialVersionUID = -187514924337443316L;
		
		@JsonProperty("id")
		private Long id;
		
		@NotNull(message="category")
		private String category;
		
		@JsonProperty("transaction-date")
		private Date transactionDate;
		
		@JsonProperty("amount")
		private double amount;
		
		@JsonProperty("goods")
		private String goods;

		@JsonProperty("user-name")
		private String userName;
		
		@JsonProperty("note")
		private String note;
		
		@JsonProperty("paid")
		private String paid;
		
		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getCategory() {
			return category;
		}

		public void setCategory(String category) {
			this.category = category;
		}

		public Date getTransactionDate() {
			return transactionDate;
		}

		public void setTransactionDate(Date transactionDate) {
			this.transactionDate = transactionDate;
		}

		public double getAmount() {
			return amount;
		}

		public void setAmount(double amount) {
			this.amount = amount;
		}

		public String getGoods() {
			return goods;
		}

		public void setGoods(String goods) {
			this.goods = goods;
		}

		public String getUserName() {
			return userName;
		}

		public void setUserName(String userName) {
			this.userName = userName;
		}

		public String getNote() {
			return note;
		}

		public void setNote(String note) {
			this.note = note;
		}

		public String getPaid() {
			return paid;
		}

		public void setPaid(String paid) {
			this.paid = paid;
		}

}
