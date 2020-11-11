package com.billing.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.billing.model.shipper.Shipper;

@Repository
public interface ShipperRepository  extends JpaRepository<Shipper, Long> {

	}