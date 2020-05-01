
package com.billing.service.impl;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.billing.dao.SalaryRecordRepository;
import com.billing.model.SalaryRecord;
import com.billing.request.SalaryRecordRequest;
import com.billing.response.SalaryRecordResponse;
import com.billing.service.SalaryRecordService;
import com.billing.service.util.ServiceRequestUtil;

@Service
public class SalaryRecordServiceImpl implements SalaryRecordService {
	
	private SalaryRecordRepository salaryRecordRespository;
	
	public SalaryRecordServiceImpl(SalaryRecordRepository salaryRecordRepository) {
		this.salaryRecordRespository = salaryRecordRepository;
	}

	@Transactional
	public void addSalaryRecord(SalaryRecordRequest request) {
		this.salaryRecordRespository.save(ServiceRequestUtil.getSalaryRecord(request));
	}

	@Transactional
	public void updateSalaryRecord(SalaryRecordRequest request) {
		this.salaryRecordRespository.save(ServiceRequestUtil.getSalaryRecord(request));
	}

	@Transactional
	public List<SalaryRecordResponse> listSalaryRecords() {
		return getSalaryResponse(this.salaryRecordRespository.findAll());
	}

	@Transactional
	public SalaryRecordResponse getSalaryRecordById(Long id) {
		Optional<SalaryRecord> salaryRecord = this.salaryRecordRespository.findById(id);
		if(salaryRecord != null) {
			return getSalaryResponse(salaryRecord.get());
		}
		return null;
	}

	@Transactional
	public void removeSalaryRecord(Long id) {
		this.salaryRecordRespository.deleteById(id);
	}
	
	public SalaryRecordResponse getSalaryResponse(SalaryRecord r) {
		SalaryRecordResponse res = new SalaryRecordResponse();
		res.setId(r.getId());
		res.setDeduction(r.getDeduction());
		res.setFinalAmount(r.getFinalPayment());
		res.setMonth(r.getMonth());
		res.setNoOfLeaves(r.getNoOfLeaves());
		res.setEmployeeName(r.getEmployee().getName());
		return res;
	}
	
	public List<SalaryRecordResponse> getSalaryResponse(List<SalaryRecord> records) {
		List<SalaryRecordResponse> response = new ArrayList<SalaryRecordResponse>();
		for(SalaryRecord r : records) {
			response.add(getSalaryResponse(r));
		}
		return response;
	}
	
}
