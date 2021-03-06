package com.billing.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.billing.model.SalaryRecord;

@Repository
public interface SalaryRecordRepository extends JpaRepository<SalaryRecord, Long> {
}
