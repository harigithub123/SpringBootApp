package com.billing.request;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TallyRequest implements Serializable {

		private static final long serialVersionUID = -187514924337443316L;
		
		//@JsonProperty("from-date")
		private Date fromDate;
		
		//@JsonProperty("to-date")
		private Date toDate;
		
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

}
