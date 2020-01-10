package com.billing.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.billing.model.CustomerTransaction;

public interface CustomerTransactionRespository  extends JpaRepository<CustomerTransaction, Long> {

}