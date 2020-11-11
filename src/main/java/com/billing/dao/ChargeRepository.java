package com.billing.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.billing.model.Organization;
import com.billing.model.masterdata.Charge;

@Repository
public interface ChargeRepository  extends JpaRepository<Charge, Long> {

}