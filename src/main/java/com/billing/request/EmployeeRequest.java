package com.billing.request;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.billing.constants.AppConstants;
import com.fasterxml.jackson.annotation.JsonProperty;

public class EmployeeRequest implements Serializable {

		private static final long serialVersionUID = -187514924337443316L;
		
		//@JsonProperty("id")
		private Long id;
		
		//@JsonProperty("person_id")
		private Long personId;
		
		//@JsonProperty("joining_date")
		private Date joiningDate;
		
		//@JsonProperty("month_salary")
		private double monthSalary;
		
		//@JsonProperty("person_name")
		@NotNull(message="MISSING_PERSON_NME")
		private String name;
		
		@Size(min=10, max=10, message="INVALID_MOBILE_NUMBER")
		@NotNull(message="MISSING_MOBILE_NUMBER")
		//@JsonProperty("mobile_number")
		private String mobileNumber;

		//@NotNull(message="MISSING_OFFICE_NAME")
		//@Size(min=10, max=10, message="INVALID_MOBILE_NUMBER")
		//@JsonProperty("aadhar_number")
		private String aadharNo;
		
		//@NotNull(message="MISSING_CONTACT_PERSON")
		//@JsonProperty("pan_number")
		private String panNo;
		
		//@NotNull(message="MISSING_EMAIL_ID")
		//@Pattern(regexp=AppConstants.EMAIL_REGEX, message="INVALID_EMAIL_ID")
		//@JsonProperty("dob")
		private Date dob;
		
		//@NotNull(message="MISSING_CONTACT_PERSON")
		//@JsonProperty("address")
		private String address;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public Long getPersonId() {
			return personId;
		}

		public void setPersonId(Long personId) {
			this.personId = personId;
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
