package com.billing.service.impl;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.billing.dao.EmployeeRepository;
import com.billing.dto.EmployeeRequest;
import com.billing.model.Employee;
import com.billing.response.EmployeeResponse;
import com.billing.service.EmployeeService;
import com.billing.service.util.ServiceRequestUtil;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	private EmployeeRepository employeeRespository;
	
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		this.employeeRespository = employeeRepository;
	}

	@Transactional
	public void addEmployee(EmployeeRequest request) {
		this.employeeRespository.save(ServiceRequestUtil.getEmployee(request));
	}

	@Transactional
	public void updateEmployee(EmployeeRequest request) {
		this.employeeRespository.save(ServiceRequestUtil.getEmployee(request));
	}

	@Transactional
	public List<Employee> listEmployees() {
		return this.employeeRespository.findAll();
	}

	@Transactional
	public Employee getEmployeeById(Long id) {
		Optional<Employee> employee = this.employeeRespository.findById(id);
		if(employee != null) {
			return employee.get();
		}
		return null;
	}

	@Transactional
	public void removeEmployee(Long id) {
		this.employeeRespository.deleteById(id);
	}
	
	public EmployeeResponse getEmployeeReponse(Employee e) {
		EmployeeResponse r = new EmployeeResponse();
		r.setAadharNo(e.getAadharNo());
		r.setAddress(e.getAddress());
		r.setDob(e.getDob());
		r.setId(e.getId());
		r.setJoiningDate(e.getJoiningDate());
		r.setMobileNumber(e.getMobileNumber());
		r.setMonthSalary(e.getMonthSalary());
		r.setName(e.getName());
		r.setPanNo(e.getPanNo());
		r.setAadharNo(e.getAadharNo());
		return r;
	}
	
	public List<EmployeeResponse> getEmployeeReponse(List<Employee> employees) {
		List<EmployeeResponse> res = new ArrayList<EmployeeResponse>();
		for(Employee e : employees) {
			res.add(getEmployeeReponse(e));
		}
		return res;
	}
}
