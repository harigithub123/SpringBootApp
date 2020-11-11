package com.billing.dto;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BillRequest implements Serializable {

		private static final long serialVersionUID = -187514924337443316L;
		
		private Date fromDate;
		
		private Date toDate;
		
		private Long customerId;
		
		private String billPeriod;
		
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
