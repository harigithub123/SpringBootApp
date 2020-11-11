package com.billing.model.masterdata;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.IdClass;

public class OtherRateId implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long shipper;
	private String shipmentType;
	private String mode;
	private String modeClass;
	private String packageType;
	
	public OtherRateId() {
		
	}

	public OtherRateId(Long shipper, String shipmentType, String mode,
			String modeClass, String packageType) {
		super();
		this.shipper = shipper;
		this.mode = mode;
		this.modeClass = modeClass;
		this.packageType = packageType;
		this.shipmentType = shipmentType;
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	public String getModeClass() {
		return modeClass;
	}

	public void setModeClass(String modeClass) {
		this.modeClass = modeClass;
	}

	public String getPackageType() {
		return packageType;
	}

	public void setPackageType(String packageType) {
		this.packageType = packageType;
	}

	public Long getShipper() {
		return shipper;
	}

	public void setShipper(Long shipper) {
		this.shipper = shipper;
	}

	@Override
	 public int hashCode() {
	  int hash = 5;
	  hash = 83 * hash + this.shipper.intValue();
	  hash = 83 * hash + Objects.hashCode(this.shipmentType);
	  hash = 83 * hash + Objects.hashCode(this.mode);
	  hash = 83 * hash + Objects.hashCode(this.modeClass);
	  hash = 83 * hash + Objects.hashCode(this.packageType);
	  
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
	  final OtherRateId other = (OtherRateId) obj;
	  if (this.shipper != other.shipper) {
	   return false;
	  }
	  
	  if (!Objects.equals(this.mode, other.mode)) {
		   return false;
		  }
	  
	  if (!Objects.equals(this.modeClass, other.modeClass)) {
		   return false;
		  }
	  
	  if (!Objects.equals(this.packageType, other.packageType)) {
		   return false;
		  }
	  
	  if (!Objects.equals(this.shipmentType, other.packageType)) {
		   return false;
		  }
	  
	  return true;
	 } 
}
