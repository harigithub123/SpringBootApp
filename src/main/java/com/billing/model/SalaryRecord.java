package com.billing.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Data;

@Entity 

@Data
public class SalaryRecord {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
	@JoinColumn(name="employee_id")
	private Employee employee;
	
	private double finalPayment;
	
	private Integer noOfLeaves;
	
	private double deduction;
	
	private String month;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public double getFinalPayment() {
		return finalPayment;
	}

	public void setFinalPayment(double finalPayment) {
		this.finalPayment = finalPayment;
	}

	public Integer getNoOfLeaves() {
		return noOfLeaves;
	}

	public void setNoOfLeaves(Integer noOfLeaves) {
		this.noOfLeaves = noOfLeaves;
	}

	public double getDeduction() {
		return deduction;
	}

	public void setDeduction(double deduction) {
		this.deduction = deduction;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}
	
}

