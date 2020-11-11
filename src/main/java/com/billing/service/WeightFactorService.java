package com.billing.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.billing.dto.masterdata.WeightFactorRequest;
import com.billing.model.MetaDataId;
import com.billing.model.masterdata.WeightFactor;

@Service
public interface WeightFactorService {

	public void addWeightFactor(WeightFactorRequest p);
	public void updateWeightFactor(WeightFactorRequest p);
	public List<WeightFactor> listWeightFactors();
	public WeightFactor getWeightFactorById(MetaDataId id);
	public void removeWeightFactor(MetaDataId id);
}
