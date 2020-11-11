package com.billing.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.billing.model.MetaDataId;
import com.billing.model.masterdata.WeightFactor;

@Repository
public interface WeightFactorRepository  extends JpaRepository<WeightFactor, MetaDataId> {

	}