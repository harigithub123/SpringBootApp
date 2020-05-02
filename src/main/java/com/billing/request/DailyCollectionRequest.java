
package com.billing.request;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DailyCollectionRequest  implements Serializable {

	private static final long serialVersionUID = -187514924337443316L;
	
	//@JsonProperty("id")
	private Long id;
	
	//@JsonProperty("cash")
	//@NotNull(message="MISSING_PERSON_NME")
	private Double cash;
	
	//@Size(min=10, max=10, message="INVALID_MOBILE_NUMBER")
	//@NotNull(message="MISSING_MOBILE_NUMBER")
	//@JsonProperty("online")
	private Double online;

	//@NotNull(message="MISSING_EMAIL_ID")
	//@Pattern(regexp=AppConstants.EMAIL_REGEX, message="INVALID_EMAIL_ID")
	//@JsonProperty("credit")
	private Double credit;
	
	//@JsonProperty("transaction-date")
	private Date transactionDate;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}
	
}

