package com.billing.dto;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class EmployeeRequest implements Serializable {

		private static final long serialVersionUID = -187514924337443316L;
		
		private Long id;
		
		private Date joiningDate;
		
		private double monthSalary;
		
		@NotNull(message="MISSING_PERSON_NME")
		private String name;
		
		@Size(min=10, max=10, message="INVALID_MOBILE_NUMBER")
		@NotNull(message="MISSING_MOBILE_NUMBER")
		private String mobileNumber;

		private String aadharNo;
		
		private String panNo;
		
		private Date dob;
		
		private String address;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public Date getJoiningDate() {
			return joiningDate;
		}

		public void setJoiningDate(Date joiningDate) {
			this.joiningDate = joiningDate;
		}

		public double getMonthSalary() {
			return monthSalary;
		}

		public void setMonthSalary(double monthSalary) {
			this.monthSalary = monthSalary;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getMobileNumber() {
			return mobileNumber;
		}

		public void setMobileNumber(String mobileNumber) {
			this.mobileNumber = mobileNumber;
		}

		public String getAadharNo() {
			return aadharNo;
		}

		public void setAadharNo(String aadharNo) {
			this.aadharNo = aadharNo;
		}

		public String getPanNo() {
			return panNo;
		}

		public void setPanNo(String panNo) {
			this.panNo = panNo;
		}

		public Date getDob() {
			return dob;
		}

		public void setDob(Date dob) {
			this.dob = dob;
		}

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}

}
