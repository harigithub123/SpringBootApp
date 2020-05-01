package com.billing.response;

import java.util.Date;
import java.util.List;

public class TallyReport {

	private Date date;
	private Double expectedAmount;
	private Double actualAmount;
	private Double cash;
	private Double online;
	private Double credit;
	private Double expense;
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Double getExpectedAmount() {
		return expectedAmount;
	}
	public void setExpectedAmount(Double expectedAmount) {
		this.expectedAmount = expectedAmount;
	}
	public Double getCash() {
		return cash;
	}
	public void setCash(Double cash) {
		this.cash = cash;
	}
	public Double getOnline() {
		return online;
	}
	public void setOnline(Double online) {
		this.online = online;
	}
	public Double getCredit() {
		return credit;
	}
	public void setCredit(Double credit) {
		this.credit = credit;
	}
	public Double getExpense() {
		return expense;
	}
	public void setExpense(Double expense) {
		this.expense = expense;
	}
	public Double getActualAmount() {
		return actualAmount;
	}
	public void setActualAmount(Double actualAmount) {
		this.actualAmount = actualAmount;
	}
	
}
