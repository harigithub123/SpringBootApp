package com.billing.response;


public class WeightFactorResponse {
	
	private Long shipperId;
	private String mode;
	private String modeClass;
	private String packageType;
	private String slots;
	private double minWeight;
	private double weightSlab;
	private double volumetricFactor;
	
	public WeightFactorResponse() {
		super();
	}
	public WeightFactorResponse(Long shipperId, String mode, String modeClass, String packageType, String slots,
			double minWeight, double weightSlab, double volumetricFactor) {
		super();
		this.shipperId = shipperId;
		this.mode = mode;
		this.modeClass = modeClass;
		this.packageType = packageType;
		this.slots = slots;
		this.minWeight = minWeight;
		this.weightSlab = weightSlab;
		this.volumetricFactor = volumetricFactor;
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
