package com.billing.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.billing.dto.masterdata.ChargesTaxesRequest;
import com.billing.model.masterdata.ChargesTaxes;

@Service
public interface ChargesTaxesService {

	public void addChargesTaxes(ChargesTaxesRequest p);
	public void updateChargesTaxes(ChargesTaxesRequest p);
	public List<ChargesTaxes> listChargesTaxess();
	public ChargesTaxes getChargesTaxesById(Long id);
	public void removeChargesTaxes(Long id);
}
