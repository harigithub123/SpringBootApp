package com.billing.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.billing.model.CustomerBill;
import com.billing.model.ItemTransaction;

@Repository
public interface ItemTransactionResponsity extends JpaRepository<ItemTransaction, Long> ,JpaSpecificationExecutor<ItemTransaction>  {
	
	@Query(value="FROM ItemTransaction o WHERE o.transactionDate >= :fromDate AND o.transactionDate <= :toDate AND transactionType = :type")
	public List<ItemTransaction> find(@Param("fromDate") Date fromDate, @Param("toDate") Date toDate, @Param("type") String type);
}
