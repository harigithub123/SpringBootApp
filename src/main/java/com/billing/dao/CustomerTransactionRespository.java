package com.billing.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.billing.model.CustomerTransaction;

@Repository
public interface CustomerTransactionRespository  extends JpaRepository<CustomerTransaction, Long> {

}