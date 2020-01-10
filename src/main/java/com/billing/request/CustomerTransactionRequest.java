package com.billing.request;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CustomerTransactionRequest  implements Serializable {

	private static final long serialVersionUID = -187514924337443316L;
	
	@JsonProperty("transaction-date")
	@NotNull(message="MISSING_TRANSACTION_DATE")
	private Date tranDate;
	
	@NotNull(message="MISSING_TRANSACTION_MODE")
	@JsonProperty("transaction-mode")
	private String tranMode;
	
	@NotNull(message="MISSING_TRANSACTION_AMOUNT")
	@JsonProperty("transaction-amount")
	private Double tranAmount;
	
	@NotNull(message="MISSING_RECEIVED_BY")
	@JsonProperty("received-by")
	private String receivedBy;

	@JsonProperty("transaction-comment")
	private String tranComment;

	@NotNull(message="MISSING_CUSTOMER_ID")
	@JsonProperty("customerd-id")
	private Long customerId;

	public Date getTranDate() {
		return tranDate;
	}

	public void setTranDate(Date tranDate) {
		this.tranDate = tranDate;
	}

	public String getTranMode() {
		return tranMode;
	}

	public void setTranMode(String tranMode) {
		this.tranMode = tranMode;
	}

	public Double getTranAmount() {
		return tranAmount;
	}

	public void setTranAmount(Double tranAmount) {
		this.tranAmount = tranAmount;
	}

	public String getReceivedBy() {
		return receivedBy;
	}

	public void setReceivedBy(String receivedBy) {
		this.receivedBy = receivedBy;
	}

	public String getTranComment() {
		return tranComment;
	}

	public void setTranComment(String tranComment) {
		this.tranComment = tranComment;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	
}
