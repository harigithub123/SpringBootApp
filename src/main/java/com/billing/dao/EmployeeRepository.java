package com.billing.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.billing.model.Employee;

@Repository
public interface EmployeeRepository  extends JpaRepository<Employee, Long> {

}
