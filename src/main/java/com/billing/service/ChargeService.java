package com.billing.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.billing.model.masterdata.Charge;

@Service
public interface ChargeService {

	public void addCharge(Charge p);
	public void updateCharge(Charge p);
	public List<Charge> listCharges();
	public Charge getChargeById(Long id);
	public void removeCharge(Long id);
}
