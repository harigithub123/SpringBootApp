package com.billing.dto.masterdata;

import java.io.Serializable;

public class FreightRateDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long shipperId;
	private String destination;
	private String zone;
	private String mode;
	private String modeClass;
	private String packageType;
	private int transitTime;
	private double amount;
	private double startWeight;
	private double endWeight;
	private double weightSlab;
	private double slabRate;
	
	public Long getShipperId() {
		return shipperId;
	}
	public void setShipperId(Long shipperId) {
		this.shipperId = shipperId;
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
	public int getTransitTime() {
		return transitTime;
	}
	public void setTransitTime(int transitTime) {
		this.transitTime = transitTime;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public double getStartWeight() {
		return startWeight;
	}
	public void setStartWeight(double startWeight) {
		this.startWeight = startWeight;
	}
	public double getEndWeight() {
		return endWeight;
	}
	public void setEndWeight(double endWeight) {
		this.endWeight = endWeight;
	}
	public double getWeightSlab() {
		return weightSlab;
	}
	public void setWeightSlab(double weightSlab) {
		this.weightSlab = weightSlab;
	}
	public double getSlabRate() {
		return slabRate;
	}
	public void setSlabRate(double slabRate) {
		this.slabRate = slabRate;
	}
	
}
