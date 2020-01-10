package com.billing.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.billing.model.Customer;

public interface CustomerRepository  extends JpaRepository<Customer, Long> {

}
