package com.billing.constants;


public enum ErrorCode {
	
	MISSING_ID("MISSING_ID","Mandatory attribute missing: item-id"),
	
	MISSING_ITEM_NAME("MISSING_ITEM_NAME","Mandatory attribute missing: item-name"),
	MISSING_DISPLAY_ORDER("MISSING_DISPLAY_ORDER","Mandatory attribute missing: display-order"),
	MISSING_ITEM_PRICE("MISSING_ITEM_PRICE","Mandatory attribute missing: item-price"),
	
	MISSING_TRANSACTION_DATE("MISSING_TRANSACTION_DATE","Mandatory attribute missing: transaction-date"),
	MISSING_TRANSACTION_MODE("MISSING_TRANSACTION_MODE","Mandatory attribute missing: transaction-mode"),
	MISSING_TRANSACTION_AMOUNT("MISSING_TRANSACTION_AMOUNT","Mandatory attribute missing: transaction-amount"),
	MISSING_RECEIVED_BY("MISSING_RECEIVED_BY","Mandatory attribute missing: received-by"),
	MISSING_CUSTOMER_ID("MISSING_CUSTOMER_ID","Mandatory attribute missing: customerd-id"),
	INVALID_TRANSACTION_AMOUNT("INVALID_TRANSACTION_AMOUNT","Invalid value specificed: transaction-amount"),
	
	MISSING_OFFICE_NO("MISSING_OFFICE_NO","Mandatory attribute missing: office-no"),
	MISSING_OFFICE_NAME("MISSING_OFFICE_NAME","Mandatory attribute missing: office-name"),
	MISSING_CONTACT_PERSON("MISSING_CONTACT_PERSON","Mandatory attribute missing: contact-person"),
	
	MISSING_USER_ID("MISSING_USER_ID","Mandatory attribute missing: user-id"),
	MISSING_NAME("MISSING_NAME","Mandatory attribute missing: name"),
	MISSING_EMAIL_ID("MISSING_EMAIL_ID","Mandatory attribute missing: email-id"),
	MISSING_PHONE_NUMBER("MISSING_PHONE_NUMBER","Mandatory attribute missing: phone-number"),
	MISSING_USER_TYPE("MISSING_USER_TYPE","Mandatory attribute missing: user-type"),
	MISSING_DOB("MISSING_DATE_OF_BIRTH","Mandatory attribute missing: dob"),

	
	INVALID_EMAIL_ID("INVALID_EMAIL_ID","Invalid value specificed: email-id"),
	INVALID_PHONE_NUMBER("INVALID_PHONE_NUMBER","Invalid value specificed: phone-number"),
	INVALID_USER_TYPE("INVALID_USER_TYPE","Invalid value specificed: user-type");
	
	private ErrorCode(String code,	String message) {
		this.code = code;
		this.message=message;
	}
	
	String code;
	String message;
	public String getCode() {
		return code;
	}
	
	public String getMessage() {
		return message;
	}
	
	
	

}
