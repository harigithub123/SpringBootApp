package com.billing.model.masterdata;

import java.io.Serializable;
import java.util.Objects;

public class FreightRateId implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long shipper;
	private String destination;
	private String zone;
	private String mode;
	private String modeClass;
	private String packageType;
	
	public FreightRateId() {
		
	}

	public FreightRateId(Long shipper, String destination, String zone, String mode,
			String modeClass, String packageType) {
		super();
		this.shipper = shipper;
		this.destination = destination;
		this.zone = zone;
		this.mode = mode;
		this.modeClass = modeClass;
		this.packageType = packageType;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getZone() {
		return zone;
	}

	public void setZone(String zone) {
		this.zone = zone;
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
	  hash = 83 * hash + Objects.hashCode(this.destination);
	  hash = 83 * hash + Objects.hashCode(this.zone);
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
	  final FreightRateId other = (FreightRateId) obj;
	  if (this.shipper != other.shipper) {
	   return false;
	  }
	  
	  if (!Objects.equals(this.destination, other.destination)) {
		   return false;
		  }
	  
	  if (!Objects.equals(this.zone, other.zone)) {
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
	  
	  return true;
	 } 
}
