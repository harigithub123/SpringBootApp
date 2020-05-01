package com.billing.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.billing.model.OrderInfo;

@Repository
public interface OrderInfoRepository  extends JpaRepository<OrderInfo, Long>, JpaSpecificationExecutor<OrderInfo> {
	
	@Query(value="FROM OrderInfo o WHERE o.orderDate BETWEEN :fromDate AND :toDate and customer.id = :customerId")
	//@Query("SELECT o FROM OrderInfo o WHERE o.customerId = :customerId")
	//public List<OrderInfo> find(@Param("customerId") Long customerId);
	public List<OrderInfo> find(@Param("customerId") Long customerId , @Param("fromDate") Date fromDate, @Param("toDate") Date toDate);

	@Query(value="FROM OrderInfo o WHERE o.orderDate BETWEEN :fromDate AND :toDate")
	//@Query("SELECT o FROM OrderInfo o WHERE o.customerId = :customerId")
	//public List<OrderInfo> find(@Param("customerId") Long customerId);
	public List<OrderInfo> find(@Param("fromDate") Date fromDate, @Param("toDate") Date toDate);
}
