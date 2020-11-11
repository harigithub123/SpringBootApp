package com.billing.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.billing.dto.SalaryRecordRequest;
import com.billing.model.SalaryRecord;
import com.billing.response.SalaryRecordResponse;

@Service
public interface SalaryRecordService {
	public void addSalaryRecord(SalaryRecordRequest p);
	public void updateSalaryRecord(SalaryRecordRequest p);
	public List<SalaryRecordResponse> listSalaryRecords();
	public SalaryRecordResponse getSalaryRecordById(Long id);
	public void removeSalaryRecord(Long id);
}
