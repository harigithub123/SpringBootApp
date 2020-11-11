package com.billing.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.billing.model.destinations.InternationalDestination;

@Repository
public interface InternationalDestinationRepository  extends JpaRepository<InternationalDestination, Long> {

	}

