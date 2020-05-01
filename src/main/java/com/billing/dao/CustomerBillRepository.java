package com.billing.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.billing.model.CustomerBill;
import com.billing.model.OrderInfo;

@Repository
public interface CustomerBillRepository  extends JpaRepository<CustomerBill, Long>,JpaSpecificationExecutor<CustomerBill>  {

	//@Query(value="FROM CustomerBill o WHERE o.startDate = :fromDate AND o.endDate = :toDate AND o.customer.id = :customerId")
	//@Query("SELECT o FROM OrderInfo o WHERE o.customerId = :customerId")
	//public List<OrderInfo> find(@Param("customerId") Long customerId);
	@Query(value="FROM CustomerBill o WHERE ((o.startDate <= :fromDate AND :fromDate <= o.endDate) OR (o.startDate <= :toDate AND :toDate <= o.endDate) OR ( o.startDate >= :fromDate AND :toDate >= o.endDate)) AND o.customer.id = :customerId")
	public List<CustomerBill> find(@Param("customerId") Long customerId , @Param("fromDate") Date fromDate, @Param("toDate") Date toDate);
	
	@Query(value="FROM CustomerBill o WHERE o.customer.id = :customerId order by  o.endDate desc ")
	//@Query("SELECT o FROM OrderInfo o WHERE o.customerId = :customerId")
	//public List<OrderInfo> find(@Param("customerId") Long customerId);
	public List<CustomerBill> findLastBillDate(@Param("customerId") Long customerId);
}
