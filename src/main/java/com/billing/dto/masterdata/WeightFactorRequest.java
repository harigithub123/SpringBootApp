package com.billing.dto.masterdata;

import javax.validation.constraints.NotNull;

public class WeightFactorRequest {
	
	private Long id;
	
	@NotNull(message="MISSING_SHIPPER_ID")
	private Long shipperId;
	
	@NotNull(message="MISSING_MODE")
	private String mode;
	
	@NotNull(message="MISSING_MODE_CLASS")
	private String modeClass;
	
	@NotNull(message="MISSING_PACKAGE_TYPE")
	private String packageType;
	
	private String slots;
	
	@NotNull(message="MISSING_MIN_WEIGHT")
	private double minWeight;
	
	@NotNull(message="MISSING_WEIGHT_SLAB")
	private double weightSlab;
	
	@NotNull(message="MISSING_VOLUMETRIC_FACTOR")
	private double volumetricFactor;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getShipperId() {
		return shipperId;
	}
	public void setShipperId(Long shipperId) {
		this.shipperId = shipperId;
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
	public String getSlots() {
		return slots;
	}
	public void setSlots(String slots) {
		this.slots = slots;
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
	public double getVolumetricFactor() {
		return volumetricFactor;
	}
	public void setVolumetricFactor(double volumetricFactor) {
		this.volumetricFactor = volumetricFactor;
	}

}

