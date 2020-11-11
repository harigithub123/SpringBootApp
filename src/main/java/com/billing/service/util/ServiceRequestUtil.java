package com.billing.service.util;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.billing.dto.CustomerTransactionRequest;
import com.billing.dto.EmployeeRequest;
import com.billing.dto.EmployeeTransactionRequest;
import com.billing.dto.ExpenseRequest;
import com.billing.dto.LoginRequest;
import com.billing.dto.PersonRequestResponse;
import com.billing.dto.SalaryRecordRequest;
import com.billing.dto.UserRequest;
import com.billing.dto.destinations.DomesticDestinationDTO;
import com.billing.dto.destinations.InternationalDestinationDTO;
import com.billing.dto.masterdata.ChargesTaxesRequest;
import com.billing.dto.masterdata.PreferenceDTO;
import com.billing.dto.masterdata.WeightFactorRequest;
import com.billing.dto.shipper.ShipperDTO;
import com.billing.model.Customer;
import com.billing.model.CustomerTransaction;
import com.billing.model.Employee;
import com.billing.model.EmployeeTransaction;
import com.billing.model.Expense;
import com.billing.model.Login;
import com.billing.model.Organization;
import com.billing.model.Person;
import com.billing.model.SalaryRecord;
import com.billing.model.User;
import com.billing.model.destinations.DomesticDestination;
import com.billing.model.destinations.InternationalDestination;
import com.billing.model.masterdata.Charge;
import com.billing.model.masterdata.ChargesTaxes;
import com.billing.model.masterdata.Preference;
import com.billing.model.masterdata.WeightFactor;
import com.billing.model.shipper.Shipper;
import com.billing.response.ExpenseResponse;

public class ServiceRequestUtil {

	public static CustomerTransaction getCustomerTransaction(CustomerTransactionRequest request) {
		CustomerTransaction tran = new CustomerTransaction();
		tran.setId(request.getId());
		tran.setCustomer(new Customer(request.getCustomerId()));
		tran.setReceivedBy(request.getReceivedBy());
		tran.setAmount(request.getTranAmount());
		tran.setComments(request.getTranComment());
		tran.setTransactionMode(request.getTranMode());
		tran.setTransactionDate(request.getTranDate());
		tran.setReferenceNo(request.getReferenceNo());
		return tran;
	}
	
	public User getUser(UserRequest request) {
		User user = new User();
		user.setEmailId(request.getEmailId());
		user.setUserName(request.getMobileNumber());
		user.setUserName(request.getUserId());
		return user;
	}
	
	public static Login getLogin(LoginRequest request) {
		Login login = new Login();
		login.setMobileNumber(request.getMobileNumber());
		login.setOtp(request.getOtp());
		return login;
	}

	public static Employee getEmployee(EmployeeRequest request) {
		Employee e = new Employee();
		e.setId(request.getId());
		e.setJoiningDate(request.getJoiningDate());
		e.setMonthSalary(request.getMonthSalary());
		e.setAadharNo(request.getAadharNo());
		e.setAddress(request.getAddress());
		e.setDob(request.getDob());
		e.setMobileNumber(request.getMobileNumber());
		e.setName(request.getName());
		e.setPanNo(request.getPanNo());
		return e;
	}

	public static EmployeeTransaction getEmployeeTransaction(EmployeeTransactionRequest request) {
		EmployeeTransaction t = new EmployeeTransaction();
		t.setId(request.getId());
		t.setAmount(request.getAmount());
		t.setComments(request.getComments());
		t.setEmployee(new Employee(request.getEmployeeId()));
		t.setGivenBy(request.getGivenBy());
		t.setReferenceNo(request.getReferenceNo());
		t.setTransactionDate(request.getTransactionDate());
		t.setTransactionMode(request.getTransactionMode());
		return t;
	}

	public static SalaryRecord getSalaryRecord(SalaryRecordRequest request) {
		SalaryRecord r = new SalaryRecord();
		r.setId(request.getId());
		r.setMonth(request.getMonth());
		r.setDeduction(request.getDeduction());
		r.setFinalPayment(request.getFinalAmount());
		r.setNoOfLeaves(request.getNoOfLeaves());
		r.setEmployee(new Employee(request.getEmployeeId()));
		return r;
	}

	public static Expense getExpense(ExpenseRequest request) {
		Expense e = new Expense();
		e.setId(request.getId());
		e.setAmount(request.getAmount());
		e.setCategory(request.getCategory());
		e.setGoods(request.getGoods());
		e.setNote(request.getNote());
		e.setTransactionDate(request.getTransactionDate());
		e.setUser(new User(request.getUserId()));
		e.setPaid(request.getPaid());
		return e;
	}
	
	public static List<ExpenseResponse> getExpenseResponse(List<Expense> list) {
		List<ExpenseResponse> res = new ArrayList<ExpenseResponse>();
		if(list == null) {
			return res;
		}
		for(Expense e : list) {
			res.add(getExpenseResponse(e));
		}
		return res;
	}
	
	public static ExpenseResponse getExpenseResponse(Expense e) {
		ExpenseResponse r = new ExpenseResponse();
		r.setAmount(e.getAmount());
		r.setCategory(e.getCategory());
		r.setGoods(e.getGoods());
		r.setTransactionDate(e.getTransactionDate());
		r.setId(e.getId());
		r.setNote(e.getNote());
		r.setPaid(e.getPaid());
		r.setUserName(e.getUser().getUserName());
		return r;
	}
	
	

	public static Person getPerson(PersonRequestResponse request) {
		Person p = new Person();
		p.setId(request.getId());
		p.setMobileNumber(request.getMobileNumber());
		p.setName(request.getMobileNumber());
		return p;
	}
	
	public static InternationalDestination getInternationalDestination(InternationalDestinationDTO request) {
		InternationalDestination d = new InternationalDestination();
		d.setId(request.getId());
		d.setCountryCode(request.getCountryCode());
		d.setCountryName(request.getCountryName());
		return d;
	}
	
	public static DomesticDestination getDomesticDestination(DomesticDestinationDTO request) {
		DomesticDestination d = new DomesticDestination();
		d.setId(request.getId());
		d.setPinCode(request.getPinCode());
		d.setDestination(request.getDestination());
		d.setZone(request.getZone());
		return d;
	}
	
	public static Shipper getShipper(ShipperDTO request) {
		Shipper s = new Shipper();
		s.setId(request.getId());
		s.setCode(request.getCode());
		s.setName(request.getName());
		s.setService(request.getService());
		s.setServiceType(request.getServiceType());
		s.setDispFscForEachAWB(request.isDispFscForEachAWB());
		s.setDispGstForEachAWB(request.isDispGstForEachAWB());
		s.setRoundUpBoxWeight(request.isRoundUpBoxWeight());
		s.setOrganization(new Organization(request.getOrganizationId()));
		return s;
	}
	
	public static Preference getPreference(PreferenceDTO request) {
		Preference p = new Preference();
		//p.setId(request.getId());
		p.setShipper(new Shipper(request.getShipperId()));
		p.setColumnName(request.getColumName());
		p.setColumnSize(request.getColumnSize());
		p.setAlignment(request.getAlignment());
		p.setDisplayOrder(request.getDisplayOrder());
		return p;
	}

	public static ChargesTaxes getChargesTaxes(ChargesTaxesRequest request) {
		ChargesTaxes ct = new ChargesTaxes();
		ct.setId(request.getId());
		ct.setTax(request.getTax());
		ct.setCharge(new Charge(request.getChargeId()));
		ct.setShipper(new Shipper(request.getShipperId()));
		return ct;
	}

	public static WeightFactor getWeightFactor(WeightFactorRequest request) {
		return new WeightFactor(new Shipper(request.getShipperId()), request.getMode(), request.getModeClass(),
				request.getPackageType(), request.getVolumetricFactor(), request.getMinWeight(),
				request.getWeightSlab(), request.getSlots());
	}
	
}
