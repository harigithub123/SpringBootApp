package com.billing.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.billing.model.Customer;

@Repository
public interface CustomerRepository  extends JpaRepository<Customer, Long> {

	}
