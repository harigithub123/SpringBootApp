package com.billing.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.billing.model.destinations.DomesticDestination;

@Repository
public interface DomesticDestinationRepository  extends JpaRepository<DomesticDestination, Long> {
		
	public List<DomesticDestination> findByPinCodeOrDestinationOrZone(String pinCode, String destination, String zone);
	
}

