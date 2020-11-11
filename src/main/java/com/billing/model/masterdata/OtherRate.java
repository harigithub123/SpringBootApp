package com.billing.model.masterdata;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.billing.model.shipper.Shipper;

import lombok.Data;

@Entity

@Data
@IdClass(OtherRateId.class)
public class OtherRate implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
	@JoinColumn(name="shipper_id")
	private Shipper shipper;
	
	@Id
	@Column(length = 10)
	private String shipmentType;
	
	@Id
	@Column(length = 8)
	private String mode;
	
	@Id
	@Column(length = 10)
	private String modeClass;
	
	@Id
	@Column(length = 10)
	private String packageType;
	
	private String destination;
	
	private double amount;
	
	private double rules;
	
	private boolean needToIncludeInFreight;
	
	public Shipper getShipper() {
		return shipper;
	}
	public void setShipper(Shipper shipper) {
		this.shipper = shipper;
	}
	public String getShipmentType() {
		return shipmentType;
	}
	public void setShipmentType(String shipmentType) {
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
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public double getRules() {
		return rules;
	}
	public void setRules(double rules) {
		this.rules = rules;
	}
	public boolean isNeedToIncludeInFreight() {
		return needToIncludeInFreight;
	}
	public void setNeedToIncludeInFreight(boolean needToIncludeInFreight) {
		this.needToIncludeInFreight = needToIncludeInFreight;
	}
	
}
