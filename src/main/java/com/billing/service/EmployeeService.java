package com.billing.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.billing.model.Employee;
import com.billing.request.EmployeeRequest;

@Service
public interface EmployeeService {
	public void addEmployee(EmployeeRequest p);
	public void updateEmployee(EmployeeRequest p);
	public List<Employee> listEmployees();
	public Employee getEmployeeById(Long id);
	public void removeEmployee(Long id);
}
