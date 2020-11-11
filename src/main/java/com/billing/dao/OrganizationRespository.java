package com.billing.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.billing.model.Organization;

@Repository
public interface OrganizationRespository  extends JpaRepository<Organization, Long> {

	}