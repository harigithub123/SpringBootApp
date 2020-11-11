package com.billing.service.impl;


import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.billing.dao.ChargeRepository;
import com.billing.dao.ChargesTaxesRepository;
import com.billing.dto.masterdata.ChargesTaxesRequest;
import com.billing.model.masterdata.Charge;
import com.billing.model.masterdata.ChargesTaxes;
import com.billing.service.ChargeService;
import com.billing.service.ChargesTaxesService;
import com.billing.service.util.ServiceRequestUtil;

@Service
public class ChargesTaxesServiceImpl implements ChargesTaxesService {
	
private ChargesTaxesRepository chargesTaxesRespository;
	
	public ChargesTaxesServiceImpl(ChargesTaxesRepository chargesTaxesRepository) {
		this.chargesTaxesRespository = chargesTaxesRepository;
	}

	@Override
	public void addChargesTaxes(ChargesTaxesRequest request) {
		this.chargesTaxesRespository.save(ServiceRequestUtil.getChargesTaxes(request));
	}

	@Override
	public void updateChargesTaxes(ChargesTaxesRequest request) {
		this.chargesTaxesRespository.save(ServiceRequestUtil.getChargesTaxes(request));
	}

	@Override
	public List<ChargesTaxes> listChargesTaxess() {
		return this.chargesTaxesRespository.findAll();
	}

	@Override
	public ChargesTaxes getChargesTaxesById(Long id) {
		Optional<ChargesTaxes> chargesTaxes = this.chargesTaxesRespository.findById(id);
		if(chargesTaxes != null) {
			return chargesTaxes.get();
		}
		return null;
	}

	@Override
	public void removeChargesTaxes(Long id) {
		this.chargesTaxesRespository.deleteById(id);
		
	}

}
