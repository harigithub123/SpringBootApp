package com.billing.model.masterdata;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.billing.model.MetaDataId;
import com.billing.model.shipper.Shipper;

import lombok.Data;

@Entity

@Data
@IdClass(MetaDataId.class)
public class WeightFactor {
	
	@Id
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
	@JoinColumn(name="shipper_id")
	private Shipper shipper;
	
	@Id
	private String mode;
	
	@Id
	private String modeClass;
	
	@Id
	private String packageType;
	
	private double volumetricFactor;
	private double minWeight;
	private double weightSlab;
	private String slots;
	
	
	public WeightFactor() {
		super();
	}
	public WeightFactor(Shipper shipper, String mode, String modeClass, String packageType, double volumetricFactor,
			double minWeight, double weightSlab, String slots) {
		super();
		this.shipper = shipper;
		this.mode = mode;
		this.modeClass = modeClass;
		this.packageType = packageType;
		this.volumetricFactor = volumetricFactor;
		this.minWeight = minWeight;
		this.weightSlab = weightSlab;
		this.slots = slots;
	}
	public Shipper getShipper() {
		return shipper;
	}
	public void setShipper(Shipper shipper) {
		this.shipper = shipper;
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
	public double getVolumetricFactor() {
		return volumetricFactor;
	}
	public void setVolumetricFactor(double volumetricFactor) {
		this.volumetricFactor = volumetricFactor;
	}
	public double getMinWeight() {
		return minWeight;
	}
	public void setMinWeight(double minWeight) {
		this.minWeight = minWeight;
	}
	public double getWeightSlab() {
		return weightSlab;
	}
	public void setWeightSlab(double weightSlab) {
		this.weightSlab = weightSlab;
	}
	public String getSlots() {
		return slots;
	}
	public void setSlots(String slots) {
		this.slots = slots;
	}
	
}
