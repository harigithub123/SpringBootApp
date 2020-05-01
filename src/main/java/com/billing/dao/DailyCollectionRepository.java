package com.billing.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.billing.model.DailyCollection;

@Repository
public interface DailyCollectionRepository extends JpaRepository<DailyCollection, Long> {

	@Query(value="FROM DailyCollection o WHERE o.transactionDate >= :fromDate AND o.transactionDate <= :toDate")
	public List<DailyCollection> find(@Param("fromDate") Date fromDate, @Param("toDate") Date toDate);
}
