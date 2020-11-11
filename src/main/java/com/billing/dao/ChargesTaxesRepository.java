package com.billing.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.billing.model.masterdata.ChargesTaxes;

@Repository
public interface ChargesTaxesRepository  extends JpaRepository<ChargesTaxes, Long> {

}