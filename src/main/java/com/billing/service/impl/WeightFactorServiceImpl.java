package com.billing.service.impl;


import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.billing.dao.WeightFactorRepository;
import com.billing.dto.masterdata.WeightFactorRequest;
import com.billing.model.MetaDataId;
import com.billing.model.masterdata.WeightFactor;
import com.billing.service.WeightFactorService;
import com.billing.service.util.ServiceRequestUtil;

@Service
public class WeightFactorServiceImpl implements WeightFactorService {
	
	private WeightFactorRepository preferenceRespository;
	
	public WeightFactorServiceImpl(WeightFactorRepository preferenceRepository) {
		this.preferenceRespository = preferenceRepository;
	}

	@Override
	public void addWeightFactor(WeightFactorRequest request) {
		this.preferenceRespository.save(ServiceRequestUtil.getWeightFactor(request));
	}

	@Override
	public void updateWeightFactor(WeightFactorRequest request) {
		this.preferenceRespository.save(ServiceRequestUtil.getWeightFactor(request));
	}

	@Override
	public List<WeightFactor> listWeightFactors() {
		return this.preferenceRespository.findAll();
	}

	@Override
	public WeightFactor getWeightFactorById(MetaDataId id) {
		Optional<WeightFactor> preference = this.preferenceRespository.findById(id);
		if(preference != null) {
			return preference.get();
		}
		return null;
	}

	@Override
	public void removeWeightFactor(MetaDataId id) {
		this.preferenceRespository.deleteById(id);
		
	}

}
