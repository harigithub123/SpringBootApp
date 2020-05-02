package com.billing.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.billing.model.MoneyTransaction;

@Repository
public interface MoneyTransactionRepository extends JpaRepository<MoneyTransaction, Long> {

}
