package com.billing.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.billing.model.EmployeeTransaction;

@Repository
public interface EmployeeTransactionRepository extends JpaRepository<EmployeeTransaction, Long> {

}
