package com.billing.service.impl;


import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.billing.dao.ChargeRepository;
import com.billing.model.masterdata.Charge;
import com.billing.service.ChargeService;

@Service
public class ChargeServiceImpl implements ChargeService {
	
	private ChargeRepository shipperRespository;
	
	public ChargeServiceImpl(ChargeRepository shipperRepository) {
		this.shipperRespository = shipperRepository;
	}

	@Override
	public void addCharge(Charge charge) {
		this.shipperRespository.save(charge);
	}

	@Override
	public void updateCharge(Charge charge) {
		this.shipperRespository.save(charge);
	}

	@Override
	public List<Charge> listCharges() {
		return this.shipperRespository.findAll();
	}

	@Override
	public Charge getChargeById(Long id) {
		Optional<Charge> shipper = this.shipperRespository.findById(id);
		if(shipper != null) {
			return shipper.get();
		}
		return null;
	}

	@Override
	public void removeCharge(Long id) {
		this.shipperRespository.deleteById(id);
		
	}

}
