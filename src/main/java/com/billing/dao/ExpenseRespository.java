package com.billing.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.billing.model.CustomerBill;
import com.billing.model.Expense;

@Repository
public interface ExpenseRespository  extends JpaRepository<Expense, Long> ,JpaSpecificationExecutor<Expense>  {
	
	@Query(value="FROM Expense o WHERE o.transactionDate >= :fromDate AND o.transactionDate <= :toDate")
	public List<Expense> find(@Param("fromDate") Date fromDate, @Param("toDate") Date toDate);
}
