package com.billing.request;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BillRequest implements Serializable {

		private static final long serialVersionUID = -187514924337443316L;
		
		@JsonProperty("from-date")
		private Date fromDate;
		
		@JsonProperty("to-date")
		private Date toDate;
		
		@JsonProperty("customer-id")
		private Long customerId;
		
		@JsonProperty("bill-period")
		private String billPeriod;
		
		@JsonProperty("month-last-date")
		private Date billLastDate;

		public Date getFromDate() {
			return fromDate;
		}

		public void setFromDate(Date fromDate) {
			this.fromDate = fromDate;
		}

		public Date getToDate() {
			return toDate;
		}

		public void setToDate(Date toDate) {
			this.toDate = toDate;
		}

		public Long getCustomerId() {
			return customerId;
		}

		public void setCustomerId(Long customerId) {
			this.customerId = customerId;
		}

		public String getBillPeriod() {
			return billPeriod;
		}

		public void setBillPeriod(String billPeriod) {
			this.billPeriod = billPeriod;
		}

		public Date getBillLastDate() {
			return billLastDate;
		}

		public void setBillLastDate(Date billLastDate) {
			this.billLastDate = billLastDate;
		}
		
}
