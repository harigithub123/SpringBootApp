package com.billing.model.masterdata;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.billing.model.shipper.Shipper;

import lombok.Data;

@Entity

@Data
@IdClass(PreferenceId.class)
public class Preference implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

/*	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;*/
	
	@Id
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
	@JoinColumn(name="shipper_id")
	private Shipper shipper;
	
	@Id
	private String columnName;
	
	private int displayOrder;
	private double columnSize;
	private String alignment;
	
	public Shipper getShipper() {
		return shipper;
	}
	public void setShipper(Shipper shipper) {
		this.shipper = shipper;
	}
	public String getColumnName() {
		return columnName;
	}
	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}
	public double getColumnSize() {
		return columnSize;
	}
	public void setColumnSize(double columnSize) {
		this.columnSize = columnSize;
	}
	public int getDisplayOrder() {
		return displayOrder;
	}
	public void setDisplayOrder(int displayOrder) {
		this.displayOrder = displayOrder;
	}
	public String getAlignment() {
		return alignment;
	}
	public void setAlignment(String alignment) {
		this.alignment = alignment;
	}
	
}
