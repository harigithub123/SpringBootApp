package com.billing.model.masterdata;

import java.io.Serializable;
import java.util.Objects;


public class PreferenceId implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long shipper;
	private String columnName;
	
	public PreferenceId() {
		
	}
	
	public PreferenceId(Long shipper, String columnName) {
		super();
		this.shipper = shipper;
		this.columnName = columnName;
	}
	
	public Long getShipper() {
		return shipper;
	}

	public void setShipper(Long shipper) {
		this.shipper = shipper;
	}

	public String getColumnName() {
		return columnName;
	}

	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}

	@Override
	 public int hashCode() {
	  int hash = 5;
	  hash = 83 * hash + this.shipper.intValue();
	  hash = 83 * hash + Objects.hashCode(this.columnName);
	  return hash;
	 }
	 
	 @Override
	 public boolean equals(Object obj) {
	  if (obj == null) {
	   return false;
	  }
	  if (getClass() != obj.getClass()) {
	   return false;
	  }
	  final PreferenceId other = (PreferenceId) obj;
	  if (this.shipper != other.shipper) {
	   return false;
	  }
	  if (!Objects.equals(this.columnName, other.columnName)) {
	   return false;
	  }
	  return true;
	 } 
}
