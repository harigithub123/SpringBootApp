package com.billing.response;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
public class BillResponse implements Serializable {

		private static final long serialVersionUID = -187514924337443316L;
		
		private String message;
		
		@JsonProperty("from-date")
		private Date fromDate;
		
		@JsonProperty("to-date")
		private Date toDate;
		
		@JsonProperty("office-name")
		private String officeName;
		
		@JsonProperty("final-total")
		private Double total;
		
		@JsonProperty("items")
		private List<OrderItemResponse> items;
		
		public BillResponse() {
			
		}
		public BillResponse(String message) {
			super();
			this.message = message;
		}

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

		public String getOfficeName() {
			return officeName;
		}

		public void setOfficeName(String officeName) {
			this.officeName = officeName;
		}

		public Double getTotal() {
			return total;
		}

		public void setTotal(Double total) {
			this.total = total;
		}

		public List<OrderItemResponse> getItems() {
			return items;
		}

		public void setItems(List<OrderItemResponse> items) {
			this.items = items;
		}

		public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}

}
