package com.billing.request;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PayBillRequest implements Serializable {

		private static final long serialVersionUID = -187514924337443316L;
		
		@JsonProperty("payment-date")
		private Date paymentDate;
		
		@JsonProperty("paid-amount")
		private Double paidAmount;
		
		@JsonProperty("bill-no")
		private Long billNo;

		public Date getPaymentDate() {
			return paymentDate;
		}

		public void setPaymentDate(Date paymentDate) {
			this.paymentDate = paymentDate;
		}

		public Double getPaidAmount() {
			return paidAmount;
		}

		public void setPaidAmount(Double paidAmount) {
			this.paidAmount = paidAmount;
		}

		public Long getBillNo() {
			return billNo;
		}

		public void setBillNo(Long billNo) {
			this.billNo = billNo;
		} 
		
}
