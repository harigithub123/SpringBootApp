package com.billing.model.masterdata;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.billing.model.shipper.Shipper;
import com.billing.service.util.SpringAttributeConverter;

import lombok.Data;

@Entity

@Data
@IdClass(FreightRateId.class)
public class FreightRate implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
	@JoinColumn(name="shipper_id")
	private Shipper shipper;
	
	@Id
	@Column(length = 30)
	private String destination;
	
	@Id
	@Column(length = 4)
	private String zone;
	
	@Id
	@Column(length = 10)
	private String mode;

	@Id
	@Column(length = 10)
	private String modeClass;
	
	@Id
	@Column(length = 10)
	private String packageType;
	
	private int transitTime;
	
	@Convert(converter = SpringAttributeConverter.class)
	private double amount;
	
	private double startWeight;
	private double endWeight;
	private double weightSlab;
	
	@Convert(converter = SpringAttributeConverter.class)
	private double slabRate;
	
	public Shipper getShipper() {
		return shipper;
	}
	public void setShipper(Shipper shipper) {
		this.shipper = shipper;
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
